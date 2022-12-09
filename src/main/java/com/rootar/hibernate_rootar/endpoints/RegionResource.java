package com.rootar.hibernate_rootar.endpoints;


import com.rootar.hibernate_rootar.dto.RegionDto;
import com.rootar.hibernate_rootar.entities.RegionEntity;
import com.rootar.hibernate_rootar.repositories.RegionRepository;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/region")
@Tag(name = "Regions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RegionResource {

    RegionRepository regionRepository = new RegionRepository();
    @GET

    public Response getAll() {
        List<RegionDto> listRegion = regionRepository.getAll();
        return Response.ok(listRegion).build();
    }
    @GET
    @Path("{idRegion}")

    public Response getById(@PathParam("idRegion") Integer idRegion) {
        RegionEntity region = regionRepository.getById(idRegion);
        return Response.ok(region).build();
    }
 /*   @POST

    public Response insert(RegionEntity region){
        if(region == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        regionRepository.create(region);
        return Response.ok(region).status(Response.Status.CREATED).build();

    }
    @PUT
    @ApiResponse(responseCode = "204", description = "Modifié")
    @ApiResponse(responseCode = "404", description = "non trouvée !")
    public Response update(RegionEntity region){

        if(region == null ){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        if(regionRepository.update(region)) {

            return Response.ok(204).build();
        }
        else{
            return  Response.status(Response.Status.CONFLICT).build();

        }
    }
    @DELETE
    @Consumes("application/json")
    @Path("{idRegion}")
    @ApiResponse(responseCode = "204", description = "Supprimé")
    @ApiResponse(responseCode = "404", description = "non trouvée !")
    public Response delete(@PathParam("idRegion") Integer idRegion){

        if(idRegion==null ){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        if(regionRepository.delete(region)) {

            return Response.ok(204).build();
        }
        else{
            return  Response.status(Response.Status.CONFLICT).build();
        }
    }*/
}
