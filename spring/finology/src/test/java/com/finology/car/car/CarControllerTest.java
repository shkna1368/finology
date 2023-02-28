package com.finology.car.car;
import com.finology.car.common.CarType;
import com.finology.car.without_inheritance.car.*;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(CarController.class)
//@Import(PostControllerTest.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CarControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private CarMapper mapper;
    @MockBean
   private CarService service;



    @Order(1)
    @Test
    public void testFindCarByType() throws Exception {


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


        CarDTO carDTO1=new CarDTO();
        String model3="m1";
        CarType carType3=CarType.SPORT;
        carDTO1.setModel(model3);
        carDTO1.setCarType(carType3);

        CarDTO carDTO2=new CarDTO();
        String model4="m2";
        CarType carType4=CarType.SPORT;
        carDTO2.setModel(model4);
        carDTO2.setCarType(carType4);






        List<Car> cars=List.of(car1,car2);
        List<CarDTO> carDTOs=List.of(carDTO1,carDTO2);

        when(service.getByCarType(CarType.SPORT)).thenReturn(cars);
        when(mapper.toDTOs(cars)).thenReturn(carDTOs);


        // when -  action or the behaviour that we are going test
        ResultActions response = mvc.perform(MockMvcRequestBuilders
                .get("/car/v1/getByCarType/SPORT")
                .accept(MediaType.APPLICATION_JSON));


        // then - handler = {ResourceHttpRequestHandler@9863} "ResourceHttpRequestHandler [classpath [META-INF/resources/], classpath [resources/], classpath [static/], classpath [public/], ServletContext [/]]"verify the output
        response.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(2)))

                .andExpect(jsonPath("$.*", isA(ArrayList.class)))
                .andExpect(jsonPath("$[0].model", Matchers.is("m1")))
                .andExpect(jsonPath("$[1].model", Matchers.is("m2")));

    }
}
