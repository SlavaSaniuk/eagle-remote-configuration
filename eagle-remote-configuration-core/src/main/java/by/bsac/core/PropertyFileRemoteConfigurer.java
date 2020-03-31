package by.bsac.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.*;
import java.util.Properties;

public class PropertyFileRemoteConfigurer implements RemoteConfigurer, ResourceLoaderAware, InitializingBean {

    //Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertyFileRemoteConfigurer.class);
    //Spring beans
    private ResourceLoader RESOURCE_LOADER;
    //Class variables
    private String property_file_path;
    private Resource PROPERTY_SOURCE;

    //Constructors
    public PropertyFileRemoteConfigurer(String a_property_file_path) {
        this.property_file_path = a_property_file_path;
    }

    @Override
    public Properties loadProperties() {
        try(InputStream in = this.openInToFile()) {

            Properties props = new Properties();
            props.load(in);
            return props;

        }catch (IOException exc) {
            LOGGER.error(exc.getMessage());
        }

        return new Properties();
    }

    @Override
    public void saveProperties(Properties a_props, String a_comment) {

        try(OutputStream out = this.openOutToFile()) {

            a_props.store(out, a_comment);

        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }

    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        LOGGER.debug(String.format("Autowire by type [%s] bean to [%s] service bean.",
                ResourceLoader.class.getCanonicalName(), PropertyFileRemoteConfigurer.class.getCanonicalName()));
        this.RESOURCE_LOADER = resourceLoader;
    }


    @Override
    public void afterPropertiesSet() throws Exception {

        //Check dependencies

        //Get resource and assert it's found
        this.PROPERTY_SOURCE = this.RESOURCE_LOADER.getResource(this.property_file_path);
        if (!this.PROPERTY_SOURCE.getFile().exists())
            throw new Exception(new BeanCreationException(
                    String.format("Specified property file with path[%s] is not found.", this.property_file_path)));
    }

    private InputStream openInToFile() throws IOException {
        return new FileInputStream(this.PROPERTY_SOURCE.getFile());
    }

    private OutputStream openOutToFile() throws IOException {
        return new FileOutputStream(this.PROPERTY_SOURCE.getFile());
    }
}
