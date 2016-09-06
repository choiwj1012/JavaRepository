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

	// 회원등록
	public boolean register(User newUser) {

		boolean success = false; 

		int nextUserNumber = 0;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			
			// 회원의 아이디 중복을 체크
			String newUserId = newUser.getUserId();
			String sql = "select * from userInfo where userId = ?";
			pstmt = Controller.getProgramController().getConn().prepareStatement(sql);
			pstmt.setString(1, newUserId);
			rs = pstmt.executeQuery();

			if(rs.next()){ // 회원 중 현재 가입하고자 하는 아디이가 있는 경우

				new AlertView().alert("이미 아이디가 존재합니다");


			} else {
				
				// 현재 회원 테이블에 있는 마지막 회원의 회원 번호를 읽어서 + 1 을 nextUserNumber 설정
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

				// 회원 가입
				sql = "insert into userInfo values(?,?,?,?)";
				pstmt = Controller.getProgramController().getConn().prepareStatement(sql);
				pstmt.setInt(1, newUser.getUserNumber());
				pstmt.setString(2, newUser.getUserId());
				pstmt.setString(3, newUser.getUserPassword());
				pstmt.setString(4, newUser.getUserName());
				int result = pstmt.executeUpdate(); // 1 : 회원 테이블에 insert 성공, 0 : 실패

				if(result != 0){

					success = true;

				}
			}

		} catch(SQLException e){
			
			System.out.println("회원 등록 시에 예외가 발생했습니다.");
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


