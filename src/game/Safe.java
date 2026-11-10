package game;

public class Safe extends Item {
	private boolean taken;
	private boolean openState;

	public Safe(String n, Boolean c) {
		super(n, c);
		taken = false;
		openState = false;
	}

	@Override
	public void open() {
		if (openState == false) {
			Game.print("you opened the safe");
			openState = true;
			if(Game.getInventory().indexOf("Notebook") == -1) {
				Item notebook = new notebook("Notebook", true);
				Game.getLocation().addItem(notebook);
				Game.print("inside the safe there is a notebook");
			}
			else {
				Game.print("There is nothing inside");
			}
		}
		else {
			Game.print("you can't open what's already opened");
		}
	}

	@Override
	public void close() {
		if(openState == true) {
			openState = false;
			Game.print("you closed the safe");
		}
	}
}
