package action;

import service.EmployeeDAO;

import com.opensymphony.xwork2.ModelDriven;

import entity.Employee;

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

	@Override
	public Employee getModel() {
		return this.employee;
	}

}
