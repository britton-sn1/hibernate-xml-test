package com.javahelps.hibernate;

import org.hibernate.internal.util.ClassLoaderHelper;

public class Main2 {

	com.javahelps.hibernate.InterviewDownloadCount dk;
	com.javahelps.hibernate.InterviewDownloadCountId jd;
	
	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader cl = ClassLoaderHelper.getContextClassLoader();
		
		
		System.out.println(cl.loadClass("com.javahelps.hibernate.InterviewDowwnloadCount").getName());
		System.out.println(cl.getClass().getName());
	}
	
	public void  go() {
		
	}
}
