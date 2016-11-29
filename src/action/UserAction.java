package action;

import com.opensymphony.xwork2.ModelDriven;

import entity.User;

public class UserAction extends SuperAction implements ModelDriven<User> {

	private static final long serialVersionUID = 1L;
	private User user = new User();

	public String returnToIndex() {
		return "returnToIndex";
	}

	@Override
	public User getModel() {
		return this.user;
	}

}
