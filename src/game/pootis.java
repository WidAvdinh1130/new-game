package game;

public class pootis extends NPC {
	private int pootisConvoNum = 1;

	public pootis() {
		super("pootis"); // NOTE: name must be lower-case
	}

	@Override
	public void talk() {
		switch (pootisConvoNum) {
		case 1:
			talk1();
			break;
		case 11:
			talk21();
			break;
		}
	}
	public void talk1() {
		say("Pootis spencer here");
		String[] responses = { "any key", "what do you have", "can I rob you\n" };
		int option = getResponse(responses);
		switch (option) {
			case 1:
				say("NO key\n");
				pootisConvoNum = 11;
				break;
			case 2:
				say("Sandwich\n");
				pootisConvoNum = 12;
				break;
			case 3:
				say("I have gun\n");
				pootisConvoNum = 13;
				break;
			default:
				say("This man is spy\n");
	
		}
	}
	public void talk21() {
		say("I don't have key");
		String[] responses = { "gimme you stuff", "what is nine plus ten", "never gonna give you up\n" };
		int option = getResponse(responses);
		switch (option) {
			case 1:
				say("I give you word\n");
				pootisConvoNum = 31;
				break;
			case 2:
				say("Sandwich\n");
				pootisConvoNum = 3;
				break;
			case 3:
				say("I have gun\n");
				pootisConvoNum = 4;
				break;
			default:
				say("This man is spy\n");
	
		}
	}
}