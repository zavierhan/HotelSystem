package service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateSessionFactory;
import entity.Employeeid;

public class EmployeeDAO {
	// 员工登录
	public boolean employeeLogin(Employeeid employeeid) {
		// 事物对象
		Transaction transaction = null;
		String hql = "";
		try {
			Session session = HibernateSessionFactory.getSessionFactory()
					.openSession();
			// 开启事务
			transaction = session.beginTransaction();
			hql = "from Employeeid where name=? and password=?";
			Query query = session.createQuery(hql);
			// 传入hql中两个占位符的参数
			query.setParameter(0, employeeid.getName());
			query.setParameter(1, employeeid.getPassword());
			List list = query.list();
			// 提交事务,必须在返回之前
			transaction.commit();
			// 开始查询
			if (list.size() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		} finally {
			if (transaction != null) {
				transaction = null;
			}
		}
	}
}
