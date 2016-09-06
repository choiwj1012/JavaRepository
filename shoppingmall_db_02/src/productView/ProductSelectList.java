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

		System.out.println("��ǰ��Ϻ���");

		if(productList.size() == 0){

			new AlertView().alert("��ǰ�� ����");

		} else {

			System.out.println("��ǰ��ȣ\t��ǰ��\t����\t������");
			for(int i=0; i<productList.size(); i++){

				System.out.print(productList.get(i).getProductNumber() + "\t");
				System.out.print(productList.get(i).getProductName() + "\t");
				System.out.print(productList.get(i).getProductPrice() + "\t");
				System.out.print(productList.get(i).getProductVendorName() + "\t");

			}

		}	

		this.menu();

	}

	public void menu(){


		while(true){

			System.out.println("[1. ��ǰ ��� 2. ��ǰ ��ȸ 0. ���α׷� ����]");
			int selectedMenu = keyboard.nextInt();

			switch(selectedMenu){

			case 1 :
				System.out.println("��ǰ ���");
				Controller.getProductController().requestRegister();
				break;

			case 2 :
				System.out.println("��ǰ ��ȸ");
				Controller.getProductController().requestSelectOne();
				break;

			case 0 :
				System.out.println("���α׷� ����");
				Controller.getProgramController().requestExitProgram();
				break;

			default :
				System.out.println("�߸��Էµ�");

			}	

		}

	}

}