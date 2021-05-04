package com.hylston.eecalculator.model;

import com.hylston.eecalculator.enums.InvitationTypeEnum;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Invitation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer invitationsIssued;

    private Date dateOfRound;

    private Integer lowestRankedCandidate;

    @Enumerated(EnumType.STRING)
    private InvitationTypeEnum invitationType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getInvitationsIssued() {
        return invitationsIssued;
    }

    public void setInvitationsIssued(Integer invitationsIssued) {
        this.invitationsIssued = invitationsIssued;
    }

    public Date getDateOfRound() {
        return dateOfRound;
    }

    public void setDateOfRound(Date dateOfRound) {
        this.dateOfRound = dateOfRound;
    }

    public Integer getLowestRankedCandidate() {
        return lowestRankedCandidate;
    }

    public void setLowestRankedCandidate(Integer lowestRankedCandidate) {
        this.lowestRankedCandidate = lowestRankedCandidate;
    }

    public InvitationTypeEnum getInvitationType() {
        return invitationType;
    }

    public void setInvitationType(InvitationTypeEnum invitationType) {
        this.invitationType = invitationType;
    }
}
