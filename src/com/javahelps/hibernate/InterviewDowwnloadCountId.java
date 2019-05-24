package com.javahelps.hibernate;

import java.io.Serializable;

public class InterviewDowwnloadCountId implements Serializable{
	
	private static final long serialVersionUID = -6304469424022543495L;
	
	public String getExportType() {
		return exportType;
	}
	public void setExportType(String exportType) {
		this.exportType = exportType;
	}
	
	public InterviewUsage getInterviewUsage() {
		return interviewUsage;
	}
	public void setInterviewUsage(InterviewUsage interviewUsage) {
		this.interviewUsage = interviewUsage;
	}

	private String exportType;
	private InterviewUsage interviewUsage;

}
