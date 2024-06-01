package org.example.restAssuredFramework.api;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.example.restAssuredFramework.config.Config;

public class BaseApi {
    protected RequestSpecification getRequest(){
        return RestAssured
                .given()
                .baseUri(Config.getBaseUrl());
    }
}
