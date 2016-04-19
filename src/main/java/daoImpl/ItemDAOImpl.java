package DAO.impl;
 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
 
import model.Item;
 
import org.hibernate.Session;
 
import util.HibernateUtil;
import DAO.ItemDAO;
 
public class ItemDAOImpl implements ItemDAO {
 
    public Collection<Item> getAllItems(Session session) throws SQLException, Exception {
        List<Item> items = new ArrayList<Item>();
        session = HibernateUtil.getSessionFactory().openSession();
        items = session.createCriteria(Item.class).list();
        return items;
    }
 
    public void addItem(Item item, Session session) throws SQLException, Exception {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
    }
 
    public void updateItem(Item item, Session session) throws SQLException, Exception {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(item);
        session.getTransaction().commit();
    }
 
    public Item getItemById(Long id, Session session) throws SQLException, Exception {
        Item item = null;
        session = HibernateUtil.getSessionFactory().openSession();
        item = (Item) session.load(Item.class, id);
        return item;
    }
 
    public void deleteItem(Item item, Session session) throws SQLException, Exception {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(item);
        session.getTransaction().commit();
    }
}
