package game;

public class Safe extends Item {
	private boolean opened;
	private boolean openState;
	private boolean canOpen;

	public Safe(String n, Boolean c) {
		super(n, c);
		opened = false;
		openState = false;
		canOpen = true;//turn false later
	}

	@Override
	public void open() {
		if (canOpen == true) {
			if(openState == false) {
				openState = true;
				Game.print("you opened the safe");
				if (opened = false) {
					Item notebook = new notebook("notebook", true);
					Game.getLocation().addItem(notebook);
					Game.print("inside the safe there is a notebook");
			} 	else {
					Game.print("There is nothing inside the safe");
			}
		
		}
			else {
				Game.print("it's already open");
			}
			}
		else {
			Game.print("you cannot open the safe");
		}
	}

	public void close() {
		if(openState == true) {
			openState = false;
		}
	}
}
