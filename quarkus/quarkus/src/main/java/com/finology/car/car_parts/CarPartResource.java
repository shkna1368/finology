package com.finology.car.car_parts;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/car-part")
@Produces(MediaType.APPLICATION_JSON)
public class CarPartResource {
    private final CarPartService service;
    private final CarPartMapper mapper;

    public CarPartResource(CarPartService service, CarPartMapper mapper) {
        this.service = service;
        this.mapper=mapper;
    }


    @GET
    public List<CarPartDTO> list() {
        return mapper.toDTOs(service.findAll());
    }

    @Transactional
    @GET
    @Path("/findByCar/{carId}")
    public List<CarPartDTO> get(@PathParam("carId") Long  carId) {
        return mapper.toDTOs(service.findByCar(carId));
    }


    @APIResponses(value = {@APIResponse(responseCode = "201",description = "create new car part")})
    @Operation(summary = "Create new ")
    @POST
    public Response create(@Valid CarPartDTO carPartDTO)  {

        service.create( mapper.toEntity(carPartDTO));

        return   Response.status(Response.Status.CREATED).build();
    }



}