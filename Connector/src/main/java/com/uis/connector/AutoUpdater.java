package com.uis.connector;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;

import com.uis.connector.repository.SyncRepository;

@Component
public class AutoUpdater implements ExitCodeGenerator {
	
	private final String APPLICATION_VERSION_FILE = "connector_version.json";
	private final String APPLICATION_JAR_NAME = "connector.jar";
	private final String APPLICATION_JAR_BK_NAME = "connector_bk.jar";
	private static final Log logger = LogFactory.getLog(AutoUpdater.class);
	
	@Autowired
	private ApplicationState appState;
	@Autowired
	private SyncRepository syncRepository;
	
	public void checkForUpdate(double currentVersion){
		URL url;
		try {
			 url = new URL(appState.getServerURL() + "/jar/" + APPLICATION_VERSION_FILE);
			 InputStream in = new BufferedInputStream(url.openStream());
			 ByteArrayOutputStream out = new ByteArrayOutputStream();
			 byte[] buf = new byte[1024];
			 int n = 0;
			 while (-1!=(n=in.read(buf)))
			 {
			    out.write(buf, 0, n);
			 }
			 out.close();
			 in.close();
			 String versionStr = new String(out.toByteArray());
			 JSONObject versionObj = new JSONObject(versionStr);
			 if (versionObj.opt("connectorVersion") != null){
				 double version = versionObj.getDouble("connectorVersion");
				 logger.info("Current Version:" + currentVersion + " New Version:" + version);
				 if (version - currentVersion > 0.0){
					 syncRepository.updateVersion(new BigDecimal(version));
					 updateJar();
				 }
			 }
			 
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}
	
	private void updateJar(){
		// Back up old jar file
		Path currentFile = Paths.get(".\\"+APPLICATION_JAR_NAME);
		Path backupFile = Paths.get(".\\"+APPLICATION_JAR_BK_NAME);
		try {
			if (Files.exists(currentFile)){
				Files.copy(currentFile, backupFile, StandardCopyOption.REPLACE_EXISTING);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("Backed up current jar file.");
		
		// Download new jar
		logger.info("Downloading new jar file...");
		getNewJarFromServer();
		
		// Restart tomcat
		logger.info("Restart application...");
		Path executionFile = Paths.get(".\\startConnector.bat");
		String command = executionFile.toString();
		ProcessBuilder builder = new ProcessBuilder(command);
		builder.redirectErrorStream(true); // redirect error stream to output stream
		builder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
		try {
			builder.start().waitFor();
			
			System.exit(0);
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}
	
	private void getNewJarFromServer(){
		URL url;
		try {
			 url = new URL(appState.getServerURL() + "/jar/" + APPLICATION_JAR_NAME);
			 InputStream in = new BufferedInputStream(url.openStream());
			 ByteArrayOutputStream out = new ByteArrayOutputStream();
			 byte[] buf = new byte[1024];
			 int n = 0;
			 while (-1!=(n=in.read(buf)))
			 {
			    out.write(buf, 0, n);
			 }
			 out.close();
			 in.close();
			 byte[] byteArray = out.toByteArray();
			 FileOutputStream fos = new FileOutputStream(APPLICATION_JAR_NAME);
			 fos.write(byteArray);
			 fos.close();
			 logger.info("New jar file downloaded.");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}
	
	@Override
	public int getExitCode() {
		return 0;
	}
}
