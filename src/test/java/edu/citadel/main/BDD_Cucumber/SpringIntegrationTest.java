package edu.citadel.main.BDD_Cucumber;


import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class SpringIntegrationTest {

    //creates latest response class
    protected static class LatestResponse {
        //latest response atttributes
        ResponseEntity<String> aResponse;
        String responseBody;


        //getter for response entity
        public ResponseEntity<String> getTheResponse() {
            return aResponse;
        }

        //getter for the resposne body
        public String getBody() {
            return responseBody;
        }
    }


        //initializes the latest response
        protected final LatestResponse latestResponse = new LatestResponse();
        private final RestTemplate restTemplate = new RestTemplate();

        protected void executeGet(String url) {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            latestResponse.aResponse = response;
            latestResponse.responseBody = response.getBody();
        }

}
