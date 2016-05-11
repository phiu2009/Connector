package com.uis.connector.ws.pojo;

public class WSResponseGet {

	private String supplierId;
	private WSResponseGetDetail<SupplierPojo> getSuppliers;
	private WSResponseGetDetail<PartListing> getPartListings;
	private WSResponseGetDetail<StockListing> getStockListings;
	private WSResponseGetDetail<VehiclePojo> getVehicles;
	private WSResponseGetDetail<PartListingImagePojo> getPartImages;
	private WSResponseGetDetail<StockListingImagePojo> getStockListingImages;
	
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public WSResponseGetDetail<SupplierPojo> getGetSuppliers() {
		return getSuppliers;
	}
	public void setGetSuppliers(WSResponseGetDetail<SupplierPojo> getSuppliers) {
		this.getSuppliers = getSuppliers;
	}
	public WSResponseGetDetail<PartListing> getGetPartListings() {
		return getPartListings;
	}
	public void setGetPartListings(WSResponseGetDetail<PartListing> getPartListings) {
		this.getPartListings = getPartListings;
	}
	public WSResponseGetDetail<StockListing> getGetStockListings() {
		return getStockListings;
	}
	public void setGetStockListings(WSResponseGetDetail<StockListing> getStockListings) {
		this.getStockListings = getStockListings;
	}
	public WSResponseGetDetail<VehiclePojo> getGetVehicles() {
		return getVehicles;
	}
	public void setGetVehicles(WSResponseGetDetail<VehiclePojo> getVehicles) {
		this.getVehicles = getVehicles;
	}
	public WSResponseGetDetail<PartListingImagePojo> getGetPartImages() {
		return getPartImages;
	}
	public void setGetPartImages(WSResponseGetDetail<PartListingImagePojo> getPartImages) {
		this.getPartImages = getPartImages;
	}
	public WSResponseGetDetail<StockListingImagePojo> getGetStockListingImages() {
		return getStockListingImages;
	}
	public void setGetStockListingImages(WSResponseGetDetail<StockListingImagePojo> getStockListingImages) {
		this.getStockListingImages = getStockListingImages;
	}
	
}
