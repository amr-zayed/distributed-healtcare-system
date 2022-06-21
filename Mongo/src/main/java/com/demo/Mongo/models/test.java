package com.demo.Mongo.models;

import lombok.Data;

@Data
public class test {

    private String type;
    private String url;

    public String getType() {
        return type;
    }
}
