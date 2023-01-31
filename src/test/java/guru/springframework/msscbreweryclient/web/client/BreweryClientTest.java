package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {
    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeerById() {
        BeerDto beerDto = breweryClient.getBeerById(UUID.randomUUID());
        assertNotNull(beerDto);
    }

    @Test
    void getCustomerById() {
        CustomerDto customerDto = breweryClient.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    void testSaveNewBeer() {
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();

        URI uri = breweryClient.saveNewBeer(beerDto);
        System.out.println(uri.toString());
        assertNotNull(uri);
    }

    @Test
    void testSaveNewCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("Niyazi").build();

        URI uri = breweryClient.saveNewCustomer(customerDto);
        System.out.println(uri.toString());
        assertNotNull(uri);
    }

    @Test
    void testUpdateBeer() {
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
        breweryClient.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    void testUpdateCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("Niyazi").build();
        breweryClient.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void testDeleteBeer() {
        breweryClient.deleteBeer(UUID.randomUUID());
    }

    @Test
    void testDeleteCustomer() {
        breweryClient.deleteCustomer(UUID.randomUUID());
    }
}