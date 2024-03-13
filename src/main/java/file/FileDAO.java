package file;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class FileDAO {

	private Connection conn;

	public FileDAO() {
		
	
	//db 연결
	try {
		String dbURL = "jdbc:mysql://localhost:3306/file";
		String dbID = "kty";
		String dbPassword = "1234";
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	}
	
	//file 업로드 
	public int upload (String fileName, String fileRealName) {
		String SQL = "insert into file values(?,?)";
		
		try {
			//Statement 보다 속도가 빠름
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, fileName);
			pstmt.setString(2, fileRealName);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
}
