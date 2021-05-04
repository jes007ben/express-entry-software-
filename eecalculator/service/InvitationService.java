package com.hylston.eecalculator.service;

import com.hylston.eecalculator.enums.InvitationTypeEnum;
import com.hylston.eecalculator.model.Invitation;
import com.hylston.eecalculator.model.Profile;
import com.hylston.eecalculator.model.response.InvitationRespose;
import com.hylston.eecalculator.repository.InvitationRepository;
import com.hylston.eecalculator.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class InvitationService {

    @Autowired
    InvitationRepository invitationRep;


    public List<InvitationRespose> getInvitationList(){

        Iterable<Invitation> iter = invitationRep.findAll();

        List<InvitationRespose> invitationResponseList = new ArrayList<>();

        for (Invitation invitation: iter) {

            InvitationRespose ir = new InvitationRespose();

            ir.setInvitationsIssued(invitation.getInvitationsIssued());

            ir.setInvitationType(invitation.getInvitationType().getValue());

            ir.setLowestRankedCandidate(invitation.getLowestRankedCandidate());

            ir.setDateOfRound(new SimpleDateFormat("yyyy/MM/dd").format(invitation.getDateOfRound()));

            invitationResponseList.add(ir);
        }

        return invitationResponseList;
    }

    public Invitation save(Invitation invitation){

        return invitationRep.save(invitation);
    }

    public void insertData(){

        try {

            Invitation invitation = new Invitation();

            invitation.setDateOfRound(new SimpleDateFormat("yyyy/MM/dd").parse("2018/11/28"));

            invitation.setInvitationsIssued(3900);

            invitation.setInvitationType(InvitationTypeEnum.GENERAL);

            invitation.setLowestRankedCandidate(445);

            //2
            Invitation invitation2 = new Invitation();

            invitation2.setDateOfRound(new SimpleDateFormat("yyyy/MM/dd").parse("2018/11/14"));

            invitation2.setInvitationsIssued(3900);

            invitation2.setInvitationType(InvitationTypeEnum.GENERAL);

            invitation2.setLowestRankedCandidate(449);


            //3
            Invitation invitation3 = new Invitation();

            invitation3.setDateOfRound(new SimpleDateFormat("yyyy/MM/dd").parse("2018/10/29"));

            invitation3.setInvitationsIssued(3900);

            invitation3.setInvitationType(InvitationTypeEnum.GENERAL);

            invitation3.setLowestRankedCandidate(442);

            //4
            Invitation invitation4 = new Invitation();

            invitation4.setDateOfRound(new SimpleDateFormat("yyyy/MM/dd").parse("2018/10/15"));

            invitation4.setInvitationsIssued(3900);

            invitation4.setInvitationType(InvitationTypeEnum.GENERAL);

            invitation4.setLowestRankedCandidate(440);


            //5
            Invitation invitation5 = new Invitation();

            invitation5.setDateOfRound(new SimpleDateFormat("yyyy/MM/dd").parse("2018/10/03"));

            invitation5.setInvitationsIssued(3900);

            invitation5.setInvitationType(InvitationTypeEnum.GENERAL);

            invitation5.setLowestRankedCandidate(445);

            //6
            Invitation invitation6 = new Invitation();

            invitation6.setDateOfRound(new SimpleDateFormat("yyyy/MM/dd").parse("2018/09/24"));

            invitation6.setInvitationsIssued(400);

            invitation6.setInvitationType(InvitationTypeEnum.FEDERAL_SKILLED_WORKER);

            invitation6.setLowestRankedCandidate(284);

            //7
            Invitation invitation7 = new Invitation();

            invitation7.setDateOfRound(new SimpleDateFormat("yyyy/MM/dd").parse("2018/09/19"));

            invitation7.setInvitationsIssued(3500);

            invitation7.setInvitationType(InvitationTypeEnum.GENERAL);

            invitation7.setLowestRankedCandidate(441);

            //8
            Invitation invitation8 = new Invitation();

            invitation8.setDateOfRound(new SimpleDateFormat("yyyy/MM/dd").parse("2018/09/05"));

            invitation8.setInvitationsIssued(3900);

            invitation8.setInvitationType(InvitationTypeEnum.GENERAL);

            invitation8.setLowestRankedCandidate(440);

            //9
            Invitation invitation9 = new Invitation();

            invitation9.setDateOfRound(new SimpleDateFormat("yyyy/MM/dd").parse("2018/08/22"));

            invitation9.setInvitationsIssued(3750);

            invitation9.setInvitationType(InvitationTypeEnum.GENERAL);

            invitation9.setLowestRankedCandidate(440);


            //10
            Invitation invitation10 = new Invitation();

            invitation10.setDateOfRound(new SimpleDateFormat("yyyy/MM/dd").parse("2018/08/08"));

            invitation10.setInvitationsIssued(3750);

            invitation10.setInvitationType(InvitationTypeEnum.GENERAL);

            invitation10.setLowestRankedCandidate(440);

            this.invitationRep.save(invitation);
            this.invitationRep.save(invitation2);
            this.invitationRep.save(invitation3);
            this.invitationRep.save(invitation4);
            this.invitationRep.save(invitation5);
            this.invitationRep.save(invitation6);
            this.invitationRep.save(invitation7);
            this.invitationRep.save(invitation8);
            this.invitationRep.save(invitation9);
            this.invitationRep.save(invitation10);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
