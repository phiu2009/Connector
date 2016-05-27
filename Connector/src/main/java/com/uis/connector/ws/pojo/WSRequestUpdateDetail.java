package com.uis.connector.ws.pojo;

import java.util.ArrayList;

public class WSRequestUpdateDetail{

	private ArrayList<PartListing> updatePartListings = new ArrayList<PartListing>();
	private ArrayList<PartListingSupp> updatePartListingSupp = new ArrayList<PartListingSupp>();
	private ArrayList<PartListingComment> updatePartListingComments = new ArrayList<PartListingComment>();
	private ArrayList<StockListing> updateStockListings = new ArrayList<StockListing>();
	private ArrayList<StockListingSupp> updateStockListingSupp = new ArrayList<StockListingSupp>();
	private ArrayList<StockListingComment> updateStockListingComments = new ArrayList<StockListingComment>();
	
	private ArrayList<MakePojo> updateMakes = new ArrayList<MakePojo>();
	private ArrayList<ModelPojo> updateModels = new ArrayList<ModelPojo>();
	private ArrayList<SeriesPojo> updateSeries = new ArrayList<SeriesPojo>();
	private ArrayList<TrimPojo> updateTrims = new ArrayList<TrimPojo>();
	private ArrayList<EnginePojo> updateEngines = new ArrayList<EnginePojo>();
	private ArrayList<GearboxPojo> updateGearboxes = new ArrayList<GearboxPojo>();
	private ArrayList<PartPojo> updateParts = new ArrayList<PartPojo>();
	
	private ArrayList<PartListingImagePojo> updatePartImages = new ArrayList<PartListingImagePojo>();
	private ArrayList<StockListingImagePojo> updateStockListingImages = new ArrayList<StockListingImagePojo>();
	
	private ArrayList<SupplierPojo> updateSuppliers = new ArrayList<SupplierPojo>();
	
	public void addData(Object data){
		switch (data.getClass().getSimpleName()){
			case "PartListing": {getUpdatePartListings().add((PartListing)data); break;}
			case "PartListingSupp": {getUpdatePartListingSupp().add((PartListingSupp)data); break;}
			case "PartListingComment": {getUpdatePartListingComments().add((PartListingComment)data); break;}
			case "StockListing": {getUpdateStockListings().add((StockListing)data); break;}
			case "StockListingSupp": {getUpdateStockListingSupp().add((StockListingSupp)data); break;}
			case "StockListingComment": {getUpdateStockListingComments().add((StockListingComment)data); break;}
			case "MakePojo": {getUpdateMakes().add((MakePojo)data); break;}
			case "ModelPojo": {getUpdateModels().add((ModelPojo)data); break;}
			case "SeriesPojo": {getUpdateSeries().add((SeriesPojo)data); break;}
			case "TrimPojo": {getUpdateTrims().add((TrimPojo)data); break;}
			case "EnginePojo": {getUpdateEngines().add((EnginePojo)data); break;}
			case "GearboxPojo": {getUpdateGearboxes().add((GearboxPojo)data); break;}
			case "PartPojo": {getUpdateParts().add((PartPojo)data); break;}
			case "SupplierPojo": {getUpdateSuppliers().add((SupplierPojo)data); break;}
			
			case "PartListingImagePojo": {getUpdatePartImages().add((PartListingImagePojo)data); break;}
			case "StockListingImagePojo": {getUpdateStockListingImages().add((StockListingImagePojo)data); break;}
			default: break;
		}
	}
	
	
	public ArrayList<PartListing> getUpdatePartListings() {
		return updatePartListings;
	}

	public void setUpdatePartListings(ArrayList<PartListing> updatePartListing) {
		this.updatePartListings = updatePartListing;
	}

	public ArrayList<PartListingSupp> getUpdatePartListingSupp() {
		return updatePartListingSupp;
	}

	public void setUpdatePartListingSupp(ArrayList<PartListingSupp> updatePartListingSupp) {
		this.updatePartListingSupp = updatePartListingSupp;
	}


	public ArrayList<MakePojo> getUpdateMakes() {
		return updateMakes;
	}


	public void setUpdateMakes(ArrayList<MakePojo> updateMakes) {
		this.updateMakes = updateMakes;
	}


	public ArrayList<ModelPojo> getUpdateModels() {
		return updateModels;
	}


	public void setUpdateModels(ArrayList<ModelPojo> updateModels) {
		this.updateModels = updateModels;
	}


	public ArrayList<SeriesPojo> getUpdateSeries() {
		return updateSeries;
	}


	public void setUpdateSeries(ArrayList<SeriesPojo> updateSeries) {
		this.updateSeries = updateSeries;
	}


	public ArrayList<TrimPojo> getUpdateTrims() {
		return updateTrims;
	}


	public void setUpdateTrims(ArrayList<TrimPojo> updateTrims) {
		this.updateTrims = updateTrims;
	}


	public ArrayList<EnginePojo> getUpdateEngines() {
		return updateEngines;
	}


	public void setUpdateEngines(ArrayList<EnginePojo> updateEngines) {
		this.updateEngines = updateEngines;
	}


	public ArrayList<GearboxPojo> getUpdateGearboxes() {
		return updateGearboxes;
	}


	public void setUpdateGearboxes(ArrayList<GearboxPojo> updateGearboxes) {
		this.updateGearboxes = updateGearboxes;
	}


	public ArrayList<StockListing> getUpdateStockListings() {
		return updateStockListings;
	}


	public void setUpdateStockListings(ArrayList<StockListing> updateStockListings) {
		this.updateStockListings = updateStockListings;
	}


	public ArrayList<StockListingSupp> getUpdateStockListingSupp() {
		return updateStockListingSupp;
	}


	public void setUpdateStockListingSupp(ArrayList<StockListingSupp> updateStockListingSupp) {
		this.updateStockListingSupp = updateStockListingSupp;
	}


	public ArrayList<PartPojo> getUpdateParts() {
		return updateParts;
	}


	public void setUpdateParts(ArrayList<PartPojo> updateParts) {
		this.updateParts = updateParts;
	}
	
	public ArrayList<PartListingComment> getUpdatePartListingComments() {
		return updatePartListingComments;
	}
	public ArrayList<StockListingComment> getUpdateStockListingComments() {
		return updateStockListingComments;
	}
	public ArrayList<SupplierPojo> getUpdateSuppliers() {
		return updateSuppliers;
	}


	public ArrayList<PartListingImagePojo> getUpdatePartImages() {
		return updatePartImages;
	}


	public void setUpdatePartImages(ArrayList<PartListingImagePojo> updatePartImages) {
		this.updatePartImages = updatePartImages;
	}


	public ArrayList<StockListingImagePojo> getUpdateStockListingImages() {
		return updateStockListingImages;
	}


	public void setUpdateStockListingImages(ArrayList<StockListingImagePojo> updateStockListingImages) {
		this.updateStockListingImages = updateStockListingImages;
	}


	public void setUpdatePartListingComments(ArrayList<PartListingComment> updatePartListingComments) {
		this.updatePartListingComments = updatePartListingComments;
	}


	public void setUpdateStockListingComments(ArrayList<StockListingComment> updateStockListingComments) {
		this.updateStockListingComments = updateStockListingComments;
	}


	public void setUpdateSuppliers(ArrayList<SupplierPojo> updateSuppliers) {
		this.updateSuppliers = updateSuppliers;
	}
	
}
