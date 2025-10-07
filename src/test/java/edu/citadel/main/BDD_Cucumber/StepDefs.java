package edu.citadel.main.BDD_Cucumber;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.http.HttpStatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class StepDefs extends SpringIntegrationTest {

    private final ObjectMapper mapper = new ObjectMapper();
    private JsonNode json; // parsed body if JSON

    @When("^the client calls (/.+)$")
    public void the_client_calls(String path) {
        executeGet(path);
        // Try to parse as JSON; if not JSON, leave json = null
        try {
            json = mapper.readTree(latestResponse.getBody() == null ? "" : latestResponse.getBody());
        } catch (Exception e) {
            json = null;
        }
    }

    @Then("^the client receives status code (\\d+)$")
    public void the_client_receives_status_code_of(int statusCode) {
        HttpStatus current = (HttpStatus) latestResponse.getTheResponse().getStatusCode();
        assertThat("Unexpected status: " + latestResponse.getBody(), current.value(), is(statusCode));
    }

    @And("^the response JSON has key \"([^\"]+)\"$")
    public void the_response_json_has_key(String key) throws Exception {
        assertThat("Body is not JSON", json, notNullValue());
        assertThat("Missing key: " + key, json.has(key), is(true));
    }

    @And("^the response JSON field \"([^\"]+)\" equals \"([^\"]+)\"$")
    public void the_response_field_equals(String key, String expected) {
        assertThat("Body is not JSON", json, notNullValue());
        assertThat("Field not present: " + key, json.has(key), is(true));
        assertThat(json.get(key).asText(), is(expected));
    }

    @And("^the response JSON boolean field \"([^\"]+)\" is (true|false)$")
    public void the_response_boolean_field_is(String key, String boolText) {
        assertThat("Body is not JSON", json, notNullValue());
        assertThat("Field not present: " + key, json.has(key), is(true));
        boolean expected = Boolean.parseBoolean(boolText);
        assertThat(json.get(key).asBoolean(), is(expected));
    }
}