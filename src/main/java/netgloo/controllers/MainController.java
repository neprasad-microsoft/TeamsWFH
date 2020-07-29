package netgloo.controllers;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.microsoft.hackathon.utility.DataStore;
import com.microsoft.hackathon.utility.GetUserPresence;
import com.microsoft.hackathon.utility.LoadCalendar;
import com.microsoft.model.CalendarEventResponse;
import com.microsoft.model.KeyValuePair;
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
  
  @RequestMapping("/getUserCalenderForNext24Hour")
  // @ResponseBody
  public ResponseEntity<CalendarEventResponse> getUserCalenderForNext24Hour() {
	  HttpHeaders responseHeaders = new HttpHeaders();
	   LoadCalendar loadCalender = new LoadCalendar();
	   CalendarEventResponse calenderInfo = loadCalender.LoadUserTodaysCalendar();
	   return new ResponseEntity<CalendarEventResponse>(calenderInfo, responseHeaders, HttpStatus.CREATED);
	  
  }
  
  @RequestMapping(value = "/setParams", method = RequestMethod.POST)
  // @ResponseBody
  public ResponseEntity<String> setParams(@RequestBody List<KeyValuePair> keyValuePairList) {
	  HttpHeaders responseHeaders = new HttpHeaders();
	   DataStore dataStore = new DataStore();
	   dataStore.storeData(keyValuePairList);
	   return new ResponseEntity<String>("Successfully Stored Data", responseHeaders, HttpStatus.CREATED);
	  
  }
  
  @RequestMapping(value = "/getParam")
  // @ResponseBody
  public ResponseEntity<String> setParam(@RequestParam String key) {
	  HttpHeaders responseHeaders = new HttpHeaders();
	  String data = DataStore.getDataFromDataStore(key);
	  return new ResponseEntity<String>(data, responseHeaders, HttpStatus.CREATED);
	  
  }
  
  
 
}
