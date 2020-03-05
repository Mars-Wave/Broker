package model.locations;

public enum Location {
	HOME (0, "HOME"),
	OFFICE (1, "OFFICE"),
	PARK(2, "PARK");

	private int id;
	private String name;
	
	private Location(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public static void printAll() {
		System.out.println("-------------------------------------");
		for (Location loc : Location.values()) {
			 System.out.println(loc);
		}
		System.out.println("-------------------------------------");
	}
	public String toString() {
		return this.id + ": " + this.name + ".";
	}
	
	public static int totalValue() {
		return values().length;
	}
	
	public static Location parse(int id) {
		for (Location loc : Location.values()) {
			if(loc.id == id) {
				return loc;
			}
		}
		return null;
	}
}
