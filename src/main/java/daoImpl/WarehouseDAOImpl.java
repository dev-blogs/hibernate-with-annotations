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
	private Session session;
	
	public WarehouseDAOImpl() {
		session = HibernateUtil.getSessionFactory().openSession();
	}
 
    public void addWarehouse(Warehouse warehouse) throws SQLException, Exception {
        session.beginTransaction();
        session.save(warehouse);
        session.getTransaction().commit();
    }
 
    public void updateWarehouse(Warehouse warehouse) throws SQLException, Exception {
        session.beginTransaction();
        session.update(warehouse);
        session.getTransaction().commit();
    }
 
    public Warehouse getWarehouseById(Long id) throws SQLException, Exception {
        Warehouse warehouse = null;
        warehouse = (Warehouse) session.load(Warehouse.class, id);
        return warehouse;
    }
 
    public Collection<Warehouse> getAllWarehouses() throws SQLException, Exception {
        List<Warehouse> warehouses = new ArrayList<Warehouse>();
        warehouses = session.createCriteria(Warehouse.class).list();
        return warehouses;
    }
 
    public void deleteWarehouse(Warehouse warehouse) throws SQLException, Exception {
        session.beginTransaction();
        session.delete(warehouse);
        session.getTransaction().commit();
    }
}