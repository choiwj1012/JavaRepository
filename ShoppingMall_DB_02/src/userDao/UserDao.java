package userDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import MainController.Controller;
import mainView.AlertView;
import userVo.User;

public class UserDao {

	// constructor
	public UserDao() {

	}

	// ȸ�����
	public boolean register(User newUser) {

		boolean success = false; 

		int nextUserNumber = 0;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			
			// ȸ���� ���̵� �ߺ��� üũ
			String newUserId = newUser.getUserId();
			String sql = "select * from userInfo where userId = ?";
			pstmt = Controller.getProgramController().getConn().prepareStatement(sql);
			pstmt.setString(1, newUserId);
			rs = pstmt.executeQuery();

			if(rs.next()){ // ȸ�� �� ���� �����ϰ��� �ϴ� �Ƶ��̰� �ִ� ���

				new AlertView().alert("�̹� ���̵� �����մϴ�");


			} else {
				
				// ���� ȸ�� ���̺��� �ִ� ������ ȸ���� ȸ�� ��ȣ�� �о + 1 �� nextUserNumber ����
				sql = "select max(userNumber) + 1 as maxUserNumber from userInfo";
				stmt = Controller.getProgramController().getConn().createStatement();
				rs = stmt.executeQuery(sql);

				if(rs.next()){

					nextUserNumber = rs.getInt("maxUserNumber");
					if(rs.wasNull()){
						nextUserNumber = 1;
					}

				}

				newUser.setUserNumber(nextUserNumber);

				// ȸ�� ����
				sql = "insert into userInfo values(?,?,?,?)";
				pstmt = Controller.getProgramController().getConn().prepareStatement(sql);
				pstmt.setInt(1, newUser.getUserNumber());
				pstmt.setString(2, newUser.getUserId());
				pstmt.setString(3, newUser.getUserPassword());
				pstmt.setString(4, newUser.getUserName());
				int result = pstmt.executeUpdate(); // 1 : ȸ�� ���̺��� insert ����, 0 : ����

				if(result != 0){

					success = true;

				}
			}

		} catch(SQLException e){
			
			System.out.println("ȸ�� ��� �ÿ� ���ܰ� �߻��߽��ϴ�.");
			e.printStackTrace();
			
		} finally {

			if(pstmt != null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}			
			}

			if(rs != null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if(stmt != null)
			{
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return success;

	}

}

