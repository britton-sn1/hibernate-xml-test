package com.javahelps.hibernate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class Main {
	// Create the SessionFactory when you start the application.
	private static final SessionFactory SESSION_FACTORY;

	/**
	 * Initialize the SessionFactory instance.
	 */
	static {
		// Create a Configuration object.
		final Configuration config = new Configuration();
		// Configure using the application resource named hibernate.cfg.xml.
		config.configure();
		// Extract the properties from the configuration file.
		final Properties prop = config.getProperties();

		// Create StandardServiceRegistryBuilder using the properties.
		final StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		builder.applySettings(prop);

		// Build a ServiceRegistry
		final ServiceRegistry registry = builder.build();

		// Create the SessionFactory using the ServiceRegistry
		SESSION_FACTORY = config.buildSessionFactory(registry);
	}

	public static void main(String[] args) {

		create();

		// NEVER FORGET TO CLOSE THE SESSION_FACTORY
		SESSION_FACTORY.close();
	}
	/**
	 * Create a new Student.
	 *
	 * @param name
	 * @param age
	 */
	public static void create() {
		

		// Create a session
		final Session session = SESSION_FACTORY.openSession();
		Transaction transaction = null;
		try {

			
			
			// Begin a transaction
			transaction = session.beginTransaction();

			List<InterviewUsage> interviewUsages = readAll(session);
			for(InterviewUsage interviewUsage : interviewUsages) {
				Set<InterviewDownloadCount> interviewDownloadCounts = interviewUsage.getInterviewDownloadCounts();
				for(InterviewDownloadCount interviewDownloadCount : interviewDownloadCounts) {
					InterviewDownloadCountId interviewDownloadCountId = interviewDownloadCount.getId();
					
					System.out.println(interviewDownloadCountId.getInterviewUsage().getPath() + "," +
							interviewDownloadCountId.getInterviewUsage().getUserName() + "," +
							interviewDownloadCount.getId().getExportType() + "," +
							interviewDownloadCount.getDownloads() );
					interviewDownloadCount.setDownloads(interviewDownloadCount.getDownloads() + 1);
				}
				
			}

			final InterviewUsage interviewUsage = new InterviewUsage();
			interviewUsage.setUserName("neil");
			interviewUsage.setPath("some path " +System.currentTimeMillis());

			final Set<InterviewDownloadCount> interviewDownloadCounts = new HashSet<>();
			final InterviewDownloadCount interviewDownloadCount = new InterviewDownloadCount();
			
			InterviewDownloadCountId interviewDowwnloadCountId = new InterviewDownloadCountId();
			interviewDowwnloadCountId.setInterviewUsage(interviewUsage);
			interviewDowwnloadCountId.setExportType("PDF");
			interviewDownloadCount.setId(interviewDowwnloadCountId);
			interviewDownloadCount.setDownloads(10);
			interviewDownloadCounts.add(interviewDownloadCount);

			interviewDowwnloadCountId = new InterviewDownloadCountId();
			interviewDowwnloadCountId.setInterviewUsage(interviewUsage);
			interviewDowwnloadCountId.setExportType("DOCX");
			interviewDownloadCount.setId(interviewDowwnloadCountId);
			interviewDownloadCount.setDownloads(2);
			interviewDownloadCounts.add(interviewDownloadCount);
			
			interviewUsage.setInterviewDownloadCounts(interviewDownloadCounts);
			

			session.save(interviewUsage);
//			session.save(interviewDownloadCount);
			
			// Commit the transaction
			transaction.commit();
		} catch (final HibernateException ex) {
			// If there are any exceptions, roll back the changes
			if (transaction != null) {
				transaction.rollback();
			}
			// Print the Exception
			ex.printStackTrace();
		} finally {
			// Close the session
			session.close();
		}
	}

	/**
	 * Delete the existing Student.
	 *
	 * @param id
	 */
	public static void delete(int id) {
		// Create a session
		final Session session = SESSION_FACTORY.openSession();
		Transaction transaction = null;
		try {
			// Begin a transaction
			transaction = session.beginTransaction();
			// Get the Student from the database.
//			final Student stu = (Student) session.get(Student.class, Integer.valueOf(id));
			// Delete the student
//			session.delete(stu);
			// Commit the transaction
			transaction.commit();
		} catch (final HibernateException ex) {
			// If there are any exceptions, roll back the changes
			if (transaction != null) {
				transaction.rollback();
			}
			// Print the Exception
			ex.printStackTrace();
		} finally {
			// Close the session
			session.close();
		}
	}


	/**
	 * Read all the Students.
	 *
	 * @return a List of Students
	 */
	public static List<InterviewUsage> readAll(Session session) {
		List<InterviewUsage> interviewUsages = null;
		// Transaction transaction = null;
		try {
			// Begin a transaction
			//transaction = session.beginTransaction();
			interviewUsages = session.createQuery("FROM InterviewUsage").list();
			// Commit the transaction
			//transaction.commit();
		} catch (final HibernateException ex) {
			// If there are any exceptions, roll back the changes
//			if (transaction != null) {
//				transaction.rollback();
//			}
			// Print the Exception
			ex.printStackTrace();
		} finally {
			// Close the session
//			session.close();
		}
		return interviewUsages;
	}

	/**
	 * Update the existing Student.
	 *
	 * @param id
	 * @param name
	 * @param age
	 */
/*	public static void upate(int id, String name, int age) {
		// Create a session
		final Session session = SESSION_FACTORY.openSession();
		Transaction transaction = null;
		try {
			// Begin a transaction
			transaction = session.beginTransaction();
			// Get the Student from the database.
			final Student stu = (Student) session.get(Student.class, Integer.valueOf(id));
			// Change the values
			stu.setName(name);
			stu.setAge(age);
			// Update the student
			session.update(stu);

			// Commit the transaction
			transaction.commit();
		} catch (final HibernateException ex) {
			// If there are any exceptions, roll back the changes
			if (transaction != null) {
				transaction.rollback();
			}
			// Print the Exception
			ex.printStackTrace();
		} finally {
			// Close the session
			session.close();
		}
	} 
	*/
}
