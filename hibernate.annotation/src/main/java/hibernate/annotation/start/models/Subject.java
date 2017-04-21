package hibernate.annotation.start.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="subject")
public class Subject{
	@Id
	@Column(name="sub_id")
	private int subID;
	@Column(name="sub_name",nullable=false)
	private String name;
	@Column(nullable=false)
	private int marks;
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "subList")
	private List<Student> studentList;
	
	public int getSubID() {
		return subID;
	}
	public void setSubID(int subID) {
		this.subID = subID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	@Override
	public String toString() {
		return "Subject [subID=" + subID + ", name=" + name + ", marks=" + marks + "]";
	}
}
