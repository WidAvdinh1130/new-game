package game;

public class Flashlight extends Item{
	private Boolean flashlightUsed;
	public Flashlight(String n, boolean c) {
		super(n, c);
		flashlightUsed = false;
	}
	@Override
	public void use() {
		if(Game.getLocation().getName().equals("Living Room")) {
			if(flashlightUsed) {
				Game.print("flashlight already used");
			}
			else {
				Game.getLocation().getExit(2).setLocked(false);
				Game.print("bedroom brightens");
				flashlightUsed = true;
			}
		}
	else {
		Game.print("You can't use it here");
		}
	}
}
