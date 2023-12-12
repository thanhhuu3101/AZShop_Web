package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity

@Table(name="Category")

@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")

public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int CategoryID;
	
	@Column(columnDefinition = "nvarchar(200)")
	private String CategoryName;
	
	@Column(columnDefinition = "nvarchar(MAX)")
	private String icon;
	
	@OneToMany(mappedBy="category", fetch=FetchType.EAGER)
	private List<Product> products;
	
	public Category(int categoryID, String categoryName, String icon, List<Product> products) {
	
	super();
	
	this.CategoryID = categoryID;
	
	this.CategoryName = categoryName;
	
	this.icon = icon;
	
	this.products = products;
	
	}
	
	public Category() {
	
	super();
	
	}
	
	public int getCategoryID() {
	
	return CategoryID;
	
	}
	
	public void setCategoryID(int categoryID) {
	
	this.CategoryID = categoryID;
	
	}

	public String getCategoryName() {
	
	return CategoryName;
	
	}

	public void setCategoryName(String categoryName) {
	
	this.CategoryName = categoryName;
	
	}

	public String getIcon() {
	
	return icon;
	
	}

	public void setIcon(String icon) {
	
	this.icon = icon;
	
	}

	public List<Product> getProducts() {
	
	return products;
	
	}

	public void setProducts(List<Product> products) {
	
	this.products = products;
	
	}

}
