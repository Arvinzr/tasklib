/*
 * Copyright (c) 2017 Garvan Institute of Medical Research
 * Copyright (c) 2017 Dmitry Degrave
 */

package au.org.garvan.tasklib.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * StatusResponse
 */
@XmlRootElement(name = "StatusResponse")
public class StatusResponse {

    private String submissionId;
    private Error  error;
    private String driverState;
    private String workerHostPort;
    private String workerId;

    public StatusResponse() {
        // needed for JAXB
    }

    public StatusResponse(String submissionId, Error error, String driverState, String workerHostPort, String workerId) {
        this.submissionId = submissionId;
        this.error = error;
        this.driverState = driverState;
        this.workerHostPort = workerHostPort;
        this.workerId = workerId;
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

    public String getDriverState() {
        return driverState;
    }

    public void setDriverState(String driverState) {
        this.driverState = driverState;
    }

    public String getWorkerHostPort() {
        return workerHostPort;
    }

    public void setWorkerHostPort(String workerHostPort) {
        this.workerHostPort = workerHostPort;
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }
}
