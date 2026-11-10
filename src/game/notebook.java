package game;

public class notebook extends Item{
	private boolean opened;
	public notebook(String n, Boolean c) {
		super(n, c);
		opened=false;
	}
	@Override
	public void open() {
		Game.print("you oppened the notebook");
		if(opened == false) {
			read();
		}
		else {
			Game.print("you got a code already");
		}
	}
	@Override
	public void read() {
		Game.print("you got a code");
		Item code = new Item("code", true);
		Game.addItem(code);
		opened = true;
	}
}
