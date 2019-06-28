package package01;

public class Location {
	
	Game game;
	UserInterface ui;
	ScreenManager sm;
	Player player = new Player();
	
	private static String direction;
	private static int mazeCount;

	
	private static boolean leaflet;
	private static boolean leafRead;
	private static boolean sword;
	private static boolean map;
	private static boolean stick;
	private static boolean boots;
	private static boolean parchment;
	private static boolean egg;
	private static boolean ruby;
	private static boolean scroll;
	private static boolean ring;
	private static boolean trophy;

	// Things we can manipulate

	private static boolean wornboots; // true if we are wearing the boots

	private static boolean door; // true if door is open
	private static boolean hedge; // true if hedge is done
	private static boolean torch; // true if torch is lit
	private static boolean serpent; // true if serpent is done
	private static boolean chest; // true if chest is done
	private static boolean fireplace; // true if fireplace is lit
	private static boolean magic; // non-null if magic invoked
	private static String exit; // non-null if in maze
	private static boolean roadrunner; // true if roadrunner is done
	private static boolean petunias; // true if petunias are done
	private static boolean giant; // true if giant is done
	
	public Location(Game g, UserInterface uInterface, ScreenManager sManager){
			game = g;
			ui = uInterface;
			sm = sManager;
	}
	
	public void defaultSetup() {
		player.playerHP = 10;
		ui.hpLabelNumber.setText("" + player.playerHP);		
		ui.weaponLabelName.setText("none");		
	}
	public void newGame()
	{
		direction = "Z";
		
		mazeCount = 0;
		
		leaflet		= false;
		leafRead	= false;
		sword		= false;
		map			= false;
		stick		= false;
		boots		= false;
		parchment	= false;
		egg			= false;
		ruby		= false;
		scroll		= false;
		ring		= false;
		trophy		= false;
		
		door 		= false;
		hedge 		= true;
		torch 		= false;
		serpent 	= false;
		chest 		= false;
		fireplace 	= false;
		magic 		= false;
		exit 		= null;
		roadrunner 	= false;
		petunias 	= false;
		giant 		= false;	
		openField();
	}
	//Locations
	public void selectLocation(String nextLocation) {
		switch(nextLocation) {
			case "1": 	openField(); 		break;
			case "2": 	forestPath(); 			break;
			case "3": 	house(); 	break;
			case "4": 	southBankPath(); 	break;
			case "5": 	southBank(); 		break;
			case "6": 	openMailbox(); 			break;
			case "7": 	takeLeaflet(); 	break;
			case "8": 	readLeaflet(); 	break;
			case "9": 	clearing(); 		break;
			case "10": 	cave(); 			break;
			case "11": 	maze(); 		break;
			case "12": 	maze1(); 			break;
			case "13": 	maze2(); 	break;
			case "14": 	maze3(); 	break;
			case "15": 	maze4(); 		break;
			case "16": 	bottom(); 			break;
			case "17": 	tree(); 	break;
			case "18": 	table(); 	break;
			case "19": 	getSword(); 		break;
			case "20": 	getStick(); 			break;
			case "21": 	touchFire(); 		break;
			case "22": 	lightStick(); 			break;
			case "23": 	killSerpent(); 	break;
			case "24": 	openChest(); 	break;
			case "25": 	lookBehindChest(); 		break;
			case "26": 	lookInHole(); 			break;
			case "27": 	takeItem(); 	break;
			case "28": 	examineFirePlace(); 	break;
			case "29": 	examineTinder(); 		break;
			case "30": 	readParchment(); 			break;
			case "31": 	lightFireplace(); 		break;
			case "32": 	getBoots(); 			break;
			case "33": 	getEgg(); 	break;
			case "34": 	throwEgg(); 	break;
			case "35": 	searchLeaves(); 		break;
			case "36": 	throwRuby(); 			break;
			case "37": 	learnSpell(); 	break;
			case "38": 	fightGiant(); 	break;
			case "39": 	chooseLeft(); 		break;
			case "40": 	chooseRight(); 			break;
			case "41": 	spellGiant(); 			break;
			case "42": 	none(); 			break;
			case "43": 	lose(); 			break;
			case "44": 	win(); 			break;
		}
	}
	
	//Locations
	public void openField()
	{
//		//position = "openField";
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(true);

			ui.mainTextArea.setText(	"You are standing in an open field west of a white house. The front door \n"
					+ 					"of the house is open. You hear a gurgling stream to the south, and a path\n"
					+ 					"leads north into a dense forest. There is a small mailbox in front of the \r\n" + 
										"house.");
		
		ui.choice1.setText("Go North");
		ui.choice2.setText("Go East");
		ui.choice3.setText("Go South");
		ui.choice4.setText("Open Mailbox");

		game.nextLocation1 = "2";
		game.nextLocation2 = "3";
		game.nextLocation3 = "4";
		game.nextLocation4 = "6";
	}
	
	public void forestPath()
	{
//		//position = "forestPath";
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(true);
		if(stick && hedge)
		{
			ui.mainTextArea.setText(	"You are on a forest path north of the field. A trail leads into a granite \n"
					+ 				"cave to the north. A small trail leads to the west.");
			ui.choice4.setVisible(false);
		}
		else if(hedge)
		{
			ui.mainTextArea.setText(	"You are on a forest path north of the field. A trail leads into a granite \n"
					+ 				"cave to the north. A small trail leads to the west. A hefty stick lies on \n"
					+ 				"the ground.");
			ui.choice4.setText("Pick Up Stick");
		}
		else if(stick)
		{
			ui.mainTextArea.setText(	"You are on a forest path north of the field. A trail leads into a granite \n"
					+ 				"cave to the north. A thick hedge blocks the way to the west.");
			ui.choice4.setVisible(false);
		}
		else
		{
			ui.mainTextArea.setText(	"You are on a forest path north of the field. A trail leads into a granite \n"
					+ 				"cave to the north. A thick hedge blocks the way to the west. A hefty stick lies on the ground.");
			ui.choice4.setText("Pick Up Stick");
		}
		ui.choice1.setText("Go North");
		ui.choice2.setText("Go West");
		ui.choice3.setText("Go South");
		
		game.nextLocation1 = "10"; 
		game.nextLocation2 = "9";	
		game.nextLocation3 = "1";
		game.nextLocation4 = "20";
	}


	public void house()
	{
//		//position = "house";
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(true);
		if(!fireplace && !sword) ui.mainTextArea.setText(	"You're in the house. The house's only furnishings are a plain \n"
						+ 					"wooden table, a single chair, and a fireplace on the north wall. \n"
						+ 					"The fireplace is unlit.\n"
						+ 					"An ornate sword hangs above the mantel.");	
		
		else if (!fireplace && sword) 
			{
				ui.mainTextArea.setText(	"You're in the house. The house's only furnishings are a plain \n"
						+ 				"wooden table, a single chair, and a fireplace on the north wall. \n"
						+ 				"The fireplace is unlit.");	
			}
		else if (fireplace && !sword) 
		{
			ui.mainTextArea.setText(	"You're in the house. The house's only furnishings are a \r\n" + 
									"plain wooden table, a single chair, and a fireplace on the\r\n" + 
									"north wall. The fireplace is lit, and crackling merrily. \r\n" + 
									"An ornate sword hangs above the mantel.");	
		}
		else
		{
			ui.mainTextArea.setText(	"You're in the house. The house's only furnishings are a \r\n" + 
					"plain wooden table, a single chair, and a fireplace on the\r\n" + 
					"north wall. The fireplace is lit, and crackling merrily.");	
		}
		ui.choice1.setText("Return to field");
		ui.choice2.setText("Examine fireplace");
		if (sword) ui.choice3.setVisible(false);
		ui.choice3.setText("Get sword");
		if (!fireplace || boots) ui.choice4.setVisible(false);
		ui.choice4.setText("Get boots");
		
		game.nextLocation1 = "1"; 
		game.nextLocation2 = "28";	
		game.nextLocation3 = "19";
		game.nextLocation4 = "42";
	}
	public void southBankPath()
	{
//		//position = "southBankPath";
		ui.choice2.setVisible(false);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		if(!boots)
		{
			ui.mainTextArea.setText(	"The stream is too difficult to cross without boots");	
		}
		else
		{
			ui.mainTextArea.setText("You hesitate for a moment, and then cross the stream. \r\n" + 
					"Every molecule in your body explodes at the speed of light.\r\n" + 
					"Well, okay, not really. You do get a little mud on you \r\n" + 
					"while climbing up the opposite bank, though. Yuck.");
		}
		ui.choice1.setText("Go Back");
		if(boots)
		{
			ui.choice2.setVisible(true);	
		}		
		ui.choice2.setText("Continue");
		
		game.nextLocation1 = "1"; 
		game.nextLocation2 = "5";	
		game.nextLocation3 = "42";
		game.nextLocation4 = "42";
	}
	
	public void southBank()
	{
//		//position = "southBank";
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		if(map) ui.mainTextArea.setText(	"You are on the southern bank of a wide stream. A path leads south\r\n" + 
										"into dense, dark forest. The forest is thick with old, gnarled trees\r\n" + 
										"and tangled masses of brambles, and precious little light pierces the\r\n" + 
										"thick canopy. If you go in there, you probably won't be able to find \n"
									+ 	"your way out again.");
		else ui.mainTextArea.setText(	"You are on the southern bank of a wide stream. A path leads south\r\n" + 
								"into dense, dark forest. The forest is thick with old, gnarled trees\r\n" + 
								"and tangled masses of brambles, and precious little light pierces the\r\n" + 
								"thick canopy. It will be almost impossible to navigate without a map..");
		ui.choice1.setText("Go Back");
		ui.choice2.setText("Go South");
		
		game.nextLocation1 = "4"; 
		game.nextLocation2 = "11";	
		game.nextLocation3 = "42";
		game.nextLocation4 = "42";
	}
	public void openMailbox()
	{
//		//position = "openMailbox";
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(false);
		if(leaflet)ui.choice3.setVisible(false);
		if(leaflet)	ui.mainTextArea.setText(	"You open the small mailbox. You see inside:\r\n" + 
				"nothing.");
		else ui.mainTextArea.setText(	"You open the small mailbox. You see inside:\r\n" + 
								"a leaflet.");	
		if(leafRead) {
			ui.choice2.setVisible(false); 
			ui.choice3.setVisible(false);
		}
		ui.choice1.setText("Return to field");
		ui.choice2.setText("Read leaflet");
		ui.choice3.setText("Get leaflet");
		
		game.nextLocation1 = "1"; 
		game.nextLocation2 = "8";	
		game.nextLocation3 = "7";
		game.nextLocation4 = "42";
	}
	public void takeLeaflet()
	{
//		//position = "takeLeaflet";
		leafRead = true; 
		leaflet = true;
		ui.choice2.setVisible(false);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		ui.mainTextArea.setText(	"You take the leaflet.");		
		ui.choice1.setText("Continue");
		
		game.nextLocation1 = "8"; 
		game.nextLocation2 = "42";	
		game.nextLocation3 = "42";
		game.nextLocation4 = "42";
	}
	public void readLeaflet()
	{
		//position = "readLeaflet";
		ui.choice2.setVisible(false);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		if(leaflet) ui.mainTextArea.setText(	"It's an advertisement for a game called \"Adventure\". \n"
								+ 			"Meh, you throw the leaflet away.");
		else ui.mainTextArea.setText(	"Pretty hard to do when the leaflet is still in the mailbox.");	
		ui.choice1.setText("Continue");
		
		if(leafRead) {
			leafRead = true; 		
			game.nextLocation1 = "1";	
		}
		else {
			game.nextLocation1 = "6";
		}		 
		game.nextLocation2 = "42";	
		game.nextLocation3 = "42";
		game.nextLocation4 = "42";
	}
	public void clearing()
	{
//		//position = "clearing";
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(false);
		ui.mainTextArea.setText(	"You're in a clearing west of the forest path. There is a huge, crackling \n"
				+ 				"bonfire here.");		
		ui.choice1.setText("Go Back");
		ui.choice2.setText("Touch Fire");
		if(torch || !stick) ui.choice3.setVisible(false);
		ui.choice3.setText("Light Stick");	
		
		game.nextLocation1 = "2"; 
		game.nextLocation2 = "21";	
		game.nextLocation3 = "22";
		game.nextLocation4 = "42";
	}
	public void cave()
	{
//		//position = "cave";
		ui.choice2.setVisible(false);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		if(!torch) 
		{	
			ui.mainTextArea.setText(	"You're in a dark and dank cave.");	
		}
		else if(!serpent)
		{
			ui.mainTextArea.setText(	"You're in a dark and dank cave. A treasure chest sits near\r\n" + 
					"the rear wall, with a dangerous-looking serpent coiled \r\n" + 
					"around it.");	
			ui.choice2.setVisible(true);
			ui.choice3.setVisible(true);
			ui.choice4.setVisible(true);
		}
		else if(!chest)
		{
			ui.mainTextArea.setText(	"You're in a dark and dank cave. A treasure chest sits near\r\n" + 
					" the rear wall, surrounded by hacked-up serpent bits.");	
			ui.choice2.setVisible(true);
			ui.choice3.setVisible(false);
			ui.choice4.setVisible(true);
		}
		else
		{
			ui.mainTextArea.setText(	"You're in a dark and dank cave. A treasure chest sits near\r\n" + 
					" the rear wall, surrounded by hacked-up serpent bits.");
			ui.choice2.setVisible(true);
			ui.choice3.setVisible(false);
			ui.choice4.setVisible(true);
		}
		if(map) ui.choice4.setVisible(false);
		ui.choice1.setText("Go back");
		ui.choice2.setText("Open Chest");
		ui.choice3.setText("Kill Serpent");
		ui.choice4.setText("Look behind Chest");
		
		game.nextLocation1 = "2"; 
		game.nextLocation2 = "24";
		if(sword) { 
			serpent = true;
			game.nextLocation3 = "23";
		}
		game.nextLocation4 = "25";
	}
	public void maze()
	{
//		//position = "maze";
		ui.choice2.setVisible(false);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		if(!map)
		{
			ui.mainTextArea.setText(	"You get lost, but manage to retrace your steps back to the entrance.");	
		}
		else
		{
			ui.mainTextArea.setText("You buck up your courage, and stride bravely into the forest.");
		}
		if(map)
		{
			ui.choice1.setVisible(false);
			ui.choice2.setVisible(true);	
		}
		ui.choice1.setText("Go Back");
		ui.choice2.setText("Continue");
		
		game.nextLocation1 = "5"; 
		game.nextLocation2 = "12";	
		game.nextLocation3 = "42";
		game.nextLocation4 = "42";
	}
	public void maze1()
	{
		//position = "maze1";
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(true);
		ui.mainTextArea.setText(	"You are in a maze of twisty little forest paths, all alike.\r\n" + 
								"Gaps in the dense, forbidding foliage lead west, south, \r\n" + 
								"and east.");	
		ui.choice1.setText("Go North");
		ui.choice2.setText("Go East");
		ui.choice3.setText("Go South");
		ui.choice4.setText("Go West");
		
		game.nextLocation1 = "10"; 
		game.nextLocation2 = "13";	
		game.nextLocation3 = "13";
		game.nextLocation4 = "13";
	}
	public void maze2()
	{
		//position = "maze2";
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(true);
		mazeCount++;
		
//		if(game.nextLocation1 == "11") direction = "N";
		if(direction == "N") ui.mainTextArea.setText(	"You push north through the thorns and branches. At least,\r\n" + 
				" you think that's the way you went.\r\n" + 
				"\r\n" + 
				"You are in a maze of twisty little forest paths, all alike.\r\n" + 
				" Gaps in the dense, forbidding foliage lead west, south, \r\n" + 
				"and east.");	
		else if(direction == "E") ui.mainTextArea.setText(	"You push east through the thorns and branches. At least,\r\n" + 
				" you think that's the way you went.\r\n" + 
				"\r\n" + 
				"You are in a maze of twisty little forest paths, all alike.\r\n" + 
				" Gaps in the dense, forbidding foliage lead west, south, \r\n" + 
				"and east.");	
			else if(direction == "S") ui.mainTextArea.setText(	"You push south through the thorns and branches. At least,\r\n" + 
					" you think that's the way you went.\r\n" + 
					"\r\n" + 
					"You are in a maze of twisty little forest paths, all alike.\r\n" + 
					" Gaps in the dense, forbidding foliage lead west, south, \r\n" + 
					"and east.");	
		else  ui.mainTextArea.setText(	"You push west through the thorns and branches. At least,\r\n" + 
				" you think that's the way you went.\r\n" + 
				"\r\n" + 
				"You are in a maze of twisty little forest paths, all alike.\r\n" + 
				" Gaps in the dense, forbidding foliage lead west, south, \r\n" + 
				"and east.");	
		ui.choice1.setText("Go North");
		ui.choice2.setText("Go East");
		ui.choice3.setText("Go South");
		ui.choice4.setText("Go West");
		
		if(mazeCount<5) {
			game.nextLocation1 = "13";
			game.nextLocation2 = "13";	
			game.nextLocation3 = "13";
			game.nextLocation4 = "13";
		}
		else {
			game.nextLocation1 = "14";
			game.nextLocation2 = "14";	
			game.nextLocation3 = "14";
			game.nextLocation4 = "14";
		}
	}
	public void maze3()
	{
		//position = "maze3";
		ui.choice2.setVisible(false);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		if(direction == "N") ui.mainTextArea.setText(	"You push north through the thor...\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"All right, by now you're probably as sick of this stupid \r\n" + 
				"maze as I am. Let's skip ahead a bit.\r\n" + 
				"You stumble out of the dense forest into a clearing.");	
		else if(direction == "E") ui.mainTextArea.setText(	"You push east through the thor...\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"All right, by now you're probably as sick of this stupid \r\n" + 
				"maze as I am. Let's skip ahead a bit.\r\n" + 
				"You stumble out of the dense forest into a clearing.");	
			else if(direction == "S") ui.mainTextArea.setText(	"You push south through the thor...\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"All right, by now you're probably as sick of this stupid \r\n" + 
					"maze as I am. Let's skip ahead a bit.\r\n" + 
					"You stumble out of the dense forest into a clearing.");	
		else  ui.mainTextArea.setText(	"You push west through the thor...\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"All right, by now you're probably as sick of this stupid \r\n" + 
				"maze as I am. Let's skip ahead a bit.\r\n" + 
				"You stumble out of the dense forest into a clearing.");			
		ui.choice1.setText("Continue");
		
		game.nextLocation1 = "16"; 
		game.nextLocation2 = "42";	
		game.nextLocation3 = "42";
		game.nextLocation4 = "42";
	}
	public void maze4()
	{
		//position = "maze4";
		ui.choice2.setVisible(false);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		ui.mainTextArea.setText(	"Ugh, on second thought, lets not go back into the maze.");		
		ui.choice1.setText("Go Back");
		
		game.nextLocation1 = "16"; 
		game.nextLocation2 = "42";	
		game.nextLocation3 = "42";
		game.nextLocation4 = "42";
	}
	public void bottom()
	{
		//position = "bottom";
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(false);
		ui.mainTextArea.setText(	"You stumble out of the dense forest into a clearing, with a particularly \n"
				+ 				"tall tree growing in the middle of it. On the ground, you see a pile of \n"
				+ 				"leaves.");		
		if(ruby) ui.choice4.setVisible(true);
		if(scroll) ui.choice4.setVisible(false);
		ui.choice1.setText("Go Back");
		ui.choice2.setText("Climb Tree");
		ui.choice3.setText("Examine Leaves");
		ui.choice4.setText("Throw Ruby");
		
		game.nextLocation1 = "15"; 
		game.nextLocation2 = "17";	
		game.nextLocation3 = "35";
		game.nextLocation4 = "36";
	}
	public void tree()
	{
		//position = "tree";
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(false);
		ui.mainTextArea.setText(	"You hoist yourself into the lower branches of the tree and start climbing. \n"
				+ 				"It's a long and difficult climb, and eventually you're forced to stop and \n"
				+ 				"rest. This tree is unusually tall -- you can't even see the forest floor \n"
				+ 				"any more, as you've climbed above the canopy. There are several other \n"
				+ 				"things to see here, though: a nearby branch holds a small bird's nest, \n"
				+ 				"which contains a large egg encrusted with precious jewels; a soccer ball \n"
				+ 				"is wedged in the branches out of your reach, with a roadrunner perched \n"
				+ 				"on it, holding a large ruby in its beak; and there is a bowl of petunias, \n"
				+ 				"also out of reach, with what looks like a scroll entangled in the flowers...");		
		
		if(egg || ruby || roadrunner) ui.choice3.setVisible(false);
		if(egg) ui.choice4.setVisible(true);
		ui.choice1.setText("Climb Down");
		ui.choice2.setText("Climb Up");
		ui.choice3.setText("Take Egg");
		ui.choice4.setText("Throw Egg at Roadrunner");
		
		game.nextLocation1 = "16"; 
		game.nextLocation2 = "18";	
		game.nextLocation3 = "33";
		game.nextLocation4 = "34";
	}
	public void table()
	{
		//position = "table";
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(true);
		ui.mainTextArea.setText(	"You eventually reach the top of the tree, and discover to your surprise \n"
				+ 				"that it serves as one leg of a massive table. You carefully crawl over \n"
				+ 				"the edge of the tabletop and look around in amazement.\r\n" 
				+ 				"This massive table is laid out for a light meal of epic proportions. \n"
				+ 				"The Giant himself is watching you intently, with his chin in his hands. \n"
				+ 				"\"How about a guessing game?\" he asks. The Giant sets two shot glasses, \n"
				+ 				"left is filled with a green, pungent liquid. The one on the right is a \n"
				+ 				"hissing red liquid. \"One is poison and one is not,\" says the Giant. \n"
				+ 				"\"Guess RIGHT and I'll return you home.\"");		
		ui.choice1.setText("Attack Giant with Sword");
		ui.choice2.setText("Choose Left");
		ui.choice3.setText("Choose Right");
		if(!magic) ui.choice4.setVisible(false);
		ui.choice4.setText("Cast 'Presto Chango'!");
		
		game.nextLocation1 = "38"; 
		game.nextLocation2 = "39";	
		game.nextLocation3 = "40";
		game.nextLocation4 = "41";
	}
	
	//Actions
	public void getSword()
	{
		//position = "getSword";
		sword = true;
		ui.choice2.setVisible(false);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		ui.mainTextArea.setText(	"You take the sword.");	
		ui.weaponLabelName.setText("Sword");
		ui.choice1.setText("Continue");
		
		game.nextLocation1 = "3"; 
		game.nextLocation2 = "42";	
		game.nextLocation3 = "42";
		game.nextLocation4 = "42";
	}
	public void getStick()
	{
		//position = "getStick";
		ui.mainTextArea.setText("You pick up the stick.");	
		stick = true; 
		ui.choice2.setVisible(false);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		
		ui.choice1.setText("Continue");
		
		game.nextLocation1 = "2"; 
		game.nextLocation2 = "42";	
		game.nextLocation3 = "42";
		game.nextLocation4 = "42";
	}
	public void touchFire()
	{
		//position = "touchFire";
		ui.choice2.setVisible(false);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		ui.mainTextArea.setText("You confirm that fire is indeed hot.\n"
				+			 "You lose 3 HP.");	
		player.playerHP = player.playerHP - 3;
		ui.hpLabelNumber.setText(""+ player.playerHP);	
		ui.choice1.setText("Continue");
		
		if(player.playerHP < 1) game.nextLocation1 = "43"; 
		else game.nextLocation1 = "9";
		game.nextLocation2 = "42";	
		game.nextLocation3 = "42";
		game.nextLocation4 = "42";
	}
	public void lightStick()
	{
		//position = "lightStick";
		torch = true;
		ui.choice2.setVisible(false);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		ui.mainTextArea.setText(	"You hold the stick in the flames until it lights. Voila! A torch!");		
		ui.choice1.setText("Continue");
		
		game.nextLocation1 = "9"; 
		game.nextLocation2 = "42";	
		game.nextLocation3 = "42";
		game.nextLocation4 = "42";
	}
	public void killSerpent()
	{
		//position = "killSerpent";
		ui.choice2.setVisible(false);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		if (sword) ui.mainTextArea.setText(	"Your sword makes quick work of the serpent.");		
		else 
		{
			ui.mainTextArea.setText(	"You attempt to fight the snake bare-handed, \n"
								+ 	"the serpent lashes out at you and bites your hand.\n"
								+	"You lose 3 HP.");	
			player.playerHP = player.playerHP - 3;
			ui.hpLabelNumber.setText(""+player.playerHP);
		}
			ui.choice1.setText("Continue");
			
			if(player.playerHP < 1) game.nextLocation1 = "43"; 
			else game.nextLocation1 = "10";
			game.nextLocation2 = "42";	
			game.nextLocation3 = "42";
			game.nextLocation4 = "42";
	}
	public void openChest()
	{
		//position = "openChest";
		ui.choice2.setVisible(false);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		if(!serpent) 
		{	
			ui.mainTextArea.setText(	"As you reach out for the chest, the serpent lashes out at you and bites \n"
										+ 	"your hand.\n"
										+	"You lose 3 HP.");
			player.playerHP = player.playerHP - 3;
			ui.hpLabelNumber.setText(""+ player.playerHP);
		}
		if(chest) ui.mainTextArea.setText(	"You open the chest, and see that it is empty.");
		else ui.mainTextArea.setText(	"You open the chest, and remove the glorious treasure from within.");		
		
		ui.choice1.setText("Continue");
		
		if(player.playerHP < 1) game.nextLocation1 = "43"; 
		else game.nextLocation1 = "10";
		game.nextLocation2 = "42";	
		game.nextLocation3 = "42";
		game.nextLocation4 = "42";
	}
	public void lookBehindChest()
	{
		//position = "lookBehindChest";
		ui.choice2.setVisible(false);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		if(!serpent)
		{	
			ui.mainTextArea.setText(	"As you approach the chest, the serpent lashes out at you and bites \n"
								+ 	"your hand.\n"
								+	"You lose 3 HP.");
			player.playerHP = player.playerHP - 3;
			ui.hpLabelNumber.setText(""+ player.playerHP);
		}	
		else ui.mainTextArea.setText(	"You discover a tiny hole in the wall behind the chest.");			
		ui.choice1.setText("Go Back");
		if(serpent) ui.choice2.setVisible(true);
		ui.choice2.setText("Look in hole");
		
		if(player.playerHP < 1) game.nextLocation1 = "43"; 
		else game.nextLocation1 = "10";
		game.nextLocation2 = "26";	
		game.nextLocation3 = "42";
		game.nextLocation4 = "42";
	}
	public void lookInHole()
	{
		//position = "lookInHole";
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		ui.mainTextArea.setText(	"You find a map in the hole!");		
		ui.choice1.setText("Take map");
		ui.choice2.setText("Leave map");
		
		game.nextLocation1 = "27"; 
		game.nextLocation2 = "10";	
		game.nextLocation3 = "42";
		game.nextLocation4 = "42";
	}
	public void takeItem()
	{
		//position = "takeItem";
		map = true;
		ui.choice2.setVisible(false);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		ui.mainTextArea.setText(	"You take the map from the hole. Looks like a map of a maze.");		
		ui.choice1.setText("Continue");
		
		game.nextLocation1 = "10"; 
		game.nextLocation2 = "42";	
		game.nextLocation3 = "42";
		game.nextLocation4 = "42";
	}
	public void examineFirePlace()
	{
		//position = "examineFirePlace";
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(true);
		if(!fireplace) ui.mainTextArea.setText(	"The fireplace is stacked with dry firewood and tinder, ready for lighting. \n"
				+ 				"A carved driftwood bird sits on the mantel.");	
		else ui.mainTextArea.setText(	"The fireplace is lit, and crackling merrily.");	
		ui.choice1.setText("Go back");
		if(fireplace) ui.choice3.setVisible(false);		
		ui.choice2.setText("Examine tinder");
		ui.choice3.setText("Light fireplace");
		if (!fireplace || boots) ui.choice4.setVisible(false);
		ui.choice4.setText("Get boots");
		
		game.nextLocation1 = "3"; 
		game.nextLocation2 = "29";	
		game.nextLocation3 = "31";
		game.nextLocation4 = "32";
	}
	public void examineTinder()
	{
		//position = "examineTinder";
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		if (fireplace) ui.mainTextArea.setText(	"Whatever was in there was reduced to ash.");				
		else if (parchment) ui.mainTextArea.setText(	"Just some dry wood and tinder.");				
		else ui.mainTextArea.setText(	"Bits of torn and wadded newspaper. Wait, what's that? \r\n" + 
								"You fish a piece of crumpled parchment out of the \r\n" + 
								"fireplace.");		
		if (fireplace) ui.choice2.setVisible(false);
		else ui.choice1.setVisible(false);
		ui.choice1.setText("Go Back");
		ui.choice2.setText("Read Parchment");
		
		game.nextLocation1 = "28"; 
		if(parchment) 	game.nextLocation2 = "28";
		else { 
			parchment = true; 
			game.nextLocation2 = "30";
		}
		game.nextLocation3 = "42";
		game.nextLocation4 = "42";
	}
	public void readParchment()
	{
		//position = "readParchment";
		parchment = true;
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(false);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		ui.mainTextArea.setText(	"It appears to be a scroll for a spell called 'presto chango'. \n"
				+ 				"But the magic in this scroll is all used up.");		
		ui.choice1.setText("Continue");
		
		game.nextLocation1 = "28"; 
		game.nextLocation2 = "42";	
		game.nextLocation3 = "42";
		game.nextLocation4 = "42";
	}
	public void lightFireplace()
	{
		//position = "lightFireplace";
		fireplace = true;
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(false);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		ui.mainTextArea.setText(	"You poke your torch into the fireplace until it catches. \n"
				+ 				"Soon a blazing fire lights up the shadowy corners of the room, \n"
				+ 				"revealing a pair of large boots.");
		ui.choice1.setText("Continue");
		
		game.nextLocation1 = "28"; 
		game.nextLocation2 = "42";	
		game.nextLocation3 = "42";
		game.nextLocation4 = "42";
	}
	public void getBoots()
	{
		//position = "getBoots";
		boots = true;
		ui.choice2.setVisible(false);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		ui.mainTextArea.setText(	"With some difficulty, you strap on the boots. Hydrophobic!");		
		ui.choice1.setText("Continue");
		
		game.nextLocation1 = "28"; 
		game.nextLocation2 = "42";	
		game.nextLocation3 = "42";
		game.nextLocation4 = "42";
	}
	public void getEgg()
	{
		//position = "getEgg";
		egg = true;
		ui.choice2.setVisible(false);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		ui.mainTextArea.setText(	"You have to stretch to reach it, but you manage to get the \n"
				+ 				"egg without losing your grip on the tree.");		
		ui.choice1.setText("Continue");
		
		game.nextLocation1 = "17"; 
		game.nextLocation2 = "42";	
		game.nextLocation3 = "42";
		game.nextLocation4 = "42";
	}
	public void throwEgg()
	{
		//position = "throwEgg";
		egg = false;
		ui.choice2.setVisible(false);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		ui.mainTextArea.setText(	"You take careful aim, and pitch the egg at the roadrunner.\r\n" + 
								"It flaps out of the way with a squawk, dropping the ruby,\r\n" + 
								"which plummets past you.");		
		ui.choice1.setText("Continue");
		
		game.nextLocation1 = "17"; 
		game.nextLocation2 = "42";	
		game.nextLocation3 = "42";
		game.nextLocation4 = "42";
	}
	public void searchLeaves()
	{
		//position = "searchLeaves";
		ui.choice2.setVisible(false);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		if(roadrunner && !ruby && !petunias) ui.mainTextArea.setText(	"You dig around in the leaves, and find a large ruby, which\r\n" + 
								" you pick up.");	
		else ui.mainTextArea.setText(	"You dig around in the leaves, but don't find anything.");	
		
		ui.choice1.setText("Continue");
		
		if(roadrunner) {
			ruby = true; 			
		}
		game.nextLocation1 = "16"; 
		game.nextLocation2 = "42";	
		game.nextLocation3 = "42";
		game.nextLocation4 = "42";
	}
	public void throwRuby()
	{
		//position = "throwRuby";
		ui.choice2.setVisible(false);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		petunias = true; 
		ruby = false;
		ui.mainTextArea.setText(	"You carefully lob the ruby into the bowl -- two points! \r\n" + 
								"The roadrunner flaps excitedly up to the bowl and scrabbles\r\n" + 
								"around in it for the ruby, knocking the scroll out of it \r\n" + 
								"in the process, and then flies away. You snatch the scroll\r\n" + 
								"out of the air as it flutters down.");		
		ui.choice1.setText("Continue");
		
		game.nextLocation1 = "37"; 
		game.nextLocation2 = "42";	
		game.nextLocation3 = "42";
		game.nextLocation4 = "42";
	}
	public void learnSpell()
	{
		//position = "learnSpell";
		scroll = true;
		ui.choice2.setVisible(false);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		if(parchment) ui.mainTextArea.setText(	"You copy 'Presto Chango' onto the scroll. \nYou can now use the spell!");		
		else ui.mainTextArea.setText(	"Seems to be a blank piece of paper, but you can feel something \n"
				+ 					"magical about it...");		
		ui.choice1.setText("Continue");
		
		if(parchment) {
			magic = true; 
		}
		game.nextLocation1 = "16";
		game.nextLocation2 = "42";	
		game.nextLocation3 = "42";
		game.nextLocation4 = "42";
	}
	public void fightGiant()
	{
		//position = "fightGiant";
		ui.choice2.setVisible(false);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		ui.mainTextArea.setText(	"You have no time for silly games! \n"
				+ 				"You gallantly unsheath your sword to slay this monster.\n"
				+ 				"The giant responds by squashing you with its enormous fists, \n"
				+ 				"and you die, \n"
				+ 				"oh so gallantly.");		
		ui.choice1.setText("Continue");
		
		game.nextLocation1 = "43";
		game.nextLocation2 = "42";	
		game.nextLocation3 = "42";
		game.nextLocation4 = "42";
	}
	public void chooseLeft()
	{
		//position = "chooseLeft";
		ui.choice2.setVisible(false);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		ui.mainTextArea.setText(	"Ha! You won't fall for that trick. You drink the green liquid.");		
		ui.choice1.setText("Continue");
		
		game.nextLocation1 = "43";
		game.nextLocation2 = "42";	
		game.nextLocation3 = "42";
		game.nextLocation4 = "42";
	}
	public void chooseRight()
	{
		//position = "chooseRight";
		ui.choice2.setVisible(false);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		ui.mainTextArea.setText(	"Aha! I get it! \n"
				+ 				"Choose \"Right\". \n\n"
				+ 				"You feel so clever while you drink the red liquid.");		
		ui.choice1.setText("Continue");
		
		game.nextLocation1 = "43";
		game.nextLocation2 = "42";	
		game.nextLocation3 = "42";
		game.nextLocation4 = "42";
	}
	public void spellGiant()
	{
		//position = "spellGiant";
		ui.choice2.setVisible(false);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		ui.mainTextArea.setText(	"You cast 'Presto Chango' at the Giant. With a loud POP, he turns \r\n" + 
								"into a huge fat toad, as tall as yourself. "
							+ 	"\"RIBBIT!\" "
							+ 	"it rumbles angrily, then hops away, knocking over the glasses.");		
		ui.choice1.setText("Continue");
		
		game.nextLocation1 = "44";
		game.nextLocation2 = "42";	
		game.nextLocation3 = "42";
		game.nextLocation4 = "42";
	}
	public void none()
	{
		//position = "none";
		ui.mainTextArea.setText(	"How did this happen? You're not supposed to be here.");		
		ui.choice1.setText("Go Back to Field");
		ui.choice2.setVisible(false);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		
		game.nextLocation1 = "1";
		game.nextLocation2 = "42";	
		game.nextLocation3 = "42";
		game.nextLocation4 = "42";
	}
	public void win(){
//		position = "win";
		
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		ui.mainTextArea.setText("Congratulations!\nYou are a winner!\n\nGame Over");
		
		ui.choice1.setText("Restart?");
		ui.choice2.setText("Quit");
		
		game.nextLocation1 = "1";
		game.nextLocation2 = "42";	
		game.nextLocation3 = "42";
		game.nextLocation4 = "42";
	}
	public void lose(){
//		position = "lose";
		ui.choice1.setVisible(true);
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		ui.mainTextArea.setText("Congratulations!\nYou are dead!\n\nGame Over");
		
		ui.choice1.setText("Restart?");
		ui.choice2.setText("Quit");
		
		game.nextLocation1 = "1";
		game.nextLocation2 = "42";	
		game.nextLocation3 = "42";
		game.nextLocation4 = "42";
	}
}
