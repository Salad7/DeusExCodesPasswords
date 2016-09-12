import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * 
 * @author MasterMatthew
 *	Matthew's superior Code
 */
public class Database{
	private static final long serialVersionUID = 1L;
	private static Database database;
	public TreeMap<String, TreeMap<String, String>> hash = new TreeMap<String, TreeMap<String, String>>();
	
	public static String printAll()
	{
		Set<String> locs = database.hash.keySet();
		String out = "";
		for(String s : locs)
		{
			out += s;
			for(String d : database.hash.get(s).keySet()){
				out += "\n\t" + d + "\t" + database.hash.get(s).get(d);
			}
			out += "\n";
		}
		return out;
	}
	
	public static String printLocations()
	{
		Set<String> locs = database.hash.keySet();
		
		String out = "Locations: \n";
		
		for(String s : locs)
		{
			out += " " + s + "\n";
		}
		
		return out;
	}
	
	public static String printDescriptions(String loc)
	{
		Set<String> descs = database.hash.get(loc).keySet();
		
		String out = "Desciptions in " + loc + ": \n";
		
		for(String s : descs)
		{
			out += " " + s + "\n";
		}
		
		return out;
	}
	
	public static String printPasswords(String loc)
	{
		Set<String> descs = database.hash.get(loc).keySet();
		
		String out = "Passwords in " + loc + ": \n";
		
		for(String s : descs)
		{
			out += " " + s + ": " + database.hash.get(loc).get(s) + "\n";
		}
		
		return out;
	}
	
	public static String findPassword(String desc)
	{
		Set<String> locs = database.hash.keySet();
		
		for(String s : locs)
		{
			if(database.hash.get(s).containsKey(desc))
			{
				return findPassword(s, desc);
			}
		}
		
		return "Password not found!";
	}
	
	public static String findPassword(String loc, String desc)
	{
		return database.hash.get(loc).get(desc);
	}
	
	public static void init()
	{
		database = Database.load();
		if(database == null) database = new Database();
	}
	
	public static void cleanup()
	{
		Database.save();
	}
	
	public static void add(String itemString)
	{
		String[] split = itemString.split("/");
		Database.add(split[0], split[1], split[2]);
	}
		
	public static void add(String loc, String desc, String pass)
	{
		if(!database.hash.containsKey(loc)) database.hash.put(loc, new TreeMap<String, String>());
		database.hash.get(loc).put(desc, pass);
	}
	
	public static void loadFile(String fileName)
	{
		Scanner k = null;
		try {
			k = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(k.hasNextLine())
		{
			Database.add(k.nextLine());
		}
		
	}
	
	private static void save()
	{
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("./res/db.sav")));
			
			out.writeObject(database);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public static Database getDatabase(){return database;}
	
	private static Database load()
	{
		Database out = null;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("./res/db.sav")));
			
			out = (Database) in.readObject();
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
		
		return out;
	}
}
