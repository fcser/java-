package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChooseUI extends JPanel implements ActionListener{
	/*private DataInputStream dis=null;
	private ObjectOutputStream oos=null;
	private Socket img;*/
	//private JButton bt1=new JButton("����");
	private JButton bt2=new JButton("�ļ�����");
	private JButton bt3=new JButton("�ļ�����");
	private JButton bt4=new JButton("�ػ�");
	private JButton bt5=new JButton("����");
	private JButton bt6=new JButton("DOS����");
     public ChooseUI(){
    	 //JPanel pane2=new JPanel();
    	 
    	 
        // this.add(bt1);
         this.add(bt2);
         this.add(bt3);
         this.add(bt6);
         this.add(bt4);
         this.add(bt5);
        // bt1.setEnabled(false);
        // bt1.addActionListener(this);
         bt2.addActionListener(this);
         bt3.addActionListener(this);
         bt4.addActionListener(this);
         bt5.addActionListener(this);
         bt6.addActionListener(this);
     }
     
     public void actionPerformed(ActionEvent e)
     {
    	 if(e.getSource()==bt2)
    	 {
    		try {
    			BufferedReader br=Client.demand("�����ļ�����");
    			String str=br.readLine();
    			System.out.println(str);
				if(str.equals("ͬ������")){
				Getfile a=new Getfile(Client.id);
					new Thread(a).start();
				}else{
					JOptionPane.showMessageDialog(null, "�Է��ܾ�����������ļ�����");
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("�ļ��������");
				e1.printStackTrace();
			}
    		
    	 }
    	 else if(e.getSource()==bt3)
    	 {
    		try {
    			BufferedReader br=Client.demand("�����ļ�����");
    			String str=br.readLine();
    			System.out.println(str);
				if(str.equals("ͬ������")){
					FileThread a=new FileThread(Client.id);
					new Thread(a).start();
				}else{
					JOptionPane.showMessageDialog(null, "�Է��ܾ�������ļ���������");
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("�ļ��������");
				e1.printStackTrace();
			}
    		
    	 }
    	 
    	 else if(e.getSource()==bt4){
    		 try {
				Client.demand("�ػ�"); 
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	 }
    	 else if(e.getSource()==bt5){
    		 try {
    			 
    			// bt4.setText("ȡ��");
    			 //bt4.setEnabled(true);
				Client.demand("����");
    			 
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	 }
    	 else if(e.getSource()==bt6){
    		 try {
				Client.demand("������");
				DOSThread a=new DOSThread(Client.id);
				new Thread(a).start();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		 
    	 }
     }
}
