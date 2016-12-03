package entity;

/**
 * Remainroom entity. @author MyEclipse Persistence Tools
 */

public class Remainroom implements java.io.Serializable {

	// Fields

	private RemainroomId id;

	// Constructors

	/** default constructor */
	public Remainroom() {
	}

	/** full constructor */
	public Remainroom(RemainroomId id) {
		this.id = id;
	}

	// Property accessors

	public RemainroomId getId() {
		return this.id;
	}

	public void setId(RemainroomId id) {
		this.id = id;
	}

}