package com.mayank.liveasy.controller;

import org.springframework.web.bind.annotation.RestController;

import com.mayank.liveasy.model.Cargo;
import com.mayank.liveasy.service.CargoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @GetMapping("/loads")
    public List<Cargo> getLoad() {
        return this.cargoService.getLoads();
    }

    @GetMapping("/load")
    public List<Cargo> getLoadByShipperId(@RequestParam String shipperId) {
        return cargoService.getLoadByShipperId(shipperId);
    }

    @GetMapping("/load/{loadId}")
    public ResponseEntity<Cargo> getLoad(@PathVariable String loadId) {
        try {
            Cargo cargo = this.cargoService.getLoad(Long.parseLong(loadId));
            return ResponseEntity.ok(cargo);

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/load")
    public ResponseEntity<String> addLoad(@RequestBody Cargo cargo) {
        try {
            Cargo createdCargo = this.cargoService.addLoad(cargo);
            return new ResponseEntity<>("Cargo created successfully with ID: " + createdCargo.getLoadId(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to create cargo. Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("load/{loadId}")
    public ResponseEntity<String> deleteCargo(@PathVariable String loadId) {
        try {
            this.cargoService.deleteLoad(Long.parseLong(loadId));
            return ResponseEntity.ok("Cargo deleted successfully");

        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Invalid cargoId format");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Failed to delete cargo. Error: " + e.getMessage());
        }
    }

    @PutMapping("load/{loadId}")
    public ResponseEntity<String> updateCargo(@PathVariable String loadId, @RequestBody Cargo updatedCargo) {
        try {
            Long id = Long.parseLong(loadId);
            
            if (cargoService.getLoad(id)!= null) {
                cargoService.updateLoad(id, updatedCargo);
                return ResponseEntity.ok("Cargo updated successfully");

            } else {
                return ResponseEntity.notFound().build();
            }

        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Invalid cargoId format");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Failed to update cargo. Error: " + e.getMessage());
        }
    }
}

