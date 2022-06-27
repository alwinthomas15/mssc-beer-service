package guru.springframework.msscbeerservice.services.inventory;

import guru.springframework.msscbeerservice.bootstrap.BeerLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@Disabled // utility for manual testing
@SpringBootTest
class BeerInventoryServiceRestTemplateImplTest {

    @Autowired
    BeerInventoryService beerInventoryService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void getOnhandInventory() {

        //todo evolve to use UPC
        Integer qoh = beerInventoryService.getOnhandInventory(UUID.fromString("026cc3c8-3a0c-4083-a05b-e908048c1b08"));

        System.out.println(qoh);

    }
}