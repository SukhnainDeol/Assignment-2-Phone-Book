// Programmer: Sukhnain Deol
// Class: CS 145
// Date 01/24/2023
// Assignment: Assignment 2: Phone Book

// Purpose:
// to do:
    // add choice to add entry at specific index

import java.util.*;

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
                    test.newNode(newEntry[0], newEntry[1], newEntry[2], newEntry[3], newEntry[4], Integer.parseInt(newEntry[5])-1);
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
                    System.out.print("\nEnter the First and Last Name to Search: ");
                    String name = in.nextLine(); // takes full name
                    Queue<Integer> nameIndex = test.searchName(name); // searches for name
                    if(nameIndex.size() <= 0) // if name not found (queue is empty)
                        {System.out.println("ERROR: Name not found");}
                    else if(nameIndex.size() == 1)  // if one instance of name found 
                        {System.out.println(name + "'s information is in contact " + (nameIndex.remove()+1));}
                    else // if multuple instances of name found
                    {
                        System.out.println("There are "+nameIndex.size()+" occurences of a person named " + name + " in the phonebook.");
                        System.out.println("These occurences are in the following contact numbers:");
                        int nameIndexSize = nameIndex.size();
                        for(int i = 0; i < nameIndexSize; i++) // print each name from queue
                            {System.out.println("Contact Number " + (nameIndex.remove()+1));}
                    }
                    break;
                case "5":
                case "search address":
                    System.out.print("\nEnter the Address to Search: ");
                    String address = in.nextLine(); // takes inputted address
                    Queue<Integer> addressIndex = test.searchAddress(address); // searches for address(es)
                    if(addressIndex.size() == 0) // if no addresses found
                        {System.out.println("ERROR: Address not found");}
                    else if(addressIndex.size() == 1) // if one instance of address found                           
                        {System.out.println("Address - " + address + "'s information is in contact " + (addressIndex.remove()+1));}
                    else // if multiple instances of address found
                    {
                        System.out.println("There are "+addressIndex.size()+" occurences of the address " + address + " in the phonebook.");
                        System.out.println("These occurences are in the following contact numbers:");
                        int addressIndexSize = addressIndex.size();
                        for(int i = 0; i < addressIndexSize; i++) // print each name from queue
                            {System.out.println("Contact Number " + (addressIndex.remove()+1));}
                    }
                    break;
                case "6":
                case "search phone number":
                    System.out.print("\nEnter the Phone Number to Search: ");
                    String phoneNumber = in.nextLine();
                    Queue<Integer> phoneIndex = test.searchPhoneNumber(phoneNumber); // searches for phone number
                    if(phoneIndex.size() == 0) // if no phone number found
                        {System.out.println("ERROR: Phone Number not found");}
                    else if (phoneIndex.size() == 1 ) // if one instance of phone number found
                        {System.out.println("Phone Number - " + phoneNumber + "'s information is in contact " + (phoneIndex.remove()+1));}
                    else // if multiple instance of phone number found
                    {
                        System.out.println("There are "+phoneIndex.size()+" occurences of the phone number " + phoneNumber + " in the phonebook.");
                        System.out.println("These occurences are in the following contact numbers:");
                        int phoneIndexSize = phoneIndex.size();
                        for(int i = 0; i < phoneIndexSize; i++) // print each name from queue
                            {System.out.println("Contact Number " + (phoneIndex.remove()+1));}
                    }
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
        boolean correctIndex = false;
        String[] newEntry = new String[6]; // array to hold new entry 
        
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
        while(correctIndex == false)
        {
            System.out.print("Contact Number of New Entry: ");
            if(in.hasNextInt())
                {
                    newEntry[5] = in.next();
                    correctIndex = true;
                }
            else
                {System.out.println("ERROR: Please Give A Numerical Input");}
            in.nextLine(); // incase multi word input, clear line for next input
        }
        
        return newEntry;
    } // end of newEntryInput method
} // end of TestClass class



