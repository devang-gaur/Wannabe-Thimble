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
public class LogicBase extends KeyAdapter{
	
	MainFrame frame;
	ReadWriteLogic rwl = null;
	@Override
	public void keyTyped(KeyEvent event) {
		// TODO Auto-generated method stub
		if(event.getKeyCode()==KeyEvent.VK_ENTER)
	       {
	    	   getThePage();
	       }
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
    	   getThePage();
       }
	}
	public void getThePage()
	{
		frame = new MainFrame();
		try
		{
			rwl= new ReadWriteLogic();
			rwl.Write(frame.getInputArea());
			rwl.Read();
			frame.getOutputArea().setContentType("text/html");
			frame.getOutputArea().setText(rwl.getStr());
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error","Bad file",JOptionPane.ERROR_MESSAGE);
		}
	}
}

