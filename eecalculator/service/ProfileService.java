package com.hylston.eecalculator.service;

import com.hylston.eecalculator.model.Profile;
import com.hylston.eecalculator.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfileService {

    @Autowired
    ProfileRepository proRep;

    public List<Profile> getProfileList(){

        Iterable<Profile> iter = proRep.findAll();

        List<Profile> profileList = new ArrayList<>();

        for (Profile profile: iter) {

            profileList.add(profile);
        }

        return profileList;
    }


    public Profile save(Profile profile){

        return proRep.save(profile);
    }

    public void delete(Profile profile){

        proRep.delete(profile);
    }

    public Profile findByName(String name){

        return proRep.findByName(name);
    }

}
