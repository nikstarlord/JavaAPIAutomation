package org.example.restAssuredFramework.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.apache.logging.log4j.Logger;
import org.example.restAssuredFramework.api.TodoApi;
import org.example.restAssuredFramework.api.UserApi;
import org.example.restAssuredFramework.config.Constants;
import org.example.restAssuredFramework.models.Todo;
import org.example.restAssuredFramework.models.User;
import org.example.restAssuredFramework.utils.JsonUtils;
import org.example.restAssuredFramework.utils.LoggerUtils;
import org.junit.Assert;
import java.util.List;


public class UserSteps {
    private static Logger logger = LoggerUtils.getLogger(UserSteps.class);
    private List<User> users;
    private List<Todo> todos;

    @Given("User has the todo tasks")
    public void user_has_the_todo_task(){
        TodoApi todo = new TodoApi();
        Response todoResponse = todo.getTodos();
        logger.info("Fetched all the Todos");
        Assert.assertEquals(Constants.STATUS_CODE, todoResponse.getStatusCode());
        todos = JsonUtils.deserializeList(todoResponse.asString(), Todo.class);
    }

    @And("User belongs to the city FanCode")
    public void user_belongs_to_city_fancode(){
        UserApi userObj = new UserApi();
        Response userResponse = userObj.getUser();
        logger.info("Fetched all the Users");
        Assert.assertEquals(Constants.STATUS_CODE, userResponse.getStatusCode());
        users = JsonUtils.deserializeList(userResponse.asString(), User.class);
        users = users.stream().filter( user -> user.address.geo.latitude >= Constants.LAT_MIN && user.address.geo.latitude <= Constants.LAT_MAX
                                    && user.address.geo.longitude >= Constants.LNG_MIN && user.address.geo.longitude <= Constants.LNG_MAX).toList();
        logger.info("Filtered users belonging to the FanCode City");
    }

    @Then("User Completed task percentage should be greater than {int}%")
    public void user_completed_task_should_be_greater_than(int percentage){
        logger.info("Filtering FanCode Users having completed tasks percentage over 50%");
        for(User user : users){
            long totalTasks = todos.stream().filter(todo -> todo.userid == user.id).count();
            long completedTasks = todos.stream().filter(todo -> todo.userid == user.id && todo.completed).count();
            Assert.assertTrue("User ID " + user.id + " has less than 50% tasks completed", totalTasks > 0 && ((double) completedTasks / totalTasks) > 0.5);
            logger.info("User ID " + user.id + " has more than 50% tasks completed");
        }
    }


}
