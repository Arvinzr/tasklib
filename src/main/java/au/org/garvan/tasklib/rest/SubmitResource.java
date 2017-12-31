/*
 * Copyright (c) 2017 Garvan Institute of Medical Research
 * Copyright (c) 2017 Dmitry Degrave
 */

package au.org.garvan.tasklib.rest;

import au.org.garvan.tasklib.entity.SubmitResponse;
import au.org.garvan.tasklib.service.TaskLibService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Submit resource, submits a job to Spark cluster
 */
@Path("/submit")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
public class SubmitResource {

    @Inject
    private TaskLibService service;

    @GET
    public SubmitResponse submit(@QueryParam("taskId") String taskId,
                                 @QueryParam("args") List<String> args) {
        return service.submit(taskId, args);
    }
}