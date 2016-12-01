package action;

import java.util.List;

import service.EmployeeDAO;

import com.opensymphony.xwork2.ModelDriven;

import entity.Check;
import entity.Employee;
import entity.Order;
import entity.Room;

public class EmployeeAction extends SuperAction implements
		ModelDriven<Employee> {

	private static final long serialVersionUID = 1L;
	private Employee employee = new Employee();

	// 员工登陆动作
	public String login() {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		if (employeeDAO.employeeLogin(employee)) {
			// 在session中保存登陆成功的用户名
			session.setAttribute("loginemployeeName", employee.getName());
			return "employee_login_success";
		} else {
			return "employee_login_faliure";
		}

	}

	// 员工登出动作
	public String logout() {
		if (session.getAttribute("loginemployeeName") != null) {
			session.invalidate();
		}
		return "employee_logout";
	}

	// 查询所有房间的具体信息
	public String queryHomeStatus() {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		List<Room> rlist = employeeDAO.queryAllHome();
		// 放进session中
		if (rlist != null) {
			// session.setAttribute("AllHome_list", rlist);
			request.setAttribute("AllHome_list", rlist);
		}
		return "queryHomeStatus_success";
	}

	// 查询指定类型房间的信息
	public String queryOneTypeHome() {
		String roomtype = request.getParameter("roomtype");
		if (roomtype.equals("*")) {
			roomtype = "单人房','双人房','大床房','电脑房','经济房";
		}
		String status = request.getParameter("status");
		if (status.equals("*")) {
			status = "空房','非空";
		}
		EmployeeDAO employeeDAO = new EmployeeDAO();
		List<Room> rList = employeeDAO.queryOneTypeHome(roomtype, status);
		if (rList != null) {
			// session.setAttribute("AllHome_list", rList);
			request.setAttribute("AllHome_list", rList);
		}
		return "queryOneTypeHome_success";
	}

	// 显示预定订单
	public String dealOrder() {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		List<Order> olist = employeeDAO.queryUnDealOrder();
		session.setAttribute("undealorderList", olist);
		return "goto_dealOrder_success";
	}

	// 确认预定订单
	public String confirmOrder() {
		Integer roomNumberString = Integer.valueOf(request
				.getParameter("orderConfirmRoomnumber"));
		EmployeeDAO employeeDAO = new EmployeeDAO();
		String employeeName = (String) session
				.getAttribute("loginemployeeName");
		// System.out
		// .println(employeeName + "=2222222222222222222222222222222222");
		Employee employee = employeeDAO.queryEmployeeByName(employeeName);
		// System.out.println(employee + "=3333333333333333333333333333333");
		Order order = employeeDAO.queryOrderByNumber(roomNumberString);

		Check check = new Check(employee, order.getRoom(), order.getUser(),
				order.getTimein(), order.getTimeout(), "待入住");
		// System.out.println(check + "=555555555555555555555555555555555");
		order.setStatus("预订成功");
		System.out.println(order + "=444444444444444444444444444444444444");
		employeeDAO.dealOrder(order, check);
		return "confirmOrder_success";
	}

	// 查看目前住房状态
	public String NowStatus() {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		List<Check> cList = employeeDAO.queryNowHomeStatus();
		if (cList != null) {
			session.setAttribute("NowStatusList", cList);
		}
		return "query_NowStatus_success";
	}

	// 处理入住
	public String dealLivein() {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		List<Check> cList = employeeDAO.queryUnLive();
		session.setAttribute("UnLiveList", cList);
		return "goto_dealLivein";
	}

	// 确认入住
	public String confirmLiveIn() {
		Integer roomNumberString = Integer.valueOf(request
				.getParameter("liveConfirmRoomnumber"));
		EmployeeDAO employeeDAO = new EmployeeDAO();
		String employeeName = (String) session
				.getAttribute("loginemployeeName");
		Employee employee = employeeDAO.queryEmployeeByName(employeeName);
		Check check = employeeDAO.queryChrckByNumber(roomNumberString);
		check.setStatus("入住成功");
		employeeDAO.updateCheck(check);
		return "confirmLiveIn_success";
	}

	// 回到主页动作
	public String returnToIndex() {
		return "Employee_returnToIndex";
	}

	// 修改房间信息
	public String updateRoom() {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		// 首先查询所有未入住房间的房间号
		List<Room> sList = employeeDAO.queryAllnumber_UnLive();
		session.setAttribute("UnLiveRoomList", sList);
		return "goto_updateRoom";
	}

	// 修改某间房间的信息
	public String updateOneRoom() {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		Integer roomnumber = Integer
				.valueOf(request.getParameter("roomnumber"));
		Double price = Double.valueOf(request.getParameter("price"));
		Room room = employeeDAO.queryRoomByNumber(roomnumber);
		String roomtype = request.getParameter("roomtype");
		room.setPrice(price);
		room.setRoomtype(roomtype);
		employeeDAO.updateRoom(room);
		return "updateOneRoom_success";
	}

	// 确认退房
	public String LeaveRoom() {
		Integer roomNumberString = Integer.valueOf(request
				.getParameter("leaveRoomnumber"));
		EmployeeDAO employeeDAO = new EmployeeDAO();
		String employeeName = (String) session
				.getAttribute("loginemployeeName");
		Employee employee = employeeDAO.queryEmployeeByName(employeeName);
		Check check = employeeDAO.queryChrckByNumber(roomNumberString);
		Room room = employeeDAO.queryRoomByNumber(roomNumberString);
		check.setStatus("已退房");
		room.setStatus("空房");
		employeeDAO.updateCheckAndRoom(check, room);
		return "LeaveRoom_success";
	}

	// 产看历史住房信息
	public String historyStatus() {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		List<Check> cList = employeeDAO.queryHistory();
		if (cList != null) {
			session.setAttribute("HistoryList", cList);
		}
		return "historyStatus_success";
	}

	@Override
	public Employee getModel() {
		return this.employee;
	}

}
