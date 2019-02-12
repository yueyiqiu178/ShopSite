package site.yueyiqiu.util.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	
	private static SessionFactory factory=null;
	private static Configuration cfg=new Configuration();
	
	static{
		
		
		cfg.configure();
		factory=cfg.buildSessionFactory();
		
		
	}
	
}
