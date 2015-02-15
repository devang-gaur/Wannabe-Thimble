import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JEditorPane;

import java.awt.Frame;
import java.awt.event.KeyListener; //classes for Key events
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;


/**
 * 
 * @author DEVANG GAUR
 *
 */
public class LogicBase implements KeyListener{
	
	MainFrame frame;
	String location="C:\Users\DEVANG GAUR\Documents\GitHub\MorseCodeParser\MorseCodeParser\resources\TestFile.html";
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyPressed(KeyEvent event) {
		// TODO Auto-generated method stub
       if(event.getKeyCode()==KeyEvent.VK_ENTER)
       {
    	   getThePage(location);
       }
	}
	public void getThePage(String location)
	{
		frame = new MainFrame();
		try
		{
			frame.getOutputArea().setPage(location);
		}
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(null,"Error retrieving specified URL","Bad URL",JOptionPane.ERROR_MESSAGE);
		}
	}
}
