package action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import service.UserDAO;

import com.opensymphony.xwork2.ModelDriven;

import entity.Check;
import entity.Description;
import entity.Order;
import entity.Remainroom;
import entity.Room;
import entity.User;

public class UserAction extends SuperAction implements ModelDriven<User> {

	private static final long serialVersionUID = 1L;
	private User user = new User();

	// 未注册时回到首页
	public String returnToIndex1() {
		return "returnToIndex1";
	}

	// 注册后回到首页
	public String returnToIndex2() {
		return "returnToIndex2";
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

	// 修改用户信息
	public String updateUser() {
		UserDAO userDAO = new UserDAO();
		User user = userDAO.queryUserByName(session.getAttribute("user_name")
				.toString());
		// 放进session中
		if (user != null) {
			session.setAttribute("user_self", user);
		}
		return "goto_updateUser";
	}

	// 保存用户提交的个人信息
	public String saveUpdateOne() {
		UserDAO userDAO = new UserDAO();
		User user = userDAO.queryUserByName(session.getAttribute("user_name")
				.toString());
		user.setPassword(request.getParameter("password"));
		user.setPhone(request.getParameter("phone"));
		userDAO.updateUser(user);
		session.setAttribute("user_self", user);
		return "saveUpdateOne_success";
	}

	// 用户登录后查询预订信息
	public String queryOrder() {
		UserDAO userDAO = new UserDAO();
		List<Order> list = userDAO.queryUserOrder(session.getAttribute(
				"user_name").toString());
		if (list != null) {
			session.setAttribute("User_OrderList", list);
		}
		return "user_queryOrder_success";
	}

	// 查询历史住房记录
	public String historyRoom() {
		UserDAO userDAO = new UserDAO();
		List<Check> cList = userDAO.queryHistory(session.getAttribute(
				"user_name").toString());
		if (cList != null) {
			session.setAttribute("User_HistoryList", cList);
		}
		return "historyRoom_success";
	}

	// 转到酒店评价页面
	public String giveComment() {
		UserDAO userDAO = new UserDAO();
		List<Check> cList = userDAO.queryUnComment(session.getAttribute(
				"user_name").toString());
		if (cList != null) {
			session.setAttribute("UnCommentList", cList);
		}
		return "goto_giveComment";
	}

	// 转到评价页面
	public String giveOneComment() {
		UserDAO userDAO = new UserDAO();
		Integer checkid = Integer.valueOf(request
				.getParameter("UnCommentCheckId"));
		Check check = userDAO.queryCheckByID(checkid);
		if (check != null) {
			session.setAttribute("Commentcheck", check);
		}
		return "giveOneComment_success";
	}

	// 保存用户评价
	public String saveComment() throws ParseException {
		UserDAO userDAO = new UserDAO();
		Integer checkid = Integer.valueOf(request.getParameter("checkid"));
		Check check = userDAO.queryCheckByID(checkid);
		String content = request.getParameter("content");
		Date date = new Date();
		Description description = new Description(check, content, date);
		userDAO.saveComment(description);
		return "saveComment_success";
	}

	// 登陆后查看酒店评价
	public String queryMessageAfter() {
		UserDAO userDAO = new UserDAO();
		List<Description> list = userDAO.queryDescriptions();
		if (list != null) {
			session.setAttribute("Description_list", list);
		}
		return "queryMessageAfter_success";
	}

	// 转到预定房间界面
	public String orderRoom() {
		UserDAO userDAO = new UserDAO();
		List<Remainroom> list = userDAO.queryRoom_View();
		// 放进request中
		if (list != null) {
			request.setAttribute("AllHome_list", list);
		}
		return "goto_orderRoom";
	}

	// 用户登陆后查询指定类型房间信息
	public String queryOneTypeHomeAfter() {
		String roomtype = request.getParameter("roomtype");
		if (roomtype.equals("*")) {
			roomtype = "单人房','双人房','大床房','电脑房','经济房";
		}
		UserDAO userDAO = new UserDAO();
		List<Remainroom> rList = userDAO.queryOneTypeHome(roomtype);
		if (rList != null) {
			request.setAttribute("AllHome_list", rList);
		}
		return "queryOneTypeHomeAfter_success";
	}

	// 预定房间
	public String selectOrderRoom() {
		String roomtype = request.getParameter("roomtype");
		UserDAO userDAO = new UserDAO();
		List<Integer> list = userDAO.queryOneTypeHomeNumber(roomtype);
		System.out.println(list.toString() + "===================="
				+ list.size());
		if (list != null) {
			session.setAttribute("OrderRoomNumberList", list);
		}
		session.setAttribute("roomtype", roomtype);
		return "selectOrderRoom_success";
	}

	// 提交预订信息
	public String saveOrderRoom() throws ParseException {
		UserDAO userDAO = new UserDAO();
		Integer roomnumber = Integer
				.valueOf(request.getParameter("roomnumber"));
		User user = userDAO.queryUserByName(session.getAttribute("user_name")
				.toString());
		Room room = userDAO.queryRoomByNumber(roomnumber);
		Date timein = new SimpleDateFormat("yyyy-MM-dd").parse(request
				.getParameter("timein"));
		Date timeout = new SimpleDateFormat("yyyy-MM-dd").parse(request
				.getParameter("timeout"));
		Order order = new Order(room, user, timein, timeout, "待处理");
		userDAO.saveNewOrder(order);
		return "saveOrderRoom_success";
	}

	@Override
	public User getModel() {
		return this.user;
	}

}
