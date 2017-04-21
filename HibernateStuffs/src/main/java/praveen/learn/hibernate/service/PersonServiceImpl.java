package praveen.learn.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import praveen.learn.hibernate.dao.A1;
import praveen.learn.hibernate.dao.PersonDao;
import praveen.learn.hibernate.models.Person;

@Service
@Transactional
public class PersonServiceImpl {
	@Autowired
	private PersonDao personDao;
	@Autowired
	private A1 a1;
	
	public void savePerson(Person p){
		personDao.saveOrUpdatePerson(p);
	}
	public List<Person> getPersonList(){
		return personDao.getPersonList();
	}
	public Person getPersonById(int id){
		return personDao.getPersonByID(id);
	}
}
