package com.hylston.eecalculator.model.response;


public class InvitationRespose {

    private Integer invitationsIssued;

    private String dateOfRound;

    private Integer lowestRankedCandidate;

    private String invitationType;

    public Integer getInvitationsIssued() {
        return invitationsIssued;
    }

    public void setInvitationsIssued(Integer invitationsIssued) {
        this.invitationsIssued = invitationsIssued;
    }

    public String getDateOfRound() {
        return dateOfRound;
    }

    public void setDateOfRound(String dateOfRound) {
        this.dateOfRound = dateOfRound;
    }

    public Integer getLowestRankedCandidate() {
        return lowestRankedCandidate;
    }

    public void setLowestRankedCandidate(Integer lowestRankedCandidate) {
        this.lowestRankedCandidate = lowestRankedCandidate;
    }

    public String getInvitationType() {
        return invitationType;
    }

    public void setInvitationType(String invitationType) {
        this.invitationType = invitationType;
    }
}
