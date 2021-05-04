package com.hylston.eecalculator.repository;

import com.hylston.eecalculator.model.Invitation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvitationRepository extends CrudRepository<Invitation, Long> {

    //User findUserByLoginAndPassword(String login, String password);
}
