package repository;
import entity.RepairingWorkshop;
import utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class RepairWorkshopRepository {

    public void save(RepairingWorkshop repairingWorkshop) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(repairingWorkshop);
        transaction.commit();
        session.close();
    }
}
