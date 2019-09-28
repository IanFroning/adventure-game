package coloradocollege.ifroning;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * The frame in which the game is played - contains an input field and an output area.
 * @author Ian Froning
 * @version 1.0
 */
public class GameFrame extends JFrame
{
	private static final int FRAME_WIDTH = 600;
	private static final int FRAME_HEIGHT = 500;
	
	private static final int AREA_ROWS = 10;
	private static final int AREA_COLUMNS = 30;
	
	private JScrollPane outPane;
	private JTextArea outArea;
	private JTextField inField;
	
	private Player player;
		
	/**
	 * Constructs a game frame with a greeting and adds a player to it.
	 * @param greeting the message that will be displayed when the game starts, before the initial location description
	 * @param thePlayer the player
	 */
	public GameFrame(String greeting, Player thePlayer)
	{
		// Sets the player
		player = thePlayer;
		
		// Sets up output area
		outArea = new JTextArea(AREA_ROWS, AREA_COLUMNS);
		outArea.setEditable(false);
		outArea.setLineWrap(true);
		outArea.setWrapStyleWord(true);
		outArea.append(greeting + "\n\n\n"); // Adds greeting
		outArea.append(player.getLocation().getDescription()); // Adds initial location
		this.add(outArea, BorderLayout.CENTER);
		
		// Enables scrolling
		outPane = new JScrollPane(outArea);
		this.add(outPane);
		
		// Sets up input field
		inField = new JTextField(AREA_COLUMNS);
		ActionListener listener = new InputListener();
		inField.addActionListener(listener); // Adds listener
		this.add(inField, BorderLayout.SOUTH);
		outArea.setCaretPosition(outArea.getDocument().getLength()); // Autoscrolling
		
		// Sets up frame
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Chapter 1: A New Beginning");
		this.setVisible(true);	
	}
	
	// Sets up listener
	class InputListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
	       if (!player.getLocation().isFinalLocation()) // Checks whether the player is at the final location (the one the game ends in)
	       {
	    	   	// Gets player inputs
	    	   	String input = inField.getText();
		        outArea.append("\n> " + input + "\n\n");
		        inField.setText("");
		        
		        // Sends inputs to interpreter and adds whatever that returns to the output area
		        Command command = new Command(player, input);
		        outArea.append(command.interpret());
	       }
	       else
	    	   inField.setEditable(false); // Disallows further input if the player has reached the final location
		}
	}
	
}
