package edu.fa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import edu.fa.Constants;
//Khai báo Name Query(câu truy vấn) một lần để dùng nhiều nơi
@NamedQueries({
	@NamedQuery(name = Constants.NAME_QUERY_OF_GROUP, query = "FROM Group WHERE name = :name AND id = :id")
})
@Entity
@Table(name = "Groups")
//@Table(...) Đặt lại tên table trong DB là "Groups", vì Group là từ khóa trùng với "Group By"
//Cài đặt để tạo bộ nhớ đệm cấp 2 cho class Group
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY) //usage: là mục đích sử dụng của Transaction ???-READ_ONLY: Chỉ đọc
public class Group {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	//Quan hệ n-n (Mỗi Fresher thuộc nhiều Group, mỗi Group có nhiều Fresher)
	//Collection: Set thì không thể lưu hai giá trị trùng nhau như ArrayList
	@ManyToMany
	private Set<Fresher> freshers = new HashSet<>();

	public Group() {
		System.out.println("Constructor Group: First Level Cache");
	}
	
	public Group(String name, Set<Fresher> freshers) {
		this.name = name;
		this.freshers = freshers;
	}
	
	public Group(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Set<Fresher> getFreshers() {
		return freshers;
	}

	public void setFreshers(Set<Fresher> freshers) {
		this.freshers = freshers;
	}

	@Override
	public String toString() {
		return "Group: " + id + " : " + name;
	}
	
}