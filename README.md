# Bank Application

## Run

- open `IntelliJ` ide and run `Main` configuration

## Basic Bank Application

This is bare bones bank application running on standard Java 8 Data Structures instead of a database for simplicity reasons.

There is two Data Models: Customer, and Ledger.

Customer contains a every basic customer, a customer in this application is just a name, ArrayList of Ledgers, and balance. We are only checking to see if the "name" is present when constructing a new customer. Name should have more defined requires and better validation rules. Normally, in a more advanced application, a customer would have an ID, Email, etc and Name would be an Alpha String. For this application, a foundational trade off was made to start off as a well-structured, well-tested ground work to build on later. The choice to use an ArrayList for Ledgers was pretty simple as ArrayList is a dynamic size. Meaning, i don't have to know the amount of Ledgers a Customer may have upfront, and i don't have to maintain the size of the Array and have to keep recreating larger size's as the Ledger Entries grow in size. Balance is simply the running balance of the customers transactions. In this application there is no concept of negative balances.

Ledger is the record of a given transaction for a Customer. Thus, it's simplest form is amount, description, and insertedAt. We at least need to know about the amount, description of transaction and the datetime it occured. There is no removing or changing an Ledger entry once it's created. It is persisted for the life of the application. 

Bank is the main class of the Bank Application it contains three methods: addCustomer(), deposit(), and withdraw().

The Bank constructor declares a new Data Structure called Map, in this this case we are using a HashMap to store our customers, the first type is a String for the customer name and the second is Customer for the customer object. The choice to use a HashMap was simple, it operates in constant time.

- addCustomer() creates a customer, and adds to the Map of customers O(1) time. It accepts just a name for this application. 
- deposit() accepts the customers name of whom who wants to do a deposit and an amount. We first start by asking the customerMap if the customer exists this is O(1) time, if it exists, we get the customer from the map O(1) time, we create a new Ledger, and add it to the Customers Ledgers List O(1) time and update the customers balance and bank balances. If the customer does not exist we throw an Exception with a message "Customer not found" otherwrise we return an array of bank balance and customer balance.
- withdraw() accepts the customers name of whom who wants to do a withdraw and an amount. We first start by asking the customerMap if the customer exists this is O(1) time, if it exists, we get the customer from the map O(1) time, we check if the Customer Balance is less than the amount if so, we throw a Exception informing the customer that they cannot withdraw at this time. we we create a new Ledger, and add it to the Customers Ledgers List O(1) time and update the customers balance and bank balances. If the customer does not exist we throw an Exception with a message "Customer not found" otherwrise we return an array of bank balance and customer balance.


- Pros: Application runs in constant time, Acceptable test coverage, easy to read and understand.
- Cons: Poor Models, Limited data validation.

Changes i would change would be better defining the Customer, and adding additional move real-life validation checks. 