package edu.mum;

import edu.mum.component.FileDisplay;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class FileMessageDisplayRedesigned {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext( JavaConfiguration.class );

        FileDisplay messageDisplay = (FileDisplay) applicationContext.getBean("fileMessageDisplay");
        try {
            messageDisplay.display();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
