package com.uis.connector.ws.client;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.uis.connector.entity.Body;
import com.uis.connector.entity.Engine;
import com.uis.connector.entity.Gearbox;
import com.uis.connector.entity.Make;
import com.uis.connector.entity.Model;
import com.uis.connector.entity.Part;
import com.uis.connector.entity.Series;
import com.uis.connector.entity.Trim;
import com.uis.connector.repository.BodyRepository;
import com.uis.connector.repository.EngineRepository;
import com.uis.connector.repository.GearboxRepository;
import com.uis.connector.repository.MakeRepository;
import com.uis.connector.repository.ModelRepository;
import com.uis.connector.repository.PartRepository;
import com.uis.connector.repository.SeriesRepository;
import com.uis.connector.repository.TrimRepository;
import com.uis.connector.repository.VehicleRepository;
import com.uis.connector.util.WSRequestBuilder;
import com.uis.connector.ws.pojo.BodyPojo;
import com.uis.connector.ws.pojo.EnginePojo;
import com.uis.connector.ws.pojo.GearboxPojo;
import com.uis.connector.ws.pojo.MakePojo;
import com.uis.connector.ws.pojo.ModelPojo;
import com.uis.connector.ws.pojo.PartPojo;
import com.uis.connector.ws.pojo.SeriesPojo;
import com.uis.connector.ws.pojo.TrimPojo;
import com.uis.connector.ws.pojo.VehiclePojo;
import com.uis.connector.ws.pojo.WSRequest;

import jersey.repackaged.com.google.common.collect.Lists;

@Component
public class MasterDataWSClient extends AbstractWSClient{

	private static final Log logger = LogFactory.getLog(MasterDataWSClient.class);
	private final int MAX_ENTITY_PER_REQUEST = 100;
	
	@Autowired 
	private WSRequestBuilder reqBuilder;
	
	@Autowired 
	private MakeRepository makeRepository;
	@Autowired 
	private ModelRepository modelRepository;
	@Autowired 
	private SeriesRepository seriesRepository;
	@Autowired 
	private TrimRepository trimRepository;
	@Autowired 
	private BodyRepository bodyRepository;
	@Autowired 
	private EngineRepository engineRepository;
	@Autowired 
	private GearboxRepository gearboxRepository;
	@Autowired 
	private PartRepository partRepository;
	@Autowired 
	private VehicleRepository vehicleRepository;
	
	public void addMakes(){
		addMasterData(MakePojo.class, makeRepository);
	}
	
	public void addModels(){
		addMasterData(ModelPojo.class, modelRepository);
	}
	
	public void addSeries(){
		addMasterData(SeriesPojo.class, seriesRepository);
	}
	
	public void addTrims(){
		addMasterData(TrimPojo.class, trimRepository);
	}
	
	public void addBody(){
		addMasterData(BodyPojo.class, bodyRepository);
	}
	
	public void addEngines(){
		addMasterData(EnginePojo.class, engineRepository);
	}
	
	public void addGearboxes(){
		addMasterData(GearboxPojo.class, gearboxRepository);
	}
	
	public void addParts(){
		addMasterData(PartPojo.class, partRepository);
	}
	
	public void addVehicles(){
		addMasterData(VehiclePojo.class, vehicleRepository);
	}
	
	private <T> void addMasterData(Class pojoClazz, CrudRepository repository){
		List<T> list = Lists.newArrayList(repository.findAll());
		logger.info("addMasterData: Class: " + pojoClazz.getSimpleName() + " Size: " + list.size());
		
    	WSRequest request = reqBuilder.initWSRequest();
    		
		for (int i=0; i<list.size(); i++){
			T entity = list.get(i);
			try {
				Object data = pojoClazz.getConstructor(entity.getClass()).newInstance(entity);
				request.getAdds().addData(data);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			if ((i> 0 && i % MAX_ENTITY_PER_REQUEST == 0) || i >= list.size()-1){
				sendWSRequest(request);
				request = reqBuilder.initWSRequest();
			}
		}
	}
	
	public void updateMakes(List<Make> list){
		updateEntity(list, MakePojo.class);
	}
	
	public void updateModels(List<Model> list){
		updateEntity(list, ModelPojo.class);
	}
	
	public void updateSeries(List<Series> list){
		updateEntity(list, SeriesPojo.class);
	}
	
	public void updateTrims(List<Trim> list){
		updateEntity(list, TrimPojo.class);
	}
	
	public void updateBody(List<Body> list){
		updateEntity(list, BodyPojo.class);
	}
	
	public void updateEngine(List<Engine> list){
		updateEntity(list, EnginePojo.class);
	}
	
	public void updateGearbox(List<Gearbox> list){
		updateEntity(list, GearboxPojo.class);
	}
	
	public void updatePart(List<Part> list){
		updateEntity(list, PartPojo.class);
	}
	
	private <T> void updateEntity(List<T> list, Class pojoClazz){
		WSRequest request = reqBuilder.initWSRequest();
		list.forEach(entity -> {
			try {
				Object data = pojoClazz.getConstructor(entity.getClass()).newInstance(entity);
				request.getUpdates().addData(data);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		});
		
        sendWSRequest(request);
	}
}
