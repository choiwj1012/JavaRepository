package loginDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import MainController.Controller;
import loginRepository.LoginRepository;
import loginVo.Login;

public class LoginDao {

	
	public LoginDao(){
		
		new LoginRepository();
		
	}
	
	
	public boolean login(Login newLogin) {

		boolean success = false;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			
			String sql = "select * from userInfo where userId = ? and userPassword = ?";
			pstmt = Controller.getProgramController().getConn().prepareStatement(sql);
			pstmt.setString(1, newLogin.getUserId());
			pstmt.setString(2, newLogin.getUserPassword());
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				// LoginRepository.setLogin();
				success = true;
			}
			
		} catch(SQLException e){
			
			System.out.println("로긴예외");
			e.printStackTrace();
			
		}
		
		return success;
	}


	public boolean checkLogin() {
		
		boolean success = false;
		
		if(LoginRepository.getLogin() != null){
			success = true;
		}
		
		return success;
	}

	
	// 로그 아웃 요청을 처리하는 메서드
	public static void logout() {
		
		LoginRepository.setLogin(null);
		
	}

	
}
