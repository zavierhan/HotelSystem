package service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateSessionFactory;
import entity.Employee;
import entity.Room;

public class EmployeeDAO {
	// 员工登录
	public boolean employeeLogin(Employee employee) {
		// 事物对象
		Transaction transaction = null;
		String hql = "";
		try {
			Session session = HibernateSessionFactory.getSessionFactory()
					.openSession();
			// 开启事务
			transaction = session.beginTransaction();
			hql = "from Employee where name=? and password=?";
			Query query = session.createQuery(hql);
			// 传入hql中两个占位符的参数
			query.setParameter(0, employee.getName());
			query.setParameter(1, employee.getPassword());
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

	// 查询酒店所有房间信息
	public List<Room> queryAllHome() {
		Transaction transaction = null;
		List<Room> rlist = null;
		String hqlString = "";
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			hqlString = " from Room";
			Query query = session.createQuery(hqlString);
			rlist = query.list();
			transaction.commit();
			return rlist;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return rlist;
		} finally {
			if (transaction != null) {
				transaction = null;
			}
		}
	}

	// 查询指定类型房间信息
	public List<Room> queryOneTypeHome(String roomtype, String status) {
		Transaction transaction = null;
		List<Room> rlist = null;
		String hqlString = "";
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			hqlString = "from Room where roomtype in('" + roomtype
					+ "')and status in('" + status + "')";
			Query query = session.createQuery(hqlString);
			rlist = query.list();
			transaction.commit();
			return rlist;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return rlist;
		} finally {
			if (transaction != null) {
				transaction = null;
			}
		}
	}
}
