package ogzkaras.predictApi.BigmlIO;

import org.bigml.binding.AuthenticationException;
import org.bigml.binding.BigMLClient;
import org.json.simple.JSONObject;

public class Requests {
	public  String getSource(String path) throws AuthenticationException  {
		BigMLClient api = new BigMLClient(
			    "oguzkkaras", "c64f8f04d57b214145a63e6f84a52e51ae4fc5a5", null);
		String sourceId;
		JSONObject args = null;
		JSONObject source = api.createSource(
			    path, "Iris Source", args);
		sourceId=(String) source.get("resource");
		return sourceId;
		
	}
	
	public  String getDataset( String source) throws AuthenticationException {
		BigMLClient api = new BigMLClient(
			    "oguzkkaras", "c64f8f04d57b214145a63e6f84a52e51ae4fc5a5", null);
		String datasetId;
		JSONObject args =null;
		JSONObject dataset = api.createDataset(source, args, null, null);
		datasetId=(String) dataset.get("resource");
		return datasetId;
	}
	
	public  String createModel( String datasetId) throws AuthenticationException {
		BigMLClient api = new BigMLClient(
			    "oguzkkaras", "c64f8f04d57b214145a63e6f84a52e51ae4fc5a5", null);
		String modelId;
		JSONObject args =null;
		JSONObject model = api.createModel(datasetId, args, null, null);
		modelId=(String) model.get("resource");
		return modelId;
	}
	
	public  void getPredict( String modelId, JSONObject inputData) throws AuthenticationException {
		BigMLClient api = new BigMLClient(
			    "oguzkkaras", "c64f8f04d57b214145a63e6f84a52e51ae4fc5a5", null);
		JSONObject args =null;
		JSONObject prediction = api.createPrediction(modelId, inputData, args, null, null);
		
		System.out.println(prediction);
	}
}
