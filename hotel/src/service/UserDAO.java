package service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateSessionFactory;
import entity.Check;
import entity.Description;
import entity.Order;
import entity.Remainroom;
import entity.Room;
import entity.User;

public class UserDAO {
	// 插入新用户
	public void saveNewUser(User user) {
		Transaction transaction = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			session.save(user);
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

	// 查询酒店所有空房信息（查视图）
	public List<Remainroom> queryRoom_View() {
		Transaction transaction = null;
		List<Remainroom> rlist = null;
		String hqlString = "";
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			hqlString = "from Remainroom";
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
	public List<Remainroom> queryOneTypeHome(String roomtype) {
		Transaction transaction = null;
		List<Remainroom> rlist = null;
		String hqlString = "";
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			hqlString = "from Remainroom where roomtype in('" + roomtype + "')";
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

	// 查询酒店所有评价
	public List<Description> queryDescriptions() {
		Transaction transaction = null;
		List<Description> rlist = null;
		String hqlString = "";
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			hqlString = "from Description";
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

	// 用户登录
	public boolean userLogin(String name, String password) {
		// 事物对象
		Transaction transaction = null;
		String hql = "";
		try {
			Session session = HibernateSessionFactory.getSessionFactory()
					.openSession();
			// 开启事务
			transaction = session.beginTransaction();
			hql = "from User where name=? and password=?";
			Query query = session.createQuery(hql);
			// 传入hql中两个占位符的参数
			query.setParameter(0, name);
			query.setParameter(1, password);
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

	// 显示个人信息
	public User queryUserByName(String name) {
		Transaction transaction = null;
		List<User> clist = null;
		User user = null;
		String hql = "";
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			hql = "from User where name='" + name + "'";
			Query query = session.createQuery(hql);
			clist = query.list();
			user = clist.get(0);
			transaction.commit();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return user;
		} finally {
			if (transaction != null) {
				transaction = null;
			}
		}
	}

	// 保存用户修改的个人信息
	public boolean updateUser(User user) {
		Transaction transaction = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			session.update(user);
			transaction.commit();
			return true;
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

	// 查询用户所有预定订单
	public List<Order> queryUserOrder(String name) {
		Transaction transaction = null;
		List<Order> list = null;
		String hqlString = "";
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			hqlString = "from Order where user.name='" + name + "'";
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

	// 查看历史住房信息
	public List<Check> queryHistory(String name) {
		Transaction transaction = null;
		List<Check> sList = null;
		String hqlString = "";
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			hqlString = "from Check where status in ('已退房','入住成功') and user.name='"
					+ name + "'";
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

	// 查询未评价订单
	public List<Check> queryUnComment(String name) {
		Transaction transaction = null;
		List<Check> sList = null;
		String hqlString = "";
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			hqlString = "from Check where status in ('已退房','入住成功') and user.name='"
					+ name
					+ "'and checkid not in(select check.checkid from Description)";
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

	// 根据checkid获取check信息
	public Check queryCheckByID(Integer checkid) {
		Transaction transaction = null;
		List<Check> clist = null;
		Check check = null;
		String hql = "";
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			hql = "from Check where checkid='" + checkid + "'";
			Query query = session.createQuery(hql);
			clist = query.list();
			check = clist.get(0);
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

	// 保存用户评论
	public void saveComment(Description description) {
		Transaction transaction = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			session.save(description);
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

	// 查询指定类型房间的房间号
	public List<Integer> queryOneTypeHomeNumber(String roomtype) {
		Transaction transaction = null;
		List<Integer> rlist = null;
		String hqlString = "";
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			hqlString = "from Room where roomtype='" + roomtype
					+ "' and status='空房'";
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

	// 根据房间号获取房间信息
	public Room queryRoomByNumber(Integer roomnumber) {
		Transaction transaction = null;
		List<Room> clist = null;
		Room room = null;
		String hql = "";
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			hql = "from Room where roomnumber='" + roomnumber + "'";
			Query query = session.createQuery(hql);
			clist = query.list();
			room = clist.get(0);
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

	// 保存订单信息
	public void saveNewOrder(Order order) {
		Transaction transaction = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			session.save(order);
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
}
