package com.uis.connector.ws.pojo;

import java.util.ArrayList;

public class WSRequestAddDetail{

	private ArrayList<PartListing> addPartListings = null;
	private ArrayList<PartListingSupp> addPartListingSupp = null;
	private ArrayList<PartListingComment> addPartListingComments = new ArrayList<PartListingComment>();
	private ArrayList<StockListing> addStockListings = null;
	private ArrayList<StockListingSupp> addStockListingSupp = null;
	private ArrayList<StockListingComment> addStockListingComments = new ArrayList<StockListingComment>();
	
	private ArrayList<MakePojo> addMakes = null;
	private ArrayList<ModelPojo> addModels = null;
	private ArrayList<SeriesPojo> addSeries = null;
	private ArrayList<TrimPojo> addTrims = null;
	private ArrayList<BodyPojo> addBody = null;
	private ArrayList<EnginePojo> addEngines = null;
	private ArrayList<GearboxPojo> addGearboxes = null;
	private ArrayList<PartPojo> addParts = null;
	private ArrayList<VehiclePojo> addVehicles = new ArrayList<VehiclePojo>();
	
	private ArrayList<PartListingImagePojo> addPartImages = new ArrayList<PartListingImagePojo>();
	private ArrayList<StockListingImagePojo> addStockListingImages = new ArrayList<StockListingImagePojo>();
	
	private ArrayList<SupplierPojo> addSuppliers = new ArrayList<SupplierPojo>();
	
	public void addData(Object data){
		switch (data.getClass().getSimpleName()){
			case "PartListing": {getAddPartListings().add((PartListing)data); break;}
			case "PartListingSupp": {getAddPartListingSupp().add((PartListingSupp)data); break;}
			case "PartListingComment": {getAddPartListingComments().add((PartListingComment)data); break;}
			case "StockListing": {getAddStockListings().add((StockListing)data); break;}
			case "StockListingSupp": {getAddStockListingSupp().add((StockListingSupp)data); break;}
			case "StockListingComment": {getAddStockListingComments().add((StockListingComment)data); break;}
			case "MakePojo": {getAddMakes().add((MakePojo)data); break;}
			case "ModelPojo": {getAddModels().add((ModelPojo)data); break;}
			case "SeriesPojo": {getAddSeries().add((SeriesPojo)data); break;}
			case "TrimPojo": {getAddTrims().add((TrimPojo)data); break;}
			case "BodyPojo": {getAddBody().add((BodyPojo)data); break;}
			case "EnginePojo": {getAddEngines().add((EnginePojo)data); break;}
			case "GearboxPojo": {getAddGearboxes().add((GearboxPojo)data); break;}
			case "PartPojo": {getAddParts().add((PartPojo)data); break;}
			case "VehiclePojo": {getAddVehicles().add((VehiclePojo)data); break;}
			
			case "PartListingImagePojo": {getAddPartImages().add((PartListingImagePojo)data); break;}
			case "StockListingImagePojo": {getAddStockListingImages().add((StockListingImagePojo)data); break;}
			
			case "SupplierPojo": {getAddSuppliers().add((SupplierPojo)data); break;}
			default: break;
		}
	}
	
	
	public ArrayList<PartListing> getAddPartListings() {
		if (addPartListings == null){
			addPartListings = new ArrayList<PartListing>();
		}
		return addPartListings;
	}

	public void setAddPartListings(ArrayList<PartListing> addPartListing) {
		this.addPartListings = addPartListing;
	}
	
	public ArrayList<PartListingSupp> getAddPartListingSupp() {
		if (addPartListingSupp == null){
			addPartListingSupp = new ArrayList<PartListingSupp>();
		}
		return addPartListingSupp;
	}

	public void setAddPartListingSupp(ArrayList<PartListingSupp> addPartListingSupp) {
		this.addPartListingSupp = addPartListingSupp;
	}


	public ArrayList<MakePojo> getAddMakes() {
		if (addMakes == null){
			addMakes = new ArrayList<MakePojo>();
		}
		return addMakes;
	}


	public void setAddMakes(ArrayList<MakePojo> addMakes) {
		this.addMakes = addMakes;
	}
	
	public ArrayList<ModelPojo> getAddModels() {
		if (addModels == null){
			addModels = new ArrayList<ModelPojo>();
		}
		return addModels;
	}
	
	public ArrayList<SeriesPojo> getAddSeries() {
		if (addSeries == null){
			addSeries = new ArrayList<SeriesPojo>();
		}
		return addSeries;
	}
	
	public ArrayList<TrimPojo> getAddTrims() {
		if (addTrims == null){
			addTrims = new ArrayList<TrimPojo>();
		}
		return addTrims;
	}
	
	public ArrayList<BodyPojo> getAddBody() {
		if (addBody == null){
			addBody = new ArrayList<BodyPojo>();
		}
		return addBody;
	}
	
	public ArrayList<EnginePojo> getAddEngines() {
		if (addEngines == null){
			addEngines = new ArrayList<EnginePojo>();
		}
		return addEngines;
	}
	
	public ArrayList<GearboxPojo> getAddGearboxes() {
		if (addGearboxes == null){
			addGearboxes = new ArrayList<GearboxPojo>();
		}
		return addGearboxes;
	}
	
	public ArrayList<StockListing> getAddStockListings() {
		if (addStockListings == null){
			addStockListings = new ArrayList<StockListing>();
		}
		return addStockListings;
	}
	
	public ArrayList<StockListingSupp> getAddStockListingSupp() {
		if (addStockListingSupp == null){
			addStockListingSupp = new ArrayList<StockListingSupp>();
		}
		return addStockListingSupp;
	}
	
	public ArrayList<PartPojo> getAddParts() {
		if (addParts == null){
			addParts = new ArrayList<PartPojo>();
		}
		return addParts;
	}

	public ArrayList<PartListingImagePojo> getAddPartImages() {
		return addPartImages;
	}

	public ArrayList<VehiclePojo> getAddVehicles() {
		return addVehicles;
	}
	
	public ArrayList<StockListingImagePojo> getAddStockListingImages() {
		return addStockListingImages;
	}
	
	public ArrayList<PartListingComment> getAddPartListingComments() {
		return addPartListingComments;
	}
	public ArrayList<StockListingComment> getAddStockListingComments() {
		return addStockListingComments;
	}
	public ArrayList<SupplierPojo> getAddSuppliers() {
		return addSuppliers;
	}
}
