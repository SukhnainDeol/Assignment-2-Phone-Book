import java.util.List;

// Programmer: Sukhnain Deol
// Class: CS 145
// Date 01/24/2023
// Assignment: Assignment 2: Phone Book

// Purpose:

class TestClass
{
    public static void main(String[] args)
    {
        PhonebookManager test = new PhonebookManager("Joe", "Allen", "4973 Yellow Brick Road", "Bellingham", "360-224-7793");
        test.newNode("Joeaaa", "Allen", "4973 Yellow Brick Road", "Bellingham", "360-224-7793");

        System.out.print(test);
    } // end of main method
} // end of TestClass class
