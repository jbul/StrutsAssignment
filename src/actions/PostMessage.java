package actions;

import dao.BaseDAO;
import entities.Post;

public class PostMessage {

	private BaseDAO dao;
	private Post post;
	
	public PostMessage() {
		this.dao = new BaseDAO();
	}
	
	public String post(){
		dao.sendPost(post);
		return "SUCCESS";
	}

	public BaseDAO getDao() {
		return dao;
	}

	public void setDao(BaseDAO dao) {
		this.dao = dao;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	
	
}
