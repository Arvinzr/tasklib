/*
 * Copyright (c) 2017 Garvan Institute of Medical Research
 * Copyright (c) 2017 Dmitry Degrave
 */

package au.org.garvan.tasklib.rest;

import au.org.garvan.tasklib.entity.DeleteResponse;
import au.org.garvan.tasklib.service.TaskLibService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Delete resource, kills the Spark job
 */
@Path("/delete")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
public class DeleteResource {

    @Inject
    private TaskLibService service;

    @GET
    public DeleteResponse delete(@QueryParam("submissionId") String submissionId) {
        return service.delete(submissionId);
    }
}