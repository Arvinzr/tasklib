/*
 * Copyright (c) 2017 Garvan Institute of Medical Research
 * Copyright (c) 2017 Dmitry Degrave
 */

package au.org.garvan.tasklib.entity;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Set;

/**
 * SubmitResponse
 */
@XmlRootElement(name = "SubmitResponse")
public class SubmitResponse {

    private String taskId;
    private List<String> args;
    private Set<String> deps;
    private String submissionId;
    private Error  error;

    public SubmitResponse() {
        // needed for JAXB
    }

    public SubmitResponse(String taskId, List<String> args, Set<String> deps, String submissionId, Error error) {
        this.taskId = taskId;
        this.args = args;
        this.deps = deps;
        this.submissionId = submissionId;
        this.error = error;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public List<String> getArgs() {
        return args;
    }

    public void setArgs(List<String> args) {
        this.args = args;
    }

    public Set<String> getDeps() {
        return deps;
    }

    public void setDeps(Set<String> deps) {
        this.deps = deps;
    }

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
