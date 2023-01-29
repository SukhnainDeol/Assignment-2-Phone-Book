// Programmer: Sukhnain Deol
// Class: CS 145
// Date 01/24/2023
// Assignment: Assignment 2: Phone Book

// Purpose:

// if newNode not working, check new overloaded constructor
// use iterator<E> and list<E> interfaces?
// rename index method to atIndex
// decide whether first and last name should be in.next or in.nextLine

// to do
    // test delete method
        // delete fields and nodes??????
    // double check everything
    // clean up
    // work on front end

import java.util.*;

class PhonebookManager
{
    private ListNode firstEntry = null; // always at first node of linked list
    private ListNode lastNodeTracker = null; // always at last node of linked list (use a while != null statement instead?)
    private int phonebookSize = 0; // used for .size method

    // remove
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

                    // change to index method

                    for(int i = 0; i < index-1; i++) // loops through all elements
                        {nodeTravelerOne = nodeTravelerOne.next; } // moves nodeTravelerOne to index before new node

                    nodeTravelerTwo = nodeTravelerOne.next; // nodeTravelerTwo is now at index after new node

                    // adds new node and connects it to next
                    nodeTravelerOne.next = new ListNode(firstName, lastName, address, city, phoneNumber, nodeTravelerTwo); 
                
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
                {foundNames.add(i);} // adds name
            nodeTraveler = nodeTraveler.next; // moves to next node
        }
        return foundNames; // return found names 
    } // end of indexName method



    // searches linked list to find a nodes with given address
    public Queue<Integer> searchAddress(String address)
    {
        ListNode nodeTraveler = firstEntry;
        Queue<Integer> foundAddresses = new LinkedList<>();
        // traverse linked list 
        for(int i = 0; i < phonebookSize; i++)
        {   // if address in node equals name in parameter
            if(nodeTraveler.address.equals(address))
                {foundAddresses.add(i);} // add address
            nodeTraveler = nodeTraveler.next; // moves to next node
        }
        return foundAddresses; // return found addresses
    } // end of indexAddress method



    // searches linked list to find a node with given address
    public Queue<Integer> searchPhoneNumber(String phoneNumber)
    {
        ListNode nodeTraveler = firstEntry;
        Queue<Integer> foundPhoneNumbers = new LinkedList<>();
        // traverse linked list 
        for(int i = 0; i < phonebookSize; i++)
        {   // if phoneNumber in node equals name in parameter
            if(nodeTraveler.phoneNumber.equals(phoneNumber))
                {foundPhoneNumbers.add(i);} // add phone number
            nodeTraveler = nodeTraveler.next; // moves to next node
        }
        return foundPhoneNumbers; // return found phone numbers
    } // end of indexPhoneNumber method



    // returns a listnode at a certain index in phonebook
    public ListNode index(int index)
    {
        ListNode nodeTraveler = firstEntry;
        for(int i = 0; i < index; i++)
            {nodeTraveler = nodeTraveler.next;}
        return nodeTraveler;
    } // end of index method


    
    // series of mutator methods that modifiy a specific indexed node's data type
    public void modifyFirstName(int index, String newFirstName)
    {
        ListNode modifiedData = index(index); // goes to specified node
        modifiedData.firstName = newFirstName; // changes firstName
    } // end of modifyFirstName mutator method

    public void modifyLastName(int index, String newLastName)
    {
        ListNode modifiedData = index(index); // goes to specified node
        modifiedData.lastName = newLastName; // changes lastName
    } // end of modifyLastName mutator method

    public void modifyAddress(int index, String newAddress)
    {
        ListNode modifiedData = index(index); // goes to specified node
        modifiedData.address = newAddress; // changes address
    } // end of modifyAddress mutator method

    public void modifyCity(int index, String newCity)
    {
        ListNode modifiedData = index(index); // goes to specified node
        modifiedData.city = newCity; // changes city
    } // end of modifyCity mutator method

    public void modifyPhoneNumber(int index, String newPhoneNumber)
    {
        ListNode modifiedData = index(index); // goes to specified node
        modifiedData.phoneNumber = newPhoneNumber; // changes phoneNumber
    } // end of modifyPhoneNumber mutator method

    

    // make sure firstEntry and lastNodeTracker will still work
        // reassign with index method?
    // edge cases
        // index is outside of range
        // delete changes last node
        // delete changes first node
        // delete removes last remaining node
    // make sure lastNodeTracker is always updated
    public void delete(int index)
    {
        phonebookSize--; // reduces total size

        // if index out of range of total contacts
        if(index > phonebookSize-1 || index < 0) 
        {
            System.out.println("ERROR: Contact Number out of range of total contact number of " + phonebookSize);
            phonebookSize++; // add back size since its an error
        } 
        else if(phonebookSize == 1) // if deleting last node left
        {   // all trackers reverted to null
            firstEntry = null;
            lastNodeTracker = null;
        }
        else if(index == 0) // if deleting first node
        {   // first entry goes to next node
            firstEntry = firstEntry.next;
        }
        else if(index == phonebookSize-1) // if deleting last node
        {
            lastNodeTracker = firstEntry; // start from beginning
            // move to 2nd to last node
            lastNodeTracker = index(phonebookSize-2);
            lastNodeTracker.next = null; // null last node
        }
        else // else if deleting in middle
        {   // move to index before deleted node
            ListNode nodeTraveler = index(index-1); 
            nodeTraveler.next = nodeTraveler.next.next; // connect to node after next
        }
    } // end of delete method


     // series of accessor methods that retreive data from a specific indexed node
    public String getFirstName(int index, String data)
    {
        ListNode get = index(index); // goes to specified node
        return get.firstName; // return node's firstName
    } // end of getFirstName accessor method
    
    public String getLastName(int index, String data)
    {
        ListNode get = index(index); // goes to specified node
        return get.lastName; // return node's lastName
    } // end of getLastName accessor method

    public String getAddress(int index, String data)
    {
        ListNode get = index(index); // goes to specified node
        return get.address; // return node's address
    } // end of getAddress accessor method

    public String getCity(int index, String data)
    {
        ListNode get = index(index); // goes to specified node
        return get.city; // return node's city 
    } // end of getCity accessor method

    public String getPhoneNumber(int index, String data)
    {
        ListNode get = index(index); // goes to specified node
        return get.phoneNumber; // return node's phoneNumber
    } // end of getPhoneNumber accessor method



    // returns total number of nodes in phonebook
    public int size()
    {
        return phonebookSize;
    } // end of size method



    // returns a formatted string containing information from the phonebook
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
    } // end of toString method
} // end of PhonebookManager class
