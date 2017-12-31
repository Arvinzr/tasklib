/*
 * Copyright (c) 2017 Garvan Institute of Medical Research
 * Copyright (c) 2017 Dmitry Degrave
 */

package au.org.garvan.tasklib.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * REST TaskLib application.
 */
@ApplicationPath("/tasklib")
public class TaskLib extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        return new HashSet<>(Arrays.asList(InfoResource.class, SubmitResource.class, StatusResource.class,
                DeleteResource.class, CorsResponseFilter.class));
    }
}