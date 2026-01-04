package rahulshettyacademy.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.io.StringReader;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.core.type.TypeReference;

import java.io.StringReader;

public class DataReader {

	public List<HashMap<String, String>> getJSONDataToMap() throws IOException {
		
	String jsonContent=	FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\rahulshettyacademy\\data\\PurchaseOrder.json"),
			StandardCharsets.UTF_8);
	
	//String to hashmap using jackson databind dependency
	ObjectMapper mapper=new ObjectMapper();
	List<HashMap<String,String>> data=mapper.readValue(new StringReader(jsonContent), new TypeReference<List<HashMap<String,String>>>(){
	});
	return data;
	}
}
