package edu.citadel.main.BDD_Cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.web.client.TestRestTemplate;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringIntegrationTest {

    // Holds latest HTTP response for assertions
    protected static class LatestResponse {
        ResponseEntity<String> aResponse;
        String responseBody;

        public ResponseEntity<String> getTheResponse() { return aResponse; }
        public String getBody() { return responseBody; }
    }

    protected final LatestResponse latestResponse = new LatestResponse();

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    /** Build a full URL from a path like "/status/health" */
    protected String url(String path) {
        String clean = path.startsWith("/") ? path : ("/" + path);
        return "http://localhost:" + port + clean;
    }

    /** Execute a GET to a *path* (not full URL) against the random-port server */
    protected void executeGet(String path) {
        ResponseEntity<String> response = restTemplate.getForEntity(url(path), String.class);
        latestResponse.aResponse = response;
        latestResponse.responseBody = response.getBody();
    }
}
