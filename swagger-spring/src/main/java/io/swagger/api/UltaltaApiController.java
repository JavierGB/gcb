package io.swagger.api;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.RandomUltalta;
import io.swagger.annotations.ApiParam;
import io.swagger.model.Ultalta;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-02T16:33:50.882Z")

@Controller
@CrossOrigin
public class UltaltaApiController implements UltaltaApi {

	private RandomUltalta random = new RandomUltalta(16);
	
    private static final Logger log = LoggerFactory.getLogger(UltaltaApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public UltaltaApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<String> addUltalta(@ApiParam(value = "Codigo partenon único" ,required=true )  @Valid @RequestBody Ultalta ultalta) {
    	
    	String result = "{ \"ultalta\" : " + "\"" +random.nextString() + "\"}";
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/xml")) {
            return new ResponseEntity<String>(result, HttpStatus.OK);
        }

        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<String>(result, HttpStatus.OK);
        }

        return new ResponseEntity<String>(HttpStatus.NOT_IMPLEMENTED);
    }

}
