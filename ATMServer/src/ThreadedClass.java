import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ThreadedClass implements Runnable {

	private ObjectOutputStream os;
	private ObjectInputStream is;
	private Socket socket;
	private FileInputStream fi;
	
	public ThreadedClass(Socket socketvar) {
		// TODO Auto-generated constructor stub
		super();
		this.socket = socketvar;
		try {
			fi = new FileInputStream("accounts.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void validateaccount(String cardnumber, String pin){
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			String secret = "ssshhhhhhhhhhh!!!!";
			os = new ObjectOutputStream(socket.getOutputStream());
			is = new ObjectInputStream(socket.getInputStream());
			AES de = new AES();
			String cardnumber= de.decrypt((String)is.readObject(), secret);
			String pin= de.decrypt((String)is.readObject(), secret);
			os.writeObject("Message Recieved");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException ex) 
		{
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

	}
	
}
