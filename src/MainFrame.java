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
   JTextArea inputArea;
   JEditorPane outputArea;
   LogicBase logic;
   public MainFrame()
   {
	   topPanel = new JPanel();
	   topLabel.setText("Type your html code on the left screen and see what you get on the right one.");
       topPanel.add(topLabel,BorderLayout.CENTER);
       
       add(topPanel,BorderLayout.NORTH);
       
       midPanel = new JPanel();
       
       midWestPanel = new JPanel();
       midWestLabel = new JLabel("Enter your HTML code here:");
       inputArea = new JTextArea();
       
       inputArea.addKeyListener(
    		
				 new LogicBase()
				   );
       inputArea.setEditable(true);
       midWestPanel.add(midWestLabel,BorderLayout.NORTH);
       midWestPanel.add(inputArea,BorderLayout.CENTER);
       
       midPanel.add(midWestPanel,BorderLayout.WEST);
       
       midEastPanel = new JPanel(); 
       midEastLabel= new JLabel("Result :");
       outputArea = new JEditorPane();
       outputArea.setEditable(false);
       midEastPanel.add(midEastLabel,BorderLayout.NORTH);
       midEastPanel.add(outputArea,BorderLayout.CENTER);
       
       midPanel.add(midEastPanel, BorderLayout.EAST);
       
       add(midPanel,BorderLayout.CENTER);
       
       
       bottomPanel = new JPanel();
       bottomLabel = new JLabel("...will add CSS compatibility soon.");
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
