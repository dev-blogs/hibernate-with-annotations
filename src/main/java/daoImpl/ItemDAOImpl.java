package daoImpl;
 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import model.Item;
import org.hibernate.Session;
import util.HibernateUtil;
import dao.ItemDAO;
 
public class ItemDAOImpl implements ItemDAO {
	private Session session;
	
	public ItemDAOImpl() {
		session = HibernateUtil.getSessionFactory().openSession();
	}
 
    public Collection<Item> getAllItems() throws SQLException, Exception {
        List<Item> items = new ArrayList<Item>();
        items = session.createCriteria(Item.class).list();
        return items;
    }
 
    public void addItem(Item item) throws SQLException, Exception {
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
    }
 
    public void updateItem(Item item) throws SQLException, Exception {
        session.beginTransaction();
        session.update(item);
        session.getTransaction().commit();
    }
 
    public Item getItemById(Long id) throws SQLException, Exception {
        Item item = null;
        item = (Item) session.load(Item.class, id);
        return item;
    }
 
    public void deleteItem(Item item) throws SQLException, Exception {
        session.beginTransaction();
        session.delete(item);
        session.getTransaction().commit();
    }
}