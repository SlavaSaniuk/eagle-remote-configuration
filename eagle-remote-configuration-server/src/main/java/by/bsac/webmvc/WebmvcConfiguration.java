package by.bsac.webmvc;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import static by.bsac.core.logging.SpringCommonLogging.*;

@Configuration("WebmvcConfiguration")

@EnableWebMvc
public class WebmvcConfiguration implements WebMvcConfigurer {

    //Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(WebmvcConfiguration.class);

    //Constructor
    public WebmvcConfiguration() {
        LOGGER.info(INITIALIZATION.startInitializeConfiguration(WebmvcConfiguration.class));
    }

    /**
     * Thymeleaf {@link org.thymeleaf.templateresolver.ITemplateResolver} implementation. Resolver configured
     * to get html template's from "src/main/resources/html" directory.
     * @return - configured {@link org.thymeleaf.templateresolver.ITemplateResolver} bean.
     */
    @Bean("TemplateResolver")
    @Order(1)
    public ITemplateResolver getClassLoaderTemplateResolver() {

        LOGGER.info(CREATION.startCreateBean(BeanDefinition.of(ClassLoaderTemplateResolver.class)));
        ClassLoaderTemplateResolver tr = new ClassLoaderTemplateResolver();

        tr.setPrefix("html/");
        tr.setSuffix(".html");

        tr.setCacheable(false);
        tr.setCharacterEncoding("UTF-8");
        tr.setTemplateMode(TemplateMode.HTML);

        LOGGER.info(CREATION.endCreateBean(BeanDefinition.of(ClassLoaderTemplateResolver.class)));
        return tr;
    }

    @Bean
    public ViewResolver getViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();

        resolver.setTemplateEngine(this.getSpringTemplateEngine());
        resolver.setOrder(1);

        return resolver;
    }

    @Bean
    public SpringTemplateEngine getSpringTemplateEngine() {

        LOGGER.info(CREATION.startCreateBean(BeanDefinition.of(SpringTemplateEngine.class)));
        SpringTemplateEngine engine = new SpringTemplateEngine();

        engine.setTemplateResolver(this.getClassLoaderTemplateResolver());
        engine.setEnableSpringELCompiler(true);

        LOGGER.info(CREATION.endCreateBean(BeanDefinition.of(SpringTemplateEngine.class)));
        return engine;
    }

    @Bean("jacksonObjectMapper")
    @Primary
    public ObjectMapper getObjectMapper() {

        LOGGER.info(CREATION.startCreateBean(BeanDefinition.of(ObjectMapper.class)));
        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

        LOGGER.info(CREATION.endCreateBean(BeanDefinition.of(ObjectMapper.class)));
        return mapper;

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("libs/**").addResourceLocations("classpath:html/libs/");
        registry.addResourceHandler("styles/**").addResourceLocations("classpath:html/styles/");
        registry.addResourceHandler("img/**").addResourceLocations("classpath:html/img/");
        registry.addResourceHandler("fonts/**").addResourceLocations("classpath:html/fonts/");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
}
