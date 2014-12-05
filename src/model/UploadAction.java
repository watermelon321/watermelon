package model;

import java.io.File;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class UploadAction {
	private File upload;
	// ��װ�����ϴ��ļ����͵�����
	private String uploadContentType;
	// ��װ�����ϴ��ļ���������
	private String uploadFileName;
	HttpServletRequest request = ServletActionContext.getRequest();
	String URLPath;
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
		try {
			URLPath=request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+request.getContextPath()+"/upload/"+getUploadFileName();
			String RealPath = ServletActionContext.getServletContext()
					.getRealPath("/upload")
					+ File.separator
					+ getUploadFileName();
			// �Է��������ļ������ַ��ԭ�ļ��������ϴ��ļ������
			System.out.println(RealPath + "·��");
			File fos = new File(RealPath);
			FileUtils.copyFile(upload, fos);
			System.out.println(URLPath);
				FromTaobao crawler = new FromTaobao();
				crawler.addSeed(URLPath);
				crawler.addRegex(URLPath);
				crawler.start(1);
			// ���ϴ��ļ�����һ���ļ��ϴ���
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
}