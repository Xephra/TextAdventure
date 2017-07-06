
class Game
{
    
	private Parser parser;
    private Player player;
    //private AsciiMap map;
    private Inventory playerInventory;
    private Item coal;
    private Item ironore;
    private Item goldore;
    private Item platinumore;
    private Item uraniumore;
    private Item pickaxe;
    private Key key;
    Room outside, mineEntrance, Floor1, Floor2, Floor3, Floor4, Floor5, coalMine, ironMine, goldMine, platMine;

    public Game()
    {
        player = new Player();
        playerInventory = new Inventory();
        createItems();
        createRooms();
        parser = new Parser();
        
    }
    private void createItems()
    {
    	key = new Key("key",100);
    	pickaxe = new Tool("Pickaxe",10);
        coal = new Ore("Coal",50);
    	ironore = new Ore("Iron",50);
    	goldore = new Ore("Gold",60);
    	platinumore = new Ore("Platinum",60);
    	uraniumore = new Ore("Uranium", 50);
    }
    private void createRooms()
    {
        

        // create the rooms
        outside = new Room("outside","Outside of the mine");
        mineEntrance = new Room("mineEntrance", "At the entrance of the mine");
        //shop = new Room("shop", "At the shop");
        Floor1 = new Room("Floor1", "At the first floor of the mine");
        Floor2 = new Room("Floor2", "At the second floor of the mine");
        Floor3 = new Room("Floor3", "At the third floor of the mine");
        Floor4 = new Room("Floor4", "At the fourth floor of the mine");
        Floor5 = new Room("Floor5", "At the deepest floor of the mine");
        coalMine = new Room("Coal Mine", "At the coal mine");
        ironMine = new Room("Iron Mine", "At the iron mine");
        goldMine = new Room("Gold Mine", "At the gold mine");
        platMine = new Room("platMine", "At the platinum mine");
        
        key.setLockedRoom(platMine);

        // Initialize room exits //
        outside.setExit("east", mineEntrance);
        //outside.setExit("west", shop);
        mineEntrance.setExit("west", outside);
        mineEntrance.setExit("east", Floor1);
        //shop.setExit("east", outside);
        Floor1.setExit("west", mineEntrance);
        Floor1.setExit("down", Floor2);
        Floor2.setExit("down", Floor3);
        Floor3.setExit("down", Floor4);

        Floor4.setExit("down", Floor5);
        Floor2.setExit("up", Floor1);
        Floor3.setExit("up", Floor2);
        Floor4.setExit("up", Floor3);
        Floor5.setExit("up", Floor4);
        Floor2.setExit("east", coalMine);
        Floor3.setExit("west", ironMine);
        Floor4.setExit("east", goldMine);
        Floor5.setExit("west", platMine);

        coalMine.setExit("west", Floor2);
        ironMine.setExit("east", Floor3);
        goldMine.setExit("west", Floor4);
        platMine.setExit("east", Floor5);
        platMine.setIsLocked(true);
        
        //setItemWeight();

        	coalMine.getHiddenInventory().AddItemToInv(coal);
        	ironMine.getHiddenInventory().AddItemToInv(ironore);
        	goldMine.getHiddenInventory().AddItemToInv(goldore);
        	platMine.getHiddenInventory().AddItemToInv(platinumore);
        	platMine.getHiddenInventory().AddItemToInv(uraniumore);        

        playerInventory.AddItemToInv(pickaxe);
        playerInventory.AddItemToInv(key);
        player.setCurrentRoom(outside);
    }
    public void play()
    {
        printWelcome();
        boolean finished = false;
        while (! finished && player.isAlive()) 
        {
            Command command = parser.getCommand();
            finished = processCommand(command);	
        }
        if (!player.isAlive())
        {
        	System.out.println("You died, thanks for playing.");
        }
        else
        {
        	System.out.println("Thank you for playing.  Goodbye.");
        }
    }
    /*public void setItemWeight()
    {
        coal.setWeight(50);
        ironore.setWeight(50);
        goldore.setWeight(65);
        platinumore.setWeight(65);
    }*/
    private void printWelcome()
    {
    	//System.out.println(player.getInventory());
    	System.out.println();
        System.out.println("Welcome to Mine Adventure!");
        System.out.println("You can see your current position in the map up top.");
        //System.out.println("The P is your current position.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
    	/*
    	System.out.println("This is a map of the mine________#########################################");
        System.out.println("Your current position is:________#########################################");
        System.out.println("Outside_______________________############################################");
        System.out.println("______________________________############################################");
        System.out.println("_|----|_________P___________O.........|1|#################################");
        System.out.println("_|Shop|________#######################|-|#################################");
        System.out.println("######################################|-|#################################");
        System.out.println("######################################|-|#################################");
        System.out.println("######################################|2|............COAL#################");
        System.out.println("######################################|-|#################################");
        System.out.println("######################################|-|#################################");
        System.out.println("#####################IRON.............|3|#################################");
        System.out.println("######################################|-|#################################");
        System.out.println("######################################|-|#################################");
        System.out.println("######################################|4|............GOLD#################");
        System.out.println("######################################|-|#################################");
        System.out.println("######################################|-|#################################");
        System.out.println("########PLATINUM......................|5|#################################");
        System.out.println("##########################################################################");
        System.out.println("##########################################################################");
        System.out.println("##########################################################################");
        System.out.println();
        */
        System.out.println(player.getCurrentRoom().getLongDescription());
    }
    private boolean processCommand(Command command)
    {
        boolean wantToQuit = false;
        
        if(command.isUnknown()) 
        {
            System.out.println("I don't know what you mean...");
            return false;
        }
        String commandWord = command.getCommandWord();
       
        if (commandWord.equals("help"))
        {
            printHelp();
        }
        else if (commandWord.equals("go"))
        {
            goRoom(command);
        }
        else if (commandWord.equals("quit"))
        {
            wantToQuit = quit(command);
        }
        else if (commandWord.equals("look"))
        {
        	lookForDoors();
        	if (player.getCurrentRoom().getRoomInventory().isEmpty())
        	{
        		System.out.println("There are no items in this room.");
        	}
        	else 
        	{
        		System.out.println("Items in this room:");
        		for (Item item : player.getCurrentRoom().getRoomInventory().GetItemList())
        		{
        			System.out.println(item.GetItemName());
        		}
        	}
        }
        else if (commandWord.equals("drop"))
        {
        	dropItem(command);
        }
        else if (commandWord.equals("grab"))
        {
        	grabItem(command);
        }
        else if (commandWord.equals("inv"))
        {
        	if (!playerInventory.GetItemList().isEmpty())
        	{
            	for (Item item : playerInventory.GetItemList())
            	{
            		System.out.println(item.GetItemName());

            	}
        	} 
        	else
        	{
        		System.out.println("You have no items");
        		System.out.println(playerInventory.getTotalWeight());
        	}
        }
        else if (commandWord.equals("use")){
        	if(!command.hasSecondWord()) 
            {
                System.out.println("Use what?");
            }
        	else
            {
        		Item usedItem = playerInventory.GetItem(command.getSecondWord());
        		if(usedItem == null){
        			System.out.println("What?");
        		}
        		else
        		{
        			usedItem.useItem(player);
        		}
            }
        }
        return wantToQuit;
    }
    private void printHelp()
    {
        System.out.println("You are a miner, but you're poor");
        System.out.println("You have a rusty pickaxe that will at least work to mine some coal ore to sell at the shop");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }    
    private void goRoom(Command command)
    {	
    	//printAsciiMap();
    	if(!command.hasSecondWord()) 
        {
            System.out.println("Go where?");
            return;
        }
		String direction = command.getSecondWord();
		
        Room nextRoom = player.getCurrentRoom().getExit(direction);

        if (nextRoom == null)
        {
            System.out.println("There is no door!");
        }
        else 
        {
        	if(nextRoom.getIsLocked())
        	{
        		System.out.println("This door is closed. You need some type of key to open it.");
        		return;
        	}
            player.setCurrentRoom(nextRoom);
            System.out.println(player.getCurrentRoom().getLongDescription());
            player.damage(1);
            player.printHealth();
        }
    }
    /*private void printAsciiMap()
     	{
        if (player.getCurrentRoom().getName().equalsIgnoreCase("Floor1"))
        {
        	System.out.println();
        	map.mapPosFloor1();
        }
        if (player.getCurrentRoom().getName().equalsIgnoreCase("Floor2"))
        {
        	System.out.println();
        	map.mapPosFloor2();
        }
        if (player.getCurrentRoom().getName().equalsIgnoreCase("Floor3"))
        {
        	System.out.println();
        	map.mapPosFloor3();
        }
        if (player.getCurrentRoom().getName().equalsIgnoreCase("Floor4"))
        {
        	System.out.println();
        	map.mapPosFloor4();
        }
        if (player.getCurrentRoom().getName().equalsIgnoreCase("floor5"))
        {
        	System.out.println();
        	map.mapPosFloor5();
        }
        if (player.getCurrentRoom().getName().equalsIgnoreCase("coalMine"))
        {
        	System.out.println();
        	map.mapPosCoal();
        }
        if (player.getCurrentRoom().getName().equalsIgnoreCase("ironMine"))
        {
        	System.out.println();
        	map.mapPosIron();
        }
    */
    
    private void lookForDoors()
    {
    	System.out.println(player.getCurrentRoom().getLongDescription());
    }
    
    
    private void grabItem(Command command)
    {
    	if (!command.hasSecondWord())
    	{
    		System.out.println("Unknown Command");
    		return;
    	}
    	if(playerInventory.getTotalWeight() < 150)
    	{
    	
    	Item item = player.getCurrentRoom().getRoomInventory().GetItem(command.getSecondWord());
    	if(command.hasSecondWord() && player.getCurrentRoom().getRoomInventory().hasItem(command.getSecondWord()))
    	
    		{
    		player.getCurrentRoom().getRoomInventory().RemoveItemFromInv(item);
    		playerInventory.AddItemToInv(item);
    		}
    	} 
    	
    	else 
    	
    	{
    		System.out.println("You can not carry this item.");
    		System.out.println("You are overencumbered!");
    	}
    	if (playerInventory.GetItemList().contains(uraniumore))
    	{
    		player.setRadiationSick(true);
    		System.out.println("You found uranium! You're now suffering from radiation sickness. (-10 health)");
    		player.damage(10);
    	} else {
    		player.setRadiationSick(false);
    	}
    	
    }

    private void dropItem(Command command)
    {
    	if (!command.hasSecondWord())
    	{
    		System.out.println("Unknown Command");
    		return;
    	}

    	playerInventory.getTotalWeight();
    	Item item = playerInventory.GetItem(command.getSecondWord());
    	
    	if (playerInventory.GetItemList().contains(uraniumore))
    	{
    		player.setRadiationSick(false);
    		System.out.println("You're no longer radiation sick.");
    	}
 
    	if(command.hasSecondWord() && playerInventory.hasItem(command.getSecondWord()))
    	{
    		playerInventory.RemoveItemFromInv(item);
    		player.getCurrentRoom().getRoomInventory().AddItemToInv(item);
    	}
    }
	
    private boolean quit(Command command)
    {
        if(command.hasSecondWord()) 
        {
            System.out.println("Quit what?");
            return false;
        }
        else
            return true;
    }
    public static void main(String[] args)
    {
        Game game = new Game();
        game.play();
    }
}