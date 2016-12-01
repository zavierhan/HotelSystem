package entity;

import java.util.Date;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */

public class Order implements java.io.Serializable {

	// Fields

	private Integer orderid;
	private Room room;

	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", timein=" + timein
				+ ", timeout=" + timeout + ", status=" + status + "]";
	}

	private User user;
	private Date timein;
	private Date timeout;
	private String status;

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** full constructor */
	public Order(Room room, User user, Date timein, Date timeout, String status) {
		this.room = room;
		this.user = user;
		this.timein = timein;
		this.timeout = timeout;
		this.status = status;
	}

	// Property accessors

	public Integer getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getTimein() {
		return this.timein;
	}

	public void setTimein(Date timein) {
		this.timein = timein;
	}

	public Date getTimeout() {
		return this.timeout;
	}

	public void setTimeout(Date timeout) {
		this.timeout = timeout;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}