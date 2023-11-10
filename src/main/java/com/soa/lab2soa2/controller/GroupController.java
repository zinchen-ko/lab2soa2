package com.soa.lab2soa2.controller;

import com.soa.lab2soa2.service.AdditionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1")
@CrossOrigin
public class GroupController {
    private final AdditionalService additionalService;

    public GroupController(AdditionalService additionalService) {
        this.additionalService = additionalService;
    }
    
    @PostMapping("/count-transferred")
    public Long countTransferred() {
        try {
            Optional<Long> sum = additionalService.countTransferred();
            return sum.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("{from}/move/{to}")
    public ResponseEntity<String> moveStudents(@PathVariable long from, @PathVariable long to) {
         additionalService.moveStudents(from, to);
         return ResponseEntity.ok("Students successfully transferred");
    }
}
