package com.example.resturantreviewtestrestapi.Controllers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Test.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.resturantreviewtestrestapi.model.Address;
import com.example.resturantreviewtestrestapi.model.Cuisine;
import com.example.resturantreviewtestrestapi.model.Restaurant;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import com.example.resturantreviewtestrestapi.model.Restaurant;
import com.example.resturantreviewtestrestapi.service.RestaurantService;
import com.example.resturantreviewtestrestapi.controllers.RestaurantController;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RestaurantController.class)
//@AutoConfigureMockMvc
public class RestaurantControllersTest {
    private final String STARTING_URI = "http://localhost:8080/api";
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RestaurantService service;
    @Autowired
    private RestaurantController controller;


    @Test
    public void post_Test1(){
        Restaurant expectedRestaurantModel = new Restaurant();
        expectedRestaurantModel.setRestaurantId(101L);
        expectedRestaurantModel.setName("Dominos");
        Address address = new Address();
        address.setCity("Falls church");
        address.setId(1l);
        address.setState("VA");
        address.setZip("22044");
        expectedRestaurantModel.setAddress(address);
        expectedRestaurantModel.setCuisine(Cuisine.CHINNESE);
        expectedRestaurantModel.setWebsite("www.dominos.com");
        doReturn(expectedRestaurantModel).when(service).createRestaurant(expectedRestaurantModel);
        Restaurant actualRestaurantModels =  controller.createRestaurant(expectedRestaurantModel);
        Restaurant actualRestaurantModel = actualRestaurantModels;
        Assertions.assertEquals(expectedRestaurantModel.getRestaurantId(),actualRestaurantModel.getRestaurantId());
        Assertions.assertEquals(expectedRestaurantModel.getName(),actualRestaurantModel.getName());
        Assertions.assertEquals(expectedRestaurantModel.getAddress(),actualRestaurantModel.getAddress());
        Assertions.assertEquals(expectedRestaurantModel.getReviews(),actualRestaurantModel.getReviews());
        Assertions.assertEquals(expectedRestaurantModel.getWebsite(),actualRestaurantModel.getWebsite());

    }
    @Test
    public void put_Test1(){
        Restaurant expectedRestaurantModel = new Restaurant();
        expectedRestaurantModel.setRestaurantId(101L);
        expectedRestaurantModel.setName("Dominos");
         Address address = new Address();
        address.setCity("Falls church");
        address.setId(1l);
        address.setState("VA");
        address.setZip("22044");
        expectedRestaurantModel.setAddress(address);
        expectedRestaurantModel.setCuisine( Cuisine.CHINNESE);
        expectedRestaurantModel.setWebsite("www.dominos.com");
        doReturn(expectedRestaurantModel).when(service).updateRestaurant(expectedRestaurantModel);
        Restaurant actualRestaurantModels =  controller.updateRestaurant(expectedRestaurantModel);
        Restaurant actualRestaurantModel = actualRestaurantModels;
        Assertions.assertEquals(expectedRestaurantModel.getRestaurantId(),actualRestaurantModel.getRestaurantId());
        Assertions.assertEquals(expectedRestaurantModel.getName(),actualRestaurantModel.getName());
        Assertions.assertEquals(expectedRestaurantModel.getAddress(),actualRestaurantModel.getAddress());
        Assertions.assertEquals(expectedRestaurantModel.getReviews(),actualRestaurantModel.getReviews());
        Assertions.assertEquals(expectedRestaurantModel.getWebsite(),actualRestaurantModel.getWebsite());

    }
    @Test
    public void getAllRestaurant_Test1(){
        Restaurant expectedRestaurantModel = new Restaurant();
        expectedRestaurantModel.setRestaurantId(101L);
        expectedRestaurantModel.setName("Dominos");
        Address address = new Address();
        address.setCity("Falls church");
        address.setId(1l);
        address.setState("VA");
        address.setZip("22044");
        expectedRestaurantModel.setAddress(address);
        expectedRestaurantModel.setCuisine( Cuisine.CHINNESE);
        expectedRestaurantModel.setWebsite("www.dominos.com");

        Restaurant expectedRestaurantModel1 = new Restaurant();
        expectedRestaurantModel1.setRestaurantId(102L);
        expectedRestaurantModel1.setName("Dominos1");
        Address address1 = new Address();
        address1.setCity("Falls church");
        address1.setId(1l);
        address1.setState("VA");
        address1.setZip("22044");
        expectedRestaurantModel.setAddress(address1);
        expectedRestaurantModel.setCuisine( Cuisine.CHINNESE);
        expectedRestaurantModel1.setWebsite("www.dominos1.com");
        List<Restaurant> restaurantModels = new ArrayList<>();
        restaurantModels.add(expectedRestaurantModel);
        restaurantModels.add(expectedRestaurantModel);
        restaurantModels.add(expectedRestaurantModel1);
        doReturn(restaurantModels).when(service).getAllRestaurants();
        List<Restaurant> actualRestaurantModels =  controller.getAllRestaurants();
        for (int i=0;i<actualRestaurantModels.size();i++) {
            Assertions.assertEquals(restaurantModels.get(i).getRestaurantId(),actualRestaurantModels.get(i).getRestaurantId());
            Assertions.assertEquals(restaurantModels.get(i).getName(),actualRestaurantModels.get(i).getName());
            Assertions.assertEquals(restaurantModels.get(i).getAddress(),actualRestaurantModels.get(i).getAddress());
            Assertions.assertEquals(restaurantModels.get(i).getReviews(),actualRestaurantModels.get(i).getReviews());
            Assertions.assertEquals(restaurantModels.get(i).getWebsite(),actualRestaurantModels.get(i).getWebsite());

        }

    }


    //@Test
 /*void testGetAllCars() throws Exception {
        String uri = STARTING_URI + "/car";
        Restaurant[] restaurants = {
                new Restaurant(),
                new RestaurantModel()};
        List<Restaurant> allres = Arrays.asList(restaurants);
        when(service.getAllRestaurants()).thenReturn(allres);
        mockMvc.perform(get(uri))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.length()").value(allres.size()))
                .andExpect(jsonPath("$[0].id").value(allres.get(0).getRestaurantId()))
                .andExpect(jsonPath("$[0].name").value(allres.get(0).getName()))
                .andExpect(jsonPath("$[0].address").value(allres.get(0).getAddress()))
                .andExpect(jsonPath("$[0].review").value(allres.get(0).getReviews()))
                .andExpect(jsonPath("$[0].website").value(allres.get(0).getWebsite()))
                .andExpect(jsonPath("$[0].cuisinetype").value(allres.get(0).getCuisinetype()))
                .andExpect(jsonPath("$[0].id").value(allres.get(0).getRestaurantId()))
                .andExpect(jsonPath("$[0].name").value(allres.get(0).getName()))
                .andExpect(jsonPath("$[0].address").value(allres.get(0).getAddress()))
                .andExpect(jsonPath("$[0].review").value(allres.get(0).getReviews()))
                .andExpect(jsonPath("$[0].website").value(allres.get(0).getWebsite()))
                .andExpect(jsonPath("$[0].cuisinetype").value(allres.get(0).getCuisinetype()));
        verify(service, times(1)).getAllRestaurants();
        verifyNoMoreInteractions(service);
    }*/


    // json - string conversions
  /*public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }*/

}


