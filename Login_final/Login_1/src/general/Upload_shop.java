package general;

import java.io.File;

import javabean.DatabaseAccess;

import javax.servlet.http.HttpServletRequest;
import showDetails.Curd;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import general.Shopping;
import java.net.URLEncoder;

public class Upload_shop {
	private File upload;
	// ��װ�����ϴ��ļ����͵�����
	private String uploadContentType;
	// ��װ�����ϴ��ļ���������
	private String uploadFileName;
	HttpServletRequest request = ServletActionContext.getRequest();
	String URLPath;
	public static String newnametmp;
	public static String newname;
	public static String filename;
	public static String filename_amazon;
	
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
		try {
			DatabaseAccess db = new DatabaseAccess(); 
			 Curd curd=new Curd();
			filename=getUploadFileName();
			newname = URLEncoder.encode(filename, "utf-8");
			newname=newname.replace("%", "");
			newname=newname.replace("+", "");
			newnametmp=newname.replace(".","");
			int indexstart=newname.length()>63?newname.length()-63:0;
			newname = newname
					.substring(indexstart, newname.length());
			URLPath = request.getScheme() + "://" + request.getServerName()
					+ ":" + request.getServerPort() + request.getContextPath()
					+ "/upload/" + newname;
			System.out.println(newname);
			System.out.println(newnametmp);
			String sql="insert into history(English,Chinese) values('"+newnametmp+"','"+filename+"')";
			db.perform(sql);
			String RealPath = ServletActionContext.getServletContext()
					.getRealPath("/upload") + File.separator + newname;
			String newsql = "create table "+newnametmp+"(1aaa varchar(150),2aaa varchar(150),3aaa varchar(150)," +
					"4aaa varchar(150),5aaa varchar(150),6aaa varchar(150),7aaa varchar(150),8aaa varchar(150)," +
					"9aaa varchar(150),10aaa varchar(150),11aaa varchar(150),12aaa varchar(150),13aaa varchar(150)," +
					"14aaa varchar(150),15aaa varchar(150),16aaa varchar(150),17aaa varchar(150),18aaa varchar(150)" +
					",19aaa varchar(150),20aaa varchar(150))";
			db.createTable(newsql);
			//"insert into users(username,password) values('" + username + "','" + password +  "')";
			String sql1 = "insert into "+Upload_shop.newnametmp+"(1aaa,2aaa,3aaa,4aaa,5aaa,6aaa,7aaa,8aaa,9aaa,10aaa," +
					"11aaa,12aaa,13aaa,14aaa,15aaa,16aaa,17aaa,18aaa,19aaa,20aaa) values('col1','2','3','4'," +
					"'5','6','7','8','9','10','11','12','13','14'," +
					"'15','16','17','18','19','20')";
	        db.perform(sql1);
			db.close();
			/*URLPath=request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+request.getContextPath()+"/upload/"+filenametmp;
		
			String RealPath = ServletActionContext.getServletContext()
					.getRealPath("/upload")
					+ File.separator
					+ getUploadFileName();*/
			// �Է��������ļ������ַ��ԭ�ļ��������ϴ��ļ������
			System.out.println(RealPath + "·��");
			File fos = new File(RealPath);
			FileUtils.copyFile(upload, fos);
			System.out.println(URLPath);
			Shopping crawler = new Shopping();
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