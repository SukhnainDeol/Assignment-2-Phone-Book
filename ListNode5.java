// Programmer: Sukhnain Deol
// Class: CS 145
// Date 01/24/2023
// Assignment: Assignment 2: Phone Book

// Purpose: Defines a Listnode class that is used to 
// implement a linked list in the PhonebookManager class.

class ListNode5
{
    public String firstName = null;
    public String lastName = null;
    public String address = null;
    public String city = null;
    public String phoneNumber = null;
    public ListNode5 next = null;


    
    // constructor with all fields as parameters 
    public ListNode5(String firstName, String lastName, 
    String address, String city, String phoneNumber, ListNode5 next)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.next = next;
    } // end of ListNode constructor method
    


    // constructor with all fields as parameters except next
    public ListNode5(String firstName, String lastName, 
    String address, String city, String phoneNumber)
    {
        // calls full paremeter constructor but makes next field null
        this(firstName, lastName, address, city, phoneNumber, null);
    } // end of ListNode constructor method

    

    // no paremeter constructor
    public ListNode5() {}
} // end of ListNode class