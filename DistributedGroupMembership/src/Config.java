import sun.applet.AppletClassLoader;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: kyle
 * Date: 9/15/13
 * Time: 1:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class Config {

    private Properties config;

    public Config(String configFile) throws IOException {
        config = new Properties();
        try {
            config.load(AppletClassLoader.getSystemResourceAsStream(configFile));
        } catch (NullPointerException e) {
            throw new IOException("File Not Found: " + configFile);
        }
    }

    public String valueFor(String key) {
        return this.config.getProperty(key);
    }
}