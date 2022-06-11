package com.finology.car.car_part;

import com.finology.car.car.CarDTO;
import com.finology.car.car.CarMapper;
import com.finology.car.car.CarType;
import com.finology.car.car.ICarService;
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
@RequestMapping(value = "/car-part/")
public class CarPartController {
  private final ICarPartService carPartService;
   private final CarPartMapper carPartMapper;

    @ApiOperation(value = "Save New carPart")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "successfully create"),
            @ApiResponse(code = 409, message = "duplicate"),
    })
    @PutMapping()
    public ResponseEntity save(@RequestBody CarPartDTO carPartDTO){
       carPartService.save(carPartMapper.toCarPart(carPartDTO));
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @ApiOperation(value = "update carPart")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successfully update"),
            @ApiResponse(code = 404, message = "not found"),
            @ApiResponse(code = 409, message = "duplicate"),

    })
    @PostMapping()
    public ResponseEntity update(@RequestBody CarPartDTO carPartDTO){
       carPartService.update(carPartMapper.toCarPart(carPartDTO));
        return  ResponseEntity.ok().build();


    }
    @ApiOperation(value = "get carPart by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successfully get car"),
            @ApiResponse(code = 404, message = "not found"),
    })
    @GetMapping(value="/{id}")
    public ResponseEntity<CarPartDTO> getById(@PathVariable Long id){

       CarPartDTO carPartDTO= carPartMapper.toCarPartDTO(carPartService.getById(id));

        return  ResponseEntity.ok(carPartDTO);


    }
    @ApiOperation(value = "get carParts by car")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successfully get cars "),
    })
    @GetMapping(value="/getByCar/{carId}")
    public ResponseEntity<List<CarPartDTO>> getByCarType(@PathVariable Long carId){

       List< CarPartDTO> carPartDTOS= carPartMapper.toDTOs(carPartService.getByCar(carId));

        return  ResponseEntity.ok(carPartDTOS);


    }
    @ApiOperation(value = "successfully delete carPart")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successfully delete car"),
            @ApiResponse(code = 404, message = "not found"),
    })
 @DeleteMapping(value="/{id}")
    public ResponseEntity delete(@PathVariable Long id){
      carPartService.delete(id);
     return  ResponseEntity.ok().build();


    }



}
