package com.microsoft.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Start
{
    private String dateTime;

    private String timeZone;

    public String getDateTime ()
    {
        return dateTime;
    }

    public void setDateTime (String dateTime)
    {
        this.dateTime = dateTime;
    }

    public String getTimeZone ()
    {
        return timeZone;
    }

    public void setTimeZone (String timeZone)
    {
        this.timeZone = timeZone;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [dateTime = "+dateTime+", timeZone = "+timeZone+"]";
    }
}
			
		