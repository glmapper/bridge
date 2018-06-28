package com.glmapper.bridge.demo.provider.service;

import com.glmapper.bridge.demo.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * description
 *
 * @author: Jerry
 * @date: 2018/6/18
 */
@Service
public class HelloServiceImpl implements HelloService {

    private static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public String sayHello() {
        logger.info("hello.service.impl.be.called");
        return "Hello,consumer";
    }
}
