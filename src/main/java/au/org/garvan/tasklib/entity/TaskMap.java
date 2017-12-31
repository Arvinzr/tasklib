/*
 * Copyright (c) 2017 Garvan Institute of Medical Research
 * Copyright (c) 2017 Dmitry Degrave
 */

package au.org.garvan.tasklib.entity;

import au.org.garvan.tasklib.util.ReadConfig;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

/**
 * TaskMap Lazy Singleton Factory
 */
public class TaskMap {

    private static class ResourceHolder {
        static Map<String,Task> tasks = newResource();

        private static Map<String,Task> newResource() {
            String path = ReadConfig.getProp().getProperty("appPath");
            Map<String,Task> newTasks = new HashMap<>();
            File[] files = new File(path).listFiles();

            if (files != null) {
                for (File file : files) {
                    String fileName = file.getName();
                    if (file.isFile() && fileName.endsWith(".jar")) {

                        try {
                            JarFile jar = new JarFile(file);
                            Manifest mf = jar.getManifest();
                            Attributes mattr = mf.getMainAttributes();
                            String taskId=null, mainClass=null, desc=null, deps=null;

                            for (Object key : mattr.keySet()) {
                                String val = mattr.getValue((Attributes.Name)key);
                                if (key != null)
                                    switch (key.toString()) {
                                        case "Main-Class": mainClass = val; break;
                                        case "Dependencies": deps = val; break;
                                        case "Specification-Title": desc = val; break;
                                        case "Implementation-Title": taskId = val; break;
                                    }
                            }

                            if (taskId != null && mainClass != null)
                                newTasks.put(taskId, new Task(taskId, desc, fileName, path, mainClass, deps));
                        } catch (IOException e) {
                            // skip it
                        }
                    }
                }
            }

            return newTasks;
        }
    }

    public static Map<String,Task> getTasks() {
        return ResourceHolder.tasks;
    }
}