
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kerly Titus
 */
public class Driver {

    /** 
     * main class
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
    	Network objNetwork = new Network("network");            /* Activate the network */
        objNetwork.start();// starting the thread for the network
        Server objServer = new Server();        
        /* Complete here the code for the main method ...*/
        objServer.start();// starting the server thread

        // with the server thread starting, it will beign processing the transactions in its own thread 
       
        // client threads
        Client objClient1 = new Client("sending");
        //Client objClient2 = new Client("client2");

        objClient1.start();
        //objClient2.start();

        try {
            objClient1.join();
            //objClient2.join();
            objServer.join();
        } catch (InterruptedException e) {
            System.out.println("Driver interrupted");
        }

        objNetwork.terminate();// signal termination

        
    }
}
