package com.microsoft.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CalendarEventResponse
{
    private Value[] value;

    public Value[] getValue ()
    {
        return value;
    }

    public void setValue (Value[] value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [value = "+value+"]";
    }
}
