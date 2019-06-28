package package01;

public class ScreenManager {

	UserInterface ui;
	
	public ScreenManager(UserInterface screen) {
		ui = screen;
	}
	public void showTitleScreen() {		
		//Show title screen
		ui.titleNamePanel.setVisible(true);
		ui.startButtonPanel.setVisible(true);
		
		//Hide game screen
		ui.mainTextPanel.setVisible(false);
		ui.choiceButtonPanel.setVisible(false);
		ui.playerPanel.setVisible(false);
	}
	public void titleToStart() {
		//Hide title screen
		ui.titleNamePanel.setVisible(false);
		ui.startButtonPanel.setVisible(false);
		
		//Hide game screen
		ui.mainTextPanel.setVisible(true);
		ui.choiceButtonPanel.setVisible(true);
		ui.playerPanel.setVisible(true);
	}
}
