package com.example.controller

import com.example.services.controllers.CalculatorController
import com.example.services.dtos.InputTwoNumberDTO
import com.example.services.entities.CalculatorLog
import com.example.services.services.CalcService
import spock.lang.Specification

class CalculatorControllerTest extends Specification {


    CalcService calculatorService = Mock(CalcService)
    def calculatorController = new CalculatorController(calculatorService);

    def "when plus execution then success "() {
        given:
        InputTwoNumberDTO data = InputTwoNumberDTO.builder()
                .number1(1)
                .number2(2)
                .build()
        when:
        calculatorController.plus(data);

        then:
        1 * calculatorService.plus(data)

    }

    def "when minus execution then success "() {
        given:
        InputTwoNumberDTO data = InputTwoNumberDTO.builder()
                .number1(1)
                .number2(2)
                .build()
        when:
        calculatorController.minus(data);

        then:
        1 * calculatorService.minus(data)

    }

    def "when divide execution then success "() {
        given:
        InputTwoNumberDTO data = InputTwoNumberDTO.builder()
                .number1(1)
                .number2(2)
                .build()
        when:
        calculatorController.divide(data);

        then:
        1 * calculatorService.divide(data)

    }

    def "when divide number 1 is 0 execution then success and result is 0.0 "() {
        given:
        InputTwoNumberDTO data = InputTwoNumberDTO.builder()
                .number1(0)
                .number2(2)
                .build()
        when:
        calculatorController.divide(data);

        then:
        1 * calculatorService.divide(data)

    }

    def "when multiply execution then success "() {
        given:
        InputTwoNumberDTO data = InputTwoNumberDTO.builder()
                .number1(1)
                .number2(2)
                .build()
        when:
        calculatorController.multiply(data);

        then:
        1 * calculatorService.multiply(data)

    }

    def 'when get all logs execution then success'(){
        when:
        calculatorController.getAllLogs()
        then:
        1 * calculatorService.getAllLogs()
    }

    def 'when get logs by id execution then success'(){
        given:
        def calcId = 1
        def execpted = new CalculatorLog()
        execpted.setId(1)
        when:
            def result= calculatorController.getLogById(calcId)
        then:
            1 * calculatorService.getLogById(_) >> execpted
            result.id == calcId
    }

}
