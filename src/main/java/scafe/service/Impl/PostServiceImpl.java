package scafe.service.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import scafe.domain.Post;
import scafe.domain.User;
import scafe.domain.dao.PostDao;
import scafe.service.PostService;
import scafe.web.board.form.PostForm;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	public PostDao postDao;

	@Override 
	public int savePostAndUser ( PostForm postForm, User user){
		Post post = new Post();
		post.setPost(postForm);
		post.setUserEmail(user.getEmail());
		post.setUserId(user.getId());
		post.setUserName(user.getName());
		return postDao.save(post).getId();
	}
	
	@Override
	public int editPostAndUser (Post post, User user){
		if(!post.getUserEmail().equals(user.getEmail())){
			return -1;
		}
		return postDao.save(post).getId();			
	}
	
	@Override
	public List<Post> findAll(){
		return postDao.findAll();
	}

	@Override
	public void save(Post post){
		postDao.save(post);
	}
	
	@Override 
	public Post getOne(Integer id) {
		return postDao.getOne(id);
	}
	
	@Override
	public Page<Post> findAll(Pageable pageable){
		
		return postDao.findAll(pageable);
	}
	
	@Override
	public void deleteById (Integer id){
		postDao.delete(id);
	}

	@Override
	public void deletePost (Post post){
		postDao.delete(post);
	}

	@Override
	public void editPost(PostForm postForm, int id) {
		Post post = this.getOne(id);
		post.setTitle(postForm.getTitle());
		post.setContent(postForm.getContent());
		post.setUpdatedAt(new Date());
		postDao.save(post);
//		postDao.upDatePostInfoById(postForm.getTitle(), postForm.getContent(), new Date(), id);		
	}
	
}
