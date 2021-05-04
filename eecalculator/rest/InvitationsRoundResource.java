package com.hylston.eecalculator.rest;


import com.hylston.eecalculator.model.Invitation;
import com.hylston.eecalculator.model.request.ProfileRequest;
import com.hylston.eecalculator.model.response.InvitationRespose;
import com.hylston.eecalculator.model.response.ProfileResponse;
import com.hylston.eecalculator.service.CalculatorService;
import com.hylston.eecalculator.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invitations")
@CrossOrigin
public class InvitationsRoundResource {

    @Autowired
    InvitationService invitationService;

    @RequestMapping(path="", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<InvitationRespose>> calculateScore(
    ){

        List<InvitationRespose> invitationList = invitationService.getInvitationList();
        return new ResponseEntity<>(invitationList, HttpStatus.OK);
    }

}
