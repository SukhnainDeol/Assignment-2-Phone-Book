// Programmer: Sukhnain Deol
// Class: CS 145
// Date 01/24/2023
// Assignment: Assignment 2: Phone Book

// Purpose:
// to do:
    // add choice to add entry at specific index

import java.util.Scanner;

class TestClass
{
    public static void main(String[] args)
    {
        PhonebookManager test = new PhonebookManager();

        Scanner in = new Scanner(System.in);
        boolean inUse = true;

        while(inUse)
        {
            printMenu();
            String command = in.nextLine();
            
            switch(command.toLowerCase())
            {
                case "1":
                case "add entry":
                    // turn into method
                    String[] newEntry = newEntryInput(in);
                    test.newNode(newEntry[0], newEntry[1], newEntry[2], newEntry[3], newEntry[4]);
                    System.out.println("\nNew Entry Added");
                    break;
                case "2":
                case "delete entry":
                    if (test.size() == 0)
                        {System.out.println("\nERROR: Phonebook is Empty");}
                    else
                    {
                        System.out.print("\nEnter Contact Number: ");
                        int deleteIndex;
                        if(in.hasNextInt())
                        { // deletes deletetIndex value from phonebook
                            deleteIndex = in.nextInt();
                            test.delete(deleteIndex-1);
                        }
                        else
                            {System.out.println("ERROR: Input is not a Number");}
                    }
                    break;
                case "3":
                case "view phonebook":
                    if(test.size() == 0) // check if anything in phonebook
                        {System.out.println("\nPhonebook is Empty");}
                    else
                        {System.out.println("\n" + test);} // print phonebook
                    break;
                case "4":
                case "search name":
                    System.out.print("\nEnter First and Last Name to Search: ");
                    String name = in.nextLine(); // takes full name
                    int nameIndex = test.searchName(name); // searches for name
                    if(nameIndex == -1) // -1 means not found
                        {System.out.println("ERROR: Name not found");}
                    else // else, returns contact number of name
                        {System.out.println(name + "'s information is in contact " + nameIndex+1);}
                    break;
                case "5":
                case "search address":
                    System.out.print("\nEnter Address to Search: ");
                    String address = in.nextLine(); 
                    int addressIndex = test.searchAddress(address); // searches for address
                    if(addressIndex == -1) // -1 means not found
                        {System.out.println("ERROR: Address not found");}
                    else // else, returns contact number of address
                        {System.out.println("Address - " + address + "'s information is in contact " + (addressIndex+1));}
                    break;
                case "6":
                case "search phone number":
                    System.out.print("\nEnter Phone Number to Search: ");
                    String phoneNumber = in.nextLine();
                    int phoneIndex = test.searchPhoneNumber(phoneNumber); // searches for phone number
                    if(phoneIndex == -1) // -1 means not found
                        {System.out.println("ERROR: Phone Number not found");}
                    else // else, returns contact number of phone number
                        {System.out.println("Phone Number - " + phoneNumber + "'s information is in contact " + (phoneIndex+1));}
                    break;
                case "7":
                case "edit first name":
                        // make sure
                    System.out.println("Which contact number's name would you like to edit?: ");
                    if (in.hasNextInt())
                    {
                        int editNameIndex = in.nextInt();
                        System.out.println("Enter new first name: ");
                        String newName = in.nextLine();
                        test.modifyFirstName(editNameIndex, newName);
                        System.out.println("Enter new last name: ");
                        String newLastName = in.nextLine();
                        test.modifyLastName(editNameIndex, newLastName);
                    }
                    break;
                case "8":
                case "edit address":
                    System.out.println("Which contact number's address would you like to edit?: ");
                    if(in.hasNextInt())
                    {
                        int editAddressIndex = in.nextInt();
                        System.out.println("Enter new address: ");
                        String newAddress = in.nextLine();
                        test.modifyAddress(editAddressIndex, newAddress);
                    }
                    else
                        {System.out.println("ERROR: Input is not a Number");}
                    break;
                case "9":
                case "edit phone number":
                    System.out.println("Which contact number's phone number would you like to edit?: ");
                    if(in.hasNextInt())
                    {
                        int editPhoneIndex = in.nextInt();
                        System.out.println("Enter new phone number: ");
                        String newPhoneNumber = in.nextLine();
                        test.modifyPhoneNumber(editPhoneIndex, newPhoneNumber);
                    }
                    else
                        {System.out.println("ERROR: Input is not a Number");}
                    break;
                case "0":
                case "quit":
                    inUse = false;
                    break;
                default:
                    System.out.println("\nERROR: Incorrect Input\n");
            } // end of switch/case

            System.out.println("\nPress enter to continue");
            in.nextLine(); // makes it easier to view output before next command
            System.out.println("\n\n");
        } // end of program while loop
    } // end of main method



    public static void printMenu()
    {
        System.out.println("Please choose one of the following menu options:");
        System.out.println("1 - Add Entry");
        System.out.println("2 - Delete Entry");
        System.out.println("3 - View Phonebook");
        System.out.println("4 - Search Name ");
        System.out.println("5 - Search Address ");
        System.out.println("6 - Search Phone Number");
        System.out.println("7 - Edit Name");
        System.out.println("8 - Edit Address");
        System.out.println("9 - Edit Phone Number");
        System.out.println("0 - Quit");
        System.out.print("\nCommand: ");
    } // end of printMenu method


    public static String[] newEntryInput(Scanner in) 
    {
        String[] newEntry = new String[5]; // array to hold new entry info
        // get all info for new entry then use newNode method
        System.out.print("\nEnter First Name: ");
        newEntry[0] = in.next();
        in.nextLine(); // incase multi word input, clear line for next input
        System.out.print("Enter Last Name: ");
        newEntry[1] = in.next();
        in.nextLine(); // incase multi word input, clear line for next input
        System.out.print("Enter Address: ");
        newEntry[2] = in.next();
        System.out.print("Enter City: ");
        newEntry[3] = in.next();
        System.out.print("Enter Phone Number: ");
        newEntry[4] = in.next();

        return newEntry;
    } // end of newEntryInput method
} // end of TestClass class



