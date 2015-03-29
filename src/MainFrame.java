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
   static JTextArea inputArea;
    JEditorPane outputArea;
   public MainFrame()
   {
	   
	   
	   //The Top panel . To instruct the user
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
       inputArea = new JTextArea("                 ");
       inputArea.setBounds(50, 70, 400, 450);
       inputArea.addKeyListener(new KeyListener() {
		
		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			outputArea.setText(getInputAreaText());
		}
		
		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	});
       
       
       inputArea.setEditable(true);  
       midWestPanel.add(midWestLabel,BorderLayout.NORTH);
       midWestPanel.add(inputArea,BorderLayout.SOUTH);
       midWestPanel.setBounds(30, 60,470,470);
       midPanel.add(midWestPanel,BorderLayout.WEST);
       
       
       //THE MID_EAST PANEL
       midEastPanel = new JPanel(); 
       midEastLabel= new JLabel("Result :");
       
       outputArea = new JEditorPane(); //JEDITORPANE TO DISPLAY HTML code .
       outputArea.setContentType("text/html");
       outputArea.setEditable(false);
       outputArea.setBounds(520, 70, 400, 450);
       outputArea.addHyperlinkListener( //THE HYPERLINK EVENT HANDLER TO OPEN ANY LINK IN THE OUTPUT AREA
				new HyperlinkListener() {
					
					@Override
					public void hyperlinkUpdate(HyperlinkEvent e) {
						// TODO Auto-generated method stub
						if(e.getEventType()==HyperlinkEvent.EventType.ACTIVATED)
						{
							new BrowserWindow().getThePage(e.getURL().toString());;
						}
					}
				});
       midEastPanel.add(midEastLabel,BorderLayout.NORTH);
       midEastPanel.add(outputArea,BorderLayout.SOUTH);
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
   
   public String getInputAreaText()
   {
	 return inputArea.getText();   
   }
   
   /*public JEditorPane getOutputArea()
   {
	   return outputArea;
   }*/
}
