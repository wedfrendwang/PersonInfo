package cn.wedfrend.category;

import java.util.Date;


public class Book {
	
	private int id;
	private String name;
	private String author;
	private double price;
	private Date date;
	private int categoryId;
	
	public Book(String name, String author, double price, Date date,
			int categoryId) {
		super();
		this.name = name;
		this.author = author;
		this.price = price;
		this.date = date;
		this.categoryId = categoryId;
	}
	public Book(int id, String name, String author, double price, Date date,
			int categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
		this.date = date;
		this.categoryId = categoryId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	

}
