package praveen.learn.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import praveen.learn.hibernate.models.Person;

@Repository
public class PersonDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveOrUpdatePerson(Person p){
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(p);
		session.flush();
	}
	public List<Person> getPersonList(){
		Session session=sessionFactory.getCurrentSession();
		List<Person> pList=(List<Person>)session.createQuery("SELECT p FROM Person p").list();
		return pList;
	}
	public Person getPersonByID(int id){
		Session session=sessionFactory.getCurrentSession();
		Person p=(Person)session.createQuery("SELECT p FROM Person p WHERE p.id=:id").
				setParameter("id", id).list().get(0);
		return p;
	}
}
