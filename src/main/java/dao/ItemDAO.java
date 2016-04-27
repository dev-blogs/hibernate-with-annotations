package dao;
 
import java.sql.SQLException;
import java.util.Collection;
 
import model.Item;
 
import org.hibernate.Session;
 
public interface ItemDAO {
    public void addItem(Item item) throws SQLException, Exception;
    public void updateItem(Item item) throws SQLException, Exception;
    public Item getItemById(Long id) throws SQLException, Exception;
    public Collection<Item> getAllItems() throws SQLException, Exception;
    public void deleteItem(Item item) throws SQLException, Exception;
}
