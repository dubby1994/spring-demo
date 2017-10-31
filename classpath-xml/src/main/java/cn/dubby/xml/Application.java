package cn.dubby.xml;

import cn.dubby.hello.service.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by teeyoung on 17/10/31.
 */
public class Application {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:app.xml");

        HelloService helloService1 = (HelloService) context.getBean("helloServiceName");
        HelloService helloService2 = (HelloService) context.getBean("helloServiceID");

        System.out.println(helloService1 == helloService2);

        System.out.println(helloService1.hello());
        System.out.println(helloService2.hello());
    }

}
