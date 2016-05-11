package com.uis.connector.ws.client;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.uis.connector.ConnectorApplication;
import com.uis.connector.entity.Body;
import com.uis.connector.entity.Engine;
import com.uis.connector.entity.Gearbox;
import com.uis.connector.entity.Make;
import com.uis.connector.entity.Model;
import com.uis.connector.entity.Part;
import com.uis.connector.entity.Series;
import com.uis.connector.entity.Trim;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ConnectorApplication.class)
public class MasterDataWSClientTest {

	@Autowired
	private MasterDataWSClient masterDataWSClient;
	
	@Test
	public void testAddMake(){
		masterDataWSClient.addMakes();
	}
	
	@Test
	public void testAddModel(){
		masterDataWSClient.addModels();
	}
	
	@Test
	public void testAddSeries(){
		masterDataWSClient.addSeries();
	}
	
	@Test
	public void testAddTrims(){
		masterDataWSClient.addTrims();
	}
	
	@Test
	public void testAddBody(){
		masterDataWSClient.addBody();
	}
	
	@Test
	public void testAddEngines(){
		masterDataWSClient.addEngines();
	}
	
	@Test
	public void testAddGearboxes(){
		masterDataWSClient.addGearboxes();
	}
	
	@Test
	public void testAddParts(){
		masterDataWSClient.addParts();
	}
	
	@Test
	public void testAddVehicles(){
		masterDataWSClient.addVehicles();
	}
	
	
	@Test
	public void testUpdateMake(){
		List<Make> list = new ArrayList<Make>();
		list.add(new Make(72, "FORD"));
		list.add(new Make(57, "ASIA"));
		
		masterDataWSClient.updateMakes(list);
	}
	
	@Test
	public void testUpdateModel(){
		List<Model> list = new ArrayList<Model>();
		list.add(new Model(957, 58, "SPIDER"));
		list.add(new Model(943, 57, "ROCKSTA"));
		
		masterDataWSClient.updateModels(list);
	}
	
	@Test
	public void testUpdateSeries(){
		List<Series> list = new ArrayList<Series>();
		list.add(new Series(1596, 963, "B61"));
		list.add(new Series(1602, 967, "B62"));
		
		masterDataWSClient.updateSeries(list);
	}
	
	@Test
	public void testUpdateTrim(){
		List<Trim> list = new ArrayList<Trim>();
		list.add(new Trim(957, 1, "SPIDER"));
		list.add(new Trim(943, 1, "ROCKSTA1"));
		
		masterDataWSClient.updateTrims(list);
	}
	
	@Test
	public void testUpdateBody(){
		List<Body> list = new ArrayList<Body>();
		list.add(new Body(91, "5D AEROBACK", "AERO 5Dr"));
		list.add(new Body(94, "4D BLIND VAN", "VAN 4Dr"));
		
		masterDataWSClient.updateBody(list);
	}
	
	@Test
	public void testUpdateEngine(){
		List<Engine> list = new ArrayList<Engine>();
		list.add(new Engine(1, "0.7L ELECTRONIC F/INJ1", "0.7 EFI1"));
		list.add(new Engine(2, "1.0L CARB1", "1.0 CARB"));
		
		masterDataWSClient.updateEngine(list);
	}
	
	@Test
	public void testUpdateGearbox(){
		List<Gearbox> list = new ArrayList<Gearbox>();
		list.add(new Gearbox(4, "2 SP AUTOMATIC1", "AT 2sp1"));
		list.add(new Gearbox(5, "3 SP AUTOMATIC1", "AT 3sp1"));
		
		masterDataWSClient.updateGearbox(list);
	}
	
	@Test
	public void testUpdatePart(){
		List<Part> list = new ArrayList<Part>();
		list.add(new Part(2, "BAR FRONT COMPLETE1", "BbF1", 2, 0, 1));
		
		masterDataWSClient.updatePart(list);
	}
}
