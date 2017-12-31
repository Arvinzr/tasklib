/*
 * Copyright (c) 2017 Garvan Institute of Medical Research
 * Copyright (c) 2017 Dmitry Degrave
 */

package au.org.garvan.tasklib.rest;

import au.org.garvan.tasklib.entity.StatusResponse;
import au.org.garvan.tasklib.service.TaskLibService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Status resource, provides status of Spark job
 */
@Path("/status")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
public class StatusResource {

    @Inject
    private TaskLibService service;

    @GET
    public StatusResponse status(@QueryParam("submissionId") String submissionId) {
        return service.status(submissionId);
    }
}