import java.io.*;
import java.net.*;



public class GomokuClient 
{
    protected Socket gomokuSocket;						 // socket for communicating w/ server
    protected PrintWriter boardOut;                      // takes care of output stream for sockets
    protected BufferedReader boardIn;					 // bufferedreader for input reading
    public static final int GOMOKU_PORT = 17033;        

    public GomokuClient(String h, int p) 
    {
    	registerWithGomoku(h, p);
    }
    public void registerWithGomoku(String h, int p) 
    {
        try {
	    // connects to h machine on port p
            gomokuSocket = new Socket(h, p);

	    // create output stream to communicate with grid
            boardOut = new PrintWriter(gomokuSocket.getOutputStream(), true); 
            boardOut.println("base"); // send role to server

	    //buffered reader reads from input stream from grid
            boardIn = new BufferedReader(new InputStreamReader(gomokuSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + h);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: " + h);
            System.exit(1);
        }
    }
    public void effectorSend(String command) 
    {
    	boardOut.println(command);
    }
}
