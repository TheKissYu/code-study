package yuhaoze.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import yuhaoze.bean.People;


public class SpringTest {
    public static void main(String[] args) {
        createBean2();
    }


    public static void createBean1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("app.xml");
        People people = (People) context.getBean("people");
        people.sayHello();
    }
    public static void createBean2(){
        BeanDefinition beanDefinition = new GenericBeanDefinition();
        
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("app.xml"));
        People people = (People) beanFactory.getBean("people");
        people.sayHello();
    }
}
