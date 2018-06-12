package io.swagger.api;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isban.elastic.UltaltaRepository;

import io.swagger.RandomUltalta;
import io.swagger.annotations.ApiParam;
import io.swagger.model.Ultalta;
import io.swagger.model.UltaltaResponse;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-02T16:33:50.882Z")

@Controller
@CrossOrigin
public class UltaltaApiController implements UltaltaApi {

	private RandomUltalta random = new RandomUltalta(16);
	
    private static final Logger log = LoggerFactory.getLogger(UltaltaApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private UltaltaRepository repository;
    
    
    @org.springframework.beans.factory.annotation.Autowired
    public UltaltaApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Autowired
    private ElasticsearchOperations ElasticsearchOperations;
    
//    public ResponseEntity<String> addUltalta(@ApiParam(value = "Codigo partenon único" ,required=true )  @Valid @RequestBody Ultalta ultalta) {
//    	String r = random.nextString();
//    	String result = "{ \"ultalta\" : " + "\"" + r + "\"}";
//        String accept = request.getHeader("Accept");
//        if (accept != null && accept.contains("application/xml")) {
//            return new ResponseEntity<String>(result, HttpStatus.OK);
//        }
//
//        if (accept != null && accept.contains("application/json")) {
//        	
//        	ultalta.setId(r);
//        	repository.save(ultalta);
//        	
////        	for (int i = 0; i < 100000; i++) {
////        		r = random.nextString();
////        		ultalta.setId(r);
////        		repository.save(ultalta);
////			}
//        	repository.findAll();
//        	
//            return new ResponseEntity<String>(result, HttpStatus.OK);
//        }
//
//        return new ResponseEntity<String>(HttpStatus.NOT_IMPLEMENTED);
//    }
    
    
    
    public ResponseEntity<UltaltaResponse> addUltalta(@ApiParam(value = "Empresa , centro y producto asociados al nuevo contrato" ,required=true )  @Valid @RequestBody Ultalta body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	
            	String r = random.nextString();
            	String result = "{ \"contrato\" : " + "\"" + r + "\"}";
            	
            	body.setId(r);
            	repository.save(body);
            	
                return new ResponseEntity<UltaltaResponse>(objectMapper.readValue(result, UltaltaResponse.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<UltaltaResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<UltaltaResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Ultalta> getUltaltaById(@ApiParam(value = "contrato partenon",required=true) @PathVariable("ultaltaId") String ultaltaId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	
            	Ultalta contrato = repository.findOne(ultaltaId);
            	
                return new ResponseEntity<Ultalta>(contrato, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<Ultalta>(HttpStatus.NOT_FOUND);
            }
        }

        return new ResponseEntity<Ultalta>(HttpStatus.NOT_IMPLEMENTED);
    }
    

}
