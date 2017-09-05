package controllers;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/netid")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_PLAIN)
public class NetIDController {
    //public NetIDController(){}

        @GET
        public String getNetID() {
            return "twd38";
        }

}