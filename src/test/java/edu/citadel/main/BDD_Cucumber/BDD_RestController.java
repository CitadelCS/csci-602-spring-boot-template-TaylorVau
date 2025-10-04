package edu.citadel.main.BDD_Cucumber;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

public class BDD_RestController {

    @RestController
    public class VersionController {
        @GetMapping("/version")
        public String getVersion() {
            return "1.0";
        }
    }
}
