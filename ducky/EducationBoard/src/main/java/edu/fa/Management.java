package edu.fa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import edu.fa.model.Course;
import edu.fa.model.Fresher;
import edu.fa.model.Group;
import edu.fa.model.Syllabus;

public class Management {

	private static final String Group = null;

	public static void main(String[] args) {
		/* Syllabus syllabus = new Syllabus("Hibernate content-6", 30); */
		// Lưu Class syllabus và các thuộc tính của Course vào DB
		/* Course course = new Course("Hibernate", new Date(), syllabus); */

		List<Syllabus> syllabuses = new ArrayList<Syllabus>();
		syllabuses.add(new Syllabus("Hibernate offline content", 30));
		syllabuses.add(new Syllabus("Hibernate online content", 50));

		Course course = new Course("Hibernate", new Date(), syllabuses);

		/*
		 * insert(course); select(1); ConnectionUtil.getSessionFactory().close();// Đóng
		 * kết nối
		 */
		// Phần quan hệ 1-1
//		Address address = new Address("Duy Tan", "Cau Giay");
//		Fresher fresher = new Fresher("Ducky", address);
		// createFresherAndAddress(fresher);

		// Phần quan hệ 1-n ( và n-1)
//		List<Course> courses = new ArrayList<>();
//		courses.add(new Course("Java"));
//		courses.add(new Course("Hibernate"));
//		Fresher fresher2 = new Fresher("Ducky", courses);
//		createFresherAndCourse(fresher2);
		
		//BEGIN: Phần quan hệ n-n
//		Fresher fresher1 = new Fresher();
//		Fresher fresher2 = new Fresher();
//		Group group1 = new Group("Group 1");
//		Group group2 = new Group("Group 2");
//		
//		Set<Fresher> freshers = new HashSet<>();
//		freshers.add(fresher1);
//		freshers.add(fresher2);
//		
//		Set<Group> groups = new HashSet<>();
//		groups.add(group1);
//		groups.add(group2);
//		
//		fresher1.setName("Fresher 1");
//		fresher1.setGroups(groups);
//		fresher2.setName("Fresher 2");
//		fresher2.setGroups(groups);
		
//		group1.setFreshers(freshers);
//		group2.setFreshers(freshers);
//		
//		createFresherAndGroup(fresher1, fresher2, group1, group2);
		//END: Phần quan hệ n-n
		
		/* BEGIN: Phần CRUD(create-read-update-delete dữ liệu trong DB) */
		//Insert (create)
//		Group javaGroup = new Group("Java Group");
//		Group jsGroup = new Group("JavaScript Group");
//		createGroup(javaGroup);
//		createGroup(jsGroup);
		
		//Đọc dữ liệu từ DB
//		int idGroup = 1;
//		Group group = getGroup(idGroup);
//		System.out.println("Group có id = " + idGroup +" là : " + group.getName());
		
		//Update dữ liệu
//		String nameUpdate = "New Java Group";
//		updateGroup(idGroup, nameUpdate);
//		//In ra sau khi update
//		Group groupUpdate = getGroup(idGroup);
//		System.out.println("Group có id = " + idGroup +" sau khi update: " + groupUpdate.getName());
		
		//Delete dữ liệu
//		int idXoa= 2;
//		//In ra trước khi xóa
//		Group groupDelete = getGroup(idXoa);
//		System.out.println("Group có id = " + idXoa +" trước khi delete: " + groupDelete.getName());
		//Thực hiện xóa
//		deleteGroup(idXoa);
//		//In ra sau khi delete
//		groupDelete = getGroup(idXoa);
//		if( groupDelete != null ) {
//			System.out.println("Group có id = " + idXoa +" sau khi delete: " + groupDelete.getName());
//		}
//		else {
//			System.out.println("Group có id = " + idXoa +" sau khi delete: Null");
//		}
		/* END: Phần CRUD(create-read-update-delete dữ liệu trong DB) */
		
		
		/*BEGIN: phần HQL(Hibernate Query Language - tự động generate câu lệnh SQL tùy CSDL)*/
		
		//Tạo dữ liệu trước để sử dụng
		Group javaGroup = new Group("Java Group");
		Group jsGroup = new Group("JavaScript Group");
		createGroup(javaGroup);
		createGroup(jsGroup);
		
		//Đọc dữ liệu với FROM
		//Lưu ý tên table chỉ cần trùng tên class ở @Entity(class define-đn), không cần trùng tên table DB
		//C1: Đây là cách dùng FROM và Condition Binding (điều kiện) để truy vấn HQL
//		String queryString = "FROM Group WHERE id= ? AND name like ?";//Tên table db là "Groups"; "?" là HashCode
//		int id = 1;
//		String name = "Java%";
//		List<Group> groups = queryGroupUsingHQL(queryString, id, name);
//		System.out.println("C1: List group là: " + groups); 
		
		//C2: Sử dụng Named Query Parameter ( không phụ thuộc vị trí t/số, kiểu dứ liệu truyền vào để set)
//		String queryNamed = "FROM Group WHERE id= :id AND name like :nameThamSo";// Dùng Select * sẽ lỗi (bỏ luôn Select nếu lấy hết cột)
//		int id2 = 1;
//		String name2 = "Java%";
//		List<Group> groupsC2 = queryGroupUsingHQL(queryNamed, id2, name2);
//		System.out.println("C2: List group là: " + groupsC2); 
		
		//update dữ liệu bằng HQL
//		String queryUpdate = "Update Group set name = :nameThamSo WHERE id = :id";
//		int idU = 1;
//		String nameU = "Java Update";
//		updateGroupUsingHQL(queryUpdate, idU, nameU);
		
		//delete dữ liệu bằng HQL
//		String queryDel = "DELETE Group WHERE id = :id";
//		int idD = 2;
//		deleteGroupUsingHQL(queryDel, idD);
		
		/*END: phần HQL(Hibernate Query Language - tự động generate câu lệnh SQL tùy CSDL)*/
		
		/*BEGIN: Phần Criteria (chủ yếu đọc dữ liệu - dễ dàng thay đổi và mở rộng hơn HQL) trong Hibernate */
//		List<Group> queryGroupsUseCriteria = queryGroupsUseCriteria("Java%", 1);
//		System.out.println("Query theo Criteria-List group là: " + queryGroupsUseCriteria); 
		/*END: Phần Criteria (chủ yếu đọc dữ liệu - dễ dàng thay đổi và mở rộng hơn HQL) trong Hibernate */
		
		/*BEGIN: Phần Named Query (Dùng query DB- khai báo một lần và sử dụng nhiều nơi) trong Hibernate và JPA (spring ???) */
//		List<Group> queryGroupsUseNamedQuery = queryGroupsUseNamedQuery("Java Group", 1);
//		System.out.println("Query theo Named Queries-List group là: " + queryGroupsUseNamedQuery); 
		/*END: Phần Named Query (Dùng query DB- khai báo một lần và sử dụng nhiều nơi) trong Hibernate và JPA (spring ???) */
		
		/* BEGIN: First Level caching (Bộ nhớ đệm cấp 1 - mặc định trong Hibernate) */
		//Trong L1:
		//Cùng một record trong DB nhưng gọi 2 lần bởi 2 session khác nhau sẽ tạo 2 Object khác nhau 
		//=>Một Object lấy từ DB sẽ lưu vào một session, 2 session sẽ truy vấn vào DB 2 lần khác nhau 
		//=> Lệnh khởi tạo Object Group được gọi 2 lần 
		//=>Nếu 2 Object cùng lấy từ 1 session thì sẽ chỉ truy vấn 1 lần, lần 2 nó sẽ lấy từ bộ nhớ đệm cấp 1 (nếu chưa close Session)
		System.out.println("\n********** First Level Cache và Second Level Cache **********"); 
		Group showFirstLevelCaching = showFirstLevelCaching(1);
		System.out.println("First Level Cache/ Second Level Cache- Group là: " + showFirstLevelCaching); 

		ConnectionUtil.getSessionFactory().close();// Đóng kết nối
	}
	
	/* BEGIN: First Level caching (Bộ nhớ đệm cấp 1 - mặc định trong Hibernate) */
	public static Group showFirstLevelCaching(int id) {
		Group group = null;
		SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			group = (Group)session.get(Group.class, id);
			
			//Bắt buộc commit Transaction để close() được nó
			session.getTransaction().commit();
			session.close();
			
			//Cùng một record trong DB nhưng gọi 2 lần bởi 2 session khác nhau sẽ tạo 2 Object khác nhau 
			//=>Một Object lấy từ DB sẽ lưu vào một session, 2 session sẽ truy vấn vào DB 2 lần khác nhau
			//Nếu lấy nhiều Object từ cùng một session thì nó chỉ query từ DB lần đầu, lần sau nó get từ bộ nhớ đệm (nếu chưa close Session trong L1)
			session = sessionFactory.openSession();
			session.beginTransaction();
			group = (Group)session.get(Group.class, id);
			
			//Bắt buộc commit Transaction để close() được nó
			session.getTransaction().commit();
			session.close();
			
			return group;
		} catch (Exception e) {
			System.out.println("Error-createFresher: " + e.toString());
		}
		
		return null;
	}
	/* END: First Level caching (Bộ nhớ đệm cấp 1 - mặc định trong Hibernate) */
	
	/*BEGIN: Phần Named Query (Dùng query DB- khai báo một lần và sử dụng nhiều nơi) trong Hibernate và JPA (spring ???) */

	//Hàm get dữ liệu từ DB bằng NamedQuery
	public static List<Group> queryGroupsUseNamedQuery(String name, int id) {
		List<Group> groups = null;
		SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Query namedQuery = session.getNamedQuery(Constants.NAME_QUERY_OF_GROUP);
			namedQuery.setParameter("name", name);
			namedQuery.setParameter("id", id);
			groups = (List<Group>)namedQuery.list();
			return groups;
		} catch (Exception e) {
			System.out.println("Error-createFresher: " + e.toString());
		}
		
		return null;
	}
	/*END: Phần Named Query (Dùng query DB- khai báo một lần và sử dụng nhiều nơi) trong Hibernate và JPA (spring ???) */
	
	/*BEGIN: Phần Criteria (chủ yếu đọc dữ liệu - dễ dàng thay đổi và mở rộng hơn HQL) trong Hibernate */

	//Hàm get dữ liệu từ DB bằng Criteria
	public static List<Group> queryGroupsUseCriteria(String name, int id) {
		List<Group> groups = null;
		SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Criteria groupCriteria = session.createCriteria(Group.class);
			//Restrictions là class có các hàm tương tự như điề	u kiện so sánh trong WHERE
			groupCriteria.add(Restrictions.eq("id", id));//lấy ra record có: id = 1
			groupCriteria.add(Restrictions.like("name", name));//Và lấy ra record có: And name = "Java%"
			groups = (List<Group>)groupCriteria.list();
			return groups;
		} catch (Exception e) {
			System.out.println("Error-createFresher: " + e.toString());
		}
		
		return null;
	}
	/*END: Phần Criteria (chủ yếu đọc dữ liệu - dễ dàng thay đổi và mở rộng hơn HQL) trong Hibernate */
	
	/*BEGIN: phần HQL(Hibernate Query Language - tự động generate câu lệnh SQL tùy CSDL)*/
		
	//Hàm đọc dữ liệu từ DB bằng HQL
	public static List<Group> queryGroupUsingHQL(String queryString, int id, String name) {
		List<Group> groups = null;
		SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
//			group = (Group)session.get(Group.class, idGroup);//Khi không dùng HQL
			Query query = (Query) session.createQuery(queryString);//Dùng HQL
			//C1: Dùng Condition Binding ( Điều kiện theo HashCode ?)
//			query.setInteger(0, id);
//			query.setString(1, name);
			
			//C2: Điều kiện theo setParameter
			query.setParameter("id", id);
			query.setParameter("nameThamSo", name);
			groups =  (List<Group>)query.list();
			return groups;
		} catch (Exception e) {
			System.out.println("Error-createFresher: " + e.toString());
		}
		
		return null;
	}
	
	//Hàm update dữ liệu từ DB bằng HQL
	public static int updateGroupUsingHQL(String queryString, int id, String name) {
		int rows = 0;
		SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = (Query) session.createQuery(queryString);//Dùng HQL
			//C1: Dùng Condition Binding ( Điều kiện theo HashCode ?)
			//				query.setInteger(0, id);
			//				query.setString(1, name);
			
			//C2: Điều kiện theo setParameter
			query.setParameter("id", id);
			query.setParameter("nameThamSo", name);
			rows = query.executeUpdate();//Thực hiện update
			session.getTransaction().commit();//Đẩy lên DB để Update
			return rows;
		} catch (Exception e) {
			System.out.println("Error-createFresher: " + e.toString());
		}
		
		return 0;
	}
	
	//Hàm delete dữ liệu từ DB bằng HQL
	public static int deleteGroupUsingHQL(String queryString, int id) {
		int rows = 0;
		SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = (Query) session.createQuery(queryString);//Dùng HQL
			//C1: Dùng Condition Binding ( Điều kiện theo HashCode ?)
			//				query.setInteger(0, id);
			
			//C2: Điều kiện theo setParameter
			query.setParameter("id", id);
			rows = query.executeUpdate();//Thực hiện delete
			session.getTransaction().commit();//Đẩy lên DB để Delete
			return rows;
		} catch (Exception e) {
			System.out.println("Error-createFresher: " + e.toString());
		}
		
		return 0;
	}


	/*END: phần HQL(Hibernate Query Language - tự động generate câu lệnh SQL tùy CSDL)*/
	
	
	
	/* BEGIN: Phần CRUD(create-read-update-delete dữ liệu trong DB) */
	
	//Hàm đọc dữ liệu từ DB
	public static Group getGroup(int idGroup) {
		Group group = null;
		SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			group = (Group)session.get(Group.class, idGroup);
			return group;
		} catch (Exception e) {
			System.out.println("Error-createFresher: " + e.toString());
		}
		
		return null;
	}
		
	//Hàm thêm dữ liệu vào DB
	public static void createGroup(Group group) {
		SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(group);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error-createFresher: " + e.toString());
		}

	}
	
	//Hàm update dữ liệu từ DB
	public static void updateGroup(int idGroup, String nameUpdate) {
		Group group = null;
		SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			//Lấy ra Group theo Id
			group = (Group)session.get(Group.class, idGroup);
			//thực hiện update
			group.setName(nameUpdate);
			session.update(group);
			session.getTransaction().commit();//Thực hiện đẩy object Group lên để update DB
		} catch (Exception e) {
			System.out.println("Error-createFresher: " + e.toString());
		}
		
	}
	
	//Hàm delete dữ liệu từ DB
	public static void deleteGroup(int idGroup) {
		Group group = null;
		SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			//Lấy ra Group theo Id
			group = (Group)session.get(Group.class, idGroup);
			//thực hiện xóa
			session.delete(group);
			session.getTransaction().commit();//Thực hiện đẩy object Group lên để xóa trong DB
		} catch (Exception e) {
			System.out.println("Error-createFresher: " + e.toString());
		}
		
	}
	/* END: Phần CRUD(create-read-update-delete dữ liệu trong DB) */
	
	public static void createFresherAndGroup(Fresher fresher1, Fresher fresher2, Group group1, Group group2) {
		SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();// Bắt đầu một giao dịch ( một vòng đời) session
			//lưu các table trong quan hệ n-n
			session.save(fresher1);
			session.save(fresher2);
			session.save(group1);
			session.save(group2);
			session.getTransaction().commit();// Đẩy Object Fresher lên lưu DB
		} catch (Exception e) {
			System.out.println("Error-createFresher: " + e.toString());
		}

	}

	public static void createFresherAndCourse(Fresher fresher) {
		SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();// Bắt đầu một giao dịch ( một vòng đời) session
			for (Course course : fresher.getCourses()) {
				session.save(course);// Lưu table Course trước
				// (Do quan hệ 1-n: Fresher không có khóa ngoại đến Course, join table sẽ có khóa ngoại đến 2 table)
			}
			session.save(fresher);// (Do quan hệ 1-n: Fresher không có khóa ngoại đến Course, join table sẽ có khóa ngoại đến 2 table)
			session.getTransaction().commit();// Đẩy Object Fresher lên lưu DB
		} catch (Exception e) {
			System.out.println("Error-createFresher: " + e.toString());
		}

	}

	public static void createFresherAndAddress(Fresher fresher) {
		SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();// Bắt đầu một giao dịch ( một vòng đời) session
			session.save(fresher.getAddress());// Lưu table Address trước
			// (Do quan hệ 1-1 nhưng một chiều: Fresher có khóa ngoại đến Address)

			session.save(fresher);// Lưu table Fresher sau (Do quan hệ 1-1 nhưng một chiều: Fresher có khóa ngoại
									// đến Address)
			session.getTransaction().commit();// Đẩy Object Fresher lên lưu DB
		} catch (Exception e) {
			System.out.println("Error-createFresher: " + e.toString());
		}

	}

	public static void insert(Course course) {
		// Yêu cầu: Insert Course này vào trong table Course của database education
		// trong Derby
		/*
		 * Cấn tạo Session để lưu Object Course vào DB, do đó cần SessionFactory [là
		 * Class được design theo FactoryPattern]
		 */

		SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();// Bắt đầu một giao dịch transaction
			session.save(course);
			session.getTransaction().commit();// đẩy Object Course lên để lưu vào DB;
		} catch (Exception e) {
			System.out.println("Loi: " + e.toString());
		}
	}

	public static void select(int id) {
		SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();// Bắt đầu một giao dịch transaction
			/* Select dữ liệu table Course trong DB ra: lấy dòng dữ liệu có ID=2 */
			Course course1 = (Course) session.get(Course.class, id);
			System.out.println("Name của Course có id =" + id + " là: " + course1.getName());

			session.getTransaction().commit();
			session.close();

			System.out.println("Thuộc tính của Course dạng Collection(List, Map,..), cụ thể List<Syllabus>  là: "
					+ course1.getSyllabuses().get(0).getContent());
		} catch (Exception e) {
			System.out.println("Loi: " + e.toString());
		}
	}
}
