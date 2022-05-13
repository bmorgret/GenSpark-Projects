package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String path = "src/main/resources/springdi.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext("springdi.xml");

        Student student = (Student) context.getBean("student");
        System.out.println(student);
    }

}
