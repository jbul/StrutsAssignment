package actions;

import dao.BaseDAO;
import entities.Post;

public class PostMessage {

	private BaseDAO dao;
	private Post post;
	private boolean isUser;
	
	public PostMessage() {
		this.dao = new BaseDAO();
	}
	
	public String post(){
		String result = "SUCCESS";
		dao.sendPost(post);
		if (isUser) {
			result = "USER";
		}
		
		return result;
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

	public boolean getIsUser() {
		return isUser;
	}

	public void setIsUser(boolean isUser) {
		this.isUser = isUser;
	}
	
	
}
