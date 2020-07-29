
package com.microsoft.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"@odata.context",
"id",
"availability",
"activity"
})
public class PresenceResponse {

@JsonProperty("@odata.context")
private String odataContext;
@JsonProperty("id")
private String id;
@JsonProperty("availability")
private String availability;
@JsonProperty("activity")
private String activity;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("@odata.context")
public String getOdataContext() {
return odataContext;
}

@JsonProperty("@odata.context")
public void setOdataContext(String odataContext) {
this.odataContext = odataContext;
}

@JsonProperty("id")
public String getId() {
return id;
}

@JsonProperty("id")
public void setId(String id) {
this.id = id;
}

@JsonProperty("availability")
public String getAvailability() {
return availability;
}

@JsonProperty("availability")
public void setAvailability(String availability) {
this.availability = availability;
}

@JsonProperty("activity")
public String getActivity() {
return activity;
}

@JsonProperty("activity")
public void setActivity(String activity) {
this.activity = activity;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}