package com.aprzecho;

import java.util.Arrays;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.swagger.Swagger2Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aprzecho.controller.UserController;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@Configuration
public class CxfConfig {

    @Autowired
    private Bus bus;
    
    @Autowired
    private UserController userController;

    @Bean
    public Server rsServer() {
        final JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
        endpoint.setProvider(new JacksonJsonProvider());
        endpoint.setBus(bus);
        endpoint.setAddress("/");
        endpoint.setServiceBeans(Arrays.<Object>asList(userController));
        endpoint.setFeatures(Arrays.asList(new Swagger2Feature()));
        return endpoint.create();
    }

//    @Bean
//    public UserController userController() {
//        return new UserController();
//    }

    //	 The default address of CXF RESTfull API is /services to change the API
    // sub-directory from /services with /api or anything that you like
//    @Bean
//    public ServletRegistrationBean cxfServlet() {
//        final ServletRegistrationBean servletRegistrationBean =
//                new ServletRegistrationBean(new CXFServlet(), "/api/*");
//        servletRegistrationBean.setLoadOnStartup(1);
//        return servletRegistrationBean;
//    }
}
