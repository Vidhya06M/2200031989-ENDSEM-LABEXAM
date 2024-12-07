package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class ClientDemo {

    public static void main(String[] args) {
        // Initialize SessionFactory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Project.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        // Insert a project
        Project project = new Project("Project 1", 12, 500000.0, "Vidhya");
        session.save(project);

        // Aggregate functions using CriteriaBuilder
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        // Count of projects - Corrected
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        Root<Project> countRoot = countQuery.from(Project.class);  // Define the root of the query
        countQuery.select(criteriaBuilder.count(countRoot));  // Select count of the projects
        long count = session.createQuery(countQuery).getSingleResult();

        // Max budget - Corrected
        CriteriaQuery<Double> maxQuery = criteriaBuilder.createQuery(Double.class);
        Root<Project> maxRoot = maxQuery.from(Project.class);  // Define the root again
        maxQuery.select(criteriaBuilder.max(maxRoot.get("budget")));  // Select max of 'budget' field
        Double maxBudget = session.createQuery(maxQuery).getSingleResult();

        // Output results
        System.out.println("Total Projects: " + count);
        System.out.println("Max Budget: " + maxBudget);

        // Commit transaction and close session
        transaction.commit();
        session.close();
        factory.close();
    }
}
