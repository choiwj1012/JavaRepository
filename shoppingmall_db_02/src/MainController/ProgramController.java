package MainController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ProgramController {

	// variable
	private Connection conn;
	private Statement stmt;
	
	// constructor
	public ProgramController() {
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("����̹� �ε� ����");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�����ͺ��̽� ���� ����");
		}
		
	}
	
	// method
	// DB ����
	public Connection getConn() {
		
		return conn;
		
	}
	
	// ���α׷� ����
	public void requestExitProgram(){
		
		if(conn != null){
			try{conn.close();} catch(SQLException e){e.printStackTrace();}
		}
		
		System.out.println("���α׷� ����");
		System.exit(0);
		
	}
	
}