/*
 * Copyright (c) 2017 Garvan Institute of Medical Research
 * Copyright (c) 2017 Dmitry Degrave
 */

package au.org.garvan.tasklib.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Task")
public class Task {

    private String taskId;
    private String desc;
    private String fileName;
    private String path;
    private String mainClass;
    private String dependencies;

    public Task() {
        // needed for JAXB
    }

    public Task(String taskId, String desc, String fileName, String path, String mainClass, String dependencies) {
        this.taskId = taskId;
        this.desc = desc;
        this.fileName = fileName;
        this.path = path;
        this.mainClass = mainClass;
        this.dependencies = dependencies;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMainClass() {
        return mainClass;
    }

    public void setMainClass(String mainClass) {
        this.mainClass = mainClass;
    }

    public String getDependencies() {
        return dependencies;
    }

    public void setDependencies(String dependencies) {
        this.dependencies = dependencies;
    }
}