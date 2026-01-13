package com.example.services.controllers;

import com.example.services.dtos.InputTwoNumberDTO;
import com.example.services.entities.CalculatorLog;
import com.example.services.services.CalcService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calc")
@Tag(name = "Calculator")
public class CalculatorController {

    private final CalcService calcService;

    public CalculatorController(CalcService calcService) {
        this.calcService = calcService;
    }

    @PostMapping("/plus")
    public Double plus(@RequestBody InputTwoNumberDTO inputTwoNumberDTO) {
        return calcService.plus(inputTwoNumberDTO);
    }

    @PostMapping("/minus")
    public Double minus(@RequestBody InputTwoNumberDTO inputTwoNumberDTO) {
        return calcService.minus(inputTwoNumberDTO);
    }
    @PostMapping("/divide")
    public Double divide(@RequestBody InputTwoNumberDTO inputTwoNumberDTO) {
        return calcService.divide(inputTwoNumberDTO);
    }

    @PostMapping("/multiply")
    public Double multiply(@RequestBody InputTwoNumberDTO inputTwoNumberDTO) {
        return calcService.multiply(inputTwoNumberDTO);
    }

    @GetMapping("/logs")
    public List<CalculatorLog> getAllLogs() {
        return calcService.getAllLogs();
    }

    @GetMapping("/logs/operation")
    public List<CalculatorLog> getLogsByOperation(@RequestParam String operation) {
        return calcService.getLogsByOperation(operation);
    }

    @GetMapping("/logs/{id}")
    public CalculatorLog getLogById(@PathVariable int id) {
        return calcService.getLogById(id);
    }



}
