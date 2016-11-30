package action;

import service.EmployeeDAO;

import com.opensymphony.xwork2.ModelDriven;

import entity.Employeeid;

public class EmployeeAction extends SuperAction implements
		ModelDriven<Employeeid> {

	private static final long serialVersionUID = 1L;
	private Employeeid employeeid = new Employeeid();

	// 员工登陆动作
	public String login() {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		if (employeeDAO.employeeLogin(employeeid)) {
			// 在session中保存登陆成功的用户名
			session.setAttribute("loginemployeeName", employeeid.getName());
			return "employee_login_success";
		} else {
			return "employee_login_faliure";
		}

	}

	@Override
	public Employeeid getModel() {
		return this.employeeid;
	}

}
