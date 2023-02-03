// Programmer: Sukhnain Deol
// Class: CS 145
// Date 01/24/2023
// Assignment: Assignment 2: Phone Book

// Purpose: Create a phonebook class with the use of the listnode class 
// in order to create a linked list class that keeps track of entries 
// with sets of names, addresses, cities, and phone numbers and that can 
// print entries in a clean, readable manner.
    
import java.util.*;

class PhonebookManager
{
    private ListNode firstEntry = null; // always at first node of linked list
    private ListNode lastNodeTracker = null; // always at last node of linked list 
    private int phonebookSize; // used for .size() method


    // constructor method that initalizes new node's values
    public PhonebookManager(String firstName, String lastName, 
    String address, String city, String phoneNumber)
    {   // creates first node
        this.firstEntry = new ListNode(firstName, lastName, address, city, 
        phoneNumber); 
        this.lastNodeTracker = this.firstEntry; // assigns lastnodetracker to 
        this.phonebookSize = 1; // phonebook constructed with a node has 1 node
    } // end of PhonebookManager constructor method


    // parameterless constructor
    public PhonebookManager()
    {
        this.phonebookSize = 0; // no nodes on construction, 0 nodes
    }


    // parameters are from each field in ListNode

    // creates a new ListNode with all fields necessary taking care of circumstances
    // such as a new first node, last node, or adding the first node in the list yet
    public void add(String firstName, String lastName, String address,
     String city, String phoneNumber, int index) throws IndexOutOfBoundsException
    {
        // if there isnt a node yet
        if(firstEntry == null && index <= phonebookSize && index >= 0)
        {
            // make new node
            firstEntry = new ListNode(firstName, lastName, address, city, 
            phoneNumber);
            // assign last to first because only 1 node so far
            lastNodeTracker = firstEntry; 
        }
        else 
        {
            // index is between 0 and size+1 
            // (phonebook size is already +1 cause of index starting at 0)
            if(index <= phonebookSize && index >= 0)
            {
                ListNode nodeTraveler = firstEntry; // starts traveler at first node
                if(index == 0) // if new first node
                {
                    // reassign first node
                    firstEntry =  new ListNode(firstName, lastName, address,
                     city,phoneNumber);
                    // connect firstnode as beginning node
                    firstEntry.next = nodeTraveler;
                }
                else // if new middle or end node
                {
                    // move traveler to node before new node to be added
                    nodeTraveler = index(index-1);

                    // adds new node and connects it to next
                    // uses nodetraveler.next as parameter to 
                    // connect new node to the rest of the nodes
                    nodeTraveler.next = new ListNode(firstName, lastName,
                     address, city, phoneNumber, nodeTraveler.next); 
                
                    // moves lastnodetracker if new node is now at the end
                    if(index == phonebookSize) 
                        {lastNodeTracker = nodeTraveler.next;}  
                }
            }
        } // end of outermost if/else
        phonebookSize++; // increment total linked list size
    } // end of newNode method
    


   // deletes contact entry at given index
    public void delete(int index)
    {
        // if index out of range of total contacts
        if(index > phonebookSize-1 || index < 0) 
        {   
            phonebookSize++; // add back size since its an error
            // send error
            throw new IndexOutOfBoundsException("Delete index out of range");
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
        else if(index == phonebookSize-1) // if deleting end node 
        {   // move to 2nd to last node
            lastNodeTracker = index(phonebookSize-2);
            lastNodeTracker.next = null; // null last node
        }
        else // else if deleting in the middle
        {   // move to index before deleted node
            ListNode nodeTraveler = index(index-1);
            // connect to node after next
            nodeTraveler.next = nodeTraveler.next.next; 
        }
        phonebookSize--; // reduces total size
    } // end of delete method



    // accessor method returns total number of nodes(entries) in phonebook
    public int size()
    {
        return phonebookSize;
    } // end of size method



    // if phonebook size is 0 return true, else false 
    public boolean isEmpty()
    {
        if(phonebookSize == 0)
            {return true;}
        else    
            {return false;}
    } // end of isEmpty method


    // returns a listnode at a certain index in phonebook
    public ListNode index(int index) 
    {   // creates traveler ListNode
        if (index < 0 || index > phonebookSize-1)
        {
            throw new IndexOutOfBoundsException();
        }
        else 
        {
            ListNode nodeTraveler = firstEntry;
            // moves to specified index
            for(int i = 0; i < index; i++)
                {nodeTraveler = nodeTraveler.next;}
            return nodeTraveler; // return node at index
        }
    } // end of index method
        


    // returns a formatted string containing information from the phonebook
    public String toString()
    {
        ListNode nodeTraveler = firstEntry;
        String toString = "";
        // adds each value at each node
        for (int i = 0; i<phonebookSize; i++)
        {
            toString += "Contact " + (i+1); 
            toString += "\nName: " + nodeTraveler.firstName + " " + 
            nodeTraveler.lastName;
            toString += "\nAddress: " + nodeTraveler.address;
            toString += "\nCity: " + nodeTraveler.city;
            toString += "\nPhone Number: " + nodeTraveler.phoneNumber + "\n\n";
            nodeTraveler = nodeTraveler.next;   
        }
        return toString;
    } // end of toString method



    // searches linked list to find a nodes with given address
    public Queue<Integer> searchName(String name)
    {
        ListNode nodeTraveler = firstEntry;
        Queue<Integer> foundNames = new LinkedList<>();
        // traverse linked list 
        for(int i = 0; i < phonebookSize; i++)
        {   // if name in node equals name in parameter
            if((nodeTraveler.firstName+" "+nodeTraveler.lastName).equals(name))
                {foundNames.add(i);} // adds name's node's index
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
                {foundAddresses.add(i);} // add address's node's index
            nodeTraveler = nodeTraveler.next; // moves to next node
        }
        return foundAddresses; // return found addresses
    } // end of indexAddress method



    // searches linked list to find a nodes with given city
    public Queue<Integer> searchCity(String city)
    {
        ListNode nodeTraveler = firstEntry;
        Queue<Integer> foundCities = new LinkedList<>();
        // traverse linked list 
        for(int i = 0; i < phonebookSize; i++)
        {   // if city in node equals name in parameter
            if(nodeTraveler.city.equals(city))
                {foundCities.add(i);} // add city's node's index
            nodeTraveler = nodeTraveler.next; // moves to next node
        }
        return foundCities; // return found addresses
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
                {foundPhoneNumbers.add(i);} // add phone number's node's index
            nodeTraveler = nodeTraveler.next; // moves to next node
        }
        return foundPhoneNumbers; // return found phone numbers
    } // end of indexPhoneNumber method



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
} // end of PhonebookManager class
