package entity;

/**
 * RemainroomId entity. @author MyEclipse Persistence Tools
 */

public class RemainroomId implements java.io.Serializable {

	// Fields

	private String roomtype;
	private Double price;
	private Long count;
	private String status;

	// Constructors

	/** default constructor */
	public RemainroomId() {
	}

	/** full constructor */
	public RemainroomId(String roomtype, Double price, Long count, String status) {
		this.roomtype = roomtype;
		this.price = price;
		this.count = count;
		this.status = status;
	}

	// Property accessors

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

	public Long getCount() {
		return this.count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RemainroomId))
			return false;
		RemainroomId castOther = (RemainroomId) other;

		return ((this.getRoomtype() == castOther.getRoomtype()) || (this
				.getRoomtype() != null && castOther.getRoomtype() != null && this
				.getRoomtype().equals(castOther.getRoomtype())))
				&& ((this.getPrice() == castOther.getPrice()) || (this
						.getPrice() != null && castOther.getPrice() != null && this
						.getPrice().equals(castOther.getPrice())))
				&& ((this.getCount() == castOther.getCount()) || (this
						.getCount() != null && castOther.getCount() != null && this
						.getCount().equals(castOther.getCount())))
				&& ((this.getStatus() == castOther.getStatus()) || (this
						.getStatus() != null && castOther.getStatus() != null && this
						.getStatus().equals(castOther.getStatus())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getRoomtype() == null ? 0 : this.getRoomtype().hashCode());
		result = 37 * result
				+ (getPrice() == null ? 0 : this.getPrice().hashCode());
		result = 37 * result
				+ (getCount() == null ? 0 : this.getCount().hashCode());
		result = 37 * result
				+ (getStatus() == null ? 0 : this.getStatus().hashCode());
		return result;
	}

}