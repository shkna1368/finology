package com.finology.car.car_part;

import com.finology.car.without_inheritance.car.Car;
import com.finology.car.without_inheritance.car.CarDTO;
import com.finology.car.common.CarType;
import com.finology.car.without_inheritance.car_part.*;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
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
@WebMvcTest(CarPartController.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CarPartControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private CarPartMapper mapper;
    @MockBean
   private CarPartService service;



    @Order(1)
    @Test
    public void testFindAll() throws Exception {


        Car car=new Car();
        car.setId(1l);
        String model="m1";
        CarType carType=CarType.SPORT;
        car.setModel(model);
        car.setCarType(carType);



        CarPart carPart1=new CarPart();
        carPart1.setCar(car);
        String title2="tit2";
        carPart1.setTitle(title2);
        carPart1.setCar(car);
        carPart1.setIsRepairable(true);


        CarPart carPart2=new CarPart();
        carPart2.setCar(car);
        String title3="tit3";
        carPart2.setTitle(title3);
        carPart2.setCar(car);
        carPart2.setIsRepairable(true);


        CarDTO carDTO1=new CarDTO();
        String model3="m1";
        CarType carType3=CarType.SPORT;
        carDTO1.setModel(model3);
        carDTO1.setCarType(carType3);

        CarPartDTO carPartDTO1=new CarPartDTO();
        String title4="tit2";
        carPartDTO1.setTitle(title4);
        carPartDTO1.setCar(carDTO1);
        carPartDTO1.setIsRepairable(true);

        CarPartDTO carPartDTO2=new CarPartDTO();
        String title5="tit3";
        carPartDTO2.setTitle(title5);
        carPartDTO2.setCar(carDTO1);
        carPartDTO2.setIsRepairable(true);





        List<CarPart> cars=List.of(carPart1,carPart2);
        List<CarPartDTO> carPartDTOS=List.of(carPartDTO1,carPartDTO2);

        when(service.getByCar(car.getId())).thenReturn(cars);
        when(mapper.toDTOs(cars)).thenReturn(carPartDTOS);


        // when -  action or the behaviour that we are going test
        ResultActions response = mvc.perform(MockMvcRequestBuilders
                .get("/car-part/v1/getByCar/1")
                .accept(MediaType.APPLICATION_JSON));


        // then - verify the output
        response.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(2)))

                .andExpect(jsonPath("$.*", isA(ArrayList.class)))
                .andExpect(jsonPath("$[0].title", Matchers.is("tit2")))
                .andExpect(jsonPath("$[1].title", Matchers.is("tit3")));

    }
}
