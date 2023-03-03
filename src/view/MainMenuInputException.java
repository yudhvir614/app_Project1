package view;

// -----------------------------------------------------
// Assignment 1
// © Safi Ullah
// Written by: Safi Ullah 40222120
// Explanation: This program lets a store manage computer inventory and uses authentication for critical features
// -----------------------------------------------------
public class MainMenuInputException extends Exception{
    MainMenuInputException(){
        super("Please enter numbers in Range 1-10");
    }
}
