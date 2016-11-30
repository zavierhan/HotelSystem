package entity;

import java.util.Date;

/**
 * Check entity. @author MyEclipse Persistence Tools
 */

public class Check implements java.io.Serializable {

	// Fields

	private Integer checkid;
	private Employeeid employeeid;
	private Room room;
	private User user;
	private Date timein;
	private Date timeout;
	private Integer status;

	// Constructors

	/** default constructor */
	public Check() {
	}

	/** full constructor */
	public Check(Employeeid employeeid, Room room, User user, Date timein,
			Date timeout, Integer status) {
		this.employeeid = employeeid;
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

	public Employeeid getEmployeeid() {
		return this.employeeid;
	}

	public void setEmployeeid(Employeeid employeeid) {
		this.employeeid = employeeid;
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

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}