package com.dev.blogs.hibernate;
 
import dao.ItemDAO;
import dao.ProviderDAO;
import dao.WarehouseDAO;
import daoImpl.ItemDAOImpl;
import daoImpl.ProviderDAOImpl;
import daoImpl.WarehouseDAOImpl;
 
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
