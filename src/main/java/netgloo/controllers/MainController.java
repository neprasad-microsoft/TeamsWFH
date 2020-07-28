package netgloo.controllers;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.microsoft.hackathon.utility.GetUserPresence;
import com.microsoft.model.PresenceResponse;

@Controller
public class MainController {

  @RequestMapping("/")
  // @ResponseBody
  public String index() {
    return "hello.html";
  }
  
  
  
  @RequestMapping("/getUsersPresence")
  // @ResponseBody
  public ResponseEntity<PresenceResponse> getUsersPresence() {
	  HttpHeaders responseHeaders = new HttpHeaders();
	   GetUserPresence getUserPresence = new GetUserPresence();
	   PresenceResponse pr = getUserPresence.GetUserCurrentPresence();
	   return new ResponseEntity<PresenceResponse>(pr, responseHeaders, HttpStatus.CREATED);
	  
  }
  
 
}
