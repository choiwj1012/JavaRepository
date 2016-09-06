package loginController;

import MainController.Controller;
import loginDao.LoginDao;
import loginView.LoginView;
import loginVo.Login;
import mainView.AlertView;

public class LoginController {

	private LoginDao loginDao;
	
	public LoginController(){
		
		this.loginDao = new LoginDao();
		
	}
	
	// 로그인 요청을 처리하는 메서드
	public void requestLogin(){
		
		// 아이디와 패스워드를 입력하는 화면에서 로그인 정보(Login)획득
		LoginView loginView = new LoginView();
		Login newLogin = loginView.login();
		
		// 획득한 로그인 정보를 통해 회원 테이블에서 로그인 정보에 해당하는 회원이 있는지 체크
		boolean success = loginDao.login(newLogin);
		
		if(success){
			new AlertView().alert("로그인 성공");
		} else {
			new AlertView().alert("로그인 실패");	
		}
		
		// 제품 컨트롤러의 제품 목록 보기를 요청함
		new AlertView().alert("제품 컨트롤러의 제품 목록 보기를 요청");
		Controller.getProductController().requestSelectList();
		
	}
	
	
	// 현재 로그인 상태(로그온, 로그아웃)(LoginRepository.getLogin() != null, 로그아웃 == null)
	public boolean requestCheckLogin(){
		
		boolean success = loginDao.checkLogin();
		
		return success;
		
	}
	
	// 로그아웃 요청을 처리하는 메서드
	public void requestLogout() {

		loginDao.logout();
		
	}
	
}
