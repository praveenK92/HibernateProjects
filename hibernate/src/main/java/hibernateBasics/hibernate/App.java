package hibernateBasics.hibernate;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import hibernateBasics.hibernate.models.Category;
import hibernateBasics.hibernate.models.Stock;
import hibernateBasics.hibernate.models.Stock2;
import hibernateBasics.hibernate.models.Stock3;
import hibernateBasics.hibernate.models.StockDailyRecord;
import hibernateBasics.hibernate.models.StockDetail;
import hibernateBasics.hibernate.util.HibernateUtil;

public class App 
{
    public static void main( String[] args ){
    	 System.out.println("Maven + Hibernate + MySQL");
         Session session = HibernateUtil.getSessionFactory().openSession();
         session.beginTransaction();
         
         //oneToOne(session);
         //oneToMany(session);
         manyToMany(session);
        
         HibernateUtil.shutdown();
    }
    public static void manyToMany(Session session){
		Stock3 stock = new Stock3();
		stock.setStockCode("7055");
		stock.setStockName("Itachi");

		Category category1 = new Category("CONSUMER", "CONSUMER COMPANY");
		Category category2 = new Category("INVESTMENT", "INVESTMENT COMPANY");

		Set<Category> categories = new HashSet<Category>();
		categories.add(category1);
		categories.add(category2);

		stock.setCategories(categories);

		session.save(stock);

		session.getTransaction().commit();
    }
    public static void oneToMany(Session session){
    	Stock2 stock = new Stock2();
        stock.setStockCode("7052");
        stock.setStockName("PADINI");
        session.save(stock);
        
        StockDailyRecord stockDailyRecords = new StockDailyRecord();
        stockDailyRecords.setPriceOpen(new Float("1.2"));
        stockDailyRecords.setPriceClose(new Float("1.1"));
        stockDailyRecords.setPriceChange(new Float("10.0"));
        stockDailyRecords.setVolume(3000000L);
        stockDailyRecords.setDate(new Date());
        
        stockDailyRecords.setStock(stock);        
        stock.getStockDailyRecords().add(stockDailyRecords);
        
        StockDailyRecord stockDailyRecords2 = new StockDailyRecord();
        stockDailyRecords2.setPriceOpen(new Float("1.2"));
        stockDailyRecords2.setPriceClose(new Float("1.1"));
        stockDailyRecords2.setPriceChange(new Float("10.0"));
        stockDailyRecords2.setVolume(3000000L);
        Calendar c=Calendar.getInstance();
        c.add(Calendar.YEAR, 1);
        stockDailyRecords2.setDate(c.getTime());
        
        stockDailyRecords2.setStock(stock);
        stock.getStockDailyRecords().add(stockDailyRecords2);

        session.save(stockDailyRecords);
        session.save(stockDailyRecords2);

		session.getTransaction().commit();
		System.out.println("Done");
    }
    public static void oneToOne(Session session){
    	Stock stock = new Stock();
 		stock.setStockCode("4201");
 		stock.setStockName("GENOS");

 		StockDetail stockDetail = new StockDetail();
 		stockDetail.setCompName("GENTING India");
 		stockDetail.setCompDesc("Best resort in the world for me");
 		stockDetail.setRemark("Nothing Special bro!");
 		stockDetail.setListedDate(new Date());
 		
 		stock.setStockDetail(stockDetail);
 		stockDetail.setStock(stock);
 		
 		//session.saveOrUpdate(stock);
 		session.save(stock);
 		session.getTransaction().commit();

 		System.out.println("Done");
    }
}
