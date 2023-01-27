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

    /*  remove
    public String toString()
    {
        String toString = ""; // return value

        // calcs length of all data (including space and puncutation)
        int fullLength = firstName.length()+ lastName.length()+address.length()+city.length()+phoneNumber.length()+5;

        // adds first parts of phonebook
        toString += (firstName + " " + lastName + "  " + address + ", " + city);

        // uses calculated length to put appropiate amount of '.' before phoneNumber
        for(int j = 0; j < 100 - fullLength; j++)
            {toString += ".";}

        // adds phoneNumber
        toString += phoneNumber + "\n";

        return toString;
    } // end of toString method
    */
} // end of ListNode class