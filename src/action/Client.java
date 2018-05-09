package action;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

import javax.swing.*;
/**
 * 
 * @author zym
 *
 */

public class Client extends JFrame implements ActionListener,Runnable{

	
  private FlowLayout flowlayout=new FlowLayout(FlowLayout.CENTER,60,60);
  private JLabel label=new JLabel("������ID��");
  private JButton bt=new JButton("����");
  private JButton bt2=new JButton("Զ�̿���");
  private JTextField text=new JTextField(10);
  private JPanel jpl=new JPanel();
  private static Socket socket;
  public static String id = null;
  

  public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
         Client client=new Client();
        
	}
  public Client() throws IOException{
	  jpl.setLayout(flowlayout);
	  jpl.add(label);
	  jpl.add(text);
	  jpl.add(bt);
      jpl.add(bt2);
      try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  this.setTitle("Զ�̼��ϵͳv1.0");
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.add(jpl);
	  this.setSize(400,300);
	  this.setVisible(true);
	 
	  new Thread(this).start();
  }
  
  
@Override
public void run() {
	// TODO Auto-generated method stub

	 bt.addActionListener(this);
	 bt2.addActionListener(this);
	
}
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==bt){
		id=text.getText();
		try {
			socket=new Socket(id,9999);
			BufferedReader br=Client.demand("����Զ�̿��ƿ���");
			String str=br.readLine();
			if(str.equals("ͬ������")){ 
				UIThread ui=new UIThread(Client.id);
				ui.start();
			 }
			 else{
				JOptionPane.showMessageDialog(null, "�Է��ܾ��������������");
			 }
			//Mngsocket.add_socket(socket);
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}
public static BufferedReader demand(String str) throws IOException{
	if(socket==null){
		socket=new Socket(id,9999);
	}
	
	System.out.println(id);
	System.out.println(str);
	
	DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
	dos.writeUTF(str);
	System.out.println("���������Ѿ�����");
	//ps.close();
	InputStream in=socket.getInputStream(); 
	BufferedReader br=new BufferedReader(new InputStreamReader(in));
	 return br;
}

//�ж��Ƿ��Ѿ������˷�����
public boolean is_have(String iid){
	  boolean a=false;
	  for(int i=0;i<Mngsocket.sockets.size();i++)
	  {
		  Socket s=Mngsocket.sockets.get(i);
		  if(iid.equals(s.getInetAddress().getHostAddress())){
			  a=true;
			  break;
		  }
	  }
	  return a;
}
}