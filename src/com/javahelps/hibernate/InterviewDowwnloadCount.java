package com.javahelps.hibernate;

import java.io.Serializable;

public class InterviewDowwnloadCount implements Serializable {

	private static final long serialVersionUID = 5981410008613156659L;
	private int downloads;
	private InterviewDowwnloadCountId interviewDowwnloadCountId;
	private InterviewUsage report;

	public void setId(InterviewDowwnloadCountId interviewDowwnloadCountId) {
		this.interviewDowwnloadCountId = interviewDowwnloadCountId;
	}

	public InterviewDowwnloadCountId getId() {
		return interviewDowwnloadCountId;
	}

	public int getDownloads() {
		return downloads;
	}

	public void setDownloads(int downloads) {
		this.downloads = downloads;
	}

	public InterviewUsage getReport() {
		return report;
	}

	public void setReport(InterviewUsage report) {
		this.report = report;
	}
}
