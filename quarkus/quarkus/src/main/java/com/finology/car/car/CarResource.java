package com.finology.car.car;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/car")
@Produces(MediaType.APPLICATION_JSON)
public class CarResource {
    private final CarService carService;
    private final CarMapper carMapper;

    public CarResource(CarService carService,CarMapper carMapper) {
        this.carService = carService;
        this.carMapper=carMapper;
    }

    @APIResponses(value = {@APIResponse(responseCode = "201",description = "create new car car")})
    @Operation(summary = "Create new ")
    @POST
    public Response  create(@Valid CarDTO carDTO)  {

        carService.create( carMapper.toEntity(carDTO));

        return   Response.status(Response.Status.CREATED).build();
    }

    @GET
    public List<CarDTO> list() {
        return carMapper.toDTOs(carService.findAll());
    }

    @Transactional
    @GET
    @Path("/findByCarType/{carType}")
    public List<CarDTO> get(@PathParam("carType") CarType carType) {
        return carMapper.toDTOs(carService.findByCarType(carType));
    }






}