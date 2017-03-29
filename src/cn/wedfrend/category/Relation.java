package cn.wedfrend.category;

import java.util.Date;

public class Relation {
	
	private int id;
	private String name;
	private String hobby;
	private String level;
	private Date date;
	
	public Relation() {
		// TODO Auto-generated constructor stub
	}
	public Relation(String name, String hobby, String level, Date date) {
		super();
		this.name = name;
		this.hobby = hobby;
		this.level = level;
		this.date = date;
	}
	
	public Relation(int id, String name, String hobby, String level, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.hobby = hobby;
		this.level = level;
		this.date = date;
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
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Relation [id=" + id + ", name=" + name + ", hobby=" + hobby
				+ ", level=" + level + ", date=" + date + "]";
	}

}
