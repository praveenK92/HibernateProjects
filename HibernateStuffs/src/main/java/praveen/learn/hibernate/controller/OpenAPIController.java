package praveen.learn.hibernate.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import praveen.learn.hibernate.models.Child;
import praveen.learn.hibernate.models.Person;
import praveen.learn.hibernate.service.PersonServiceImpl;

@RestController
public class OpenAPIController {
	
	@Autowired
	private Gson gson;
	@Autowired
	private PersonServiceImpl personService;
	
	@RequestMapping(value = { "/do/something/bro", }, method = RequestMethod.GET)
	public ResponseEntity<?> getSomeStuff(){
		
		/*Person p1=new Person("Madara","Leaf");
		List<Child> cList=new ArrayList<>();
		for(int i=1;i<=3;i++){
			Child c=new Child("pikachu"+i, p1);
			cList.add(c);
		}
		p1.setChildList(cList);*/
		Person p1=personService.getPersonById(1);
		p1.setName("Sasuke");
		List<Child> cList=p1.getChildList();
		/*for(int i=1;i<=3;i++){
			cList.get(i-1).setcName("SasuSakura"+i);
		}*/
		cList.remove(0);
		cList.add(new Child("Sasori sama",p1,p1.getId()));
		//personService.savePerson(p1);
		
		return new ResponseEntity<>(gson.toJson(p1),HttpStatus.OK);
	}
	public static void main(String a[]){
		String ax1[]={"aa","ab","ac","ad"};
		List<String> a1=new ArrayList<>(Arrays.asList(ax1));
		Iterator<String> i1=a1.iterator();
		System.out.println(a1);
		while(i1.hasNext()){
			String x=i1.next();
			System.out.println(x);
			i1.remove();
			System.out.println(a1);
		}
		System.out.println("Last:: "+a1);
	}
}
