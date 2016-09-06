package productView;

import java.util.Scanner;

import productVo.Product;

public class ProductRegisterView {

	// variable
	private Scanner keyboard;
	
	// constructor
	public ProductRegisterView(){
		
		this.keyboard = new Scanner(System.in);
		
	}
	
	// method
	public Product regist(){
		
		Product product = null;
		
		System.out.println("��ǰ��ϸ���Դϴ�");
		
		System.out.print("��ǰ�� : ");
		String productName = keyboard.next();
		
		System.out.print("��ǰ���� : ");
		String productComment = keyboard.next();
		
		System.out.println("��ǰ���� : ");
		int productPrice = keyboard.nextInt();
		
		System.out.println("������ : ");
		String productVendorName = keyboard.next();
		
		product = new Product(productName, productComment, productPrice, productVendorName);
		
		return product;
		
	}
	
}