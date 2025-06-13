package dev.hekmyr.holidays.api.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OdooOrderLineCreateDTO {

    @JsonProperty("order_id")
    private int orderId;

    @JsonProperty("product_id")
    private int productId;

    @JsonProperty("date_stay_begin")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateStayBegin;

    @JsonProperty("date_stay_end")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateStayEnd;

	@JsonProperty("product_uom_qty")
	private double productUomQty;
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public LocalDateTime getDateStayBegin() {
		return dateStayBegin;
	}

	public void setDateStayBegin(LocalDateTime dateStayBegin) {
		this.dateStayBegin = dateStayBegin;
	}

	public LocalDateTime getDateStayEnd() {
		return dateStayEnd;
	}

	public void setDateStayEnd(LocalDateTime dateStayEnd) {
		this.dateStayEnd = dateStayEnd;
	}

	public double getProductUomQty() {
		return productUomQty;
	}

	public void setProductUomQty(double productUomQty) {
		this.productUomQty = productUomQty;
	}
}