package game;

public class Tools extends Item {
	boolean usedTool = false;
	public Tools(String n, Boolean c) {
		super(n, c);
	}
	@Override
	public void use() {
		if (Game.getLocation().getName().equals("Bedroom")) {
			if (usedTool) {
				Game.print("It's already opened");
			}
			else {
				Game.getLocation().getExit(4).setLocked(false);
				usedTool = true;
				Game.print("You Use the Tools in the Bedroom, The Attic now oppens");
			}
		}
		else
			Game.print("You can't use it here");
	}
}