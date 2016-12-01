package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Room entity. @author MyEclipse Persistence Tools
 */

public class Room implements java.io.Serializable {

	// Fields

	private Integer roomid;
	private Integer roomnumber;
	private String roomtype;
	private Double price;
	private String status;
	private Set orders = new HashSet(0);
	private Set checks = new HashSet(0);

	// Constructors

	/** default constructor */
	public Room() {
	}

	/** minimal constructor */
	public Room(Integer roomnumber, String roomtype, Double price, String status) {
		this.roomnumber = roomnumber;
		this.roomtype = roomtype;
		this.price = price;
		this.status = status;
	}

	/** full constructor */
	public Room(Integer roomnumber, String roomtype, Double price,
			String status, Set orders, Set checks) {
		this.roomnumber = roomnumber;
		this.roomtype = roomtype;
		this.price = price;
		this.status = status;
		this.orders = orders;
		this.checks = checks;
	}

	// Property accessors

	@Override
	public String toString() {
		return "Room [roomid=" + roomid + ", roomnumber=" + roomnumber
				+ ", roomtype=" + roomtype + ", price=" + price + ", status="
				+ status + "]";
	}

	public Integer getRoomid() {
		return this.roomid;
	}

	public void setRoomid(Integer roomid) {
		this.roomid = roomid;
	}

	public Integer getRoomnumber() {
		return this.roomnumber;
	}

	public void setRoomnumber(Integer roomnumber) {
		this.roomnumber = roomnumber;
	}

	public String getRoomtype() {
		return this.roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set getOrders() {
		return this.orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}

	public Set getChecks() {
		return this.checks;
	}

	public void setChecks(Set checks) {
		this.checks = checks;
	}

}