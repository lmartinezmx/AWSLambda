package com.lmv.awslambda.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.lmv.awslambda.model.ThrdServiceRequest;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Service
public class LambdaMethodEndPointHandler implements RequestStreamHandler {
    private static final String THRD_URLPOST = "https://yourdomine.com/servicepath";
    private static final String THRD_USERNAME = "username";
    private static final String THRD_PASSWORD= "password";


    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        JSONParser parser = new JSONParser();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        JSONObject responseJson = new JSONObject();
        JSONObject responseBody = new JSONObject();

        try {
            JSONObject event = (JSONObject) parser.parse(reader);
            if (event.get("body") != null) {
                ThrdServiceRequest thrdServiceRequest = new ThrdServiceRequest((String) event.get("body"));
                if(thrdServiceRequest.getData() != null){
                    Map<String, Object> responseCpi = new HashMap<>();

                        try{
                            responseCpi = sendRequestToThrdService(thrdServiceRequest);
                            responseBody.put("message", "Status code: "+responseCpi.get("status") +", With body: "+responseCpi.get("body"));

                            responseJson.put("statusCode", responseCpi.get("status"));
                            responseJson.put("body", responseCpi.get("body"));

                        }catch (Exception ex){

                            responseBody.put("message", "fail sending");

                            responseJson.put("statusCode", 501);
                            responseJson.put("body", "{\"message\":\"fail sending to cpi\"}");
                        }
                }else{
                    responseBody.put("message", "No data in request...");
                    responseBody.put("message2",  " Total request is: "+thrdServiceRequest.getTotal());
                    responseBody.put("message3", thrdServiceRequest.getClientInfo()!=null? " Thrdservice info client id is: "+thrdServiceRequest.getClientInfo().getCustomerId():" No client info in request");

                    responseJson.put("statusCode", 200);
                    responseJson.put("body", "{\"message\":\"no data in request\"}");
                }


            }
        } catch (ParseException pex) {
            responseJson.put("statusCode", 400);
            responseJson.put("exception", pex);
        }

        OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
        writer.write(responseJson.toString());
        writer.close();
    }

    @RequestMapping(method = RequestMethod.POST, produces = ("application/json"), consumes = ("application/json"))
    public Map<String, Object> sendRequestToThrdService(ThrdServiceRequest request) {

        Map<String, Object> response = new HashMap<>();

        Gson gson = new Gson();
        String json = gson.toJson(request);
        org.json.JSONObject jsonObject = new org.json.JSONObject(json);

        RestTemplate restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter jsonHttpMessageConverter = new MappingJackson2HttpMessageConverter();
        jsonHttpMessageConverter.getObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        restTemplate.getMessageConverters().add(jsonHttpMessageConverter);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Accept-Encoding","gzip,deflate");
        httpHeaders.set("Accept","application/json");
        httpHeaders.set("Connection","Keep-Alive");
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setBasicAuth(THRD_USERNAME,THRD_PASSWORD);

        HttpEntity<?> httpEntity = new HttpEntity<Object>(jsonObject.toString(), httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(THRD_URLPOST, HttpMethod.POST, httpEntity, String.class);

        response.put("status",responseEntity.getStatusCode().value());
        response.put("body",responseEntity.getBody() !=null ? responseEntity.getBody() : "{\"message\":\"thrdservice body is null\"}");

        return response;
    }
}
