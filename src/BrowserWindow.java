import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class BrowserWindow extends JFrame{

	private JTextField enterField;
	private JEditorPane contentsArea;
	
	public BrowserWindow()
	{
		super("Simple Web Browser");
		
		enterField = new JTextField("Enter field URL here");
		enterField.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						getThePage(e.getActionCommand());
					}
				});
		
		add(enterField,BorderLayout.NORTH);
		
		contentsArea = new JEditorPane();
		contentsArea.setEditable(false);
		contentsArea.addHyperlinkListener(
				new HyperlinkListener() {
					
					@Override
					public void hyperlinkUpdate(HyperlinkEvent e) {
						// TODO Auto-generated method stub
						if(e.getEventType()==HyperlinkEvent.EventType.ACTIVATED)
						{
							
							getThePage(e.getURL().toString());
						}
					}
				});
		
		add(new JScrollPane(contentsArea));
		
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void getThePage(String location)
	{
		try
		{
			contentsArea.setPage(location);
			enterField.setText(location);
		}
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(this,"Error retrieving specified URL","Bad URL",JOptionPane.ERROR_MESSAGE);
		}
	}	
}
