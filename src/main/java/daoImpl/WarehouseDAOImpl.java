package daoImpl;
 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;
import model.Warehouse;
import dao.WarehouseDAO;
 
public class WarehouseDAOImpl implements WarehouseDAO {
 
    public void addWarehouse(Warehouse warehouse, Session session) throws SQLException, Exception {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(warehouse);
        session.getTransaction().commit();
    }
 
    public void updateWarehouse(Warehouse warehouse, Session session) throws SQLException, Exception {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(warehouse);
        session.getTransaction().commit();
    }
 
    public Warehouse getWarehouseById(Long id, Session session) throws SQLException, Exception {
        Warehouse warehouse = null;
        session = HibernateUtil.getSessionFactory().openSession();
        warehouse = (Warehouse) session.load(Warehouse.class, id);
        return warehouse;
    }
 
    public Collection<Warehouse> getAllWarehouses(Session session) throws SQLException, Exception {
        List<Warehouse> warehouses = new ArrayList<Warehouse>();
        session = HibernateUtil.getSessionFactory().openSession();
        warehouses = session.createCriteria(Warehouse.class).list();
        return warehouses;
    }
 
    public void deleteWarehouse(Warehouse warehouse, Session session) throws SQLException, Exception {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(warehouse);
        session.getTransaction().commit();
    }
}
