package general_communication;

import java.io.File;

import javabean.DatabaseAccess;

import javax.servlet.http.HttpServletRequest;
import showDetails.Curd_communication;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class UploadC {
	private File upload;
	// ��װ�����ϴ��ļ����͵�����
	private String uploadContentType;
	// ��װ�����ϴ��ļ���������
	private String uploadFileName;
	HttpServletRequest request = ServletActionContext.getRequest();
	String URLPath;
	public static String filenametmp;
	public static String newfilename;
	public static String filename;
	
	public String getSavePath() {
		// return ServletActionContext.getRequest().getRealPath("");
		String onload = "C:\\report\\cached\\";
		request.setAttribute("onload", onload);
		// return ServletActionContext.getRequest().getContextPath();
		return onload;
	}

	public void setSavePath(String savePath) {
	}

	// �ϴ������ļ����ļ����͵�setter��getter����
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadContentType() {
		return (this.uploadContentType);
	}

	// �ϴ������ļ����ļ�����setter��getter����
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadFileName() {
		return (this.uploadFileName);
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
		// savePath = ServletActionContext .getRequest().getRealPath("");
	}

	// �ϴ������ļ�
	public String execute() {
		String s="";
		Curd_communication curd=new Curd_communication();
		try {
			DatabaseAccess db = new DatabaseAccess(); 
			filenametmp=getUploadFileName();
			filename = filenametmp.substring(1,3)+"aaa";
			String newsql = "create table "+filename+"(1aaa varchar(150),2aaa varchar(150),3aaa varchar(150)," +
					"4aaa varchar(150),5aaa varchar(150),6aaa varchar(150),7aaa varchar(150),8aaa varchar(150)," +
					"9aaa varchar(150),10aaa varchar(150))";
			db.createTable(newsql);
	        db.close();
			URLPath=request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+request.getContextPath()+"/upload/"+filenametmp;
		
			String RealPath = ServletActionContext.getServletContext()
					.getRealPath("/upload")
					+ File.separator
					+ getUploadFileName();
			// �Է��������ļ������ַ��ԭ�ļ��������ϴ��ļ������
			System.out.println(RealPath + "·��");
			File fos = new File(RealPath);
			FileUtils.copyFile(upload, fos);
			System.out.println(URLPath);
			Communication crawler = new Communication();
				crawler.addSeed(URLPath);
				crawler.addRegex(URLPath);
				crawler.start(1);
			// ���ϴ��ļ�����һ���ļ��ϴ���
				s=curd.getAllCurds();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
}