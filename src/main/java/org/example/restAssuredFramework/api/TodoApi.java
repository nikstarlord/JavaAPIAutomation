package org.example.restAssuredFramework.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.Logger;
import org.example.restAssuredFramework.config.Endpoints;
import org.example.restAssuredFramework.utils.LoggerUtils;

import java.util.List;

public class TodoApi extends BaseApi{
    private static final Logger logger = LoggerUtils.getLogger(TodoApi.class);

    public Response getTodos(){
        logger.info("Getting all ToDos");
         return RestAssured.given(getRequest()).get(Endpoints.TODOS);
    }
}
