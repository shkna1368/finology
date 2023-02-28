package com.finology.car.without_inheritance.car_part;


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
@RequestMapping(value = "/car-part/")
public class CarPartController {
  private final ICarPartService carPartService;
   private final CarPartMapper carPartMapper;

    @Operation(summary = "Save new carPart")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successfully create"),
            @ApiResponse(responseCode = "409", description = "duplicate"),
    })
    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody CarPartDTO carPartDTO){
       carPartService.save(carPartMapper.toCarPart(carPartDTO));
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "update car part")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successfully update"),
            @ApiResponse(responseCode = "404", description = "not found"),
            @ApiResponse(responseCode = "409", description = "duplicate"),

    })
    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody CarPartDTO carPartDTO){
       carPartService.update(carPartMapper.toCarPart(carPartDTO));
        return  ResponseEntity.ok().build();


    }
    @Operation(summary = "get carPart by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successfully get car"),
            @ApiResponse(responseCode = "404", description = "not found"),
    })
    @GetMapping(value="/v1/{id}")
    public ResponseEntity<CarPartDTO> getById(@PathVariable Long id){

       CarPartDTO carPartDTO= carPartMapper.toCarPartDTO(carPartService.getById(id));

        return  ResponseEntity.ok(carPartDTO);


    }
    @Operation(description = "get carParts by car")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successfully get cars "),
    })
    @GetMapping(value="/v1/getByCar/{carId}")
    public ResponseEntity<List<CarPartDTO>> getByCarType(@PathVariable Long carId){

       List< CarPartDTO> carPartDTOS= carPartMapper.toDTOs(carPartService.getByCar(carId));

        return  ResponseEntity.ok(carPartDTOS);


    }
    @Operation(summary = "successfully delete carPart")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successfully delete car"),
            @ApiResponse(responseCode = "404", description = "not found"),
    })
 @DeleteMapping(value="/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
      carPartService.delete(id);
     return  ResponseEntity.ok().build();


    }



}
