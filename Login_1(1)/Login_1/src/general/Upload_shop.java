package general;

import java.io.File;

import javabean.DatabaseAccess;
import login.Login;
import javax.servlet.http.HttpServletRequest;
import showDetails.Curd;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import general.Shopping;
import java.net.URLEncoder;
import java.sql.ResultSet;

public class Upload_shop {
	private File upload;
	// 封装单个上传文件类型的属性
	private String uploadContentType;
	// 封装单个上传文件名的属性
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
	public String origin() {
		String s = "";
		ResultSet rs = null;
		try {
			DatabaseAccess db = new DatabaseAccess();
			Curd curd = new Curd();
			filename = getUploadFileName();
			
			newname = URLEncoder.encode(filename, "utf-8");
			newname = newname.replace("%", "");
			newname = newname.replace("+", "");
			int indexstart = newname.length() > 63 ? newname.length() - 63 : 0;
			newname = newname.substring(indexstart, newname.length());
			URLPath = request.getScheme() + "://" + request.getServerName()
					+ ":" + request.getServerPort() + request.getContextPath()
					+ "/upload/" + newname;
			
			String filenametmp;
			if (filename.contains(".html"))
				filenametmp = filename.replace(".html", " ");
			else
				filenametmp = filename.replace(".htm", " ");
			int cnt=0;
			String sqlconfigure;
			if (Login.username != null) {
			      sqlconfigure = "select * from "+Login.username+"history where Chinese like'%" + filenametmp + "%'";
			}
			else sqlconfigure = "select * from history where Chinese like'%" + filenametmp + "%'";
				rs = db.query(sqlconfigure);
				while(rs.next()){
					cnt++;
				}
				if (cnt!=0) {
					filenametmp=filenametmp+"("+cnt+")";
				}
			
			
			newnametmp = URLEncoder.encode(filenametmp, "utf-8");
			newnametmp = newnametmp.replace("%", "");
			newnametmp = newnametmp.replace("+", "");
			if (Login.username != null) {
			      newnametmp=Login.username+newnametmp;
			}
		
			int indexstart1 = newnametmp.length() > 63 ? newnametmp.length() - 63 : 0;
			newnametmp = newnametmp.substring(indexstart1, newnametmp.length());
            StringBuffer aBuffer = new StringBuffer(newnametmp.length());
			char aCharacter;
			for (int i = 0; i < newnametmp.length(); i++) {
				aCharacter = newnametmp.charAt(i);
				if (Character.isLetter(aCharacter)
						|| Character.isDigit(aCharacter)) {
					aBuffer.append(new Character(aCharacter));
				}
			}
			newnametmp = new String(aBuffer);
			if (Login.username != null) {
			
				String sql = "insert into "+Login.username+"history(English,Chinese) values('"
						+ newnametmp + "','" + filenametmp + "')";
				db.perform(sql);
			}
			else {
				String sql = "insert into history(English,Chinese) values('"
						+ newnametmp + "','" + filenametmp + "')";
				db.perform(sql);
			}
			
			String RealPath = ServletActionContext.getServletContext()
					.getRealPath("/upload") + File.separator + newname;
			String newsql = "create table "
					+ newnametmp
					+ "(1aaa varchar(150),2aaa varchar(150),3aaa varchar(150),"
					+ "4aaa varchar(150),5aaa varchar(150),6aaa varchar(150),7aaa varchar(150),8aaa varchar(150),"
					+ "9aaa varchar(150),10aaa varchar(150),11aaa varchar(150),12aaa varchar(150),13aaa varchar(150),"
					+ "14aaa varchar(150),15aaa varchar(150),16aaa varchar(150),17aaa varchar(150),18aaa varchar(150)"
					+ ",19aaa varchar(150),20aaa varchar(150))";
			System.out.println("login.username" + Login.username);
				db.createTable(newsql);
			String sql1 = "insert into "+Upload_shop.newnametmp+"(1aaa,2aaa,3aaa,4aaa,5aaa,6aaa,7aaa,8aaa,9aaa,10aaa," +
					"11aaa,12aaa,13aaa,14aaa,15aaa,16aaa,17aaa,18aaa,19aaa,20aaa) values('col1','2','3','4'," +
					"'5','6','7','8','9','10','11','12','13','14'," +
					"'15','16','17','18','19','20')";
				db.perform(sql1);
			
			db.close();
			System.out.println(RealPath + "路径");
			File fos = new File(RealPath);
			FileUtils.copyFile(upload, fos);
			System.out.println(URLPath);
			Shopping crawler = new Shopping();
			crawler.addSeed(URLPath);
			crawler.addRegex(URLPath);
			crawler.start(1);
			// 以上传文件建立一个文件上传流

			s = curd.getAllCurds();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public String login() {
		String s = "";
		ResultSet rs = null;
		try {
			DatabaseAccess db = new DatabaseAccess();
			Curd curd = new Curd();
			filename = getUploadFileName();
			
			newname = URLEncoder.encode(filename, "utf-8");
			newname = newname.replace("%", "");
			newname = newname.replace("+", "");
			int indexstart = newname.length() > 63 ? newname.length() - 63 : 0;
			newname = newname.substring(indexstart, newname.length());
			URLPath = request.getScheme() + "://" + request.getServerName()
					+ ":" + request.getServerPort() + request.getContextPath()
					+ "/upload/" + newname;
			
			String filenametmp;
			if (filename.contains(".html"))
				filenametmp = filename.replace(".html", " ");
			else
				filenametmp = filename.replace(".htm", " ");
			int cnt=0;
			String sqlconfigure;
			if (Login.username != null) {
			      sqlconfigure = "select * from "+Login.username+"history where Chinese like'%" + filenametmp + "%'";
			}
			else sqlconfigure = "select * from history where Chinese like'%" + filenametmp + "%'";
				rs = db.query(sqlconfigure);
				while(rs.next()){
					cnt++;
				}
				if (cnt!=0) {
					filenametmp=filenametmp+"("+cnt+")";
				}
			
			
			newnametmp = URLEncoder.encode(filenametmp, "utf-8");
			newnametmp = newnametmp.replace("%", "");
			newnametmp = newnametmp.replace("+", "");
			if (Login.username != null) {
			      newnametmp=Login.username+newnametmp;
			}
		
			int indexstart1 = newnametmp.length() > 63 ? newnametmp.length() - 63 : 0;
			newnametmp = newnametmp.substring(indexstart1, newnametmp.length());
            StringBuffer aBuffer = new StringBuffer(newnametmp.length());
			char aCharacter;
			for (int i = 0; i < newnametmp.length(); i++) {
				aCharacter = newnametmp.charAt(i);
				if (Character.isLetter(aCharacter)
						|| Character.isDigit(aCharacter)) {
					aBuffer.append(new Character(aCharacter));
				}
			}
			newnametmp = new String(aBuffer);
			if (Login.username != null) {
			
				String sql = "insert into "+Login.username+"history(English,Chinese) values('"
						+ newnametmp + "','" + filenametmp + "')";
				db.perform(sql);
			}
			else {
				String sql = "insert into history(English,Chinese) values('"
						+ newnametmp + "','" + filenametmp + "')";
				db.perform(sql);
			}
			
			String RealPath = ServletActionContext.getServletContext()
					.getRealPath("/upload") + File.separator + newname;
			String newsql = "create table "
					+ newnametmp
					+ "(1aaa varchar(150),2aaa varchar(150),3aaa varchar(150),"
					+ "4aaa varchar(150),5aaa varchar(150),6aaa varchar(150),7aaa varchar(150),8aaa varchar(150),"
					+ "9aaa varchar(150),10aaa varchar(150),11aaa varchar(150),12aaa varchar(150),13aaa varchar(150),"
					+ "14aaa varchar(150),15aaa varchar(150),16aaa varchar(150),17aaa varchar(150),18aaa varchar(150)"
					+ ",19aaa varchar(150),20aaa varchar(150))";
			System.out.println("login.username" + Login.username);
				db.createTable(newsql);
			String sql1 = "insert into "+Upload_shop.newnametmp+"(1aaa,2aaa,3aaa,4aaa,5aaa,6aaa,7aaa,8aaa,9aaa,10aaa," +
					"11aaa,12aaa,13aaa,14aaa,15aaa,16aaa,17aaa,18aaa,19aaa,20aaa) values('col1','2','3','4'," +
					"'5','6','7','8','9','10','11','12','13','14'," +
					"'15','16','17','18','19','20')";
				db.perform(sql1);
			
			db.close();
			System.out.println(RealPath + "路径");
			File fos = new File(RealPath);
			FileUtils.copyFile(upload, fos);
			System.out.println(URLPath);
			Shopping crawler = new Shopping();
			crawler.addSeed(URLPath);
			crawler.addRegex(URLPath);
			crawler.start(1);
			// 以上传文件建立一个文件上传流

			s = curd.getAllCurds();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
}