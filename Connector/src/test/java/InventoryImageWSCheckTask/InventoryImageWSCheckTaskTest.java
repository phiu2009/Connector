package InventoryImageWSCheckTask;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.uis.connector.ConnectorApplication;
import com.uis.connector.task.InventoryImageWSCheckTask;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ConnectorApplication.class)
public class InventoryImageWSCheckTaskTest {

	@Autowired
	private InventoryImageWSCheckTask task;
	
	@Test
	public void testCheckImageUpdate(){
		task.checkForPartImageUpdateInWebServer();
		
	}
}
