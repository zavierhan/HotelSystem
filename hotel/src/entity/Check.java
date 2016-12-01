package entity;

import java.util.Date;

/**
 * Check entity. @author MyEclipse Persistence Tools
 */

public class Check implements java.io.Serializable {

	// Fields

	private Integer checkid;
	private Employee employee;
	private Room room;
	private User user;
	private Date timein;
	private Date timeout;
	private String status;

	// Constructors

	/** default constructor */
	public Check() {
	}

	@Override
	public String toString() {
		return "Check [employee=" + employee + ", room=" + room + ", user="
				+ user + ", timein=" + timein + ", timeout=" + timeout
				+ ", status=" + status + "]";
	}

	/** full constructor */
	public Check(Employee employee, Room room, User user, Date timein,
			Date timeout, String status) {
		this.employee = employee;
		this.room = room;
		this.user = user;
		this.timein = timein;
		this.timeout = timeout;
		this.status = status;
	}

	// Property accessors

	public Integer getCheckid() {
		return this.checkid;
	}

	public void setCheckid(Integer checkid) {
		this.checkid = checkid;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
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