/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WSSPack;

import Controller.OntoController;
import Model.IndividualModel;
import Model.PlatformModel;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author icarv
 */
@Path("WSSecoRestful")
public class WSSeco {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WSSeco
     */
    public WSSeco() {
    }

    /**
     * Retrieves representation of an instance of WSSPack.WSSeco
     * @param platform
     * @return 
     */
        
       
    
    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_XML)
    public String createPlatform(PlatformModel platform){
        return OntoController.createPlatform(platform);
    }
    
    @POST
    @Path("edit")
    @Consumes(MediaType.APPLICATION_XML)
    public String editPlatform(PlatformModel platform){
        return OntoController.savePlatform(platform);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("getplatform/{name}")
    public static PlatformModel returnPlatform(@PathParam("name") String name){
        return OntoController.returnPlatform(name);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("getplatforms")
    public List<PlatformModel> getPlatforms() {
        return OntoController.returnPlatforms();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("getdata/{name}")
    public static List<PlatformModel> returnData(@PathParam("name") String name){
        return OntoController.returnData(name);
    }

}
