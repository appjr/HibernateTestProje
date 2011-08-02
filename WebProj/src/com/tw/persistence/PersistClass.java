package com.tw.persistence;
import javax.persistence.*;
import org.hibernate.*;
import org.hibernate.annotations.Entity;
import org.hibernate.cfg.*;
import org.hibernate.tool.hbm2ddl.*;

@Entity
@Table(name="WebApp")
public class PersistClass {

	 @Id
	 @GeneratedValue
	  private Long id;
	 @Column(name="username")
	 private String name;
	 
	 @Column(name="email")
	 private String email;
	 
	 @Column(name="password")
	 private String password;
	 
	 

	 public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Long getId() {return id;}

	public void setId(Long id) {
	    this.id = id;
	}
	 
	public static void main(String args[]) {
		 AnnotationConfiguration config = new AnnotationConfiguration();
		 config.addAnnotatedClass(PersistClass.class);
		 config.configure();
		 new SchemaExport(config).create(true, true);
		 
		 PersistClass persistClass = new PersistClass();
		 persistClass.setName("First");
		 persistClass.setEmail("a@gmail.com");
		 persistClass.setPassword("this");
		 
		 SessionFactory sessionFactory = config.buildSessionFactory();
		 Session session = sessionFactory.getCurrentSession();

		 session.beginTransaction();
		 session.save(persistClass);
		 session.getTransaction().commit();
		}
	 
}







 


