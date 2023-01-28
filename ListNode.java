// Programmer: Sukhnain Deol
// Class: CS 145
// Date 01/24/2023
// Assignment: Assignment 2: Phone Book

// Purpose: Defines a Listnode class that is used to implement a linked list
// in the class PhonebookManager.

class ListNode
{
    public String firstName = null;
    public String lastName = null;
    public String address = null;
    public String city = null;
    public String phoneNumber = null;
    public ListNode next = null;

    

    // constructor with all fields as parameters except next
    public ListNode(String firstName, String lastName, String address, String city, String phoneNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
    } // end of ListNode constructor method

    

    // no paremeter constructor
    public ListNode() {}
} // end of ListNode class