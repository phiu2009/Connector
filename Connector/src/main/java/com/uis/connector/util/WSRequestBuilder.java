package com.uis.connector.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uis.connector.ApplicationState;
import com.uis.connector.entity.Inventory;
import com.uis.connector.entity.Stock;
import com.uis.connector.repository.LocationRepository;
import com.uis.connector.ws.pojo.PartListing;
import com.uis.connector.ws.pojo.PartListingComment;
import com.uis.connector.ws.pojo.PartListingSupp;
import com.uis.connector.ws.pojo.StockListing;
import com.uis.connector.ws.pojo.StockListingComment;
import com.uis.connector.ws.pojo.StockListingSupp;
import com.uis.connector.ws.pojo.WSRequest;
import com.uis.connector.ws.pojo.WSRequestDelete;
import com.uis.connector.ws.pojo.WSRequestDeleteDetail;
import com.uis.connector.ws.pojo.WSRequestGet;
import com.uis.connector.ws.pojo.WSRequestGetDetail;

@Component
public class WSRequestBuilder {
	
	@Autowired
	private ApplicationState appState;

	private WSRequest request;
	
	public WSRequest initWSRequest(){
		request = new WSRequest();
		request.setSupplierId(appState.getPLSupplierCode());
		
		return request;
	}
	
	public WSRequestDelete initWSDeleteRequest(){
		WSRequestDelete requestDelete = new WSRequestDelete();
		requestDelete.setDeletes(new WSRequestDeleteDetail());
		requestDelete.setSupplierId(appState.getPLSupplierCode());
		
		return requestDelete;
	}
	
	public WSRequestGet initWSRequestGet(WSRequestGetDetail getRequestDetail){
		WSRequestGet getRequest = new WSRequestGet(getRequestDetail);
		getRequest.setSupplierId(appState.getPLSupplierCode());
		
		return getRequest;
	}
	
	public void buildWSRequest(List<Inventory> partList){
		partList.stream().filter(part -> part.getLocation() > 0)
			.forEach(part -> part.setLocationDetail(appState.getLocationMap().get(part.getLocation())));
		
		List<Inventory> updatedParts = partList.stream().filter(part -> part.isSynced()).collect(Collectors.toList());
		List<Inventory> newParts = partList.stream().filter(part -> !part.isSynced()).collect(Collectors.toList());
		
		updatedParts.forEach(inv -> {PartListing part = new PartListing(inv);
									 part.setSupplierId(appState.getPLSupplierId());
									 part.setWheresoldDelete(0);
									 PartListingSupp partSupp = new PartListingSupp(inv, appState.getPLSupplierId());
									 PartListingComment partComment = new PartListingComment(appState.getPLSupplierId(), inv.getSerial(), inv.getComment());
									 request.getUpdates().addData(part);
									 request.getUpdates().addData(partSupp);
									 request.getUpdates().addData(partComment);
									});
		newParts.forEach(inv -> {PartListing part = new PartListing(inv);
								 part.setSupplierId(appState.getPLSupplierId());
								 PartListingSupp partSupp = new PartListingSupp(inv, appState.getPLSupplierId());
		 						 request.getAdds().addData(part);
		 						 request.getAdds().addData(partSupp);
		 						 if (inv.getComment() != null && !"".equals(inv.getComment())){
		 							 PartListingComment partComment = new PartListingComment(appState.getPLSupplierId(), inv.getSerial(), inv.getComment());
		 							 request.getAdds().addData(partComment);
		 						 }
		});
	}
	
	public void buildWSStockRequest(List<Stock> stockList){
		stockList.stream().filter(stock -> stock.getLocation() > 0)
			.forEach(stock -> stock.setLocationDetail(appState.getLocationMap().get(stock.getLocation())));
		
		List<Stock> updatedStocks = stockList.stream().filter(stock -> stock.isSynced()).collect(Collectors.toList());
		List<Stock> newStocks = stockList.stream().filter(part -> !part.isSynced()).collect(Collectors.toList());
		
		updatedStocks.forEach(st -> { StockListing stock = new StockListing(st);
									 stock.setWheredeleteSold(0);
									 stock.setSupplierId(appState.getPLSupplierId());
									 StockListingSupp stockSupp = new StockListingSupp(st, appState.getPLSupplierId());
									 StockListingComment stockComment = new StockListingComment(appState.getPLSupplierId(), st.getSerial(), st.getNotes());
									 request.getUpdates().addData(stock);
									 request.getUpdates().addData(stockSupp);
									 request.getUpdates().addData(stockComment);
									});
		newStocks.forEach(st -> { StockListing stock = new StockListing(st);
		 						 stock.setSupplierId(appState.getPLSupplierId());
								 StockListingSupp stockSupp = new StockListingSupp(st, appState.getPLSupplierId());
		 						 request.getAdds().addData(stock);
		 						 request.getAdds().addData(stockSupp);
		 						 if (st.getNotes() != null && !"".equals(st.getNotes())){
									 StockListingComment stockComment = new StockListingComment(appState.getPLSupplierId(), st.getSerial(), st.getNotes());
									 request.getAdds().addData(stockComment);
								 }
		});
		
	}
	
	public void buildWSRequestResync(List<Inventory> partList){
		partList.stream().filter(part -> part.getLocation() > 0)
			.forEach(part -> part.setLocationDetail(appState.getLocationMap().get(part.getLocation())));
		
		partList.forEach(inv -> {PartListing part = new PartListing(inv);
								 part.setSupplierId(appState.getPLSupplierId());
								 PartListingSupp partSupp = new PartListingSupp(inv, appState.getPLSupplierId());
		 						 request.getAdds().addData(part);
		 						 request.getAdds().addData(partSupp);
		 						 if (inv.getComment() != null && !"".equals(inv.getComment())){
		 							 PartListingComment partComment = new PartListingComment(appState.getPLSupplierId(), inv.getSerial(), inv.getComment());
		 							 request.getAdds().addData(partComment);
		 						 }
		});
	}
	
	public void buildWSStockRequestResync(List<Stock> stockList){
		stockList.stream().filter(stock -> stock.getLocation() > 0)
			.forEach(stock -> stock.setLocationDetail(appState.getLocationMap().get(stock.getLocation())));
		
		stockList.forEach(st -> { StockListing stock = new StockListing(st);
		 						 stock.setSupplierId(appState.getPLSupplierId());
								 StockListingSupp stockSupp = new StockListingSupp(st, appState.getPLSupplierId());
		 						 request.getAdds().addData(stock);
		 						 request.getAdds().addData(stockSupp);
		 						 if (st.getNotes() != null && !"".equals(st.getNotes())){
									 StockListingComment stockComment = new StockListingComment(appState.getPLSupplierId(), st.getSerial(), st.getNotes());
									 request.getAdds().addData(stockComment);
								 }
		});
		
	}
}
