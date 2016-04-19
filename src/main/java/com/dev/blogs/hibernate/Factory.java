package com.dev.blogs.hibernate;
 
import DAO.ItemDAO;
import DAO.ProviderDAO;
import DAO.WarehouseDAO;
import DAO.impl.ItemDAOImpl;
import DAO.impl.ProviderDAOImpl;
import DAO.impl.WarehouseDAOImpl;
 
public class Factory {
    private static Factory instance = null;
    private static ItemDAO itemDAO = null;
    private static ProviderDAO providerDAO = null;
    private static WarehouseDAO warehouseDAO = null;
     
    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }
     
    public ItemDAO getItemDAO() {
        if (itemDAO == null) {
            itemDAO = new ItemDAOImpl();
        }
        return itemDAO;
    }
     
    public ProviderDAO getProviderDAO() {
        if (providerDAO == null) {
            providerDAO = new ProviderDAOImpl();
        }
        return providerDAO;
    }
     
    public WarehouseDAO getWarehouseDAO() {
        if (warehouseDAO == null) {
            warehouseDAO = new WarehouseDAOImpl();
        }
        return warehouseDAO;
    }
}
