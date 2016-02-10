package scafe.domain.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import scafe.domain.Post;

public interface PostDao extends JpaRepository <Post, Integer> {

	@Modifying
	@Query("update Post p set p.title =?1, p.content=?2 where p.id =?3")
	void upDatePostInfoById(String title, String content, int id);

//	@Modifying
//	@Query("update Post p set p.title =?1, p.content=?2, p.updated_at=?3 where p.id =?4")
//	void upDatePostInfoById(String title, String content, Date d, int id);
}
