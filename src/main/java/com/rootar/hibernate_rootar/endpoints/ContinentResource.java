package com.rootar.hibernate_rootar.endpoints;


import com.rootar.hibernate_rootar.entities.ContinentEntity;
import com.rootar.hibernate_rootar.entities.MonnaieEntity;
import com.rootar.hibernate_rootar.repositories.ContinentRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/continent")
@Tag(name="Continent")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContinentResource {

    ContinentRepository continentRepository = new ContinentRepository();
    @GET

    @Operation(summary = "Recuperation des continents")
    public Response getAll() {
        List<ContinentEntity> continents = continentRepository.getAll();
        return Response.ok(continents).build();
    }

    @GET
    @Path("{id}")

    public Response getById(@PathParam("id") Integer id) {
        ContinentEntity continent = continentRepository.getById(id);
        return Response.ok(continent).build();
    }


    @PUT
    @ApiResponse(responseCode = "204", description = "Modifié")
    @ApiResponse(responseCode = "404", description = "non trouvée !")
    public Response update(ContinentEntity continent){
        if(continent == null ){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        if(continentRepository.update(continent)) {
            return Response.ok(204).build();
        }
        else{
            return  Response.status(Response.Status.CONFLICT).build();
        }
    }

    @DELETE
    @Path("{id}")
    @ApiResponse(responseCode = "204", description = "Supprimé")
    @ApiResponse(responseCode = "404", description = "non trouvée !")
    public Response delete(@PathParam("id") Integer id){
        ContinentEntity continent = new ContinentEntity();
        continent.setIdContinent(id);
        if(id == null ){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        if(continentRepository.delete(continent)){

            return Response.ok(204).build();
        }
        else{
            return  Response.status(Response.Status.CONFLICT).build();

        }
    }

    @POST
    public Response insert(ContinentEntity continent){

            if(continent == null){
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
            continentRepository.insert(continent);
            return Response.ok(continent).status(Response.Status.CREATED).build();



        }

}
