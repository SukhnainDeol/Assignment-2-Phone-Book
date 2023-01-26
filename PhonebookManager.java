// Programmer: Sukhnain Deol
// Class: CS 145
// Date 01/24/2023
// Assignment: Assignment 2: Phone Book

// Purpose:

// to do
    // add more to toString to look fancier
    // add delete
        // fields and nodes?
            // make field null
    // add modify
        // modify data & modify node? 
    // -----------.get
        // make better way change specific inputted datatype (e.g. city)
    // is last node supposed to link to first?
    // limit length or make other solution to long entries
        // limit phone number chars
    // check if any exceptions need to be thrown (indexoutofbounds)


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
        this.phonebookSize++;
    } // end of PhonebookManager constructor method



    public void newNode(String firstName, String lastName, String address, String city, String phoneNumber)
    {
        lastNodeTracker.next = new ListNode(firstName, lastName, address, city, phoneNumber); // makes new node
        lastNodeTracker = lastNodeTracker.next; // moves lastNodeTracker to new last node
        lastNodeTracker.next = firstEntry; // links last node to first node
        phonebookSize++;
    } // end of newNode method



    public ListNode index(int index)
    {
        nodeTraveler = firstEntry;
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


    // make sure firstEntry and lastNodeTracker will still work
    public void delete(int index)
    {
        // index to node before deleted one connects to index after
        firstEntry.next = lastNodeTracker;
        System.out.println(lastNodeTracker);
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
