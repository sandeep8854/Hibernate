package com.sandeepAlgoExpert.DemoHiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
public class App 
{
    public static void main( String[] args )
    {
       Alien jupiter=new Alien();
       jupiter.setAid(101);
       jupiter.setAname("Sandeep");
       jupiter.setAcolor("Green");
       
      Configuration con=new Configuration().configure().addAnnotatedClass(Alien.class); 
      
      ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
       SessionFactory sf=con.buildSessionFactory(reg);
       Session session=sf.openSession();
       Transaction tx=session.beginTransaction();
       
      session.save(jupiter);
      tx.commit();
       
    }
}
 		