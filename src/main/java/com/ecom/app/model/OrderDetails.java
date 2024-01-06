package com.ecom.app.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ecom.app.constant.Constant;
import com.ecom.app.dto.OrderDetailsDto;
import com.ecom.app.enums.OrderStatus;
import com.ecom.app.util.DateUtil;

@Entity
@Table(name = "order_details")
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "user_id")
	private UserData userId;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "product_id")
	private Product productId;

	@Column(name = "uuid")
	private String uuid;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "address_id")
	private UserAddressMap addressId;

	@Column(name = "order_status")
	private OrderStatus orderStatus;

	@Column(name = "created_by")
	private Long createdBy;

	@Column(name = "created_on")
	private Date createdOn;
	
	@Column(name = "cancelled_on")
	private Date cancelledOn;
	
	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserData getUserId() {
		return userId;
	}

	public void setUserId(UserData userId) {
		this.userId = userId;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public UserAddressMap getAddressId() {
		return addressId;
	}

	public void setAddressId(UserAddressMap addressId) {
		this.addressId = addressId;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getCancelledOn() {
		return cancelledOn;
	}

	public void setCancelledOn(Date cancelledOn) {
		this.cancelledOn = cancelledOn;
	}

	public OrderDetails(Long id, UserData userId, Product productId, String uuid, UserAddressMap addressId,
			Long createdBy, Date createdOn,OrderStatus orderStatus) {
		super();
		this.id = id;
		this.userId = userId;
		this.productId = productId;
		this.uuid = uuid;
		this.addressId = addressId;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.orderStatus=orderStatus;
	}

	public OrderDetailsDto convertToOrderDetailsDto() {
		return new OrderDetailsDto(this.getId(),
				this.getUserId() != null && this.getUserId().getId() != null ? this.getUserId().getId() : null,
				this.getUserId(),
				this.getProductId() != null && this.getProductId().getId() != null ? this.getProductId().getId() : null,
				this.getProductId().convertToProductDto(), this.getUuid(),
				this.getAddressId() != null && this.getAddressId().getId() != null ? this.getAddressId().getId() : null,
				this.getAddressId(), this.getCreatedBy(), this.getCreatedOn());
	}

	public OrderDetailsDto convertToOrderDetailsDtoV2() {
		Boolean isAm = true;
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.getCreatedOn());
		cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 4);
		if (cal.get(Calendar.AM_PM) != 0) {
			isAm = false;
		}
		Date deleveryDate = cal.getTime();
		DateFormat dateWIthHour = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		DateFormat dateonly = new SimpleDateFormat("yyyy-MM-dd");
		
		return new OrderDetailsDto(this.getId(),
				this.getUserId() != null && this.getUserId().getId() != null ? this.getUserId().getId() : null,
				this.getUserId(),
				this.getProductId() != null && this.getProductId().getId() != null ? this.getProductId().getId() : null,
				this.getProductId().convertToProductDto(), this.getUuid(),
				this.getAddressId() != null && this.getAddressId().getId() != null ? this.getAddressId().getId() : null,
				this.getAddressId(), this.getCreatedBy(), this.getCreatedOn(),
				this.getProductId() != null && this.getProductId().getProductName() != null
						&& this.getProductId().getModelName() != null
								? this.getProductId().getProductName() + "-" + this.getProductId().getModelName()
								: null,
				isAm ? (dateWIthHour.format(this.getCreatedOn()).toString() + " AM")
						: (dateWIthHour.format(this.getCreatedOn()).toString() + " PM"),
				dateonly.format(deleveryDate).toString(),
				this.getAddressId() != null && this.getAddressId().getAddress() != null
						&& this.getAddressId().getCity() != null && this.getAddressId().getState() != null
								? this.getAddressId().convertToUserAddressMapResponseDto().getAddress()
								: null,this.getOrderStatus(),this.cancelledOn==null ?null:(dateWIthHour.format(this.getCancelledOn()).toString()));
	}

}
