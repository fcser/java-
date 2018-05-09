package action;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * 
 * @version :v1.0.0
 * @description :
 * @author: zym;
 * @date: 2017��10��31������2:49:48
 */
public class ClientUI extends JFrame implements MouseMotionListener ,MouseListener,MouseWheelListener ,KeyListener{
    private DataInputStream dis;//���ܱ����ƶ˷�����ͼƬ
    private ObjectOutputStream oos;//���Ϳ����¼�
    private static JLabel backImage;//ʹ��JLable��ʾͼƬ
    
    public ClientUI(DataInputStream dis, ObjectOutputStream oos,Socket img) {
        this();
        this.dis = dis;
        this.oos = oos;
        
    }
  
    public static void setImage()
    {
    	backImage=null;
    }
    /**
     * ����ͼƬ���ݸ��¿��ƶ˽���
     */
    public void update(byte[] imageData) {
        ImageIcon image = new ImageIcon(imageData);
        backImage.setIcon(image);
        this.repaint();
    }
   
    public void updateSize(Dimension client) {
        Dimension clientSize = client;
        Dimension frameSize = this.getSize();//��ȡ����ߴ�
        if (frameSize.height > clientSize.height) {
            frameSize.height = clientSize.height;
        }
        if (frameSize.width > clientSize.width) {
            frameSize.width = clientSize.width;
        }
        this.setLocation( (clientSize.width - frameSize.width) / 2, (clientSize.height - frameSize.height) / 2);//�������
        this.setVisible(true);
    }
 
    private ClientUI() {
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Զ�̼�ؿͻ���");
        setSize(1050, 800);
        backImage = new JLabel();
        JPanel pane = new JPanel();
        JScrollPane scrollPane = new JScrollPane(pane);
        pane.setLayout(new FlowLayout());
        pane.add(backImage);
        ChooseUI pane2=new ChooseUI();
        getContentPane().add(pane2, java.awt.BorderLayout.PAGE_START);
        getContentPane().add(scrollPane,java.awt.BorderLayout.CENTER);
        backImage.addKeyListener(this);
        backImage.addMouseListener(this);
        backImage.addMouseMotionListener(this);
        backImage.addMouseWheelListener(this);   
    }
    public void mouseDragged(MouseEvent e) {
    	sendEventObject(e);
    }

    public void mouseMoved(MouseEvent e) {
    	sendEventObject(e);
    }

    //--------------------------------------------------------------------------
    public void mouseClicked(MouseEvent e) {
        requestFocus();
    }

    public void mousePressed(MouseEvent e) {
    	sendEventObject(e);
    }

    public void mouseReleased(MouseEvent e) {
    	sendEventObject(e);
    }

    public void mouseEntered(MouseEvent e) {
    	sendEventObject(e);

    }

    public void mouseExited(MouseEvent e) {
    	sendEventObject(e);
    }

    //--------------------------------------------------------------------------

    public void mouseWheelMoved (MouseWheelEvent e){
    	sendEventObject(e);
    }

    //--------------------------------------------------------------------------

    public void keyTyped(KeyEvent e) {
    	sendEventObject(e);
    }

    public void keyPressed(KeyEvent e) {
    	sendEventObject(e);
    }

    public void keyReleased(KeyEvent e) {
    	sendEventObject(e);
    }
       
 
    //�����¼�
    private void sendEventObject(java.awt.event.InputEvent event) {
        try {
            oos.writeObject(event);
        } catch (Exception ef) {
            ef.printStackTrace();
        }
 
    }
    
 
    public Dimension getScreenSize() {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }




	public void dispose() {
		// TODO Auto-generated method stub
		//dispose();
	}
}
