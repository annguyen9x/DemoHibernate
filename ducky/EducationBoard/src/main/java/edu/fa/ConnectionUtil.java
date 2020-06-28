package edu.fa;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ConnectionUtil {
	//Sử dụng Sington để đảm bảo có duy nhất một SessionFactory được tạo ra trong ứng dụng
	private static SessionFactory sessionFactory = null;
	private static int a = 5;
	
	//Hàm tạo SessionFactory để dùng chung cho toàn bộ ứng dụng
	public static SessionFactory getSessionFactory() {
		if( sessionFactory == null ) {
			Configuration configuration = new Configuration();
			configuration.configure(); //hàm này sẽ load file cấu hình hibernate"hibernate.cfg.xml"
			ServiceRegistry registry =
					(ServiceRegistry) new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			/*
			 * "configuration.getProperties()" sẽ truyền vào map ánh xạ những Properties và
			 * Value của map đó => sau đó chọn p/thức build
			 */
			sessionFactory = configuration.buildSessionFactory(registry);
			System.out.println("Test xem thuộc tính có được gọi không: a = "+a);
			System.out.println("Thuộc tính được gọi  => mỗi lần gọi sessionFactory gán = null => rồi lại khởi tạo lại => hơi mất time");
		}
		return sessionFactory;
	}
}
