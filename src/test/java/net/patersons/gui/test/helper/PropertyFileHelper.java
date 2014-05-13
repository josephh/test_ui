package net.patersons.gui.test.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileHelper {

    private String propertyFile;

    public PropertyFileHelper(String propertyFile) {
        this.propertyFile = propertyFile;
    }

    public Properties load() throws IOException {
        InputStream propertyStream = PropertyFileHelper.class.getClassLoader().getResourceAsStream(propertyFile);
        Properties properties = new Properties();
        if(propertyStream != null) {
            properties.load(propertyStream);
        }

        return properties;
    }

    public static String propertiesFileName(Class clazz) {
        return clazz.getSimpleName() + ".properties";
    }

}
