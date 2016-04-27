package dao;
 
import java.sql.SQLException;
import java.util.Collection;
 
import model.Warehouse;
 
import org.hibernate.Session;
 
public interface WarehouseDAO {
    public void addWarehouse(Warehouse warehouse) throws SQLException, Exception;
    public void updateWarehouse(Warehouse warehouse) throws SQLException, Exception;
    public Warehouse getWarehouseById(Long id) throws SQLException, Exception;
    public Collection<Warehouse> getAllWarehouses() throws SQLException, Exception;
    public void deleteWarehouse(Warehouse warehouse) throws SQLException, Exception;
}
