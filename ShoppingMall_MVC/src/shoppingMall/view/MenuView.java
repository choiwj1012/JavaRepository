package shoppingMall.view;

import java.util.Scanner;

import shoppingMall.controller.MainController;

public class MenuView {

	// variable
	private Scanner keyboard;
	
	// constructor
	public MenuView(){
		
		this.keyboard = new Scanner(System.in);
		
	}

	// method
	public void mainMenuView(){

		MainController.productController.requestDisplayProductList();

		boolean exit = false;
		while(!exit){

			System.out.println("\n쇼핑몰에 오신것을 환영합니다");
			System.out.println("원하시는 메뉴를 선택해 주세요");
			System.out.println("1. 회원가입하기");
			System.out.println("2. 로그인하기");
			System.out.println("3. 나가기");

			int selectedMenu = keyboard.nextInt();
			if(selectedMenu == 1){

				MainController.userController.requestAddUser(); // 회원가입하기

			} else if(selectedMenu == 2){

				MainController.userController.requestLogIn(); // 로그인하기

			} else if(selectedMenu == 3){

				break;

			} else {

				System.out.println("번호를 잘못 누르셨습니다.");

			}

		} // End of while 

		System.out.println("시스템을 종료합니다.");	

	} // End of mainMenuView()


	public void adminMenuView(){

		while(true){

			String[] adminMenu = {"관리자 메뉴입니다.","메뉴를 선택 하세요","1. 상품 조회","2. 상품 등록","3. 상품 수정","4. 상품 삭제","5. 메인메뉴로 가기"};
			for(int i=0; i<adminMenu.length; i++){
				System.out.println(adminMenu[i]);
			}

			int selectedMain = keyboard.nextInt();
			if(selectedMain == 1){

				MainController.productController.requestDisplayProductList(); // 상품조회

			} else if(selectedMain == 2){

				MainController.productController.requestAddProduct(); // 상품등록

			} else if(selectedMain == 3){

				MainController.productController.requestUpdateProduct(); // 상품수정

			} else if(selectedMain == 4){

				MainController.productController.requestDeleteProduct(); // 상품삭제

			} else if(selectedMain == 5){

				break; // 종료

			} else {

				System.out.println("메뉴를 다시 선택해주세요");

			}

		} // End of while

	} // End of adminMenuView()


	public void UserMenuView(){

		while(true){
			
			String[] mainMenu = {"쇼핑몰의 메인 메뉴입니다.","메뉴를 선택 하세요","[c]. 구매하기","[s]. 장바구니 확인","[m]. 회원정보수정","[r]. 회원정보조회","[o]. 로그아웃","[w]. 회원탈퇴"};
			for(int i=0; i<mainMenu.length; i++){
				System.out.println(mainMenu[i]);
			}
			
			char selectedMenu = keyboard.next().charAt(0);
			switch(selectedMenu){
			
				case 'c' :
					MainController.cartController.requestPurchase(); // 구매하기
					break;
					
				case 's' :
					MainController.cartController.requestDisplayCartList(); // 장바구니 확인
					break;
											
				case 'm' :
					MainController.userController.requestUpdateUserInfo(); // 회원정보수정
					break;
					
				case 'r' :
					MainController.userController.requestReadUserInfo(); // 회원정보조회
					break;
					
				case 'o' :
					System.out.println("로그아웃되었습니다.");
					MainController.userController.requestLogOut(); // 로그아웃
					break;
					
				case 'w' :
					MainController.userController.requestWithdrawMember(); // 회원탈퇴
					break;
					
				default :
					System.out.println("잘못입력했습니다. 다시 입력해주세요");
					
			}
			
		} // End of while

	} // End of UserMenuView()

}