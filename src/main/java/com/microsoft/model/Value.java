package com.microsoft.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Value
{
    private Start start;

    private End end;

    public Start getStart ()
    {
        return start;
    }

    public void setStart (Start start)
    {
        this.start = start;
    }

    public End getEnd ()
    {
        return end;
    }

    public void setEnd (End end)
    {
        this.end = end;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [start = "+start+", end = "+end+"]";
    }
}