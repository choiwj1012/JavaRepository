package productView;

import java.util.Scanner;

import MainController.Controller;
import mainView.AlertView;
import productVo.Product;

public class ProductSelectOneView {

	private Scanner keyboard;

	public ProductSelectOneView(){

		keyboard = new Scanner(System.in);

	}


	// 제품번호 획득
	public int getSearchProductNumber(){

		int searchProductNumber = 0;

		System.out.println("제품 조회 모드입니다.");
		System.out.println("제품번호를 입력하세요");
		searchProductNumber = keyboard.nextInt();

		return searchProductNumber;

	}


	public void printSearchedProduct(Product searchedProduct) {

		System.out.println("제품 번호 : " + searchedProduct.getProductNumber());
		System.out.println("제품 이름 : " + searchedProduct.getProductName());
		System.out.println("제품 설명 : " + searchedProduct.getProductComment());
		System.out.println("제품 가격 : " + searchedProduct.getProductPrice());
		System.out.println("제품 제조사 : " + searchedProduct.getProductVendorName());

		this.menu(searchedProduct.getProductNumber());
	}


	private void menu(int productNumber) {

		while(true){

			System.out.println("[1. 제품 목록 보기, 2. 제품 주문] : "); // 제품 삭제, 제품 수정 추가 가능
			int selectedMenu = keyboard.nextInt();

			if(selectedMenu == 1){

				new AlertView().alert("제품 컨트롤러에 제품 목록 보기를 요청");
				Controller.getProductController().requestSelectList();

			} else if(selectedMenu == 2){

				new AlertView().alert("주문 컨트롤러에 제품 주문 요청");

			} else {

				new AlertView().alert("잘못 선택함");

			}
			
		}
		
	}

}
