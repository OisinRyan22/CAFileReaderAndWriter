/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cafilereaderandwriter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author ocean
 */
public class CAFileReaderAndWriter {

    /**
     * @param args the command line arguments
     */
    //https://github.com/OisinRyan22/CAFileReaderAndWriter
    //Input FilePath("C:\\Users\\ocean\\OneDrive\\Documents\\NetBeansProjects\\students.txt")
    //Output FilePath ("status.txt")
    
    public static void main(String[] args) throws IOException {
        try
            (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ocean\\OneDrive\\Documents\\NetBeansProjects\\students.txt"))) {
           
            String line; 
            while ((line = br.readLine()) != null) {
                String firstName = line.trim();
                String numofClasses = br.readLine().trim();
                String studentNum = br.readLine().trim();
                
                String[] names = firstName.split(" ", 2);           //Splits first and second name on first line 
                firstName = names[0];
                String secondName = (names.length > 1) ? names[1] : "";
                
                String error = validateData (firstName, secondName, numofClasses, studentNum);      //Validates data
                
                if (error != null) {
                System.out.println("Data is invalid for" + firstName + " " + secondName + ":");      
                System.out.println(error);
                //If validation fails, this output and error message        
            }
          
            
    }
    } 
}

    private static String validateData(String firstName, String secondName, String numofClasses, String studentNum) {
     
    }
