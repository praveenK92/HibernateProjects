package hibernate.annotation.start;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import hibernate.annotation.start.models.Stock;
import hibernate.annotation.start.models.Stock1;
import hibernate.annotation.start.models.StockDetail;
import hibernate.annotation.start.models.Student;
import hibernate.annotation.start.models.Subject;
import hibernate.annotation.start.util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        //test(session);
        //oneToOne(session);
        Student s=getStudent(session);
        List<Subject> sl=getAllSubject(session);
        System.out.println(s);System.out.println(sl);
        
        //insertStudent(session, s,sl);
        
        HibernateUtil.shutdown();
        System.out.println("Done");
        
	}
	public static Student getStudent(Session session){
		Student s1=session.get(Student.class, 1);
		return s1;
	}
	public static List<Subject> getAllSubject(Session session){
		List<Subject> s1=session.createCriteria(Subject.class).list();
		return s1;
	}
	public static void insertStudent(Session session,Student s,List<Subject> sl){
		Student s1=new Student();
		s1.setId(3);s1.setName("Itachi");s1.setSalary(5000);s1.setSubList(sl);
		session.saveOrUpdate(s1);
		session.getTransaction().commit();
	}
	
	public static void oneToOne(Session session){
		Stock1 stock = new Stock1();

		stock.setStockCode("102");
		stock.setStockName("itachi 102");

		StockDetail stockDetail = new StockDetail();
		stockDetail.setCompName("itachi 102 Holding Malaysia");
		stockDetail.setCompDesc("a one stop shopping");
		stockDetail.setRemark("vinci vinci");
		stockDetail.setListedDate(new Date());

		stock.setStockDetail(stockDetail);
		stockDetail.setStock(stock);

		session.save(stock);
		session.getTransaction().commit();

	}
	public static void test(Session session){
		Stock stock = new Stock();
        
        stock.setStockCode("101");
        stock.setStockName("Itachi 101");
        
        session.save(stock);
        session.getTransaction().commit();
	}

}
