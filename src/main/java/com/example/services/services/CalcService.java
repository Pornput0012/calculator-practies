package com.example.services.services;

import com.example.services.dtos.InputTwoNumberDTO;
import com.example.services.entities.CalculatorLog;
import com.example.services.repositories.CalculatorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CalcService {

    private final ModelMapper modelMapper;
    private CalculatorRepository calculatorRepository;

    public CalcService(CalculatorRepository calculatorRepository, ModelMapper modelMapper) {
        this.calculatorRepository = calculatorRepository;
        this.modelMapper = modelMapper;
    }

    public Double plus(InputTwoNumberDTO inputTwoNumberDTO) {
        CalculatorLog calculatorLog = new CalculatorLog();
        modelMapper.map(inputTwoNumberDTO, calculatorLog);

        double result = inputTwoNumberDTO.getNumber1() + inputTwoNumberDTO.getNumber2();
        calculatorLog.setOperation("+");
        calculatorLog.setResult(result);

        calculatorRepository.save(calculatorLog);

        return result;
    }

    public Double minus(InputTwoNumberDTO inputTwoNumberDTO) {
        CalculatorLog calculatorLog = new CalculatorLog();
        modelMapper.map(inputTwoNumberDTO, calculatorLog);

        double result = inputTwoNumberDTO.getNumber1() - inputTwoNumberDTO.getNumber2();
        calculatorLog.setOperation("-");
        calculatorLog.setResult(result);

        calculatorRepository.save(calculatorLog);

        return result;
    }

    public Double multiply(InputTwoNumberDTO inputTwoNumberDTO) {
        CalculatorLog calculatorLog = new CalculatorLog();
        modelMapper.map(inputTwoNumberDTO, calculatorLog);

        double result = inputTwoNumberDTO.getNumber1() * inputTwoNumberDTO.getNumber2();
        calculatorLog.setOperation("*");
        calculatorLog.setResult(result);

        calculatorRepository.save(calculatorLog);

        return result;
    }

    public Double divide(InputTwoNumberDTO inputTwoNumberDTO) {
        if (inputTwoNumberDTO.getNumber2() == 0) {
            throw new ArithmeticException("Division by zero");
        }

        CalculatorLog calculatorLog = new CalculatorLog();
        modelMapper.map(inputTwoNumberDTO, calculatorLog);

        double result = inputTwoNumberDTO.getNumber1() / inputTwoNumberDTO.getNumber2();
        calculatorLog.setOperation("/");
        calculatorLog.setResult(result);

        calculatorRepository.save(calculatorLog);

        return result;
    }

    public java.util.List<CalculatorLog> getAllLogs() {
        return calculatorRepository.findAll();
    }

    public CalculatorLog getLogById(int id) {
        return calculatorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Log not found with id: " + id));
    }
}
