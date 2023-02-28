package com.finology.car.without_inheritance.car;


import com.finology.car.common.CarType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/car/")
public class CarController {
  private final   ICarService carService;
   private final CarMapper carMapper;


 @Operation(summary = "create new car")
 @ApiResponses(value = {
         @ApiResponse( responseCode = "200", description = "successfully update"),
         @ApiResponse( responseCode = "409", description = "duplicate"),
 })
    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody CarDTO carDTO){
       carService.save(carMapper.toCar(carDTO));
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }


   @Operation(summary = "update car")
    @ApiResponses(value = {
            @ApiResponse( responseCode = "200", description = "successfully update"),
            @ApiResponse( responseCode = "404", description = "not found"),
            @ApiResponse( responseCode = "409", description = "duplicate"),
    })
    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody CarDTO carDTO){
       carService.update(carMapper.toCar(carDTO));
        return  ResponseEntity.ok().build();
    }


    @Operation(summary = "get car by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successfully get car"),
            @ApiResponse(responseCode = "404", description = "not found"),
    })
    @GetMapping(value="/v1/{id}")
    public ResponseEntity<CarDTO> getById(@PathVariable Long id){

       CarDTO carDTO= carMapper.toCarDTO(carService.getById(id));

        return  ResponseEntity.ok(carDTO);


    }
    @Operation(summary = "get cars by carType")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successfully get cars "),
    })
    @GetMapping(value="/v1/getByCarType/{carType}")
    public ResponseEntity<List<CarDTO>> getByCarType(@PathVariable CarType carType){

       List< CarDTO> carDTOs= carMapper.toDTOs(carService.getByCarType(carType));

        return  ResponseEntity.ok(carDTOs);


    }
    @Operation(summary = " delete car")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successfully delete car"),
            @ApiResponse(responseCode = "404", description = "not found"),
    })

 @DeleteMapping(value="/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
      carService.delete(id);
     return  ResponseEntity.ok().build();


    }



}
