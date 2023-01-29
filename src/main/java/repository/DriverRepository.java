package repository;

import entity.Company;
import entity.TruckDriver;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

public class DriverRepository {

    public void save(TruckDriver truckDriver) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(truckDriver);
        transaction.commit();
        session.close();
    }
    public void addNewDriver(String firstName, String lastName, double salary) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        TruckDriver truckDriver = new TruckDriver();
        truckDriver.setFistName(firstName);
        truckDriver.setLastName(lastName);
        truckDriver.setSalary(salary);
        session.save(truckDriver);

        transaction.commit();
        session.close();
        System.out.println("new driver created");
    }
    public TruckDriver findByLastName(String lastName){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from TruckDriver where LastName = :LastName");
        query.setParameter("LastName", lastName);
        TruckDriver truckDriver = (TruckDriver) query.uniqueResult();
        transaction.commit();
        session.close();
        return truckDriver;
    }
}
