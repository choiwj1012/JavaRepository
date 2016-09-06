package MainController;

import loginController.LoginController;
import productController.ProductController;
import userController.UserController;

public class Controller {

	
	private static ProgramController programController;
	private static ProductController productController;
	private static UserController userController;
	private static LoginController loginController;
	
	public Controller(){
		
		this.programController = new ProgramController();
		this.productController = new ProductController();
		this.userController = new UserController();
		this.loginController = new LoginController();
		
	}


	public static ProgramController getProgramController() {
		return programController;
	}


	public static ProductController getProductController() {
		return productController;
	}


	public static UserController getUserController() {
		return userController;
	}


	public static LoginController getLoginController() {
		return loginController;
	}
	
	
}
