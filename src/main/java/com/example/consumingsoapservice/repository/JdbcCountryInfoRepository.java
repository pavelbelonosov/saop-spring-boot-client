package com.example.consumingsoapservice.repository;

import com.example.consumingsoapservice.model.Country;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Repository
public class JdbcCountryInfoRepository implements CountryInfoRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcCountryInfoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Country country) {
        return jdbcTemplate.update("INSERT INTO country (id, iso_code, name, capital_city," +
                        " phone_code, continent_code, currency_iso_code, country_flag_link)" +
                        " VALUES(?,?,?,?,?,?,?,?)",
                new Object[]{country.getId(),
                        country.getIsoCode(),
                        country.getName(),
                        country.getCapitalCity(),
                        country.getPhoneCode(),
                        country.getContinentCode(),
                        country.getCurrencyIsoCode(),
                        country.getCountryFlagLink()

                });
    }

    @Override
    public List<Country> findAll() {
        return jdbcTemplate.query("SELECT * FROM country", BeanPropertyRowMapper.newInstance(Country.class));
    }

    @Override
    public void drop() {
        jdbcTemplate.execute("TRUNCATE TABLE country");
    }

}
