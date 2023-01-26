// Programmer: Sukhnain Deol
// Class: CS 145
// Date 01/24/2023
// Assignment: Assignment 2: Phone Book

// Purpose:

class ListNode
{
    public String firstName;
    public String lastName;
    public String address;
    public String city;
    public String phoneNumber;
    public ListNode next = null;

    public ListNode(String firstName, String lastName, String address, String city, String phoneNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }
} // end of ListNode class