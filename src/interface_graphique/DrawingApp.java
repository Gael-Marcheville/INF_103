package interface_graphique;

import javax.swing.* ;

public class DrawingApp extends JFrame
{
	private final DrawingMenuBar drawingMenuBar ;
	
	public DrawingApp()
	{
		super("Drawing Application") ;
		
		setJMenuBar(drawingMenuBar = new DrawingMenuBar(this)) ;
		
		// Window content creation

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ; 
		pack() ;
		setVisible(true) ;
	}

}
