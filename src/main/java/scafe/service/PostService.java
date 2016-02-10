package scafe.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import scafe.domain.Post;
import scafe.domain.User;
import scafe.web.board.form.PostForm;


public interface PostService {

	public List<Post> findAll();
	public Page<Post> findAll(Pageable pageable);

	public void save(Post post);

	public Post getOne(Integer id);
	
	public void deleteById(Integer id);
	
	public void deletePost (Post post);

	public int savePostAndUser ( PostForm postForm, User user);
	public int editPostAndUser (Post post, User user);
	
	public void editPost(PostForm postForm, int id);
}
