package game;

import javax.swing.JOptionPane;

/*
 * NPC says something.
Create array of potential responses.
Use inherited getResponse method to get player's dialog choice.
NPC responds to player's dialog choice.
 */
public class NPC {
	private String name;
	
	public NPC(String n) {
		name = n;
	}
	
	public void say(String dialog) {
		Game.print(name);
		Game.print(dialog);
		//do all caps maybe on lab 13
	}
	
	public void talk() {
		Game.print("You can't talk to Bobo");
	}
	public int getResponse(String[] responses) {
		for (String option : responses) {
			Game.print(option);
		}
		String input = JOptionPane.showInputDialog(null, "Choose an option:");
		
		return Integer.parseInt(input);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
