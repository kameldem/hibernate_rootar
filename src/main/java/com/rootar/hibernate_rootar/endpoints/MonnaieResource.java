package com.rootar.hibernate_rootar.endpoints;


import com.rootar.hibernate_rootar.entities.MonnaieEntity;
import com.rootar.hibernate_rootar.repositories.MonnaieRepository;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/monnaie")
@Tag(name = "Monnaies")
public class MonnaieResource {

    MonnaieRepository monnaieRepository = new MonnaieRepository();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<MonnaieEntity> listMonnaies= monnaieRepository.getAll();
        return Response.ok(listMonnaies).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id) {
        MonnaieEntity monnaie = monnaieRepository.getById(id);
        return Response.ok(monnaie).build();
    }
   /* @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(Monnaie monnaie){
        if(monnaie == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        if(DAOFactory.getMonnaieDAO().insert(monnaie)){
            return Response.ok(monnaie).status(Response.Status.CREATED).build();
        }
        else return Response.status(Response.Status.BAD_REQUEST).build();

    }


    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiResponse(responseCode = "204", description = "Modifié")
    @ApiResponse(responseCode = "404", description = "non trouvée !")
    public Response update(Monnaie monnaie){

        if(monnaie == null ){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        if(DAOFactory.getMonnaieDAO().update(monnaie)) {

            return Response.ok(204).build();
        }
        else{
            return  Response.status(Response.Status.CONFLICT).build();

        }


    }

    @DELETE
    @Consumes("application/json")
    @Path("{id}")
    @ApiResponse(responseCode = "204", description = "Supprimé")
    @ApiResponse(responseCode = "404", description = "non trouvée !")
    public Response delete(@PathParam("id") Integer id){

        if(id == null ){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        if(DAOFactory.getMonnaieDAO().delete(new Monnaie(id,""))) {

            return Response.ok(204).build();
        }
        else{
            return  Response.status(Response.Status.CONFLICT).build();

        }
    }*/
}
