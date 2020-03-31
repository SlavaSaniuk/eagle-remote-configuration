package by.bsac;

import by.bsac.webmvc.WebmvcConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@Import({RootConfiguration.class, WebmvcConfiguration.class})
public class Main extends SpringBootServletInitializer {

    //Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

        LOGGER.info(String.format("Start to configure [%s] web application.", "eagle-rc-server"));

        //Disable spring banner
        LOGGER.info("Disable default spring banner.");
        builder.bannerMode(Banner.Mode.OFF);

        return super.configure(builder);
    }
}
