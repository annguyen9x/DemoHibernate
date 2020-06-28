package edu.fa.model;

import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable//Class bị nhúng vào table khác trong DB
//@Table(name = "BBB")//Cách 2: mapping B như một table độc lập rồi inser vào table khác trongg DB
public class Syllabus {//Syllabus: giáo trình
	private String content;//nội dung
	private int duration;//thời lượng
	
	public Syllabus() {
	}
	
	public Syllabus(String content, int duration) {
		this.content = content;
		this.duration = duration;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
}
