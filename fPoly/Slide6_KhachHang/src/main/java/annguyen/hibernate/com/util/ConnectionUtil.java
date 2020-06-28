package annguyen.hibernate.com.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ConnectionUtil {
	
	private static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration configuration = new Configuration();
			configuration.configure(); // load file cấu hình Hibernate "hibernate.cfg.xml"

			ServiceRegistry serviceRegistry = (ServiceRegistry) new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			// configuration.getProperties(): Sẽ truyền vào Map ánh xạ của properties và các
			// value tương ứng

			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;
	}
}