/*
 * Copyright (c) 2017 Garvan Institute of Medical Research
 * Copyright (c) 2017 Dmitry Degrave
 */

package au.org.garvan.tasklib.service;

import au.org.garvan.tasklib.entity.*;
import au.org.garvan.tasklib.entity.Error;
import com.github.ywilkof.sparkrestclient.FailedSparkRequestException;
import com.github.ywilkof.sparkrestclient.JobStatusResponse;
import com.github.ywilkof.sparkrestclient.SparkRestClient;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import java.io.File;
import java.util.*;

/**
 * TaskLib core service
 */
@RequestScoped
public class TaskLibService {

    @PostConstruct
    public void init() {
    }

    public InfoResponse info() {
        return new InfoResponse(new ArrayList<>(TaskMap.getTasks().values()));
    }

    public SubmitResponse submit(String taskId, List<String> args) {
        Set<String> dependencies = new HashSet<>();

        if (!TaskMap.getTasks().containsKey(taskId)) {
            Error errorResource = new Error("Spark submit request exception", "taskId doesn't exist");
            return new SubmitResponse(taskId, args, null, null, errorResource);
        }

        if (TaskMap.getTasks().get(taskId) != null) {
            Task t = TaskMap.getTasks().get(taskId);
            String deps = (t.getDependencies() != null) ? t.getDependencies() : t.getFileName();
            for (String dep : deps.split(",")) {
                dependencies.add(t.getPath() + File.separator + dep);
            }
        }

        Properties p = au.org.garvan.tasklib.util.ReadConfig.getProp();
        SparkRestClient sparkRestClient = SparkRestClient.builder()
                .masterHost(p.getProperty("sparkMaster"))
                .sparkVersion(p.getProperty("sparkVersion"))
                .build();
        try {
            Task t = TaskMap.getTasks().get(taskId);
            String submissionId = sparkRestClient.prepareJobSubmit()
                    .appName(t.getTaskId())
                    .appResource(t.getPath() + File.separator + t.getFileName())
                    .appArgs(args)
                    .mainClass(TaskMap.getTasks().get(taskId).getMainClass())
                    .usingJars(dependencies)
                    .submit();
            return new SubmitResponse(taskId, args, dependencies, submissionId, null);
        } catch (FailedSparkRequestException e) {
            Error errorResource = new Error("Spark submit request exception", e.getMessage());
            return new SubmitResponse(taskId, args, dependencies, null, errorResource);
        }
    }

    public StatusResponse status(String submissionId) {
        Properties p = au.org.garvan.tasklib.util.ReadConfig.getProp();
        SparkRestClient sparkRestClient = SparkRestClient.builder()
                .masterHost(p.getProperty("sparkMaster"))
                .sparkVersion(p.getProperty("sparkVersion"))
                .build();
        try {
            JobStatusResponse js = sparkRestClient.checkJobStatus().withSubmissionIdFullResponse(submissionId);
            return new StatusResponse(submissionId, null, js.getDriverState().toString(),
                    js.getWorkerHostPort().orElse(null), js.getWorkerId().orElse(null));
        } catch (FailedSparkRequestException e) {
            Error errorResource = new Error("Spark status request exception", "Unknown submissionId");
            return new StatusResponse(submissionId, errorResource, null, null, null);
        }
    }

    public DeleteResponse delete(String submissionId) {
        Properties p = au.org.garvan.tasklib.util.ReadConfig.getProp();
        SparkRestClient sparkRestClient = SparkRestClient.builder()
                .masterHost(p.getProperty("sparkMaster"))
                .sparkVersion(p.getProperty("sparkVersion"))
                .build();
        try {
            boolean successfulKill = sparkRestClient.killJob().withSubmissionId(submissionId);
            return new DeleteResponse(submissionId, null, successfulKill);
        } catch (FailedSparkRequestException e) {
            Error errorResource = new Error("Spark delete request exception", e.getMessage());
            return new DeleteResponse(submissionId, errorResource, null);
        }
    }

}