package com.javahelps.hibernate;

import java.io.Serializable;
import java.util.Set;

public class InterviewUsage implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 8191745162253550727L;
	private String userName;
	private String path;
	private Integer totalUsage = 0;
	private Set<InterviewDownloadCount> interviewDownloadCounts;

	public String getPath() {
		return path;
	}

	public String getUserName() {
		return userName;
	}


	public void setPath(String path) {
		this.path = path;
	}

	public void setUserName(String username) {
		this.userName = username;
	}

	public Integer getTotalUsage() {
		return totalUsage != null ? totalUsage : 0;
	}

	public void setTotalUsage(Integer totalUsage) {
		this.totalUsage = totalUsage;
	}

	public Set<InterviewDownloadCount> getInterviewDownloadCounts() {
		return interviewDownloadCounts;
	}

	public void setInterviewDownloadCounts(Set<InterviewDownloadCount> interviewDownloadCounts) {
		this.interviewDownloadCounts = interviewDownloadCounts;
	}

}
