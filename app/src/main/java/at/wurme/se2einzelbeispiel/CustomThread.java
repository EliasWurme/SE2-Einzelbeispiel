package at.wurme.se2einzelbeispiel;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class CustomThread extends Thread {
    private String hostname, msg, answer;
    private int port;

    public CustomThread (String hostname, int port, String msg){
        this.hostname = hostname;
        this.port = port;
        this.msg = msg;
    }

    public void run(){
        try{

            Socket clientSocket = new Socket(this.hostname, this.port);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            outToServer.writeBytes(this.msg + '\n');
            this.answer = inFromServer.readLine();
            clientSocket.close();

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public String getAnswer (){
        return this.answer;
    }
}
