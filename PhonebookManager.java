// Programmer: Sukhnain Deol
// Class: CS 145
// Date 01/24/2023
// Assignment: Assignment 2: Phone Book

// Purpose:
// create .next with another var

class PhonebookManager
{
    private ListNode firstEntry = null; // always at first node
    private ListNode lastNodeTracker = null; // always at last node
    private ListNode nodeTraveler = null; // used to travel through nodes
    private int phonebookSize = 0; // used for .size

    public PhonebookManager(String firstName, String lastName, String address, String city, String phoneNumber)
    {
        this.firstEntry = new ListNode(firstName, lastName, address, city, phoneNumber); // creates first node
        this.lastNodeTracker = this.firstEntry; // assigns lastnodetracker to node
        phonebookSize++;
    } // end of PhonebookManager constructor method



    public void newNode(String firstName, String lastName, String address, String city, String phoneNumber)
    {
        lastNodeTracker.next = new ListNode(firstName, lastName, address, city, phoneNumber); // makes new node
        lastNodeTracker = lastNodeTracker.next; // moves lastNodeTracker to new last node
        lastNodeTracker.next = firstEntry; // links last node to first node
        phonebookSize++;
    } // end of newNode method

    

    public int size()
    {
        return phonebookSize;
    } // end of size method



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
} // end of PhonebookManager class
