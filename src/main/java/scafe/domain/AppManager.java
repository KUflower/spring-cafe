package scafe.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name ="app_manager")
public class AppManager {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int id;
	
	@Column(name = "user_id", nullable = false)
	private int userId;
	
	@Column(name = "user_name", nullable = false)
	private String userName;

	@Column(name = "user_email", nullable = false)
	private String userEmail;

	@Column(name = "content", nullable = false)
	private String content;

	@Column(name = "applicate_at", nullable = false)
	private Date applicateAt;
	
	public void SetAppManager (AppManager appManager){
		this.userId = appManager.userId;
		this.userName = appManager.userName;
		this.userEmail = appManager.userEmail;
		this.content = appManager.content;		
		this.applicateAt = new Date();
	}

}
