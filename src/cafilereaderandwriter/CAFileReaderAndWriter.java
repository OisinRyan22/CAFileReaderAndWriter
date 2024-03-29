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
import java.util.Scanner;

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
    //Input FilePath("C:\\Users\\ocean\\OneDrive\\Documents\\NetBeansProjects\\CAFileReaderAndWriter\\students.txt")
    //Output FilePath ("status.txt")
    public static void main(String[] args) throws IOException {

        //Cancelled out console attempt in main method. got too confusing.
//        try (Scanner sc = new Scanner(System.in)) {
//            System.out.println("Console Menu:");
//            System.out.println("Option 1: Validate student.txt file data.");
//            System.out.println("Option 2: Input data using console to status.txt file.");
//            System.out.println("Please choose an option by only entering the number 1 or 2: ");
//            int option = sc.nextInt();
//            sc.nextLine();
//            switch (option) {
//                case 1:
//                    firstOption();
//                    break;
//                case 2:
//                    consoleMenu(sc);
//                    break;
//                default:
//                    System.out.println("Invalid number choosen. Please choose 1 or 2.");

//            }
//    }
//    private static void firstOption() throws IOException {


        try ( BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ocean\\OneDrive\\Documents\\NetBeansProjects\\CAFileReaderAndWriter\\students.txt"))) {

            String line;
            while ((line = br.readLine()) != null) {
                String firstName = line.trim();
                String numofClasses = br.readLine().trim();
                String studentNum = br.readLine().trim();

                String[] names = firstName.split(" ", 2);           //Splits first and second name on first line 
                firstName = names[0];
                String secondName = (names.length > 1) ? names[1] : "";

                String invalid = validateData(firstName, secondName, numofClasses, studentNum);      //Validates data

                if (invalid != null) {
                    System.out.println("Data is invalid for " + firstName + " " + secondName + ":");
                    System.out.println(invalid);
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
            return " Error, student number format must have at least 6 characters starting with 20 - 24, then contain at 2 or 3 letters and end between 0-200";     //Validates the student number
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

        try ( BufferedWriter bw = new BufferedWriter(new FileWriter("status.txt", true))) {                      //File writer import and file name 
            bw.write(studentNum + " - " + (secondName != null ? secondName : "") + "\n" + workload + "\n\n");
        } catch (IOException e) {
            System.err.println("Error! Failed to write to status.txt file.");     // Error message to appear if writing to file fails 
        }
        return null;  //If there is no error 
    }

    public static boolean validName1(String name1) {
        return name1.matches("[a-zA-z]+");                      //First name is valid if only letter 
    }

    public static boolean validName2(String name2) {            //Second name is valid if letters and/or numbers 
        return name2.matches("[a-zA-Z0-9]+");
    }

    public static boolean validClasses(String numofClasses) {       //Number of class is valid if between the numbers 1 to 8
        try {
            int classes = Integer.parseInt(numofClasses);
            return classes >= 1 && classes <= 8;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean validstudentNum(String studentNum) {
        return studentNum.matches("(20|21|22|23|24)[A-Za-z]{3}(0|[1-9][0-9]?|1[0-9]{2}|200)");   //Student number is valid if it starts between 20 to 24, then up to 3 letters and end between the number 0 to 200
    }

//    public static void consoleMenu(String[] args) {
//        try (Scanner sc = new Scanner(System.in)) {
//            System.out.println("Console Menu:");
//            System.out.println("Option 1: Validate student.txt file data.");
//            System.out.println("Option 2: Input data using console to status.txt file.");
//            System.out.println("Please choose an option by only entering the number 1 or 2: ");
//            int option = sc.nextInt();
//            sc.nextLine();
    //Trying to get console to work.
    //Moving console to main method and working down.
//    private static void consoleMenu(Scanner sc) {
//        System.out.print("Please enter a first and second name: ");
//        String firstName = sc.nextLine();
//        
//        System.out.print("Please enter the number of classes: ");
//        String numofClasses = sc.nextLine();
//        
//        System.out.print("Please enter a student number: ");
//        String studentNum = sc.nextLine();
//        
//         String[] names = firstName.split(" ", 2);           //Splits first and second name on first line 
//                firstName = names[0];
//                String secondName = (names.length > 1) ? names[1] : "";
//                
//                String invalid = validateData(firstName, secondName, numofClasses, studentNum);
//                
//                if (invalid == null) {
//                    System.out.print("Data is valid. Writing to status.txt");
    
                //Tried making a console menu but got confused and the code got too messy for me.
    
    
}


