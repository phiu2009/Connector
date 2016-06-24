package com.uis.connector.ws.client;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uis.connector.ApplicationState;
import com.uis.connector.ws.pojo.WSRequest;
import com.uis.connector.ws.pojo.WSRequestDelete;
import com.uis.connector.ws.pojo.WSRequestGet;
import com.uis.connector.ws.pojo.WSResponse;
import com.uis.connector.ws.pojo.WSResponseGet;


@Component
public class AbstractWSClient {

	protected static final Log logger = LogFactory.getLog(AbstractWSClient.class);
	private RestTemplate rt;

//	private final String URL = "http://localhost:8080/UISws/rest/api";
//	private final String URL = "http://52.62.244.157:8080/UISws/rest/api";
	private String URL;
	private MappingJackson2HttpMessageConverter mappingJackson;
	private ObjectMapper mapper;
	
	@Autowired
	private ApplicationState appState;
	
	@PostConstruct
	public void init(){
		rt = new RestTemplate();
		URL = appState.getWebServerAddress() + "/UISws/rest/api";
		
		for (HttpMessageConverter msgConverter : rt.getMessageConverters()){
			if (msgConverter instanceof MappingJackson2HttpMessageConverter){
				mappingJackson = (MappingJackson2HttpMessageConverter)msgConverter;
				mappingJackson.getObjectMapper().setSerializationInclusion(Include.NON_NULL);
//				SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
//				mappingJackson.getObjectMapper().setDateFormat(dateFormat);
			}
		}
		mapper = mappingJackson.getObjectMapper();
	}
	
	protected WSResponse sendWSRequest(WSRequest request) {
		try{
			 mapper = mappingJackson.getObjectMapper();
	         String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(request);
	         logger.info(jsonInString);
	         
	         String response = rt.postForObject(URL, request, String.class);
	         WSResponse responseObj = mapper.readValue(response, WSResponse.class);
//	         logger.info(response);
	         logger.info(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(responseObj));
	         
	         return responseObj;
         }
         catch(HttpServerErrorException ex){
        	 ex.printStackTrace();
        	 logger.error(ex.getMessage());
         }
         catch (JsonProcessingException ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
		}catch (Exception ex){
			 ex.printStackTrace();
			 logger.error(ex.getMessage());
		}
		
		return null;
	}
	
	protected WSResponseGet sendWSGetRequest(WSRequestGet getRequest){
		try{
			 mapper = mappingJackson.getObjectMapper();
	         String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(getRequest);
//	         String jsonInString = mapper.writeValueAsString(getRequest);
	         logger.info(jsonInString);
	         
	         String response = rt.postForObject(URL, getRequest, String.class);
//	         logger.info(response);
	         
	         WSResponseGet responseObj = mapper.readValue(response, WSResponseGet.class);
	         logger.info(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(responseObj));
	         return responseObj;
        }
        catch(HttpServerErrorException ex){
	       	 ex.printStackTrace();
	       	 logger.error(ex.getMessage());
        }
        catch (JsonProcessingException ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
		}catch (RestClientException ex){
			ex.printStackTrace();
			 logger.error(ex.getMessage());
		}
		catch (Exception ex){
			 ex.printStackTrace();
			 logger.error(ex.getMessage());
		}
		return null;
	}
	
	protected WSResponse sendWSRequest(WSRequestDelete request) {
		try{
			 mapper = mappingJackson.getObjectMapper();
	         String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(request);
	         logger.info(jsonInString);
	         
	         String response = rt.postForObject(URL, request, String.class);
	         WSResponse responseObj = mapper.readValue(response, WSResponse.class);
//	         logger.info(response);
	         logger.info(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(responseObj));
	         
	         return responseObj;
         }
         catch(HttpServerErrorException ex){
        	 ex.printStackTrace();
        	 logger.error(ex.getMessage());
         }
         catch (JsonProcessingException ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
		}catch (Exception ex){
			 ex.printStackTrace();
			 logger.error(ex.getMessage());
		}
		
		return null;
	}
	
	protected String sendSimplifyRequest(JSONObject requestObj){
		String URL = appState.getWebServerAddress() + "/UISws/rest/api/sseMsgReceived";
		
		try{
			String response = rt.postForObject(URL, requestObj.toString(), String.class);
//			logger.info(response);
			return response;
		}
        catch(HttpServerErrorException ex){
       	 	ex.printStackTrace();
       	 	logger.error(ex.getMessage());
		}catch (Exception ex){
			 ex.printStackTrace();
			logger.error(ex.getMessage());
		}
		return null;
	}
}
