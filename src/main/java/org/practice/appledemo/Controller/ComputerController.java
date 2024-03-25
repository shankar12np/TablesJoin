package org.practice.appledemo.Controller;

import org.practice.appledemo.Model.ComputerDetailsPOJO;
import org.practice.appledemo.Model.ComputerPOJO;
import org.practice.appledemo.Service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/computers")
public class ComputerController {

    @Autowired
    private ComputerService computerService;

    @PostMapping("/add-computer")
    public ResponseEntity<?> addComputer(@RequestBody ComputerPOJO computerPOJO) {
        computerService.addComputers(computerPOJO);
        return new ResponseEntity<>("Computer Added", HttpStatus.OK);
    }

    @PostMapping("/add-details")
    public ResponseEntity<?> addDetails(@RequestBody ComputerDetailsPOJO computerDetailsPOJO) {
        computerService.addDetails(computerDetailsPOJO);
        return new ResponseEntity<>("Computer Details added", HttpStatus.OK);
    }

    @GetMapping("/get-comp-by-id/{computerId}")
    public ResponseEntity<ComputerPOJO> getComputerDetailsByComputerId(@PathVariable String computerId) {
       ComputerPOJO computerPOJO = computerService.getComputerByComputerId(computerId);
        return ResponseEntity.ok(computerPOJO);

    }

    @GetMapping("/get-all")
    public ResponseEntity<List<ComputerPOJO>> getAll() {
        List<ComputerPOJO> computerPOJOList = computerService.getAllComputers();
        return ResponseEntity.ok(computerPOJOList);
    }
}
