package game;

public class pootis extends NPC {
	public pootis() {
		super("pootis"); // NOTE: name must be lower-case
	}

@Override
public void talk() {
	say("Pootis spencer here");
	String[] responses =
{
		"any key",
		"what do you have",
		"can I rob you\n"
};
	int option = getResponse(responses);
	switch(option) {
	case 1:
		say("NO\n");
		break;
	case 2:
		say("Sandwich\n");
		break;
	case 3:
		say("No.");
		break;
	default:
			say("This man is spy\n");
		}
	}
}