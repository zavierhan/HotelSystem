package service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateSessionFactory;
import entity.Check;
import entity.Employee;
import entity.Order;
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
			hqlString = "from Room";
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

	// 查询所有待确定的预定订单
	public List<Order> queryUnDealOrder() {
		Transaction transaction = null;
		List<Order> list = null;
		String hqlString = "";
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			hqlString = "from Order where status='待处理'";
			Query query = session.createQuery(hqlString);
			list = query.list();
			transaction.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return list;
		} finally {
			if (transaction != null) {
				transaction = null;
			}
		}
	}

	// 查询目前住房信息
	public List<Check> queryNowHomeStatus() {
		Transaction transaction = null;
		List<Check> rlist = null;
		String hqlString = "";
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			hqlString = " from Check where status='入住成功'";
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

	// 查询目前待入住信息
	public List<Check> queryUnLive() {
		Transaction transaction = null;
		List<Check> rlist = null;
		String hqlString = "";
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			hqlString = " from Check where status='待入住'";
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

	// 查询所有未入住的房间号
	public List<Room> queryAllnumber_UnLive() {
		Transaction transaction = null;
		List<Room> sList = null;
		String hqlString = "";
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			hqlString = "from Room where status='空房'";
			Query query = session.createQuery(hqlString);
			sList = query.list();
			transaction.commit();
			return sList;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return sList;
		} finally {
			if (transaction != null) {
				transaction = null;
			}
		}
	}

	// 处理预定订单,同时向check表插入新纪录
	public void dealOrder(Order order, Check check) {
		Transaction transaction = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			session.save(check);
			session.update(order);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if (transaction != null) {
				transaction = null;
			}
		}
	}

	// 根据orderid查询order表信息
	public Order queryOrderByID(Integer orderid) {
		Transaction transaction = null;
		List<Order> rlist = null;
		Order order = null;
		String hqlString = "";
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			hqlString = "from Order where orderid='" + orderid + "'";
			Query query = session.createQuery(hqlString);
			rlist = query.list();
			order = rlist.get(0);
			transaction.commit();
			return order;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return order;
		} finally {
			if (transaction != null) {
				transaction = null;
			}
		}
	}

	// 根据checkid查询check表信息
	public Check queryChrckByID(Integer checkid) {
		Transaction transaction = null;
		List<Check> rlist = null;
		Check check = null;
		String hqlString = "";
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			hqlString = "from Check where checkid='" + checkid + "'";
			Query query = session.createQuery(hqlString);
			rlist = query.list();
			check = rlist.get(0);
			transaction.commit();
			return check;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return check;
		} finally {
			if (transaction != null) {
				transaction = null;
			}
		}
	}

	// 更新check表信息
	public void updateCheck(Check check) {
		Transaction transaction = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			session.update(check);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if (transaction != null) {
				transaction = null;
			}
		}
	}

	// 查看历史住房信息
	public List<Check> queryHistory() {
		Transaction transaction = null;
		List<Check> sList = null;
		String hqlString = "";
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			hqlString = "from Check where status='已退房'";
			Query query = session.createQuery(hqlString);
			sList = query.list();
			transaction.commit();
			return sList;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return sList;
		} finally {
			if (transaction != null) {
				transaction = null;
			}
		}
	}

	// 更新check表和room表信息
	public void updateCheckAndRoom(Check check, Room room) {
		Transaction transaction = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			session.update(check);
			session.update(room);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if (transaction != null) {
				transaction = null;
			}
		}
	}

	// 更新room表信息
	public void updateRoom(Room room) {
		Transaction transaction = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			session.update(room);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if (transaction != null) {
				transaction = null;
			}
		}
	}

	// 根据房间号查询房间信息
	public Room queryRoomByNumber(Integer roomnumber) {
		Transaction transaction = null;
		List<Room> rlist = null;
		Room room = null;
		String hqlString = "";
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			hqlString = "from Room where roomnumber='" + roomnumber + "'";
			Query query = session.createQuery(hqlString);
			rlist = query.list();
			room = rlist.get(0);
			transaction.commit();
			return room;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return room;
		} finally {
			if (transaction != null) {
				transaction = null;
			}
		}
	}

	// 查询当前员工信息
	public Employee queryEmployeeByName(String name) {
		Transaction transaction = null;
		List<Employee> rlist = null;
		Employee employee = null;
		String hqlString = "";
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			hqlString = "from Employee where name='" + name + "'";
			Query query = session.createQuery(hqlString);
			rlist = query.list();
			employee = rlist.get(0);
			transaction.commit();
			return employee;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return employee;
		} finally {
			if (transaction != null) {
				transaction = null;
			}
		}
	}
}
