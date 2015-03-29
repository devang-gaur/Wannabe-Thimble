import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**
 * 
 * @author DEVANG GAUR
 *
 */
public class MainFrame extends JFrame {
	
   JPanel topPanel ,midPanel ,midWestPanel, midEastPanel, bottomPanel;
   JLabel topLabel,midWestLabel,midEastLabel,bottomLabel;
   final JTextArea inputArea;
   JEditorPane outputArea;
   LogicBase logic;
   public MainFrame()
   {
	   topPanel = new JPanel();
	   topPanel.setBounds(50,20,900, 50);
	   topLabel=new JLabel("Type your html code on the left screen and see what you get on the right one.");
       topPanel.add(topLabel,BorderLayout.CENTER);
       
       add(topPanel,BorderLayout.NORTH);
       //Mid panel : contains Mid east and mid west panel
       midPanel = new JPanel();
       //Mid west Panel
       midWestPanel = new JPanel();
       midWestLabel = new JLabel("Enter your HTML code here:");
       inputArea = new JTextArea("Yo");
       inputArea.setBounds(50, 70, 400, 450);
       inputArea.addKeyListener(new LogicBase());
       inputArea.setEditable(true);  
       midWestPanel.add(midWestLabel,BorderLayout.NORTH);
       midWestPanel.add(new JScrollPane(inputArea),BorderLayout.SOUTH);
       midWestPanel.setBounds(30, 60,470,470);
       midPanel.add(midWestPanel,BorderLayout.WEST);
       
       //THE MID_EAST PANEL
       midEastPanel = new JPanel(); 
       midEastLabel= new JLabel("Result :");
       
       outputArea = new JEditorPane(); //JEDITORPANE TO DISPLAY HTML code .
       outputArea.setEditable(false);
       outputArea.setBounds(520, 70, 400, 450);
       outputArea.addHyperlinkListener(
				new HyperlinkListener() {
					
					@Override
					public void hyperlinkUpdate(HyperlinkEvent e) {
						// TODO Auto-generated method stub
						if(e.getEventType()==HyperlinkEvent.EventType.ACTIVATED)
						{
							BrowserWindow bw = new BrowserWindow();
							bw.getThePage(e.getURL().toString());
						}
					}
				});
       midEastPanel.add(midEastLabel,BorderLayout.NORTH);
       midEastPanel.add(new JScrollPane(outputArea),BorderLayout.SOUTH);
       midWestPanel.setBounds(500, 60,470,470);
       midPanel.add(midEastPanel, BorderLayout.EAST);
       
       add(midPanel,BorderLayout.CENTER);
       
       
       
       //The bottom panel to display info on upcoming features
       bottomPanel = new JPanel();
       bottomPanel.setSize(900,130);
       bottomLabel = new JLabel("...will add CSS compatibility soon.");
       bottomPanel.add(bottomLabel,BorderLayout.CENTER);
       add(bottomPanel,BorderLayout.SOUTH);
   }
   
   public JTextArea getInputArea()
   {
	 return inputArea;   
   }
   
   public JEditorPane getOutputArea()
   {
	   return outputArea;
   }
}
