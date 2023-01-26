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
    public inStringt phoneNumber;
    public ListNode next;

    public ListNode(String firstName, String lastName, String address, String city, String phoneNumber, ListNode next)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.next = next;
    }

} // end of ListNode class