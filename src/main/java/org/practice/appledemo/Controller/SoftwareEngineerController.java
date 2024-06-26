package org.practice.appledemo.Controller;


import org.practice.appledemo.Entity.SoftwareEngineers;
import org.practice.appledemo.Model.EngineersPOJO;
import org.practice.appledemo.Model.EngineersRequest;
import org.practice.appledemo.Service.ComputerEngineersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/engineer")
public class SoftwareEngineerController {
    @Autowired
    private ComputerEngineersService computerEngineersService;

    @PostMapping("/add-engineers")
    public ResponseEntity<?> addEngineers(@RequestBody SoftwareEngineers softwareEngineers) {
        computerEngineersService.assignEngineerToComputers(softwareEngineers, softwareEngineers.getComputers());
        return new ResponseEntity<>("Engineers Added", HttpStatus.OK);
    }

    @GetMapping("/get-all-engineers")
    public ResponseEntity<?> getAllEngineers() {
        List<EngineersPOJO> engineersPOJOList = computerEngineersService.getAllEngineers();
        return ResponseEntity.ok(engineersPOJOList);
    }
}
