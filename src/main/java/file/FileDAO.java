package file;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	
	public int hit(String fileRealName) {
		String SQL = "update file set downloadCount = downloadCount + 1 "
				+ "where fileRealName = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, fileRealName);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	// 요즘 하는 방식 List, getList 둘 다 사용하기 위해
	public ArrayList<FileDTO> getList(){
		String SQL = "select fileName, fileRealName, downloadCount from file";
		ArrayList<FileDTO> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
                      FileDTO file = new FileDTO(rs.getString(1), rs.getString(2), rs.getInt(3));
				list.add(file);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//file 업로드 
	public int upload (String fileName, String fileRealName) {
		String SQL = "insert into file values(?,?,0)";
		
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
