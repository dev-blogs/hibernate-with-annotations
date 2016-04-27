package model;
 
import java.util.HashSet;
import java.util.Set;
 
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
 
@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
     
    @Column(name = "name")
    private String name;
     
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "items_providers",
                joinColumns={@JoinColumn(name = "item_id")},
                inverseJoinColumns={@JoinColumn(name = "provider_id")})
    private Set<Provider> providers = new HashSet<Provider>();
     
    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;
     
    public Item() {
    }
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public Set<Provider> getProviders() {
        return providers;
    }
 
    public void setProviders(Set<Provider> providers) {
        this.providers = providers;
    }
 
    public Warehouse getWarehouse() {
        return warehouse;
    }
 
    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
