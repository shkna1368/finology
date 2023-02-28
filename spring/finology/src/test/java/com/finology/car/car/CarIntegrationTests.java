package com.finology.car.car;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finology.car.without_inheritance.car.Car;
import com.finology.car.without_inheritance.car.CarRepository;
import com.finology.car.common.CarType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.isA;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)

@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class CarIntegrationTests {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CarRepository carRepository;

 @Autowired
    private ObjectMapper objectMapper;


    @BeforeEach
    void clearDatabase(@Autowired CarRepository personRepository) {
        personRepository.deleteAll();
    }


    @Test
    public void givenCarObject_whenCreateCar_thenReturnSaved() throws Exception{

        // given - precondition or setup

        Car car1=new Car();
        String model="m1";
        CarType carType=CarType.SPORT;
        car1.setModel(model);
        car1.setCarType(carType);



        // when - action or behaviour that we are going test
        ResultActions response = mockMvc.perform(post("/car/v1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(car1)));



        // then - verify the result or output using assert statements
        response.andDo(print()).
                andExpect(status().isCreated());


    }
    @Test
    public void givenListOfCar_whenGetAllCar_thenReturnCarList() throws Exception{
        // given - precondition or setup


        Car car1=new Car();
        String model="m1";
        CarType carType=CarType.SPORT;
        car1.setModel(model);
        car1.setCarType(carType);


        Car car2=new Car();
        String model2="m2";
        CarType carType2=CarType.SPORT;
        car2.setModel(model2);
        car2.setCarType(carType2);


        List<Car> cars=List.of(car1,car2);

      carRepository.saveAll(cars);


        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders
                        .get("/car/v1/getByCarType/SPORT")
                        .accept(MediaType.APPLICATION_JSON));


        // then - verify the output
         response.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(2)))

                .andExpect(jsonPath("$.*", isA(ArrayList.class)))
                .andExpect(jsonPath("$[0].model", Matchers.is("m1")));


    }


}
