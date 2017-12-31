/*
 * Copyright (c) 2017 Garvan Institute of Medical Research
 * Copyright (c) 2017 Dmitry Degrave
 */

package au.org.garvan.tasklib.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Config file utilities.
 */
public class ReadConfig {
    private static final String propFileName = "tasklib.properties";
    private static final Properties prop = readConfig();

    private static Properties readConfig() {
        Properties p = new Properties();
        try (InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(propFileName)) {
            if (inputStream != null) {
                p.load(inputStream);
            } else {
                setDefaults(p);
            }
        } catch (IOException e) {
            setDefaults(p);
        }
        return p;
    }

    private static void setDefaults(Properties p) {
        System.out.println("Can't read properties from " + propFileName);
        System.out.println("Starting with sparkMaster=localhost sparkVersion=2.1.0 appPath=/opt/app");
        p.setProperty("sparkMaster","localhost");
        p.setProperty("sparkVersion","2.1.0");
        p.setProperty("appPath","/opt/app/");
    }

    public static Properties getProp() {
        return prop;
    }
}
