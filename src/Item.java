
public class Item {
	String loc;
	String desc;
	String pass;
	
	public Item(String l, String d, String p)
	{
		loc = l;
		desc = d;
		pass = p;
	}

	public String getLoc() {
		return loc;
	}

	public String getDesc() {
		return desc;
	}

	public String getPass() {
		return pass;
	}
	
	public String toString()
	{
		return "Location: " + loc
				+ "\nDescription: " + desc
				+ "\nPassword: " + pass;
	}
}
