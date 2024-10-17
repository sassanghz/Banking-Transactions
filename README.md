Client:

  Reads a series of transactions from a file (transaction.txt).
  Sends each transaction to the server via the network using send().
  Receives the updated transactions from the server using receive() and displays the results.
  Uses two threads: one for sending and one for receiving transactions.

Server:

  Reads account data from a file (account.txt).
  Receives transactions from the network input buffer using transferIn().
  Processes each transaction by updating the appropriate account.
  Sends the updated transactions back to the client using transferOut().

Network:

  Manages the input and output buffers that facilitate communication between the client and server.
  The network thread continuously checks whether data is available for transfer and yields the CPU when necessary.

1. Network Class
The Network class facilitates communication between the client and server by providing an infrastructure to transmit and receive transactions. It implements:

inComingPacket[] and outGoingPacket[]: Buffers to store incoming and outgoing transactions. Each buffer has a capacity of 10 elements.
Methods like connect(), send(), and receive(): Allow the client and server to interact with the network.

2. Client Class
The Client class is responsible for:

-Reading transactions from transaction.txt and saving them in an array.
-Sending transactions to the server through the network.
-Retrieving updated transactions from the network and displaying them on the screen.
It uses two threads: one for sending transactions and one for receiving the updated ones. The client uses the Network class's send() and receive() methods.

3. Server Class
The Server class:

-Reads account data from account.txt and stores it in an array.
-Retrieves transactions from the network buffer using transferIn().
-Processes transactions (withdraw, deposit, query) and updates account balances.
-Sends the updated transactions back to the client using transferOut().
-Uses a thread to continuously monitor the network input and output buffers.

4. Transactions Class
  Represents individual banking transactions such as withdrawals, deposits, and account queries.

6. Accounts Class
  Stores information about individual bank accounts, including account balances.
