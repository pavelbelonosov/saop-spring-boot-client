package com.example.consumingsoapservice.service;

import com.example.consumingsoapservice.model.Country;
import com.example.consumingsoapservice.repository.JdbcCountryInfoRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class DbPopulationService {

    private ClientService clientService;
    private JdbcCountryInfoRepository repo;

    public DbPopulationService(ClientService cs, JdbcCountryInfoRepository r) {
        this.clientService = cs;
        this.repo = r;
    }

    @Scheduled(fixedRate = 1800000)
    @Transactional
    public void populate() {
        clientService.getCountriesInfo().getFullCountryInfoAllCountriesResult()
                .getTCountryInfo()
                .forEach(e -> {
                    repo.save(new Country(UUID.randomUUID(),
                            e.getSISOCode(),
                            e.getSName(),
                            e.getSCapitalCity(),
                            e.getSPhoneCode(),
                            e.getSContinentCode(),
                            e.getSCurrencyISOCode(),
                            e.getSCountryFlag()
                    ));
                });
    }


    @Scheduled(fixedRate = 1800000, initialDelay = 2000)
    public void list() {
        repo.findAll().stream().forEachOrdered(e ->
                System.out.println(e.getId() + " "
                        + e.getName() + "  "
                        + e.getIsoCode() + "  "
                        + e.getContinentCode() + "  "
                        + e.getCapitalCity() + "  "
                        + e.getPhoneCode() + "  "
                        + e.getCurrencyIsoCode() + "  "
                        + e.getCountryFlagLink()));
    }

    @Scheduled(fixedRate = 1800000, initialDelay = 4000)
    public void wipe(){
        repo.drop();
    }
}
