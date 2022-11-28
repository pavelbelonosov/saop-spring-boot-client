package com.example.consumingsoapservice.repository;

import com.example.consumingsoapservice.model.Country;

import java.util.List;

public interface CountryInfoRepository {

    int save (Country country);

    List<Country> findAll();

    void drop();
}
