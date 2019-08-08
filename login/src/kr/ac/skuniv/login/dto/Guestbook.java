package kr.ac.skuniv.login.dto;

public class Guestbook {
	
	private int num;
	private String id;
	private String content;
	private String date;

	public Integer getNum() {
		return num;
	}
	
	public void setNum(Integer num) {
		this.num = num;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Guestbook [num=" + num + ", id=" + id + ", content=" + content + ", date=" + date + "]";
	}
	
	

}
