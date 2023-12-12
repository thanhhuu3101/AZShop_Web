package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity

@Table(name="Product")

@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")

public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int ProductID;
	
	private int stoke;
	
	private int Amount;
	
	@Column(columnDefinition = "nvarchar(MAX)")
	private String Description;
	
	@Column(columnDefinition = "nvarchar(255)")
	private String ProductName;
	
	private String imageLink;
	
	private int SellerID;
	
	private int Price;
	
	@ManyToOne
	@JoinColumn(name="CategoryID")
	private Category category;
	
	public Product() {
	
	super();
	
	}
	
	public Product(int productID, int stoke, int amount, String description, String productName, String imageLink,
	
	int sellerID, int price, Category category) {
	
	super();
	
	this.ProductID = productID;
	
	this.stoke = stoke;
	
	this.Amount = amount;
	
	this.Description = description;
	
	this.ProductName = productName;
	
	this.imageLink = imageLink;
	
	this.SellerID = sellerID;
	
	this.Price = price;
	
	this.category = category;
	
	}
	
	public int getProductID() {
	
	return ProductID;
	
	}
	
	public void setProductID(int productID) {
	
	ProductID = productID;
	
	}
	
	public int getStoke() {
	
	return stoke;
	
	}
	
	public void setStoke(int stoke) {
	
	this.stoke = stoke;
	
	}
	
	public int getAmount() {
	
	return Amount;
	
	}
	
	public void setAmount(int amount) {
	
	this.Amount = amount;
	
	}
	
	public String getDescription() {
	
	return Description;
	
	}
	
	public void setDescription(String description) {
	
	this.Description = description;
	
	}
	
	public String getProductName() {
	
	return ProductName;
	
	}
	
	public void setProductName(String productName) {
	
	this.ProductName = productName;
	
	}
	
	public String getImageLink() {
	
	return imageLink;
	
	}
	
	public void setImageLink(String imageLink) {
	
	this.imageLink = imageLink;
	
	}
	
	public int getSellerID() {
	
	return SellerID;
	
	}
	
	public void setSellerID(int sellerID) {
	
	this.SellerID = sellerID;
	
	}
	
	public int getPrice() {
	
	return Price;
	
	}
	
	public void setPrice(int price) {
	
	this.Price = price;
	
	}
	
	public Category getCategory() {
	
	return category;
	
	}
	
	public void setCategory(Category category) {
	
	this.category = category;
	
	}

}