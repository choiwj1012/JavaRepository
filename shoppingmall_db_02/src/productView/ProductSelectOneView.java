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


	// ��ǰ��ȣ ȹ��
	public int getSearchProductNumber(){

		int searchProductNumber = 0;

		System.out.println("��ǰ ��ȸ ����Դϴ�.");
		System.out.println("��ǰ��ȣ�� �Է��ϼ���");
		searchProductNumber = keyboard.nextInt();

		return searchProductNumber;

	}


	public void printSearchedProduct(Product searchedProduct) {

		System.out.println("��ǰ ��ȣ : " + searchedProduct.getProductNumber());
		System.out.println("��ǰ �̸� : " + searchedProduct.getProductName());
		System.out.println("��ǰ ���� : " + searchedProduct.getProductComment());
		System.out.println("��ǰ ���� : " + searchedProduct.getProductPrice());
		System.out.println("��ǰ ������ : " + searchedProduct.getProductVendorName());

		this.menu(searchedProduct.getProductNumber());
	}


	private void menu(int productNumber) {

		while(true){

			System.out.println("[1. ��ǰ ��� ����, 2. ��ǰ �ֹ�] : "); // ��ǰ ����, ��ǰ ���� �߰� ����
			int selectedMenu = keyboard.nextInt();

			if(selectedMenu == 1){

				new AlertView().alert("��ǰ ��Ʈ�ѷ��� ��ǰ ��� ���⸦ ��û");
				Controller.getProductController().requestSelectList();

			} else if(selectedMenu == 2){

				new AlertView().alert("�ֹ� ��Ʈ�ѷ��� ��ǰ �ֹ� ��û");

			} else {

				new AlertView().alert("�߸� ������");

			}
			
		}
		
	}

}