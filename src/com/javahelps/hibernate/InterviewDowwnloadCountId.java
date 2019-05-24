package com.javahelps.hibernate;

import java.io.Serializable;

public class InterviewDowwnloadCountId implements Serializable{
	
	private static final long serialVersionUID = -6304469424022543495L;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getExportType() {
		return exportType;
	}
	public void setExportType(String exportType) {
		this.exportType = exportType;
	}
	
	private String userName;
	private String path;
	private String exportType;

}
