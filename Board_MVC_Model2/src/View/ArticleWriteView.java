package view;

import java.util.Scanner;

import domain.Article;

public class ArticleWriteView {
	
	// variable
	private Scanner keyboard;
	
	// constructor
	public ArticleWriteView() {
		
		this.keyboard = new Scanner(System.in);
		
	}
	
	// method
	public Article writeArticle(){
		
		Article article = null;
		
		System.out.println("[글쓰기모드]");
		
		System.out.print("제목 : ");
		String title = keyboard.next();
		
		System.out.print("내용 : ");
		String content = keyboard.next();
		
		System.out.print("글작성자 : ");
		String writer = keyboard.next();
		
		article = new Article(title, content, writer);
		
		return article;
		
	}
	
}
