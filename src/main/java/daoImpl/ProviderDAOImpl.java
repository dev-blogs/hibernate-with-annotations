package daoImpl;
 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.hibernate.Session;
import dao.ProviderDAO;
import model.Provider;
import util.HibernateUtil;
 
public class ProviderDAOImpl implements ProviderDAO {
	private Session session;
	
	public ProviderDAOImpl() {
		session = HibernateUtil.getSessionFactory().openSession();
	}
 
    public void addProvider(Provider provider) throws SQLException, Exception {
        session.beginTransaction();
        session.save(provider);
        session.getTransaction().commit();
    }
 
    public void updateProvider(Provider provider) throws SQLException, Exception {
        session.beginTransaction();
        session.update(provider);
        session.getTransaction().commit();
    }
 
    public Provider getProviderById(Long id) throws SQLException, Exception {
        Provider provider = null;
        provider = (Provider) session.load(Provider.class, id);
        return provider;
         
    }
 
    public Collection<Provider> getAllProviders() throws SQLException, Exception {
        List<Provider> providers = new ArrayList<Provider>();
        providers = session.createCriteria(Provider.class).list();
        return providers;
    }
 
    public void deleteProvider(Provider provider) throws SQLException, Exception {
        session.beginTransaction();
        session.delete(provider);
        session.getTransaction().commit();
    }
}
