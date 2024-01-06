package com.ecom.app.dto;

import java.util.Date;

import com.ecom.app.enums.OrderStatus;
import com.ecom.app.model.OrderDetails;
import com.ecom.app.model.Product;
import com.ecom.app.model.UserAddressMap;
import com.ecom.app.model.UserData;

public class OrderDetailsDto {

	private Long id;

	private Long userId;

	private UserData user;

	private Long productId;

	private ProductDto product;

	private String uuid;

	private Long addressId;

	private UserAddressMap address;

	private Long createdBy;

	private Date createdOn;

	private String productName;

	private String orderAt;

	private String expectedDelivered;

	private String deliveredTo;

	private OrderStatus orderStatus;
	
	private String cancelledOn;

	public OrderDetailsDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public UserData getUser() {
		return user;
	}

	public void setUser(UserData user) {
		this.user = user;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public ProductDto getProduct() {
		return product;
	}

	public void setProduct(ProductDto product) {
		this.product = product;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public UserAddressMap getAddress() {
		return address;
	}

	public void setAddress(UserAddressMap address) {
		this.address = address;
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getOrderAt() {
		return orderAt;
	}

	public void setOrderAt(String orderAt) {
		this.orderAt = orderAt;
	}

	public String getExpectedDelivered() {
		return expectedDelivered;
	}

	public void setExpectedDelivered(String expectedDelivered) {
		this.expectedDelivered = expectedDelivered;
	}

	public String getDeliveredTo() {
		return deliveredTo;
	}

	public void setDeliveredTo(String deliveredTo) {
		this.deliveredTo = deliveredTo;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getCancelledOn() {
		return cancelledOn;
	}

	public void setCancelledOn(String cancelledOn) {
		this.cancelledOn = cancelledOn;
	}

	public OrderDetailsDto(Long id, Long userId, UserData user, Long productId, ProductDto product, String uuid,
			Long addressId, UserAddressMap address, Long createdBy, Date createdOn, String productName, String orderAt,
			String expectedDelivered, String delieredTo, OrderStatus orderStatus,String cancelledOn) {
		super();
		this.id = id;
		this.userId = userId;
		this.user = user;
		this.productId = productId;
		this.product = product;
		this.uuid = uuid;
		this.addressId = addressId;
		this.address = address;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.productName = productName;
		this.orderAt = orderAt;
		this.expectedDelivered = expectedDelivered;
		this.deliveredTo = delieredTo;
		this.orderStatus = orderStatus;
		this.cancelledOn=cancelledOn;
	}

	public OrderDetailsDto(Long id, Long userId, UserData user, Long productId, ProductDto product, String uuid,
			Long addressId, UserAddressMap address, Long createdBy, Date createdOn) {
		super();
		this.id = id;
		this.userId = userId;
		this.user = user;
		this.productId = productId;
		this.product = product;
		this.uuid = uuid;
		this.addressId = addressId;
		this.address = address;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
	}

	public OrderDetails convertToOrderDetails() {
		return new OrderDetails(this.getId(), new UserData(this.getUserId()), new Product(this.getProductId()),
				this.getUuid(), new UserAddressMap(this.getAddressId()), this.getUserId(), this.getCreatedOn(),this.orderStatus!=null?this.getOrderStatus():OrderStatus.ORDER_PLACED);
	}

}
