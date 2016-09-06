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
		
		System.out.println("제품등록모드입니다");
		
		System.out.print("제품명 : ");
		String productName = keyboard.next();
		
		System.out.print("제품설명 : ");
		String productComment = keyboard.next();
		
		System.out.println("제품가격 : ");
		int productPrice = keyboard.nextInt();
		
		System.out.println("제조사 : ");
		String productVendorName = keyboard.next();
		
		product = new Product(productName, productComment, productPrice, productVendorName);
		
		return product;
		
	}
	
}
