package com.springframework.msscbeerservice.bootstrap;

import com.springframework.msscbeerservice.domain.Beer;
import com.springframework.msscbeerservice.repositories.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    @Autowired
    private BeerRepository beerRepository;

    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(beerRepository.count() == 0) {
            beerRepository.save(Beer.builder().beerName("Mango Bobs").beerStyle("IPA")
                    .quantityToBrew(200).minOnHand(12)
                    .upc(BEER_1_UPC).price(new BigDecimal("12.95"))
                    .build());

            beerRepository.save(Beer.builder().beerName("Galaxy Cat")
                    .beerStyle("PALE ALE")
                    .quantityToBrew(200).minOnHand(12)
                    .upc(BEER_2_UPC).price(new BigDecimal("11.95"))
                    .build());
        }

     //   System.out.println("Loaded Beers: " + beerRepository.count());

    }

}
