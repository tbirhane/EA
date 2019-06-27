package edu.mum.component.impl;

import java.io.*;


import edu.mum.component.FileDisplay;
import org.springframework.beans.factory.annotation.Autowired;
import edu.mum.component.MessageOrigin;
import org.springframework.stereotype.Component;

/*
 * Need to declare class...  
 */
@Component
	 public class FileMessageDisplay implements FileDisplay {

	 	@Autowired
		MessageOrigin messageOrigin;

    public void display() {
        if (messageOrigin == null) {
            throw new RuntimeException(
                "You must set the property messageSource of class:"
                + FileMessageDisplay.class.getName());
        }

        System.out.println(messageOrigin.getMessage());
        
         writeMessageToFile(messageOrigin.getMessage());
    }

    
    public MessageOrigin getMessageSource() {
        return this.messageOrigin;
    }
    
    private void writeMessageToFile(String message) {
    	String fileName = "test.txt";
        System.out.println("Function called!");
    	String path = this.getClass().getClassLoader().getResource(".").getFile();

    	//create file

            File file = null;


    	
    	try {
             file = new File(path+fileName);
			if (file.createNewFile()) {
			    System.out.println("File is created!");

			} else {
			    System.out.println("File already exists.");
			}
		} catch (IOException e) {
            System.out.println("Not working");
			e.printStackTrace();
		}
    	
    	FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(message);
			bufferedWriter.close();
		    System.out.println("Message written to File in target/classes " + fileName);
		} catch (IOException e) {

			e.printStackTrace();
		}
 
    	return  ;
    }
}
