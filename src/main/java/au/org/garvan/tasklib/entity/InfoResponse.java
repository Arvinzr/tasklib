/*
 * Copyright (c) 2017 Garvan Institute of Medical Research
 * Copyright (c) 2017 Dmitry Degrave
 */

package au.org.garvan.tasklib.entity;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * InfoResponse
 */
@XmlRootElement(name = "InfoResponse")
public class InfoResponse {

    private List<Task> taskId;

    public InfoResponse() {
        // needed for JAXB
    }

    public InfoResponse(List<Task> taskId) {
        this.taskId = taskId;
    }

    public List<Task> getTaskId() {
        return taskId;
    }

    public void setTaskId(List<Task> taskId) {
        this.taskId = taskId;
    }
}
