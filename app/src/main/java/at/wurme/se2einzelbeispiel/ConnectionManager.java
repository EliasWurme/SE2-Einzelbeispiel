package at.wurme.se2einzelbeispiel;

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

}
