package action;

import java.util.List;

import service.UserDAO;

import com.opensymphony.xwork2.ModelDriven;

import entity.Description;
import entity.Remainroom;
import entity.User;

public class UserAction extends SuperAction implements ModelDriven<User> {

	private static final long serialVersionUID = 1L;
	private User user = new User();

	// 未注册时回到首页
	public String returnToIndex1() {
		return "returnToIndex1";
	}

	// 注销用户并退出
	public String logout() {
		session.invalidate();
		return "logout_success";
	}

	// 跳到用户登录页面
	public String login() {
		return "goto_login";
	}

	// 跳转到用户注册页面
	public String goto_register() {
		return "goto_register";
	}

	// 验证用户登陆信息
	public String loginSuccess() {
		UserDAO userDAO = new UserDAO();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		if (userDAO.userLogin(name, password)) {
			// 在session中保存登陆成功的用户名
			session.setAttribute("user_name", name);
			return "user_login_success";
		} else {
			return "user_login_faliure";
		}
	}

	// 保存进用户注册信息
	public String saveRegister() {
		User user = new User(request.getParameter("name"),
				request.getParameter("idnumber"),
				request.getParameter("password"), request.getParameter("phone"));
		UserDAO userDAO = new UserDAO();
		userDAO.saveNewUser(user);
		session.setAttribute("user_name", user.getName());
		return "saveRegister_success";
	}

	// 用户未注册时查看酒店房间
	public String viewRoom() {
		UserDAO userDAO = new UserDAO();
		List<Remainroom> list = userDAO.queryRoom_View();
		// 放进request中
		if (list != null) {
			request.setAttribute("AllHome_list", list);
		}
		return "viewRoom_success";
	}

	// 用户未注册时查询指定类型房间信息
	public String queryOneTypeHome() {
		String roomtype = request.getParameter("roomtype");
		if (roomtype.equals("*")) {
			roomtype = "单人房','双人房','大床房','电脑房','经济房";
		}
		UserDAO userDAO = new UserDAO();
		List<Remainroom> rList = userDAO.queryOneTypeHome(roomtype);
		if (rList != null) {
			request.setAttribute("AllHome_list", rList);
		}
		return "Firstuser_queryOneTypeHome_success";
	}

	// 查看酒店评价
	public String queryMessage() {
		UserDAO userDAO = new UserDAO();
		List<Description> list = userDAO.queryDescriptions();
		if (list != null) {
			session.setAttribute("Description_list", list);
		}
		return "queryMessage_success";
	}

	@Override
	public User getModel() {
		return this.user;
	}

}
