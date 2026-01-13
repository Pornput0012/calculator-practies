package com.example.services

import com.example.services.dtos.InputTwoNumberDTO
import com.example.services.entities.CalculatorLog
import com.example.services.repositories.CalculatorRepository
import com.example.services.services.CalcService
import org.modelmapper.ModelMapper
import spock.lang.Specification

class CalcServiceTests extends Specification {
    def mockCalcRepository = Mock(CalculatorRepository)
    def modelMapper = new ModelMapper()
    def calcService = new CalcService(mockCalcRepository, modelMapper)

    def "should return 35.79977978 when adding 12.12345678 and 23.676323"() {
        given:
        def mockNumber = new InputTwoNumberDTO(12.12345678, 23.676323)

        when:
        def result = calcService.plus(mockNumber)

        then:
        result == 35.79977978
    }

    def "should return -11.55286622 when subtracting 23.676323 from 12.12345678"() {
        given:
        def mockNumber = new InputTwoNumberDTO(12.12345678, 23.676323)

        when:
        def result = calcService.minus(mockNumber)

        then:
        result == -11.55286622
    }

    def "should return 11.55286622 when subtracting 12.12345678 from 23.676323"() {
        given:
        def mockNumber = new InputTwoNumberDTO(23.676323, 12.12345678)

        when:
        def result = calcService.minus(mockNumber)

        then:
        result == 11.55286622
    }

    def "should return 0 when multiplying 0 by 1234567.89"() {
        given:
        def mockNumber = new InputTwoNumberDTO(0, 1234567.89)

        when:
        def result = calcService.multiply(mockNumber)

        then:
        result == 0
    }

    def "should return -1234567.89 when multiplying -1 by 1234567.89"() {
        given:
        def mockNumber = new InputTwoNumberDTO(-1, 1234567.89)

        when:
        def result = calcService.multiply(mockNumber)

        then:
        result == -1234567.89
    }

    def "should return 1234567.89 when multiplying -1 by -1234567.89"() {
        given:
        def mockNumber = new InputTwoNumberDTO(-1, -1234567.89)

        when:
        def result = calcService.multiply(mockNumber)

        then:
        result == 1234567.89
    }

    def "should return 1234567.89 when multiplying 1 by 1234567.89"() {
        given:
        def mockNumber = new InputTwoNumberDTO(1, 1234567.89)

        when:
        def result = calcService.multiply(mockNumber)

        then:
        result == 1234567.89
    }

    def "should throw ArithmeticException when dividing by zero"() {
        given:
        def mockNumber = new InputTwoNumberDTO(10, 0)

        when:
        calcService.divide(mockNumber)

        then:
        thrown(ArithmeticException)
    }

    def "should return 5 when dividing 10 by 2"() {
        given:
        def mockNumber = new InputTwoNumberDTO(10, 2)

        when:
        def result = calcService.divide(mockNumber)

        then:
        result == 5
    }

    def "should return array when execute getAllLogs"() {
        when:
        def result = calcService.getAllLogs()
        then:
        1 * mockCalcRepository.findAll() >> []
        result != null
        result.size() == 0
    }

    def "should return object when execute getLog by id"() {
        given:
        CalculatorLog calculatorLog = new CalculatorLog()
        calculatorLog.setId(1)
        calculatorLog.setResult(3)

        when:
        def result = calcService.getLogById(1)

        then:
        // Wrap the object in Optional.of()
        1 * mockCalcRepository.findById(_) >> Optional.of(calculatorLog)

        result != null
        result.id == 1
        result.result == 3
    }
    def "should return calc log when execute get by operation"() {
        given:
            CalculatorLog calculatorLog = new CalculatorLog()
            calculatorLog.setOperation("+")
            calculatorLog.setNumber1(1.0)
            calculatorLog.setNumber2(2.0)
            calculatorLog.setResult(3.0)

        when:
            def result = calcService.getLogsByOperation("+")
        then:
            1 * mockCalcRepository.findByOperation(_) >> [calculatorLog]
            result[0].number1 == 1.0
            result[0].number2 == 2.0
            result[0].result == 3.0
            result[0].operation == "+"
    }

}
