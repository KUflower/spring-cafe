package scafe.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import scafe.web.board.form.PostForm;

@Data
@Entity
@Table (name ="cafe_post")
public class Post implements Serializable{	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name = "user_id", nullable = false)
	private int userId;

	@Column(name = "user_email", nullable = false)
	private String userEmail;

	@Column(name = "user_name", nullable = false)
	private String userName;
	
	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "content", nullable = false)
	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false)
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = false)
	private Date updatedAt;
	
	public void setPost(PostForm postForm){
		this.userId = postForm.getUserId();
		this.userEmail = postForm.getUserEmail();
		this.userName = postForm.getUserName();
		this.title = postForm.getTitle();
		this.content = postForm.getContent();
		if(this.createdAt == null)
			this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	
}
