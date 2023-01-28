// Programmer: Sukhnain Deol
// Class: CS 145
// Date 01/24/2023
// Assignment: Assignment 2: Phone Book

// Purpose:

// to do
    // add more to toString to look fancier

    // add modify
        // modify data & modify node? 
    // -----------.get
        // make better way change specific inputted datatype (e.g. city)
    // check if any exceptions need to be thrown (indexoutofbounds)
    // add new entry at specific index

    // decide wheter 1 modify method (with data type parameter) or 5 modify methods (one for each data type)
    // delete method
        // delete node
        // delete field
        // adjust first and last entry listnodes

    // Test before Turn in
        // NewNode()

import java.util.*;

class PhonebookManager
{
    private ListNode firstEntry = null; // always at first node of linked list
    private ListNode lastNodeTracker = null; // always at last node of linked list
    private int phonebookSize = 0; // used for .size method


    // constructor method
    public PhonebookManager(String firstName, String lastName, String address, String city, String phoneNumber)
    {
        this.firstEntry = new ListNode(firstName, lastName, address, city, phoneNumber); // creates first node
        this.lastNodeTracker = this.firstEntry; // assigns lastnodetracker to node
        this.phonebookSize++;
    } // end of PhonebookManager constructor method


    // parameterless constructor
    public PhonebookManager(){}



    // creates a new node, if there isnt on, creates a new one and intializes field values appropiately
    // if at beginning index, reassign firstEntry field while another field holds all the fields and then 
    // reassign firstEntry back as the start of the linked list
    // else put a Listnode each at the node before and after where the new node will be and then add it and reattached the end 
    public void newNode(String firstName, String lastName, String address, String city, String phoneNumber, int index) throws IndexOutOfBoundsException
    {
        // if there isnt a node yet
        if(firstEntry == null)
        {
            // make new node
            firstEntry = new ListNode(firstName, lastName, address, city, phoneNumber);
            lastNodeTracker = firstEntry; // assign last to first because only 1 node so far
            phonebookSize++; // increment total linked list size
        }
        else // if index is not the edge have 2 node travelers
        {
            // index is one larger than max index or zero(starting index)
            if(index <= phonebookSize && index >= 0)
            {
                ListNode nodeTravelerOne = firstEntry; // starts traveler at first node
                if(index == 0) // if new first node
                {
                    firstEntry =  new ListNode(firstName, lastName, address, city, phoneNumber);
                    firstEntry.next = nodeTravelerOne;
                }
                else 
                {
                    ListNode nodeTravelerTwo; // travels to index after new node to be added
                    for(int i = 0; i < index-1; i++) // loops through all elements
                        {nodeTravelerOne = nodeTravelerOne.next; } // moves nodeTravelerOne to index before new node

                    nodeTravelerTwo = nodeTravelerOne.next; // nodeTravelerTwo is now at index after new node

                    // adds new node
                    nodeTravelerOne.next = new ListNode(firstName, lastName, address, city, phoneNumber); 
                    nodeTravelerOne.next.next = nodeTravelerTwo; // connects new node to node after 
                
                    if(index == phonebookSize) // if new node is at end of list
                        {lastNodeTracker = nodeTravelerOne.next;} // lastNodeTracker is now at new last node          
                }
                phonebookSize++; // increment total linked list size
            }
            else
                {System.out.println("ERROR: Index Not Within Than Phonebook Size of "+ phonebookSize);}
        }
    } // end of newNode method



    // searches linked list to find a nodes with given address
    public Queue<Integer> searchName(String name)
    {
        ListNode nodeTraveler = firstEntry;
        Queue<Integer> foundNames = new LinkedList<>();
        // traverse linked list 
        for(int i = 0; i < phonebookSize; i++)
        {   // if name in node equals name in parameter
            if((nodeTraveler.firstName+" "+nodeTraveler.lastName).equals(name))
                {foundNames.add(i);} // return index of node
            nodeTraveler = nodeTraveler.next;
        }
        return foundNames; // return -1 if name is not found
    } // end of indexName method



    // searches linked list to find a nodes with given address
    public int searchAddress(String address)
    {
        ListNode nodeTraveler = firstEntry;
        // traverse linked list 
        for(int i = 0; i < phonebookSize; i++)
        {   // if address in node equals name in parameter
            if(nodeTraveler.address.equals(address))
                {return i;} // return index of node
            nodeTraveler = nodeTraveler.next;
        }
        return -1; // return -1 if address is not found
    } // end of indexAddress method



    // searches linked list to find a node with given address
    public int searchPhoneNumber(String phoneNumber)
    {
        ListNode nodeTraveler = firstEntry;
        // traverse linked list 
        for(int i = 0; i < phonebookSize; i++)
        {   // if phoneNumber in node equals name in parameter
            if(nodeTraveler.phoneNumber.equals(phoneNumber))
                {return i;} // return index of node
            nodeTraveler = nodeTraveler.next;
        }
        return -1; // return -1 if phoneNumber is not found
    } // end of indexPhoneNumber method



    public ListNode index(int index)
    {
        ListNode nodeTraveler = firstEntry;
        for(int i = 0; i < index; i++)
            {nodeTraveler = nodeTraveler.next;}
        return nodeTraveler;
    } // end of index method



    // make more efficent way to find out what data needs be changed
    public void modify(int index, String Data, String newData)
    {
        ListNode modifiedData = index(index);
        switch(Data.toLowerCase())
        {
            case "firstname":
                modifiedData.firstName = newData;
                break;
            case "lastname":
                modifiedData.lastName = newData;
                break;
            case "address":
                modifiedData.address = newData;
                break;
            case "city":
                modifiedData.city = newData;
                break;
            case "phonenumber":
                modifiedData.phoneNumber = newData;
                break;
        }
    } // end of modifyData method

    public void modifyFirstName(int index, String newData)
    {
        ListNode modifiedData = index(index);
        modifiedData.firstName = newData;
    } // end of modifyFirstName method

    public void modifyLastName(int index, String newData)
    {
        ListNode modifiedData = index(index);
        modifiedData.lastName = newData;
    } // end of modifyLastName method

    public void modifyAddress(int index, String newData)
    {
        ListNode modifiedData = index(index);
        modifiedData.address = newData;
    } // end of modifyAddress method

    public void modifyCity(int index, String newData)
    {
        ListNode modifiedData = index(index);
        modifiedData.city = newData;
    } // end of modifyCity method

    public void modifyPhoneNumber(int index, String newData)
    {
        ListNode modifiedData = index(index);
        modifiedData.phoneNumber = newData;
    } // end of modifyPhoneNumber method

    

    // make sure firstEntry and lastNodeTracker will still work
        // reassign with index method?
    public void delete(int index)
    {
        // index to node before deleted one connects to index after
        if (index == 0 && index == phonebookSize-1) // if deleting only node
        {
            firstEntry = null; 
            lastNodeTracker = null;
        } 
        else
        {
            if(index == 0) // if deleting first node
            {firstEntry = index(index+1);} // firstEntry is now at index after deleted node
            else if(index == phonebookSize-1) // if deleting last node
            {
                lastNodeTracker = index(index-1);
                lastNodeTracker.next = null;
            } // lastNodeTracker is now at index before deleted node
            else // if deleting node in middle of list
                {index(index-1).next = index(index+1);} // index before deleted node connects to index after
        }
        
        phonebookSize--; // reduces total size
    } // end of delete method


 
    public String get(int index, String data)
    {
        ListNode get = index(index);
        switch(data.toLowerCase())
        {
            case "firstname":
                return get.firstName;
            case "lastname":
                return get.lastName;
            case "address":
                return get.address;
            case "city":
                return get.city;
            case "phonenumber":
                return get.phoneNumber;
            default:
                return "ERROR";
        }
    }

    public int size()
    {
        return phonebookSize;
    } // end of size method

    public String toString()
    {
        ListNode nodeTraveler = firstEntry;
        String toString = "";
        for (int i = 0; i<phonebookSize; i++)
        {
            toString += "Contact " + (i+1); 
            toString += "\nName: " + nodeTraveler.firstName + " " + nodeTraveler.lastName;
            toString += "\nAddress: " + nodeTraveler.address;
            toString += "\nCity: " + nodeTraveler.city;
            toString += "\nPhone Number: " + nodeTraveler.phoneNumber + "\n\n";
            nodeTraveler = nodeTraveler.next;
            
        }

        return toString;
    }

    /* remove
    public String toString()
    {
        nodeTraveler = firstEntry; // starts traveler at first node
        String toString = ""; // return value

        for(int i = 0; i < phonebookSize; i++) // loops through all elements
        {
            // calcs length of all data (including space and puncutation)
            int fullLength = nodeTraveler.firstName.length()+nodeTraveler.lastName.length()+nodeTraveler.address.length()+nodeTraveler.city.length()+nodeTraveler.phoneNumber.length()+5;

            // adds first parts of phonebook
            toString += (nodeTraveler.firstName + " " + nodeTraveler.lastName + "  " + nodeTraveler.address + ", " + nodeTraveler.city);

            // uses calculated length to put appropiate amount of '.' before phoneNumber
            for(int j = 0; j < 100 - fullLength; j++)
                {toString += ".";}

            // adds phoneNumber
            toString += nodeTraveler.phoneNumber + "\n";

            // goes to next node
            nodeTraveler = nodeTraveler.next;
        }

        return toString;
    } // end of toString method
    */
} // end of PhonebookManager class
