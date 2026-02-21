package manytomanybidirectional;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FetchType;
import javax.persistence.Persistence;


public class Main {
public static void main(String[] args) {
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("postgres");
	EntityManager em=emf.createEntityManager();
	
	EntityTransaction et=em.getTransaction();
	Subject e=em.find(Subject.class, 100);
	System.out.println(e);
//	
//	Student student1=new Student();
//	student1.setId(1);
//	student1.setName("Miller");
//	student1.setBranch("CSE");
//	
//	Student student2=new Student();
//	student2.setId(2);
//	student2.setName("Avni");
//	student2.setBranch("ECE");
//	
//	Subject sub1=new Subject();
//	sub1.setId(100);
//	sub1.setName("Micro-processor");
//	
//	Subject sub2=new Subject();
//	sub2.setId(101);
//	sub2.setName("Machine learning");
//	
//	Subject sub3=new Subject();
//	sub3.setId(102);
//	sub3.setName("Software Engineering");
//			
//	List<Student> stu=List.of(student1,student2);
//	List<Subject> subject=List.of(sub1,sub2,sub3);
//	
//	
//	//without mapping null values will be there
//	//student-->subject
//	
//	student1.setSubject(subject);
//	student2.setSubject(subject);
//	
//	//subject-->student
//	
//	sub1.setStudent(stu);
//	sub2.setStudent(stu);
//	sub3.setStudent(stu);
//	
//	et.begin();
//	em.persist(student2);
//	em.persist(student1);
//    et.commit();
//    em.close();
	
}
}
