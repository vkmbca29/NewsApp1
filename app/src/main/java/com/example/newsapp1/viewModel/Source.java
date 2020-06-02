package com.example.newsapp1.viewModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Source
{
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private String id;

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "Results [name = "+name+", id = "+id+"]";
    }
}
