/*
 * Copyright (c) 2017 Garvan Institute of Medical Research
 * Copyright (c) 2017 Dmitry Degrave
 */

package au.org.garvan.tasklib.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * DeleteResponse
 */
@XmlRootElement(name = "DeleteResponse")
public class DeleteResponse {

    private String submissionId;
    private Error error;
    private Boolean successfulKill;

    public DeleteResponse() {
        // needed for JAXB
    }

    public DeleteResponse(String submissionId, Error error, Boolean successfulKill) {
        this.submissionId = submissionId;
        this.error = error;
        this.successfulKill = successfulKill;
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

    public Boolean getSuccessfulKill() {
        return successfulKill;
    }

    public void setSuccessfulKill(Boolean successfulKill) {
        this.successfulKill = successfulKill;
    }
}
