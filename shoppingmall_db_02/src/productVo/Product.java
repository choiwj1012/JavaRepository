package productVo;

public class Product {


	// variable
	private int productNumber;
	private String productName;
	private String productComment;
	private int productPrice;
	private String productVendorName;


	// constructor
	public Product(){

	}

	public Product(String productName, String productComment, int productPrice, String productVendorName){

		this.productName = productName;
		this.productComment = productComment;
		this.productPrice = productPrice;
		this.productVendorName = productVendorName;

	}

	public Product(int productNumber, String productName, String productComment, int productPrice, String productVendorName){

		this.productNumber = productNumber;
		this.productName = productName;
		this.productComment = productComment;
		this.productPrice = productPrice;
		this.productVendorName = productVendorName;

	}


	// getter and setter

	public int getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductComment() {
		return productComment;
	}

	public void setProductComment(String productComment) {
		this.productComment = productComment;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductVendorName() {
		return productVendorName;
	}

	public void setProductVendorName(String productVendorName) {
		this.productVendorName = productVendorName;
	}


}
