// Programmer: Sukhnain Deol
// Class: CS 145
// Date 01/24/2023
// Assignment: Assignment 2: Phone Book

// Purpose: Create an interface for users to access, find, manipulate, 
// add and remove data from a phonebook

// test delete 
// test default on editNode

import java.util.*;

class TestClass
{
    public static void main(String[] args)
    {
        // creates test phonebookmanager object to showcase  
        PhonebookManager test = new PhonebookManager();

        Scanner in = new Scanner(System.in); // takes in user input
        boolean inUse = true; // used to loop program until user quits

        while(inUse) // loops until 'quit' (or '0') is inputted by user
        {
            printMenu(); // prints command options to user
            String command = in.nextLine(); // takes in users command
            
            // if phonebook empty, ask user to create a new entry before doing anything else
            if(test.size() == 0 && !(command.equals("1") || command.toLowerCase().equals("add entry")))
            {   // if quitting, break out of if statement (proceeds to switch/case)
                if(command.equals("0") || command.toLowerCase().equals("quit"))
                    {break;}
                System.out.println("\nPhonebook is empty, please create a a new entry first");
                System.out.println("\nPress enter to contiue");
                in.nextLine(); // waits for user to press enter 
                System.out.println("\n"); // spacing to seperate previous input and menu
                continue; // repeats whole loop from beginning
            }
            
            // main part of the interface 
            switch(command.toLowerCase())
            {
                case "1":
                case "add entry":
                    // asks user for inputs and which are returned in an array
                    String[] newEntry = newEntryInput(in, test.size());
                    // adds user inputs into a new entry in phonebook manager
                    test.add(newEntry[0], newEntry[1], newEntry[2], newEntry[3], newEntry[4], Integer.parseInt(newEntry[5])-1);
                    break;
                case "2":
                case "delete entry":
                    System.out.print("\nEnter Contact Number to Delete: ");
                    int deleteIndex; // index (starting from 1) of entry to delete
                    if(in.hasNextInt()) // if int is inputted
                    {   // deletes entry at deletetIndex value from phonebook
                        deleteIndex = in.nextInt();
                        test.delete(deleteIndex-1); // -1 because method starts with 0
                    }
                    else // prints error message
                        {System.out.println("ERROR: Input is not a Whole Number");}
                    break;
                case "3":
                case "view phonebook":
                    System.out.println("\n" + test); // prints phonebook 
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
                        {System.out.println("The person with the address" + address + " has their information in contact " + (addressIndex.remove()+1));}
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
                case "search city":
                    System.out.print("\nEnter the City to Search: ");
                    String city = in.nextLine();
                    Queue<Integer> cityIndex = test.searchCity(city); // searches for phone number
                    if(cityIndex.size() == 0) // if no phone number found
                        {System.out.println("ERROR: City not found");}
                    else if (cityIndex.size() == 1 ) // if one instance of phone number found
                        {System.out.println("The person in the city " + city + " has their information in contact " + (cityIndex.remove()+1));}
                    else // if multiple instance of phone number found
                    {
                        System.out.println("There are "+cityIndex.size()+" occurences of the city " + city + " in the phonebook.");
                        System.out.println("These occurences are in the following contact numbers:");
                        int cityIndexSize = cityIndex.size();
                        for(int i = 0; i < cityIndexSize; i++) // print each name from queue
                            {System.out.println("Contact Number " + (cityIndex.remove()+1));}
                    }
                    break;
                case "7":
                case "search phone number":
                    System.out.print("\nEnter the Phone Number to Search: ");
                    String phoneNumber = in.nextLine();
                    Queue<Integer> phoneIndex = test.searchPhoneNumber(phoneNumber); // searches for phone number
                    if(phoneIndex.size() == 0) // if no phone number found
                        {System.out.println("ERROR: Phone Number not found");}
                    else if (phoneIndex.size() == 1 ) // if one instance of phone number found
                        {System.out.println("The person with the phone number " + phoneNumber + " has their information in contact " + (phoneIndex.remove()+1));}
                    else // if multiple instance of phone number found
                    {
                        System.out.println("There are "+phoneIndex.size()+" occurences of the phone number " + phoneNumber + " in the phonebook.");
                        System.out.println("These occurences are in the following contact numbers:");
                        int phoneIndexSize = phoneIndex.size();
                        for(int i = 0; i < phoneIndexSize; i++) // print each name from queue
                            {System.out.println("Contact Number " + (phoneIndex.remove()+1));}
                    }
                    break;
                case "8":
                case "edit name":
                    // asks which contact number's data to edit and what the new value is
                    editNode(in, "name", test); 
                    break;
                case "9":
                case "edit address":
                    // asks which contact number's data to edit and what the new value is
                    editNode(in, "address", test);
                    break;
                case "10":
                case "edit city":
                    // asks which contact number's data to edit and what the new value is
                    editNode(in, "city", test);
                    break;
                case "11":
                case "edit phone number":
                    // asks which contact number's data to edit and what the new value is
                    editNode(in, "phone number", test);
                    break;
                case "0":
                case "quit":
                    inUse = false; // ends while loop
                    continue; // continue instead of break in order to instantly end loop
                default: // default to sending general error message
                    System.out.println("\nERROR: Incorrect Input\n");
                    break;
            } // end of switch/case

            System.out.println("\nPress enter to continue");
            in.nextLine(); // waits for user to press enter
            // moves down to create space between menu and previous input
            System.out.println("\n\n"); 
        } // end of program while-loop
    } // end of main method



    // displays to the user what commands they have access to
    // both number and command name will work in the program (upper or lower case)
    public static void printMenu()
    {
        System.out.println("Please choose one of the following menu options:");
        System.out.println("1 - Add Entry");
        System.out.println("2 - Delete Entry");
        System.out.println("3 - View Phonebook");
        System.out.println("4 - Search Name ");
        System.out.println("5 - Search Address ");
        System.out.println("6 - Search City");
        System.out.println("7 - Search Phone Number");
        System.out.println("8 - Edit Name");
        System.out.println("9 - Edit Address");
        System.out.println("10 - Edit City");
        System.out.println("11 - Edit Phone Number");
        System.out.println("0 - Quit");

        System.out.print("\nCommand: ");
    } // end of printMenu method


    // parameters for scanner and size of phonebook in order for method to
    // know valid range of contact numbers the user can input

    // asks user to input each field of the node (excluding next node)
    // as well as the contact number the new node will be shown as
    // returns each of the values as a string array
    public static String[] newEntryInput(Scanner in, int phonebookSize) 
    {
        // bool that loops until a valid contact # is inputted
        boolean correctIndex = false; 
        String[] newEntry = new String[6]; // array to hold new entry info
        
        System.out.print("\nEnter First Name: ");
        newEntry[0] = in.next();
        in.nextLine(); // incase multi word input, clear line for next 
        
        System.out.print("Enter Last Name: ");
        newEntry[1] = in.next();
        in.nextLine(); // incase multi word input, clear line for next input

        System.out.print("Enter Address: ");
        newEntry[2] = in.nextLine();
        // if value is blank or whitespace it will be entered as "N/A"
        if(newEntry[2].replace(" ", "").equals(""))
            {newEntry[2] = "N/A";}

        System.out.print("Enter City: ");
        newEntry[3] = in.nextLine();
        // if value is blank or whitespace it will be entered as "N/A"
        if(newEntry[3].replace(" ", "").equals(""))
            {newEntry[3] = "N/A";}

        System.out.print("Enter Phone Number: ");
        newEntry[4] = in.nextLine();
        // if value is blank or whitespace it will be entered as "N/A"
        if(newEntry[4].replace(" ", "").equals(""))
            {newEntry[4] = "N/A";}

        // loop until valid contact number given
        while(correctIndex == false)
        { 
            System.out.print("Contact Number of New Entry (currently at " + phonebookSize + " contacts): ");
            if(in.hasNextInt()) // if int inputted
            {
                newEntry[5] = in.next(); // add new input
                // parse int converts string to int 
                int contactNumber = Integer.parseInt(newEntry[5]);
                // if new entry is a contact number in phonebook or the next available
                if(contactNumber <= phonebookSize+1 && contactNumber > 0)
                    {correctIndex = true;} // ends loop
                else
                {   // tells user errors, size of phonebook and valid range of contact numbers
                    System.out.println("\nERROR: Index Not Within Than Phonebook Size of "+ phonebookSize);
                    System.out.println("Please choose a number through the range of 1 to " + (phonebookSize+1)+"\n");
                }  
            }
            else // print error message 
                {System.out.println("ERROR: Input is not a Whole Number");}
            in.nextLine(); // incase multi word input, clear line for next input
        }
        return newEntry; // return String array
    } // end of newEntryInput method

    // parameters are for scanner, which node data to ask the user about and the phonebook 
    // manager in order to alter the data and know the size of the phonebook

    // asks user for what contact number's data they would like to change and then asks
    // for the new value of that data
    public static void editNode(Scanner in, String nodeData, PhonebookManager test) throws IllegalArgumentException
    {
        String newData = ""; // new value of specific nodedata that will be changed
        boolean correctIndexInputted = false; // check if valid index inputted
        while(!correctIndexInputted)
        {   // asks for which contact number's data to edit
            System.out.print("Which contact number's "+nodeData+" would you like to edit? (currently at "+test.size()+" contacts): ");
            if(in.hasNextInt()) // if an int inputted
            {
                int editIndex = in.nextInt(); // takes in int
                // if index is a real contact number
                if(editIndex > 0 && editIndex <= test.size())
                    {correctIndexInputted = true;} // ends loop
                else
                {   // sends error
                    System.out.println("ERROR: Number is not within range contacts");
                    in.nextLine(); // clears line for next input
                }
            }
            else
            {   // sends error
                System.out.println("ERROR: Input is not a Whole Number");
                in.nextLine(); // clears line for next input
            }
        } // end of while loop

        editIndex--; // index -1 to match index start 0 (shown as 1 to user)
        in.nextLine(); // clears line for next input
        // if not changing a name because it needs a first and last name input
        if(!nodeData.equalsIgnoreCase("name"))
        {   // asks for new values
            System.out.print("Enter new "+nodeData+": ");
            newData = in.nextLine(); // takes in new value
        }
        
        switch(nodeData.toLowerCase())
        {   // name case asks for new first & last name then adds
            case "name":
                System.out.print("Enter new first name: ");
                newData = in.nextLine();
                test.modifyFirstName(editIndex, newData); 

                System.out.print("Enter new last name: ");
                newData = in.nextLine();
                test.modifyLastName(editIndex, newData);

                break;
            case "address": // adds new address
                test.modifyAddress(editIndex, newData);
                break;
            case "city": // adds new city
                test.modifyCity(editIndex, newData);
                break;
            case "phone number": // adds new phone number
                test.modifyPhoneNumber(editIndex, newData);
                break;
            default: // tells user they used an invalid parameter by default
                throw new IllegalArgumentException("Not a Valid NodeData Parameter");
                break;
        } // end of switch/case
    } // end of editNode method
} // end of TestClass class