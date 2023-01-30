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
            
            // if phonebook empty, ask them to created a new entry before doing anything else
            if(test.size() == 0 && !(command.equals("1") || command.toLowerCase().equals("add entry")))
            {   // if quitting, break out of nest if loop
                if(command.equals("0") || command.toLowerCase().equals("quit"))
                    {break;}
                System.out.println("\nPhonebook is empty, please create a a new entry first");
                System.out.println("\nPress enter to contiue");
                in.nextLine(); // waits for user to press enter 
                System.out.println("\n");
                continue; // repeats loop from beginning
            }
            
            switch(command.toLowerCase())
            {
                case "1":
                case "add entry":
                    // turn into method
                    String[] newEntry = newEntryInput(in, test.size());
                    test.newNode(newEntry[0], newEntry[1], newEntry[2], newEntry[3], newEntry[4], Integer.parseInt(newEntry[5])-1);
                    break;
                case "2":
                case "delete entry":
                    if (test.size() == 0)
                        {System.out.println("\nERROR: Phonebook is Empty");}
                    else
                    {
                        System.out.print("\nEnter Contact Number to Delete: ");
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
                case "search city":
                    System.out.print("\nEnter the City to Search: ");
                    String city = in.nextLine();
                    Queue<Integer> cityIndex = test.searchAddress(city); // searches for phone number
                    if(cityIndex.size() == 0) // if no phone number found
                        {System.out.println("ERROR: City not found");}
                    else if (cityIndex.size() == 1 ) // if one instance of phone number found
                        {System.out.println("City - " + city + "'s information is in contact " + (cityIndex.remove()+1));}
                    else // if multiple instance of phone number found
                    {
                        System.out.println("There are "+cityIndex.size()+" occurences of the phone number " + city + " in the phonebook.");
                        System.out.println("These occurences are in the following contact numbers:");
                        int cityIndexSize = cityIndex.size();
                        for(int i = 0; i < cityIndexSize; i++) // print each name from queue
                            {System.out.println("Contact Number " + (cityIndex.remove()+1));}
                    }
                    break;
                case "8":
                case "edit name":
                        // make sure
                    System.out.print("Which contact number's Name would you like to edit?: ");
                    if (in.hasNextInt())
                    {
                        int editNameIndex = in.nextInt();
                        // if index is a real contact number
                        if(editNameIndex > 0 && editNameIndex <= test.size())
                        {
                            editNameIndex--; // index -1 to match index start 0 (shown as 1 to user)
                            in.nextLine();
                            System.out.println("Enter new first name: ");
                            String newFirstName = in.nextLine();
                            test.modifyFirstName(editNameIndex, newFirstName);
                            System.out.print("Enter new last name: ");
                            String newLastName = in.nextLine();
                            test.modifyLastName(editNameIndex, newLastName);
                        }
                        else
                        {
                            System.out.println("ERROR: Number is not within range contacts");
                            in.nextLine();
                        }
                    }
                    else
                    {
                        System.out.println("ERROR: Input is not a Whole Number");
                        in.nextLine();
                    }
                    break;
                case "9":
                case "edit address":
                    System.out.print("Which contact number's Address would you like to edit?: ");
                    if(in.hasNextInt())
                    {
                        int editAddressIndex = in.nextInt();
                        if(editAddressIndex > 0 && editAddressIndex <= test.size())
                        {
                            editAddressIndex--; // index -1 to match index start 0 (shown as 1 to user)
                            in.nextLine();
                            System.out.print("Enter new address: ");
                            String newAddress = in.nextLine();
                            test.modifyAddress(editAddressIndex-1, newAddress);
                        }
                        else
                        {
                            System.out.println("ERROR: Number is not within range contacts");
                            in.nextLine();
                        }
                    }
                    else
                    {
                        System.out.println("ERROR: Input is not a Whole Number");
                        in.nextLine();
                    }
                    break;
                case "10":
                case "edit phone number":
                    System.out.print("Which contact number's Phone Number would you like to edit?: ");
                    if(in.hasNextInt())
                    {
                        int editPhoneIndex = in.nextInt();
                        // if index is a real contact number
                        if(editPhoneIndex > 0 && editPhoneIndex <= test.size())
                        {
                            editPhoneIndex--; // index -1 to match index start 0 (shown as 1 to user)
                            in.nextLine();
                            System.out.print("Enter new phone number: ");
                            String newPhoneNumber = in.nextLine();
                            test.modifyPhoneNumber(editPhoneIndex, newPhoneNumber);
                        }
                        else
                        {
                            System.out.println("ERROR: Number is not within range contacts");
                            in.nextLine();
                        }
                    }
                    else
                    {
                        System.out.println("ERROR: Input is not a Whole Number");
                        in.nextLine();
                    }
                    break;
                case "11":
                case "edit city":
                    System.out.print("Which contact number's City would you like to edit?: ");
                    if(in.hasNextInt())
                    {
                        int editCityIndex = in.nextInt();
                        // if index is a real contact number
                        if(editCityIndex > 0 && editCityIndex <= test.size())
                        {
                            editCityIndex--; // index -1 to match index start 0 (shown as 1 to user)
                            in.nextLine();
                            System.out.print("Enter new city: ");
                            String newCity = in.nextLine();
                            test.modifyCity(editCityIndex, newCity);
                        }
                        else
                        {
                            System.out.println("ERROR: Number is not within range contacts");
                            in.nextLine();
                        }
                    }
                    else
                    {
                        System.out.println("ERROR: Input is not a Whole Number");
                        in.nextLine();
                    }
                    break;
                case "0":
                case "quit":
                    inUse = false; // ends while loop
                    break;
                default:
                    System.out.println("\nERROR: Incorrect Input\n");
            } // end of switch/case

            System.out.println("\nPress enter to continue");
            in.nextLine(); // makes it easier to view output before next command
            System.out.println("\n\n");
        } // end of program while loop
    } // end of main method



    // displays to the user what commands they have access to
    public static void printMenu()
    {
        System.out.println("Please choose one of the following menu options:");
        System.out.println("1 - Add Entry");
        System.out.println("2 - Delete Entry");
        System.out.println("3 - View Phonebook");
        System.out.println("4 - Search Name ");
        System.out.println("5 - Search Address ");
        System.out.println("6 - Search Phone Number");
        System.out.println("7 - Search City");
        System.out.println("8 - Edit Name");
        System.out.println("9 - Edit Address");
        System.out.println("10 - Edit Phone Number");
        System.out.println("11 - Edit City");
        System.out.println("0 - Quit");

        System.out.print("\nCommand: ");
    } // end of printMenu method



    // asks user to input each field of the node (excluding next node)
    // as well as the contact number the new node will be shown as
    public static String[] newEntryInput(Scanner in, int phonebookSize) 
    {
        boolean correctIndex = false;
        String[] newEntry = new String[6]; // array to hold new entry 
        
        // get all info for new entry then use newNode method
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
            if(in.hasNextInt()) // if correct input, end loop 
            {
                newEntry[5] = in.next();
                int contactNumber = Integer.parseInt(newEntry[5]);
                // if new entry is a contact number in phonebook
                if(contactNumber <= phonebookSize+1 && contactNumber > 0)
                    {correctIndex = true;}
                else
                {
                    System.out.println("\nERROR: Index Not Within Than Phonebook Size of "+ phonebookSize);
                    System.out.println("Please choose a number through the range of 1 to " + (phonebookSize+1)+"\n");
                }  
            }
            else // print error message each failure
                {System.out.println("ERROR: Please Give A Numerical Input");}
            in.nextLine(); // incase multi word input, clear line for next input
        }
        
        return newEntry;
    } // end of newEntryInput method
} // end of TestClass class