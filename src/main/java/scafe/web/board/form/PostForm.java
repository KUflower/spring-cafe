package scafe.web.board.form;

import java.util.Date;

import lombok.Data;
import scafe.domain.Post;

@Data
public class PostForm {

	private int userId;
	
	private String userEmail;

	private String userName;
	
	private String title;

	private String content;

	private Date updatedAt;
	
	public void setPostForm( Post post){
		this.userId = post.getId();
		this.userEmail = post.getUserEmail();
		this.userName = post.getUserName();
		this.title = post.getTitle();
		this.content = post.getContent();
	}
	
}
