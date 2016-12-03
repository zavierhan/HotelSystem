package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer userid;
	private String name;
	private String idnumber;
	private String password;
	private String phone;
	private Set orders = new HashSet(0);
	private Set checks = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String name, String idnumber, String password) {
		this.name = name;
		this.idnumber = idnumber;
		this.password = password;
	}

	public User(String name, String idnumber, String password, String phone) {
		super();
		this.name = name;
		this.idnumber = idnumber;
		this.password = password;
		this.phone = phone;
	}

	/** full constructor */
	public User(String name, String idnumber, String password, String phone,
			Set orders, Set checks) {
		this.name = name;
		this.idnumber = idnumber;
		this.password = password;
		this.phone = phone;
		this.orders = orders;
		this.checks = checks;
	}

	// Property accessors

	public Integer getUserid() {
		return this.userid;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", name=" + name + ", idnumber="
				+ idnumber + ", password=" + password + ", phone=" + phone
				+ "]";
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdnumber() {
		return this.idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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