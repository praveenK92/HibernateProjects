package praveen.learn.hibernate.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id;
	@Column(nullable=false)
	private String name;
	@Column
	private String country;
	@OneToMany(fetch=FetchType.EAGER,mappedBy="person",cascade=CascadeType.ALL,orphanRemoval=true)
	List<Child> childList;
	
	public Person(){}
	public Person(String name, String country) {
		this.name = name;
		this.country = country;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public List<Child> getChildList() {
		return childList;
	}
	public void setChildList(List<Child> childList) {
		this.childList = childList;
	}	
}
