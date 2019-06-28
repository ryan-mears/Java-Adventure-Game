package package01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
//	ChoiceHandler cHandler = new ChoiceHandler(this);
	ChoiceHandler cHandler = new ChoiceHandler();
	UserInterface ui = new UserInterface();
	ScreenManager sm = new ScreenManager(ui);
	Location location = new Location(this, ui, sm);
			
	String nextLocation1, nextLocation2, nextLocation3, nextLocation4;
	
	public static void main(String[] args) {
		new Game();
	}

	public Game(){
		ui.createUI(cHandler);
		location.defaultSetup();
		sm.showTitleScreen();
	}
		
	public class ChoiceHandler implements ActionListener
	{
/*		Game game;
		
		public ChoiceHandler(Game g) {
			game = g;
		}
*/		
		public void actionPerformed(ActionEvent event)
		{
			String yourChoice = event.getActionCommand();
			
			switch(yourChoice)
			{
				case "start": 	sm.titleToStart(); location.newGame(); break;
				case "c1": 		location.selectLocation(nextLocation1);	break;
				case "c2": 		location.selectLocation(nextLocation2);	break;
				case "c3": 		location.selectLocation(nextLocation3);	break;
				case "c4": 		location.selectLocation(nextLocation4);	break;
			}
		}
	}
}
