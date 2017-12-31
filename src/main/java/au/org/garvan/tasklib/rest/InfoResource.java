/*
 * Copyright (c) 2017 Garvan Institute of Medical Research
 * Copyright (c) 2017 Dmitry Degrave
 */

package au.org.garvan.tasklib.rest;

import au.org.garvan.tasklib.entity.InfoResponse;
import au.org.garvan.tasklib.service.TaskLibService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Info resource, provides list of tasks
 */
@Path("/info")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
public class InfoResource {

    @Inject
    private TaskLibService service;

    @GET
    public InfoResponse info() {
        return service.info();
    }
}