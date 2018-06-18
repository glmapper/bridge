package com.glmapper.bridge.demo.provider;

import com.glmapper.bridge.demo.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.util.Arrays;

/**
 * description
 *
 * @email: <a href="sunzhenyu@terminus.io">孙振宇</a>
 * @author: ginkgo
 * @date: 2018/6/18
 */
@SpringBootApplication
public class ProviderBootstrap {

    private static final Logger logger = LoggerFactory.getLogger(ProviderBootstrap.class);

    @Autowired
    private HelloService helloService;

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ProviderBootstrap.class, args);
        logger.info("bootstrap.complete");
        String[] names = applicationContext.getBeanDefinitionNames();
        logger.info("application.context.contain.such.bean:{}", Arrays.toString(names));
        ProviderBootstrap bootstrap = applicationContext.getBean(ProviderBootstrap.class);
        bootstrap.sayHello();
        System.in.read();
    }

    public void sayHello() {
        String s = helloService.sayHello();
        logger.info(s);
    }
}
