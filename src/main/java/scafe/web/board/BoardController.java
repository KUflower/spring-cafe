package scafe.web.board;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import scafe.domain.Post;
import scafe.domain.User;
import scafe.domain.utils.SecurityUtil;
import scafe.service.PostService;
import scafe.service.UserService;
import scafe.web.board.form.PostForm;

@Controller
@RequestMapping ( value = "/board")
public class BoardController {

	@Autowired
	PostService postService;
	
	@Autowired
	UserService userService;
		
	@RequestMapping(value = {"", "/list"})
	public String boardList (Model model, @PageableDefault(sort = { "id" }, direction = Direction.DESC, size = 10) Pageable pageable){
		Page <Post> postPage = postService.findAll(pageable);
		model.addAttribute ("postPage", postPage);
		return "/board/list";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String getWritePost (Model model, HttpServletRequest request){
		
		PostForm postForm = (PostForm) request.getSession().getAttribute("postForm");	
		if(postForm == null)
			postForm = new PostForm();	
		request.setAttribute("postForm", postForm);
		return "/board/write";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String postWritePost(@Valid PostForm postForm, BindingResult result, HttpServletRequest request, Model model){
		if(result.hasErrors()){
			return "/board/write";
		}

		UserDetails scafeUserDetail = SecurityUtil.getCurrentUserDetails();
		User user = userService.getUserByEmail(scafeUserDetail.getUsername());			
		
		postService.savePostAndUser(postForm, user);			
		request.removeAttribute("postForm");
				
		return "redirect:/board";
	}
	
	@RequestMapping(value ="/{id}/edit", method = RequestMethod.GET)
	public String getEditPost(@PathVariable int id, HttpServletRequest request, Model model){
		UserDetails scafeUserDetail = SecurityUtil.getCurrentUserDetails();
		User user = userService.getUserByEmail(scafeUserDetail.getUsername());	
		request.setAttribute("user", user);
		
		Post post = postService.getOne(id);		
		if(!post.getUserEmail().equals(user.getEmail()))
			return "redirect:/board";
		
		PostForm postForm = new PostForm();
		postForm.setPostForm(post);
		model.addAttribute("postForm", postForm);
		return "/board/write";
	}
	
	@RequestMapping(value="/{id}/edit", method = RequestMethod.POST)
	public String saveEditPost(@Valid PostForm postForm, BindingResult result, @PathVariable int id, Model model, User user){
		postService.editPost(postForm, id);
		return "redirect:/board/{id}";
	}
	
	@RequestMapping(value ="/{id}")
	public String viewPost (@PathVariable int id, Model model){
		
		Post post = postService.getOne(id);
		model.addAttribute(post);
		
		return "/board/post";
	}
	
	@RequestMapping(value ="/{id}/delete")
	public String deletePost (@PathVariable int id){
		UserDetails scafeUserDetail = SecurityUtil.getCurrentUserDetails();
		User user = userService.getUserByEmail(scafeUserDetail.getUsername());	
		
		if(!postService.getOne(id).getUserEmail().equals(user.getEmail()) && !user.getRoles().get(0).getName().equals("ADMIN") && !user.getRoles().get(0).getName().equals("MANAGER"))
			return "redirect:/board";
		postService.deleteById(id);		
		return "redirect:/board";
	}
	

}
