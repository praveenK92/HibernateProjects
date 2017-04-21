package hibernateBasics.hibernate.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Category implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer categoryId;
	private String name;
	private String desc;
	private Set<Stock3> stocks = new HashSet<>();
	
	public Category(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}
	
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Set<Stock3> getStocks() {
		return stocks;
	}
	public void setStocks(Set<Stock3> stocks) {
		this.stocks = stocks;
	}
}
