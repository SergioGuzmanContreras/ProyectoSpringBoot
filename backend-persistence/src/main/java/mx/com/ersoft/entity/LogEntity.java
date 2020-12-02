package mx.com.ersoft.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "log")
public class LogEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "date")
	private Date date;

	@Column(name = "details")
	private String details;

	@Column(name = "userName")
	private String userName;

	@Column(name = "url")
	private String url;

	public LogEntity() { }

	public LogEntity(Date date, String details, String userName, String url) {
		this.date = date;
		this.details = details;
		this.userName = userName;
		this.url = url;
	}

	public int getId() { return id; }
	public Date getDate() { return date; }
	public String getDetails() { return details; }
	public String getUserName() { return userName; }
	public String getUrl() { return url; }

	public void setId(int id) { this.id = id; }
	public void setDate(Date date) { this.date = date; }
	public void setDetails(String details) { this.details = details; }
	public void setUserName(String userName) { this.userName = userName; }
	public void setUrl(String url) { this.url = url; }

	@Override
	public String toString() {
		return "LogEntity [id=" + id + ", date=" + date + ", details=" + details + ", userName=" + userName + ", url=" + url + "]";
	}
	
}
