package service;
    import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.Transaction;
	import org.hibernate.cfg.Configuration;
	

import entity.Employee;


	public class Hibernate_CRUD {
		public static void main(String[] args) {
		  SessionFactory factory = new Configuration()
				  .configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				  .buildSessionFactory();
		  Session session = factory.getCurrentSession();
		  Transaction tx = session.beginTransaction();
		  //Inserting  the records
		  Employee emp1 = new Employee(1,"Anu","IT");
		  Employee emp2 = new Employee(2,"Rani","HR");
		  Employee emp3 = new Employee(3,"Pushpa","HR");
	  session.save(emp1);
		  session.save(emp2);
		  session.save(emp3);
		//Retrieving the data
		    Employee employeeDetails3 = session.get(Employee.class,3);
		    System.out.println(employeeDetails3);
		    
		    //Multiple records
		    java.util.List<Employee> empRecords = session.createQuery("from Employee").list();
		    System.out.println("All Employee:");
		    for(int i = 0; i < empRecords.size(); i++) {
		    	System.out.println(empRecords.get(i));
		    }
		    
		    //Update the record
		    Employee empDetails2 = session.get(Employee.class,2);
		    empDetails2.setName("Rani");
		    session.update(empDetails2);
		    
		    //Update through query
		    session.createQuery("update Employee set dept_name = 'Admin' where id = 2").executeUpdate();
		    
		    //Deleting the record
		    Employee empDetails1 = session.get(Employee.class, 1);
		    session.delete(empDetails1);

		  
		tx.commit();
		
		}

	}


