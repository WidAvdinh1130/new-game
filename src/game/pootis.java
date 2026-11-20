package game;

import java.util.Iterator;

public class pootis extends NPC {
	private int pootisConvoNum = 0;

	public pootis() {
		super("pootis"); // NOTE: name must be lower-case
	}

	@Override
	public void talk() {
		switch (pootisConvoNum) {
		case 0:
			talk0();
			break;
		case 1:
			talk1();
			break;
		case 2:
			talk2();
			break;
		case 3:
			talk3();
			break;
		case 11:
		case 12:
		case 13:
		case 21:
		case 22:
		case 23:
		case 31:
		case 32:
		case 33:
			finalTalk();
			break;
		}
	}
	@Override
	public void give(Item i) {
		if(i.getName().equals("Four Hundred Thousand Dollars")) {
			say("Thank you here is safe combination");
			Item combo = new Item("combination", true);
			Game.addItem(combo);
			Game.rmItem(i);
		}
		else {
			say("I don't want your garbage");
		}
	}

	public void talk0() {
		say("Pootis spencer here");
		String[] responses = { "any key", "what do you have", "can I rob you\n" };
		int option = getResponse(responses);
		switch (option) {
		case 1:
			say("NO key\n");
			pootisConvoNum = 1;
			break;
		case 2:
			say("Sandwich\n");
			pootisConvoNum = 2;
			break;
		case 3:
			say("I have gun\n");
			pootisConvoNum = 3;
			break;
		default:
			say("This man is spy\n");

		}
	}

	public void talk1() {
		say("I don't have key");
		String[] responses = { "gimme you stuff", "what is nine plus ten", "never gonna give you up\n" };
		int option = getResponse(responses);
		switch (option) {
		case 1:
			say("I give you word\n");
			pootisConvoNum = 11;
			break;
		case 2:
			say("you have brain damage\n");
			pootisConvoNum = 12;
			break;
		case 3:
			say("what the heck\n");
			pootisConvoNum = 13;
			break;
		default:
			say("This man is spy\n");

		}
	}

	public void talk2() {
		say("I have good sandwich");
		String[] responses = { "can I have it", "can you make me sandwich", "how to make sandwich\n" };
		int option = getResponse(responses);
		switch (option) {
		case 1:
			say("No\n");
			pootisConvoNum = 21;
			break;
		case 2:
			say("Go make yourself\n");
			pootisConvoNum = 22;
			break;
		case 3:
			say("2 slices of bread, 2 slices of ham, 1 lettuce,\n");
			pootisConvoNum = 23;
			break;
		default:
			say("This man is spy\n");

		}
	}

	public void talk3() {
		say("don't rob me or I kill you");
		String[] responses = { "Okay okay I won't anymore", "I'm going to touch your gun", "are you dumb\n" };
		int option = getResponse(responses);
		switch (option) {
		case 1:
			say("Good\n");
			pootisConvoNum = 31;
			break;
		case 2:
			say("I will kill you\n");
			pootisConvoNum = 32;
			break;
		case 3:
			say("No\n");
			pootisConvoNum = 33;
			break;
		default:
			say("This man is spy\n");

		}
	}

	public void finalTalk() {
		switch (pootisConvoNum) {
		case 11:
			say("haha you have nothing\n");
			break;
		case 12:
			say("don't talk to me you brainrot\n");
			break;
		case 13:
			say("you rickroll me\n");
			break;
		case 21:
			say("I told you no\n");
			break;
		case 22:
			say("go make your sandwich yourself\n");
			break;
		case 23:
			say("now you can make sandwich\n");
			break;
		case 31:
			say("now I don't need gun on you\n");
			break;
		case 32:
			say("don't touch sasha\n");
			break;
		case 33:
			say("I am smarter than you\n");
			break;
		}
	}
}