package com.hylston.eecalculator.rest;


import com.hylston.eecalculator.model.request.ProfileRequest;
import com.hylston.eecalculator.model.response.ProfileResponse;
import com.hylston.eecalculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ee_calculator")
@CrossOrigin
public class EECalculatorResource {

    @Autowired
    CalculatorService calculatorService;

    @RequestMapping(path="", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ProfileResponse> calculateScore(
            @RequestBody ProfileRequest profileRequest
    ){

        ProfileResponse profileResponse = calculatorService.calculateProfileScore(profileRequest, false);

        return new ResponseEntity<>(profileResponse, HttpStatus.OK);
    }

    @RequestMapping(path="/inverse", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ProfileResponse> calculateScoreWhereSpouseIsMainApplicant(
            @RequestBody ProfileRequest profileRequest
    ){

        ProfileResponse profileResponse = calculatorService.calculateProfileScore(profileRequest, true);

        return new ResponseEntity<>(profileResponse, HttpStatus.OK);
    }

}
