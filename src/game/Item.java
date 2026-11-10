package game;

import java.io.Serializable;

public class Item implements Serializable{
    private String name;
    private boolean carry;
	//constructor
	public Item(String n, boolean c) {
		name = n;
		carry = c;
	}
    	public String getName(){
		return name;
	}
    	public void setName(String n){
		name = n;
	}
    	public void use() {
    		Game.print("You cannot use this item stupid");
    	}
    	public boolean canCarry(){
    		return carry;
    	}
    	public void open()	 {
    		Game.print("If you open it, you break it");
    	}
    	public void close() {
    		Game.print("You can't close anything");
    	}
    	public void read() {
    		Game.print("you read the item, but there is nothing to read because there is no words");
    	}
    	public String toString() {
		String s = "";
		s += name;
		return s;
	}
}