package com.rootar.hibernate_rootar.endpoints;

import com.rootar.hibernate_rootar.entities.MonnaieEntity;
import com.rootar.hibernate_rootar.entities.PaysEntity;
import com.rootar.hibernate_rootar.repositories.MonnaieRepository;
import com.rootar.hibernate_rootar.repositories.PaysRepository;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/pays")
@Tag(name = "Pays")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PaysResource {
    PaysRepository paysRepository = new PaysRepository();
    @GET
    public Response getAll() {
        List<PaysEntity> listPays= paysRepository.getAll();
        return Response.ok(listPays).build();
    }
    @GET
    @Path("{idPays}")
    public Response getById(@PathParam("idPays") Integer idPays) {
        PaysEntity pays = paysRepository.getById(idPays);
        return Response.ok(pays).build();
    }
    @POST
    public Response insert(PaysEntity pays){
        if(pays == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        paysRepository.create(pays);
        return Response.ok(pays).status(Response.Status.CREATED).build();


    }
    @PUT
    @ApiResponse(responseCode = "204", description = "Modifié")
    @ApiResponse(responseCode = "404", description = "non trouvée !")
    public Response update(PaysEntity pays){

        if(pays == null ){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        if(paysRepository.update(pays)) {

            return Response.ok(204).build();
        }
        else{
            return  Response.status(Response.Status.CONFLICT).build();

        }
    }
    @DELETE
    @Consumes("application/json")
    @Path("{idPays}")
    @ApiResponse(responseCode = "204", description = "Supprimé")
    @ApiResponse(responseCode = "404", description = "non trouvée !")
    public Response delete(@PathParam("idPays") Integer idPays){
        PaysEntity pays= new PaysEntity();
        pays.setIdMonnaie(idPays);
        if(idPays == null ){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        if(paysRepository.delete(pays)) {

            return Response.ok(204).build();
        }
        else{
            return  Response.status(Response.Status.CONFLICT).build();

        }
    }
}
