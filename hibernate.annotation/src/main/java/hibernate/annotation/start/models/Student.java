package hibernate.annotation.start.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	@Id
	private int id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private int salary;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "student_subj_map", joinColumns = {
			@JoinColumn(name = "stud_id", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "subj_id",
					nullable = false, updatable = false) })
	private List<Subject> subList;
	
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public List<Subject> getSubList() {
		return subList;
	}
	public void setSubList(List<Subject> subList) {
		this.subList = subList;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
}
