package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {

    private final String property1;

    private final String property2;


    public Data(@JsonProperty("слово1") String property1, @JsonProperty("слово2") String property2) {
        this.property1 = property1;
        this.property2 = property2;
    }

    public String getProperty1() {
        return property1;
    }

    public String getProperty2() {
        return property2;
    }


}
