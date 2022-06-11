package com.finology.car.car;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "Save New car")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "successfully create"),
            @ApiResponse(code = 409, message = "duplicate"),

    })
    @PutMapping()
    public ResponseEntity save(@RequestBody CarDTO carDTO){
       carService.save(carMapper.toCar(carDTO));
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @ApiOperation(value = "update car")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successfully update"),
            @ApiResponse(code = 404, message = "not found"),
            @ApiResponse(code = 409, message = "duplicate"),

    })
    @PostMapping()
    public ResponseEntity update(@RequestBody CarDTO carDTO){
       carService.update(carMapper.toCar(carDTO));
        return  ResponseEntity.ok().build();


    }
    @ApiOperation(value = "get car by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successfully get car"),
            @ApiResponse(code = 404, message = "not found"),
    })
    @GetMapping(value="/{id}")
    public ResponseEntity<CarDTO> getById(@PathVariable Long id){

       CarDTO carDTO= carMapper.toCarDTO(carService.getById(id));

        return  ResponseEntity.ok(carDTO);


    }
    @ApiOperation(value = "get cars by carType")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successfully get cars "),
    })
    @GetMapping(value="/getByCarType/{carType}")
    public ResponseEntity<List<CarDTO>> getByCarType(@PathVariable CarType  carType){

       List< CarDTO> carDTOs= carMapper.toDTOs(carService.getByCarType(carType));

        return  ResponseEntity.ok(carDTOs);


    }
    @ApiOperation(value = "successfully delete car")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successfully delete car"),
            @ApiResponse(code = 404, message = "not found"),
    })
 @DeleteMapping(value="/{id}")
    public ResponseEntity delete(@PathVariable Long id){
      carService.delete(id);
     return  ResponseEntity.ok().build();


    }



}
