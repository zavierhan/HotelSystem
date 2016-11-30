package action;

import java.util.List;

import service.EmployeeDAO;

import com.opensymphony.xwork2.ModelDriven;

import entity.Employee;
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
		if (rlist != null && rlist.size() > 0) {
			session.setAttribute("AllHome_list", rlist);
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
		if (rList != null && rList.size() > 0) {
			session.setAttribute("AllHome_list", rList);
		}
		return "queryOneTypeHome_success";
	}

	// 回到主页动作
	public String returnToIndex() {
		return "Employee_returnToIndex";
	}

	@Override
	public Employee getModel() {
		return this.employee;
	}

}
