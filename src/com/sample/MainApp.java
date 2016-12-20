package com.sample;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sample.User;

public class MainApp {

	public static void main(String[] args) {

		// Insert
		User user = new User();
		//user.setid(n);               //Auto-increment
		user.setname("Adam");
		user.settelephone("765 555 6666");

		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		
		// Select
		String hql = "from User where name = :name";
		Query query = session.createQuery(hql);
		query.setParameter("name","Adam");
		
		@SuppressWarnings("unchecked")
		List<User> list = query.list();
		for(User usr : list) {
			int usr_id   = usr.getid();
			String usr_name = usr.getname();
			String user_tel = user.gettelephone();
			System.out.println(usr_id+" "+usr_name+" "+user_tel);
		}
		
		// Delete
		String hql3 = "delete User where name = :name";
		Query query3 = session.createQuery(hql3);
		query3.setParameter("name","Adam");
		int result = query3.executeUpdate();
		if (result > 0) {
			System.out.println(" User name Adam removed ");
		}

		// Update
		String hql4 = "update User set name = :name where id = :id";
		Query query4 = session.createQuery(hql4);
		query4.setParameter("name","George");
		query4.setParameter("id",2);
		int result2 = query4.executeUpdate();
		if (result2 > 0) {
			System.out.println("User id is updated");
		}
		
		session.close();
		System.exit(0);
	}

}
