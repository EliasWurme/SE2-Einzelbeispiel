package at.wurme.se2einzelbeispiel;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConnectionManager{
    private int port;
    private String hostname;
    private String msg;
    private String answer = "test";

    public ConnectionManager (String hostname, int port){
        this.hostname = hostname;
        this.port = port;
    }

    public String communicate (String msg) throws Exception {
        CustomThread ct = new CustomThread(this.hostname,this.port, msg);

        ct.start();
        ct.join();

       return ct.getAnswer();
    }

        /*
        String receivedMsg = "";
        Socket clientSocket = new Socket(this.hostname, this.port);

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        outToServer.writeBytes(msg + '\n');

        receivedMsg = inFromServer.readLine();

        clientSocket.close();
        /*
         */

}
