package praveen.learn.hibernate.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name="child")
public class Child {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="c_id")
	private int childID;
	@Column(name="child_name",nullable=false)
	private String cName;
	@Column(name="parent_id",nullable=false)
	private int parentID;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="parent_id",nullable=false,referencedColumnName="id",
				updatable=false,insertable=false)
	@Expose(serialize=false)
	private Person person;
	
	public Child(){}
	public Child(String cName, Person person,int parentID){
		this.cName = cName;
		this.person = person;
		this.parentID=parentID;
	}
	public int getChildID() {
		return childID;
	}
	public void setChildID(int childID) {
		this.childID = childID;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public int getParentID() {
		return parentID;
	}
	public void setParentID(int parentID) {
		this.parentID = parentID;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
}
