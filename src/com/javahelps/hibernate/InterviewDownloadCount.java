package com.javahelps.hibernate;

import java.io.Serializable;

public class InterviewDownloadCount implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String path;
	private int downloadCount;
	private String downloadType;

	public int getDownloadCount() {
		return downloadCount;
	}

	public String getDownloadType() {
		return downloadType;
	}

	public String getPath() {
		return path;
	}

	public String getUserName() {
		return userName;
	}

	public void setDownloadCount(int downloadCount) {
		this.downloadCount = downloadCount;
	}

	public void setDownloadType(String downloadType) {
		this.downloadType = downloadType;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
