package productView;

import java.util.ArrayList;
import java.util.Scanner;

import MainController.Controller;
import mainView.AlertView;
import productVo.Product;

public class ProductSelectList {

	private Scanner keyboard;

	public ProductSelectList(){

		keyboard = new Scanner(System.in);

	}

	public void printProductSelectList(ArrayList<Product> productList){

		System.out.println("제품목록보기");

		if(productList.size() == 0){

			new AlertView().alert("제품이 없음");

		} else {

			System.out.println("제품번호\t제품명\t가격\t제조사");
			for(int i=0; i<productList.size(); i++){

				System.out.print(productList.get(i).getProductNumber() + "\t");
				System.out.print(productList.get(i).getProductName() + "\t");
				System.out.print(productList.get(i).getProductPrice() + "\t");
				System.out.println(productList.get(i).getProductVendorName());

			}

		}	

		this.menu();

	}

	public void menu(){


		while(true){
						
			boolean success = Controller.getLoginController().requestCheckLogin();		
			
			if(!success){ // 로그인 되지 않은 상태
			
				System.out.println("[1. 제품 등록 2. 제품 조회 3. 회원 가입, 4. 로그인, 0. 프로그램 종료]");	
					
			} else {
				
				System.out.println("[1. 제품 등록 2. 제품 조회 3. 회원 가입, 4. 로그아웃, 0. 프로그램 종료]");
				
			}
			
			int selectedMenu = keyboard.nextInt();

			switch(selectedMenu){

			case 1 :
				System.out.println("제품 등록");
				Controller.getProductController().requestRegister();
				break;

			case 2 :
				System.out.println("제품 조회");
				Controller.getProductController().requestSelectOne();
				break;
				
			case 3 :
				System.out.println("회원 등록");
				Controller.getUserController().requestRegister();
				break;
				
			case 4 :
				if(!success){
					System.out.println("로그인");
					Controller.getLoginController().requestLogin();	
				} else {
					Controller.getLoginController().requestLogout();
				}
				
				break;

			case 0 :
				System.out.println("프로그램 종료");
				Controller.getProgramController().requestExitProgram();
				break;

			default :
				System.out.println("잘못입력됨");

			}	

		}

	}

}
