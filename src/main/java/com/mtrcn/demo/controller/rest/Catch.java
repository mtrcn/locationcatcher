package com.mtrcn.demo.controller.rest;

import com.mtrcn.demo.domain.LocationMessage;
import com.mtrcn.demo.repository.LocationRepository;
import org.primefaces.push.PushContext;
import org.primefaces.push.PushContextFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;

@Path("/catch")
@Component
public class Catch {

    @Autowired
    LocationRepository locationRepository;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getMessage(LocationMessage message) {
        try{
            message.setTime(new Date());
            locationRepository.save(message);
            String result = "{\"result\":\"Message received\"}";
            PushContext pushContext = PushContextFactory.getDefault().getPushContext();
            pushContext.push("/location", message);
            return Response.status(200).entity(result).build();
        }catch (Exception ex){
            ex.printStackTrace();
            return Response.status(500).entity(ex.getMessage()).build();
        }
    }
}
