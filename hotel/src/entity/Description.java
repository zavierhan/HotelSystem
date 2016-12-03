package entity;

import java.util.Date;

/**
 * Description entity. @author MyEclipse Persistence Tools
 */

public class Description implements java.io.Serializable {

	// Fields

	private Integer desid;
	private Check check;
	private String content;
	private Date time;

	// Constructors

	/** default constructor */
	public Description() {
	}

	/** full constructor */
	public Description(Check check, String content, Date time) {
		this.check = check;
		this.content = content;
		this.time = time;
	}

	// Property accessors

	public Integer getDesid() {
		return this.desid;
	}

	public void setDesid(Integer desid) {
		this.desid = desid;
	}

	public Check getCheck() {
		return this.check;
	}

	public void setCheck(Check check) {
		this.check = check;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}