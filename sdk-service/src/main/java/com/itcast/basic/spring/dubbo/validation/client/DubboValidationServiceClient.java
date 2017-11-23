package com.itcast.basic.spring.dubbo.validation.client;

import com.alibaba.dubbo.rpc.RpcException;
import com.itcast.basic.spring.dubbo.validation.model.ValidationParameter;
import com.itcast.basic.spring.dubbo.validation.service.ValidationService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.Date;
import java.util.Set;

/**
 * Created by treey.qian on 2017/11/22.
 */
public class DubboValidationServiceClient {
    public static void main(String[] args) {
        try {
            System.out.println("enter into DubboValidationServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/validation/client/application.xml"});
            ValidationService validationService = (ValidationService) applicationContext.getBean("validationService");
            ValidationParameter validationParameter = new ValidationParameter();
            validationParameter.setId(1);
            validationParameter.setEmail("1258166167@qq.com");
            validationParameter.setName("lily");
            validationParameter.setLoginDate(new Date(System.currentTimeMillis() - 1000));
            validationParameter.setExpiryDate(new Date(System.currentTimeMillis() + 1000));
            validationService.save(validationParameter);
        } catch (RpcException e) {
            System.out.println(e.getCause() instanceof ValidationException);
            ConstraintViolationException ve = (ConstraintViolationException) e.getCause(); // ⾥⾯嵌了⼀个ConstraintViolationException

            Set<ConstraintViolation<?>> violations = ve.getConstraintViolations(); // 可以拿到⼀个验证错误详细信息的集合
            System.out.println("violations size is " + violations.size());
            StringBuilder message = new StringBuilder();
            for (ConstraintViolation constraintViolation : violations) {
                message.append(constraintViolation.getMessage()).append(" ");
            }
            System.out.println("message is " + message.toString());
        } catch (Exception e) {
            System.out.println("DubboValidationServiceClient error is " + e);
        }
    }
}
