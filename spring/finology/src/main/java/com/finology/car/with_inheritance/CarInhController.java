package com.finology.car.with_inheritance;


import com.finology.car.common.CarType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/carinh/")
public class CarInhController {

private final ICarInhService carInhService;


    @Operation(summary = "get cars by carType")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successfully get cars "),
    })
    @GetMapping(value="/getByCarType/{carType}")
    public ResponseEntity<List<? extends CarInh>> getByCarType(@PathVariable CarType carType){

            return  ResponseEntity.ok(carInhService.getCarByType(carType));


    }




}
