/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cafilereaderandwriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ocean
 */
public class CAFileReaderAndWriter {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    //https://github.com/OisinRyan22/CAFileReaderAndWriter
    //Input FilePath("C:\\Users\\ocean\\OneDrive\\Documents\\NetBeansProjects\\students.txt")
    //Output FilePath ("status.txt")
    public static void main(String[] args) throws IOException {
        try ( BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ocean\\OneDrive\\Documents\\NetBeansProjects\\students.txt"))) {

            String line;
            while ((line = br.readLine()) != null) {
                String firstName = line.trim();
                String numofClasses = br.readLine().trim();
                String studentNum = br.readLine().trim();

                String[] names = firstName.split(" ", 2);           //Splits first and second name on first line 
                firstName = names[0];
                String secondName = (names.length > 1) ? names[1] : "";

                String error = validateData(firstName, secondName, numofClasses, studentNum);      //Validates data

                if (error != null) {
                    System.out.println("Data is invalid for" + firstName + " " + secondName + ":");
                    System.out.println(error);
                    //If validation fails, this output and error message        
                }

            }
        }
    }

    private static String validateData(String firstName, String secondName, String numofClasses, String studentNum) {

        if (!validName1(firstName)) {
            return "Error in first name! Must contain letters only!";       //Validates the first name 
        }
        if (!validName2(secondName)) {
            return "Error in second name! Must contain letters and/or numbers only!";   //Validates the second name 
        }
        if (!validClasses(numofClasses)) {
            return "Error in number of classes entered! Must be between 1 and 8!";     //Validates the number of classes
        }
        if (!validstudentNum(studentNum)) {
            return " Error, invalid student number! Formet 00AAA000....";     //Validates the student number
        }

        //Code to get the workload output based off number of classes in the input file
        String workload;
        int numofclassesInt = Integer.parseInt(numofClasses);
        if (numofclassesInt == 1) {                     //If 1 class
            workload = "Very Light";
        } else if (numofclassesInt == 2) {              //If 2 classes
            workload = "Light";
        } else if (numofclassesInt >= 3 && numofclassesInt <= 5) {          //If 3 to 5 Classes
            workload = "Part-Time";
        } else {                        //If 6 to 8 Classes
            workload = "Full-Time";
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("status.txt", true))) {
            bw.write(studentNum + " - " + (secondName != null ? secondName : "") + "\n" + workload + "\n\n");
        } catch (IOException e) {
            System.err.println("Error! Failed to write to status.txt file.");
        }
        return null;  //If no error 
    }

    public static boolean validName1(String name1) {
        return name1.matches("[a-zA-z]+");
    }

    public static boolean validName2(String name2) {
        return name2.matches("[a-zA-Z1-9]+");
    }

    public static boolean validClasses(String numofClasses) {
        try {
            int classes = Integer.parseInt(numofClasses);
            return classes >= 1 && classes <= 8;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean validstudentNum(String studentNum) {
        return studentNum.matches("2[1-9]\\d[A-Za-z]{2,}\\d+");
    }

}
