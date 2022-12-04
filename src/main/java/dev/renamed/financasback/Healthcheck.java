package dev.renamed.financasback;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/health")
public class Healthcheck {

    @GetMapping
    public ResponseEntity Ping(){
        return ResponseEntity.ok().build();
    }
}
