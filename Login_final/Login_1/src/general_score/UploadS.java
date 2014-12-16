package general_score;

import java.io.File;

import javabean.DatabaseAccess;

import javax.servlet.http.HttpServletRequest;
import showDetails.Curd;
import showDetails.Curd_S;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class UploadS {
	private File upload;
	// 封装单个上传文件类型的属性
	private String uploadContentType;
	// 封装单个上传文件名的属性
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

	// 上传单个文件的文件类型的setter和getter方法
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadContentType() {
		return (this.uploadContentType);
	}

	// 上传单个文件的文件名的setter和getter方法
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

	// 上传单个文件
	public String execute() {
		String s="";
		Curd_S curd=new Curd_S();
		try {
			DatabaseAccess db = new DatabaseAccess(); 
			 
			filenametmp=getUploadFileName();
			filename = filenametmp.substring(1,3)+"aaa";
			String newsql = "create table "+filename+"(store varchar(150))";
			System.out.println(filenametmp);
			db.createTable(newsql);
	        db.close();
			URLPath=request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+request.getContextPath()+"/upload/"+filenametmp;
		
			String RealPath = ServletActionContext.getServletContext()
					.getRealPath("/upload")
					+ File.separator
					+ getUploadFileName();
			// 以服务器的文件保存地址和原文件名建立上传文件输出流
			System.out.println(RealPath + "路径");
			File fos = new File(RealPath);
			FileUtils.copyFile(upload, fos);
			System.out.println(URLPath);
			Score crawler = new Score();
				crawler.addSeed(URLPath);
				crawler.addRegex(URLPath);
				crawler.start(1);
			// 以上传文件建立一个文件上传流
				s=curd.getAllCurds();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
}