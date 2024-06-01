package org.example.restAssuredFramework.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.Logger;
import org.example.restAssuredFramework.config.Endpoints;
import org.example.restAssuredFramework.utils.LoggerUtils;

import java.util.List;

public class UserApi extends BaseApi{
    private static final Logger logger = LoggerUtils.getLogger(UserApi.class);

    public Response getUser(){
        logger.info("Fetching all Users list");
        return RestAssured.given(getRequest()).get(Endpoints.USERS);
    }
}
