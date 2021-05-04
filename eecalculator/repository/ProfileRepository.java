package com.hylston.eecalculator.repository;

import com.hylston.eecalculator.model.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long> {

    Profile findByName(String name);
}
