package productController;

import java.util.ArrayList;

import MainController.Controller;
import mainView.AlertView;
import productDao.ProductDao;
import productView.ProductRegisterView;
import productView.ProductSelectList;
import productView.ProductSelectOneView;
import productVo.Product;

public class ProductController {

	// variable
	private ProductDao productDao;
	
	// constructor
	public ProductController(){
		
		productDao = new ProductDao();
		
	}
	
	
	// 제품 목록 보기 요청을 처리하는 메서드
	public void requestSelectList(){
		
		// 제품목록을 가져오기 (product 테이블)
		ArrayList<Product> productList = productDao.selectList();
		
		// 제품목록 표시
		ProductSelectList productSelectList = new ProductSelectList();
		productSelectList.printProductSelectList(productList);
		
	}
	
	// 제품 등록 요청 처리
	public void requestRegister(){
		
		// 제품 등록에 필요한 정보를 취득하는 view 생성
		ProductRegisterView productRegisterView = new ProductRegisterView();
		Product newProduct = productRegisterView.regist();
		
		// 취득한 정보를 제품 테이블에 기록하는 dao 메서드 호출
		boolean success = productDao.regist(newProduct);
		
		if(success){
			new AlertView().alert("신제품 등록 성공");
		}else{
			new AlertView().alert("등록 실패");
		}
		
		// 제품목록 보기로 이동
		new AlertView().alert("제품 콘트롤러 제품목록보기");
		Controller.getProductController().requestSelectList();
	}


	// 제품 조회 요청 처리
	public void requestSelectOne() {
	
		// 제품 번호를 입력받는 화면
		ProductSelectOneView productSelectOneView = new ProductSelectOneView();
		int searchProductNumber = productSelectOneView.getSearchProductNumber();
	
				
		// 제품 번호를 통해 제품의 모든 정보를 구하는 dao 메서드
		Product searchedProduct = productDao.selectOne(searchProductNumber);
			
		
		// 제품의 모든 정보를 표시하는 화면
		productSelectOneView.printSearchedProduct(searchedProduct);
		
	}	
	
}
