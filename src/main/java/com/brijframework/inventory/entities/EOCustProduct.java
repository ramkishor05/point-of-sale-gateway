package com.brijframework.inventory.entities;

import static com.brijframework.inventory.contants.Constants.CUST_CATEGORY_ID;
import static com.brijframework.inventory.contants.Constants.CUST_PRODUCT;
import static com.brijframework.inventory.contants.Constants.CUST_PROD_APP_ID;
import static com.brijframework.inventory.contants.Constants.EOCUST_PRODUCT;
import static com.brijframework.inventory.contants.Constants.EXPIRY_DATE;
import static com.brijframework.inventory.contants.Constants.GLB_IMG_ID;
import static com.brijframework.inventory.contants.Constants.GLB_MRF_ID;
import static com.brijframework.inventory.contants.Constants.IDEN_NO;
import static com.brijframework.inventory.contants.Constants.MRFTR_DATE;
import static com.brijframework.inventory.contants.Constants.PURCHASE_PRICE;
import static com.brijframework.inventory.contants.Constants.RETAIL_PRICE;
import static com.brijframework.inventory.contants.Constants.SALE_QTN;
import static com.brijframework.inventory.contants.Constants.STOCK_QTN;
import static com.brijframework.inventory.contants.Constants.TITLE;
import static com.brijframework.inventory.contants.Constants.WHOLE_PRICE;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = EOCUST_PRODUCT, uniqueConstraints = { @UniqueConstraint(columnNames = { CUST_PROD_APP_ID, IDEN_NO }) })
public class EOCustProduct extends EOCustItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = TITLE)
	private String title;

	// for purchase cost
	@Column(name = PURCHASE_PRICE)
	private Double purchasePrice;
	
	@JoinColumn(name = "PURCHASE_UNIT")
	@OneToOne
	private EOCustUnit purchaseUnit;

	// for sale cost
	@Column(name = RETAIL_PRICE)
	private Double retailPrice;
	
	@JoinColumn(name = "RETAIL_UNIT")
	@OneToOne
	private EOCustUnit retailUnit;

	@Column(name = WHOLE_PRICE)
	private Double wholePrice;
	
	@JoinColumn(name = "WHOLE_UNIT")
	@OneToOne
	private EOCustUnit wholeUnit;

	@Column(name = STOCK_QTN)
	private Long stockQnt;

	@Column(name = SALE_QTN)
	private Long saleQnt;

	@Column(name = EXPIRY_DATE)
	private Date expDate;

	@Column(name = MRFTR_DATE)
	private Date mfrDate;

	@OneToOne
	@JoinColumn(name = GLB_IMG_ID)
	public EOGlobalMediaDetail glbImageDetail;

	@OneToOne
	@JoinColumn(name = GLB_MRF_ID)
	public EOGlobalManufacturer globalManufacturer;

	@JoinColumn(name = CUST_PROD_APP_ID, nullable = false)
	@ManyToOne
	private EOCustInventoryApp custInventoryApp;

	@Column(name = CUST_CATEGORY_ID)
	public Long custCategoryId;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Double getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(Double retailPrice) {
		this.retailPrice = retailPrice;
	}

	public Double getWholePrice() {
		return wholePrice;
	}

	public void setWholePrice(Double wholePrice) {
		this.wholePrice = wholePrice;
	}

	public Long getStockQnt() {
		return stockQnt;
	}

	public void setStockQnt(Long stockQnt) {
		this.stockQnt = stockQnt;
	}

	public Long getSaleQnt() {
		return saleQnt;
	}

	public void setSaleQnt(Long saleQnt) {
		this.saleQnt = saleQnt;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public Date getMfrDate() {
		return mfrDate;
	}

	public void setMfrDate(Date mfrDate) {
		this.mfrDate = mfrDate;
	}
	
	public EOCustUnit getPurchaseUnit() {
		return purchaseUnit;
	}

	public void setPurchaseUnit(EOCustUnit purchaseUnit) {
		this.purchaseUnit = purchaseUnit;
	}

	public EOCustUnit getRetailUnit() {
		return retailUnit;
	}

	public void setRetailUnit(EOCustUnit retailUnit) {
		this.retailUnit = retailUnit;
	}

	public EOCustUnit getWholeUnit() {
		return wholeUnit;
	}

	public void setWholeUnit(EOCustUnit wholeUnit) {
		this.wholeUnit = wholeUnit;
	}

	public EOGlobalMediaDetail getGlbImageDetail() {
		return glbImageDetail;
	}

	public void setGlbImageDetail(EOGlobalMediaDetail glbImageDetail) {
		this.glbImageDetail = glbImageDetail;
	}

	public EOGlobalManufacturer getGlobalManufacturer() {
		return globalManufacturer;
	}

	public void setGlobalManufacturer(EOGlobalManufacturer globalManufacturer) {
		this.globalManufacturer = globalManufacturer;
	}

	public EOCustInventoryApp getCustInventoryApp() {
		return custInventoryApp;
	}

	public void setCustInventoryApp(EOCustInventoryApp custInventoryApp) {
		this.custInventoryApp = custInventoryApp;
	}

	public Long getCustCategoryId() {
		return custCategoryId;
	}

	public void setCustCategoryId(Long custCategoryId) {
		this.custCategoryId = custCategoryId;
	}

	
}