package file;

public class FileDTO {

	
	String fileName;
	String fileRealName;
	int downloadcount;
	
	public FileDTO(String fileName, String fileRealName, int downloadcount) {
		super();
		this.fileName = fileName;
		this.fileRealName = fileRealName;
		this.downloadcount = downloadcount;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileRealName() {
		return fileRealName;
	}
	public void setFileRealName(String fileRealName) {
		this.fileRealName = fileRealName;
	}
	public int getDownloadcount() {
		return downloadcount;
	}
	public void setDownloadcount(int downloadcount) {
		this.downloadcount = downloadcount;
	}
	
}
