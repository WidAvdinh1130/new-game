package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//game class
public class Game {
	private static Room location = World.buildWorld();
	public static ArrayList<Item> inventory = new ArrayList<Item>();
	public static HashMap<String, String> house = new HashMap<>();
	private static HashMap<String, Integer> dirTracker = new HashMap<>();
	// run game
	public static void runGame() {
		PrintFileDemo();
		print(location);
		Scanner input = new Scanner(System.in);
		String command = "";
		while (!command.equals("exit")) {
			System.out.println("Enter command");
			command = input.nextLine();
			String multcommand[] = command.split(" ");

			//move command
			if (multcommand[0].equals("go")) {
				if(multcommand.length == 2 && dirTracker.containsKey(multcommand[1])) {
					move(multcommand[1]);
				} else {
						print("go where?");
				}
			}
			
			//show inventory
			else if (command.equals("i")) {
				print("your are carrying:");
				if (inventory.size() != 0) {
					for (Item item : inventory) {
						print(item);
					}
				} else {
					print("nothing");
				}
			}
			
			//take item command
			else if (multcommand[0].equals("take")) {
				if (multcommand.length >= 2) {
					String itemName = "";
					for (int i = 1; i < multcommand.length; i++) {
						if (i < multcommand.length - 1)
							itemName += multcommand[i] + " ";
						else {
							itemName += multcommand[i];
						}
					}
					takeItem(itemName);
				}
				else{
					print("take what");
				}
			}
			
			//use item
			else if (multcommand[0].equals("use")) {
				if (multcommand.length >= 2) {
					String itemName = "";
					for (int i = 1; i < multcommand.length; i++) {
						if (i < multcommand.length - 1) {
							itemName += multcommand[i] + " ";
						} else {
							itemName += multcommand[i];
						}
					}
					for (Item thing : inventory) {
						if (thing.getName().equals(itemName)) {
							thing.use();
						}
					}
				}
				else {
					print("use what");
					}
				}
			
			//open attic safe
			else if (multcommand[0].equals("open")) {
				if (multcommand.length >= 2 && multcommand[1].equals("Safe")) {
					location.getItem("Safe").openSafe();
				}
				else {
					print("you can't open anything here");
				}
			}
			
			else if (multcommand[0].equals("close")) {
				if (multcommand.length >= 2 && multcommand[1].equals("Safe")) {
					location.getItem("Safe").closeSafe();
				}
				else {
					print("you can't close anything here");
				}
			}
			else if (multcommand[0].equals("read")) {
				if (multcommand.length >=2 && multcommand[1].equals("Notebook")){
					if(inventory.indexOf(location.getItem("Notebook")) == -1) {
						inventory.get(inventory.indexOf(location.getItem("Notebook"))).read();
						print("pass");
					}
					else {
						print("fail");
					}
				}
				else {
					print("you can't read anything here");
				}
			}
			//load game
			else if (command.equals("load")) {
				print("file loaded");
				loadGame();
			}
			
			//save game
			else if (command.equals("save")) {
				print("file saved");
				saveGame();
			}
			print(location);
			}
		input.close();
		print("goodbye");
	}

	private static void saveGame() {
		try {
			File saveFile = new File("saveData0.sav");
			saveFile.createNewFile();
			ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(saveFile));
			outStream.writeObject(location);
			outStream.writeObject(inventory);
			outStream.writeObject(World.houseData);
			outStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void loadGame() {
		try {
			File saveFile = new File("saveData0.sav");
			ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(saveFile));
			location = (Room) inStream.readObject();
			inventory = (ArrayList<Item>) inStream.readObject();
			World.houseData = (HashMap<String, Room>) inStream.readObject();
			inStream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void move(String dir) {
		if(location.getExit(dirTracker.get(dir))==null) {
			print("you can't go there\n");
		}
		else if(location.getExit(dirTracker.get(dir)).getLocked() == true) {
			print("it is locked, find something to unlock it\n");
		}
		else {
			location = location.getExit(dirTracker.get(dir));
		}
	}

	public static void takeItem(String itemName) {
		if (location.getItem(itemName) != null) {
			if (itemName.equals(location.getItem(itemName).toString())) {
				if (location.getItem(itemName).canCarry() == true) {
					inventory.add(location.getItem(itemName));
					print("you take the " + location.getItem(itemName).getName() + " with you" + "\n");
					location.removeItem(itemName);
				} else {
					print("you can't carry " + location.getItem(itemName).getName());
				}
			} else {
				print("you look for the " + itemName + " but didn't find it");
			}
		} else {
			print("there is nothing to take");
		}
	}

	public static void PrintFileDemo() {
		try {
			Scanner fileScan = new Scanner(new File("description.txt"));
			while (fileScan.hasNextLine()) {
				String Line = fileScan.nextLine();
				String theRoom = Line;
				String theDesc = "";
				Line = fileScan.nextLine();
				while (!Line.equals("#")) {
					theDesc += Line + " ";
					Line = fileScan.nextLine();
				}

				house.put(theRoom, theDesc);
			}
			fileScan.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void print(Object obj) {
		System.out.println(obj);
	}

	public static Room getLocation() {
		return location;
	}

	public static ArrayList<Item> getInventory() {
		return inventory;
	}

	public static void addItem(Item i) {
		inventory.add(i);
	}

	public static void main(String[] args) {
		dirTracker.put("east", 0);
		dirTracker.put("west", 1);
		dirTracker.put("north", 2);
		dirTracker.put("south", 3);
		dirTracker.put("up", 4);
		dirTracker.put("down", 5);
		runGame();
	}
}