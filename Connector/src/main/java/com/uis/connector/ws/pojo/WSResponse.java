package com.uis.connector.ws.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value=Include.NON_EMPTY)
public class WSResponse {

	private String supplierId;
	private WSResponseDetail addPartListings;
	private WSResponseDetail addPartListingSupp;
	private WSResponseDetail addStockListings;
	private WSResponseDetail addStockListingSupp;
	private WSResponseDetail addMakes;
	private WSResponseDetail addModels;
	private WSResponseDetail addSeries;
	private WSResponseDetail addTrims;
	private WSResponseDetail addBody;
	private WSResponseDetail addEngines;
	private WSResponseDetail addGearboxes;
	private WSResponseDetail addParts;
	private WSResponseDetail addVehicles;
	private WSResponseDetail addPartImages;
	private WSResponseDetail addStockListingImages;
	private WSResponseDetail addPartListingComments;
	private WSResponseDetail addStockListingComments;
	private WSResponseDetail addSuppliers;
	
	private WSResponseDetail updatePartListings;
	private WSResponseDetail updatePartListingSupp;
	private WSResponseDetail updateStockListings;
	private WSResponseDetail updateStockListingSupp;
	private WSResponseDetail updateMakes;
	private WSResponseDetail updateModels;
	private WSResponseDetail updateSeries;
	private WSResponseDetail updateTrims;
	private WSResponseDetail updateBody;
	private WSResponseDetail updateEngines;
	private WSResponseDetail updateGearboxes;
	private WSResponseDetail updateParts;
	private WSResponseDetail updatePartListingComments;
	private WSResponseDetail updateStockListingComments;
	private WSResponseDetail updateSuppliers;
	private WSResponseDetail updatePartImages;
	
	public WSResponseDetail getAddPartListings() {
		return addPartListings;
	}
	public void setAddPartListings(WSResponseDetail addPartListings) {
		this.addPartListings = addPartListings;
	}
	public WSResponseDetail getAddStockListingImages() {
		return addStockListingImages;
	}
	public void setAddStockListingImages(WSResponseDetail addStockListingImages) {
		this.addStockListingImages = addStockListingImages;
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public WSResponseDetail getAddPartListingSupp() {
		return addPartListingSupp;
	}
	public void setAddPartListingSupp(WSResponseDetail addPartListingSupp) {
		this.addPartListingSupp = addPartListingSupp;
	}
	public WSResponseDetail getAddStockListings() {
		return addStockListings;
	}
	public void setAddStockListings(WSResponseDetail addStockListings) {
		this.addStockListings = addStockListings;
	}
	public WSResponseDetail getAddStockListingSupp() {
		return addStockListingSupp;
	}
	public void setAddStockListingSupp(WSResponseDetail addStockListingSupp) {
		this.addStockListingSupp = addStockListingSupp;
	}
	public WSResponseDetail getAddMakes() {
		return addMakes;
	}
	public void setAddMakes(WSResponseDetail addMakes) {
		this.addMakes = addMakes;
	}
	public WSResponseDetail getAddModels() {
		return addModels;
	}
	public void setAddModels(WSResponseDetail addModels) {
		this.addModels = addModels;
	}
	public WSResponseDetail getAddSeries() {
		return addSeries;
	}
	public void setAddSeries(WSResponseDetail addSeries) {
		this.addSeries = addSeries;
	}
	public WSResponseDetail getAddTrims() {
		return addTrims;
	}
	public void setAddTrims(WSResponseDetail addTrims) {
		this.addTrims = addTrims;
	}
	public WSResponseDetail getAddBody() {
		return addBody;
	}
	public void setAddBody(WSResponseDetail addBody) {
		this.addBody = addBody;
	}
	public WSResponseDetail getAddEngines() {
		return addEngines;
	}
	public void setAddEngines(WSResponseDetail addEngines) {
		this.addEngines = addEngines;
	}
	public WSResponseDetail getAddGearboxes() {
		return addGearboxes;
	}
	public void setAddGearboxes(WSResponseDetail addGearboxes) {
		this.addGearboxes = addGearboxes;
	}
	public WSResponseDetail getAddParts() {
		return addParts;
	}
	public void setAddParts(WSResponseDetail addParts) {
		this.addParts = addParts;
	}
	public WSResponseDetail getAddVehicles() {
		return addVehicles;
	}
	public void setAddVehicles(WSResponseDetail addVehicles) {
		this.addVehicles = addVehicles;
	}
	public WSResponseDetail getAddPartImages() {
		return addPartImages;
	}
	public void setAddPartImages(WSResponseDetail addPartImages) {
		this.addPartImages = addPartImages;
	}
	public WSResponseDetail getUpdatePartListings() {
		return updatePartListings;
	}
	public void setUpdatePartListings(WSResponseDetail updatePartListings) {
		this.updatePartListings = updatePartListings;
	}
	public WSResponseDetail getUpdatePartListingSupp() {
		return updatePartListingSupp;
	}
	public void setUpdatePartListingSupp(WSResponseDetail updatePartListingSupp) {
		this.updatePartListingSupp = updatePartListingSupp;
	}
	public WSResponseDetail getUpdateStockListings() {
		return updateStockListings;
	}
	public void setUpdateStockListings(WSResponseDetail updateStockListings) {
		this.updateStockListings = updateStockListings;
	}
	public WSResponseDetail getUpdateStockListingSupp() {
		return updateStockListingSupp;
	}
	public void setUpdateStockListingSupp(WSResponseDetail updateStockListingSupp) {
		this.updateStockListingSupp = updateStockListingSupp;
	}
	public WSResponseDetail getUpdateMakes() {
		return updateMakes;
	}
	public void setUpdateMakes(WSResponseDetail updateMakes) {
		this.updateMakes = updateMakes;
	}
	public WSResponseDetail getUpdateModels() {
		return updateModels;
	}
	public void setUpdateModels(WSResponseDetail updateModels) {
		this.updateModels = updateModels;
	}
	public WSResponseDetail getUpdateSeries() {
		return updateSeries;
	}
	public void setUpdateSeries(WSResponseDetail updateSeries) {
		this.updateSeries = updateSeries;
	}
	public WSResponseDetail getUpdateTrims() {
		return updateTrims;
	}
	public void setUpdateTrims(WSResponseDetail updateTrims) {
		this.updateTrims = updateTrims;
	}
	public WSResponseDetail getUpdateBody() {
		return updateBody;
	}
	public void setUpdateBody(WSResponseDetail updateBody) {
		this.updateBody = updateBody;
	}
	public WSResponseDetail getUpdateEngines() {
		return updateEngines;
	}
	public void setUpdateEngines(WSResponseDetail updateEngines) {
		this.updateEngines = updateEngines;
	}
	public WSResponseDetail getUpdateGearboxes() {
		return updateGearboxes;
	}
	public void setUpdateGearboxes(WSResponseDetail updateGearboxes) {
		this.updateGearboxes = updateGearboxes;
	}
	public WSResponseDetail getUpdateParts() {
		return updateParts;
	}
	public void setUpdateParts(WSResponseDetail updateParts) {
		this.updateParts = updateParts;
	}
	public WSResponseDetail getAddPartListingComments() {
		return addPartListingComments;
	}
	public void setAddPartListingComments(WSResponseDetail addPartListingComments) {
		this.addPartListingComments = addPartListingComments;
	}
	public WSResponseDetail getUpdatePartListingComments() {
		return updatePartListingComments;
	}
	public void setUpdatePartListingComments(WSResponseDetail updatePartListingComments) {
		this.updatePartListingComments = updatePartListingComments;
	}
	public WSResponseDetail getAddStockListingComments() {
		return addStockListingComments;
	}
	public void setAddStockListingComments(WSResponseDetail addStockListingComments) {
		this.addStockListingComments = addStockListingComments;
	}
	public WSResponseDetail getUpdateStockListingComments() {
		return updateStockListingComments;
	}
	public void setUpdateStockListingComments(WSResponseDetail updateStockListingComments) {
		this.updateStockListingComments = updateStockListingComments;
	}
	public WSResponseDetail getAddSuppliers() {
		return addSuppliers;
	}
	public void setAddSuppliers(WSResponseDetail addSuppliers) {
		this.addSuppliers = addSuppliers;
	}
	public WSResponseDetail getUpdateSuppliers() {
		return updateSuppliers;
	}
	public void setUpdateSuppliers(WSResponseDetail updateSuppliers) {
		this.updateSuppliers = updateSuppliers;
	}
	public WSResponseDetail getUpdatePartImages() {
		return updatePartImages;
	}
	public void setUpdatePartImages(WSResponseDetail updatePartImages) {
		this.updatePartImages = updatePartImages;
	}
	
}
