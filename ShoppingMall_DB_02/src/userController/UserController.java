package userController;

import MainController.Controller;
import userDao.UserDao;
import userView.UserRegisterView;
import userVo.User;

public class UserController {

	private UserDao userDao;
	
	public UserController() {
	
		userDao = new UserDao();
		
	}
	
	// 회원 등록(가입) 요청을 처리하는 메서드
	public void requestRegister(){
		
		// 회원 등록을 위해서 회원 정보를 입력하는 화면 표시(단, 회원 번호는 시스템에서 자동 지정함으로 수집하지 않는다)
		UserRegisterView userRegisterView = new UserRegisterView();
		User newUser = userRegisterView.regist();
		
		// 수집한 회원 정보를 회원 테이블에 등록 (insert)
		userDao.register(newUser);
		
		// 제품 컨트롤러의 제품 목록 표시 화면으로 이동
		Controller.getProductController().requestSelectList();
		
	}
	
	
}
