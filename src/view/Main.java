package view;// -----------------------------------------------------
// Assignment 1
// © Safi Ullah
// Written by: Safi Ullah 40222120
// Explanation: This program lets a store manage computer inventory and uses authentication for critical features
// -----------------------------------------------------

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.*;

public class Main {

//    static final String PASSWORD = "password";
//    static final int PASS_MAX_TRIES = 3;
    static final Scanner sc = new Scanner(System.in);
//    static int maxInventory;

//    public static boolean login(){
//        boolean validStatus=false;
//        int tries = 0;
//        System.out.print("Please enter the password > ");
//        while(validStatus==false && tries<PASS_MAX_TRIES){
//            if(tries!=0)  {System.out.print("Login Failed - Please enter the valid password > ");}
//            String userPass = sc.nextLine();
//            if (PASSWORD.equals(userPass)) {  //todo handle null exception
//                validStatus = true;
//            }
//            tries+=1;
//        }
//        return validStatus;
//    }
    public static int integerInput(String message){
        boolean valid = false;
        int inputInteger = 0;
        while(valid==false){
            System.out.print(message);
            String input = sc.nextLine();
            try {
                inputInteger = Integer.parseInt(input);
                valid=true;
            }catch (NumberFormatException e){
                System.out.println("ERROR! - Only integer input is allowed.");
            }
        }
        return inputInteger;
    }
    public static double doubleInput(String message){
        boolean valid = false;
        double inputInteger = 0;
        while(valid==false){
            System.out.print(message);
            String input = sc.nextLine();
            try {
                inputInteger = Double.parseDouble(input);
                valid=true;
            }catch (NumberFormatException e){
                System.out.println("ERROR! - Only integer input is allowed.");
            }
        }
        return inputInteger;
    }
    public static long longInput(String message){
        boolean valid = false;
        long inputInteger = 0;
        while(valid==false){
            System.out.print(message);
            String input = sc.nextLine();
            try {
                inputInteger = Long.parseLong(input);
                valid=true;
            }catch (NumberFormatException e){
                System.out.println("ERROR! - Only integer input is allowed.");
            }
        }
        return inputInteger;
    }

    public static int MenuDisplay(String str[], int lowerBound,int upperBound){

        while(true){
            for(int i=0;i< str.length;i++){
                System.out.println(i+1+". "+str[i]);
            }
            System.out.print("Please enter your choice >");
            String input = sc.nextLine();
            try {
                int inputInteger= Integer.parseInt(input);
                if(inputInteger>=lowerBound && inputInteger<=upperBound){
                    return inputInteger;
                }
                throw new MainMenuInputException();
            }
            catch(MainMenuInputException e){
                System.out.println(e.getMessage());
            }catch(InputMismatchException e){
                System.out.println("You didn't enter an integer");
            }catch (NumberFormatException e){
                System.out.println("Only integer input is allowed.");
            }
        }
    }


//    public static void option1(){
//        boolean validLogin = login();
//        int userComps=0;
//        if(validLogin){
//            boolean valid=false;
//            userComps= integerInput("How many computers you want to enter > ");
//            while(valid ==false){
//                if (userComps+Computer.objectsCounts< maxInventory){
//                    valid=true;
//                } else{
//                    userComps= integerInput("Inventory limit exceeded! - Max number of computers can only be = "+ (maxInventory - Computer.objectsCounts)+". Please enter again > ");
//                }
//            }
//            for(int i=0; i<userComps;i++){
//                addComputer();
//            }
//        }
//    }
//    public static void option2(){
//        boolean validLogin = login();
//        int selectedComputer=0;
//        boolean mainMenu= false;
//        if(validLogin){
//            boolean valid=false;
//            while(valid == false){
//                selectedComputer= integerInput("Which computer do you want to edit > ");
//                if (selectedComputer>=0 && selectedComputer< Computer.objectsCounts){
//                    valid=true;
//                } else {
//                    char tempInput;
//                    do {
//                        System.out.print("Inventory limit exceeded! - This computer doesn't exist in our database. Computer Number starts from 0-" +Computer.objectsCounts+ ". Do you wish to try again? (y/n) > ");
//                        tempInput = sc.next().charAt(0);
//                        sc.nextLine();
//                        if(tempInput == 'n'){
//                            mainMenu = true;
//                            valid=true;
//                            break;
//                        }
//                    } while (tempInput !='y');
//                }
//            }
//            if(mainMenu){
//                mainMenuDisplay();
//                return;
//            }
//            valid=false;
//            do{
//                System.out.println("Computer Information Found!");
//                System.out.println("Computer#"+selectedComputer);
//                System.out.println("Brand: "+inventory[selectedComputer].getBrand());
//                System.out.println("Model: "+inventory[selectedComputer].getModel());
//                System.out.println("SN: "+inventory[selectedComputer].getSN());
//                System.out.println("Price: "+inventory[selectedComputer].getPrice());
//                int option = option2Menu();
//                option2Edit(option, selectedComputer);
//                if(option==5) {
//                    valid = true;
//                }
//            }while(!valid);
//        }
//    }

//    public static int option2Menu() {
//        int lowerBound = 1;
//        int upperBound = 5;
//
//        while(true){
//            System.out.println("What information would you like to change?");
//            System.out.println("1.Brand ");
//            System.out.println("2. Model ");
//            System.out.println("3. SN ");
//            System.out.println("4. price ");
//            System.out.println("5. Quit");
//            System.out.print("Please enter your choice >");
//            String input = sc.nextLine();
//            try {
//                int inputInteger= Integer.parseInt(input);
//                if(inputInteger>=lowerBound && inputInteger<=upperBound){
//                    return inputInteger;
//                }
//                throw new MainMenuInputException();
//            }
//            catch(MainMenuInputException e){
//                System.out.println(e.getMessage());
//            }catch(InputMismatchException e){
//                System.out.println("You didn't enter an integer");
//            }catch (NumberFormatException e){
//                System.out.println("Only integer input is allowed.");
//            }
//        }
//    }
//
//    public static void option2Edit(int option, int index) {
//        switch(option){
//            case 1:
//                System.out.println("Enter the new brand information > ");
//                String brand = sc.nextLine();
//                inventory[index].setBrand(brand);
//                break;
//            case 2:
//                System.out.println("Enter the new model information > ");
//                String model = sc.nextLine();
//                inventory[index].setModel(model);
//                break;
//            case 3:
//                long SN = longInput("Enter the new SN information >");
//                inventory[index].setSN(SN);
//                break;
//            case 4:
//                double price = doubleInput("Enter the new price information >");
//                inventory[index].setPrice(price);
//                break;
//            default:
//                System.out.println("Thanks for using the system.");
//                break;
//        }
//    }
//
//    public static void addComputer(){
//        String brand;
//        String model;
//        long SN;
//        double price;
//
//        System.out.println("Add Computer");
//        System.out.print("Enter computer brand: ");
//        brand=sc.nextLine();
//        System.out.print("Enter computer model: ");
//        model=sc.nextLine();
//        SN= longInput("Enter the computer SN: ");
//        price= doubleInput("Enter the computer price: ");
//        Computer c = new Computer(brand,model, SN, price);
//        int index = Computer.findNumberOfCreatedComputers()-1;
//        inventory[index]= c;
//        System.out.println("Computer # "+index+"created.");
//        System.out.println("Success! Computer added.");
//    }
//
//    public static void findComputersBy(String name) {
//        for(int i=0;i<Computer.objectsCounts;i++){
//            if(inventory[i].getBrand().equals(name)){
//                System.out.println("Computer#"+i);
//                System.out.println("Brand: "+inventory[i].getBrand());
//                System.out.println("Model: "+inventory[i].getModel());
//                System.out.println("SN: "+inventory[i].getSN());
//                System.out.println("Price: "+inventory[i].getPrice());
//            }
//        }
//    }
//
//    public static void findCheaperThan(double price) {
//        for(int i=0;i<Computer.objectsCounts;i++){
//            if(inventory[i].getPrice() < price) {
//                System.out.println("Computer#"+i);
//                System.out.println("Brand: "+inventory[i].getBrand());
//                System.out.println("Model: "+inventory[i].getModel());
//                System.out.println("SN: "+inventory[i].getSN());
//                System.out.println("Price: "+inventory[i].getPrice());
//            }
//        }
//    }




    //Add property
    //    public static void addComputer(){
//        String brand;
//        String model;
//        long SN;
//        double price;
//
//        System.out.println("Add Computer");
//        System.out.print("Enter computer brand: ");
//        brand=sc.nextLine();
//        System.out.print("Enter computer model: ");
//        model=sc.nextLine();
//        SN= longInput("Enter the computer SN: ");
//        price= doubleInput("Enter the computer price: ");
//        Computer c = new Computer(brand,model, SN, price);
//        int index = Computer.findNumberOfCreatedComputers()-1;
//        inventory[index]= c;
//        System.out.println("Computer # "+index+"created.");
//        System.out.println("Success! Computer added.");
//    }


    public static void addAppartment(){
        int id;
        String streetName;
        String city;
        String postalCode;
        int numOfBedrooms;
        int numOfBathrooms;
        float squareFoot;

        System.out.println("Add Appartment");
        System.out.print("Enter Street Name: ");
        streetName=sc.nextLine();
        System.out.print("Enter city: ");
        city=sc.nextLine();
        System.out.print("Enter postalCode: ");
        postalCode=sc.nextLine();
        numOfBedrooms= integerInput("Enter number of bedrooms: ");
        numOfBathrooms= integerInput("Enter number of bathrooms: ");
        squareFoot= integerInput("Enter number of square foot: ");

        PropertyModel appartment = new Appartment();




        Computer c = new Computer(brand,model, SN, price);
        int index = Computer.findNumberOfCreatedComputers()-1;
        inventory[index]= c;
        System.out.println("Computer # "+index+"created.");
        System.out.println("Success! Computer added.");



    }

    public static void addPropertyOption(){
        String[] options = { "Add an Apartment","Add a Condo" ,"Add a House", "Quit"};
        int input =0;
        do{
            input = MenuDisplay(options, 1, options.length+1);
            switch(input){
                case 1:
                    System.out.println("Option-"+input+" Selected");
                    addAppartment();
                    break;
                case 2:
                    System.out.println("Option-"+input+" Selected");
//                    option2();
                    break;
                case 3:
                    System.out.println("Option-"+input+" Selected");
                    System.out.print("Please enter the name of the brand you want to search > ");
                    String brand = sc.nextLine();
//                    findComputersBy(brand);
                    break;
                case 4:
                    System.out.println("Option-"+input+" Selected");
                    double price = doubleInput("Please enter the price to filter computers having price less than that > ");
//                    findCheaperThan(price);
                    break;
                case 5:
                    System.out.println("Thankyou for using the system. Goodbye!");
                    break;
            }
        } while (input!=options.length+1);
    }


    public static void main(String[] args) {
        System.out.println("Welcome to SPMS!");
        String[] options = {"Add a property","Add a tenant","Add a interested tenant","Rent a unit","Display properties","Display tenants","Display rented units","Display vacant units","Display all leases","Quit"};
        int input =0;
        do{
            input = MenuDisplay(options, 1, options.length+1);
            switch(input){
                case 1:
                    System.out.println("Option-"+input+" Selected");
//                    option1();
                    break;
                case 2:
                    System.out.println("Option-"+input+" Selected");
//                    option2();
                    break;
                case 3:
                    System.out.println("Option-"+input+" Selected");
                    System.out.print("Please enter the name of the brand you want to search > ");
                    String brand = sc.nextLine();
//                    findComputersBy(brand);
                    break;
                case 4:
                    System.out.println("Option-"+input+" Selected");
                    double price = doubleInput("Please enter the price to filter computers having price less than that > ");
//                    findCheaperThan(price);
                    break;
                case 5:
                    System.out.println("Thankyou for using the system. Goodbye!");
                    break;
            }
        } while (input!=options.length+1);
    }
}
