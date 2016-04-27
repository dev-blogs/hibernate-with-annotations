package daoImpl;
 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;
import model.Provider;
import dao.ProviderDAO;
 
public class ProviderDAOImpl implements ProviderDAO {
 
    public void addProvider(Provider provider, Session session) throws SQLException, Exception {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(provider);
        session.getTransaction().commit();
    }
 
    public void updateProvider(Provider provider, Session session) throws SQLException, Exception {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(provider);
        session.getTransaction().commit();
    }
 
    public Provider getProviderById(Long id, Session session) throws SQLException, Exception {
        Provider provider = null;
        session = HibernateUtil.getSessionFactory().openSession();
        provider = (Provider) session.load(Provider.class, id);
        return provider;
         
    }
 
    public Collection<Provider> getAllProviders(Session session) throws SQLException, Exception {
        List<Provider> providers = new ArrayList<Provider>();
        session = HibernateUtil.getSessionFactory().openSession();
        providers = session.createCriteria(Provider.class).list();
        return providers;
    }
 
    public void deleteProvider(Provider provider, Session session) throws SQLException, Exception {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(provider);
        session.getTransaction().commit();
    }
}
