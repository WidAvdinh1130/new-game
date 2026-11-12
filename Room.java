package game;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


// make room objects
public class Room implements Serializable{
	private String name;
	private Room[] roomstogo;
	private HashMap<String,Item> roomInventory = new HashMap<>();
	private HashMap<String,NPC> roomPop = new HashMap<>();
	private Boolean isLocked;
	
	//constructor
	public Room(String n, Boolean l) {
		name = n;
		roomstogo = new Room[6];
		World.houseData.put(name, this);
		isLocked = l;
	}
	
	public Item getItem(String name) {
		return roomInventory.get(name);
	}

	public void addItem(Item i) {
		roomInventory.put(i.getName(), i);
	}
	public Boolean getLocked() {
		return isLocked;
	}

	public void setLocked(Boolean l) {
		isLocked = l;
	}

	public void removeItem(String name) {
		roomInventory.remove(name);
	}

	public void addExit(Room r, int i) {
		roomstogo[i] = r;
	}
	
	public Room getExit(int i) {
		return roomstogo[i];
	}
	
	public String getName(){
		return name;
	}
	
	public String getDescription(String name) {
		return Game.house.get(name);
	}
	
	public void setName(String n){
		name = n;
	}
	
	public void setDescription(String name, String description) {
		Game.house.put(name, description);
	}
	
	public HashMap<String, NPC> getRoomPop() {
		return roomPop;
	}

	public void putRoomPop(String n, NPC p) {
		roomPop.put(n, p);
	}

	public String toString() {
		String s = "";
		s += name + "\n" + Game.house.get(name);
		if(roomInventory.size() != 0) {
			s += "\n\n" + "there is a:";
			Iterator<Item> it = roomInventory.values().iterator();
			while(it.hasNext()) {
				Item a = it.next();
				s += "\n" + a;
			}
			s += "\nhere\n";
		}
		if(roomPop.size() != 0) {
			s += "\n\n";
			Iterator<String> it = roomPop.keySet().iterator();
			while(it.hasNext()) {
				String a = it.next();
				s += "\n" + a;
			}
			s += "\nare also here\n";
		}
		return s;
	}
	

}