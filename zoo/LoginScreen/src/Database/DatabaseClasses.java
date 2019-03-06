package Database;

import java.sql.ResultSet;
import java.util.Vector;

public class DatabaseClasses {
	static sqlengine dbEngine = new sqlengine("root", "root");

	public static void init() {
		dbEngine.connect();
	}

	public static String getUsername(String user) {

		String correctUser = "null";
		try {
			ResultSet result = dbEngine.executeQuery("select username from userlogin where username = '" + user + "'");

			while (result.next()) {
				correctUser = result.getString("username");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return correctUser;
	}

	public static String getPassword(String password) {
		String correctPass = "null";

		try {
			ResultSet result = dbEngine
					.executeQuery("select password from userlogin where password = '" + password + "'");

			while (result.next()) {
				correctPass = result.getString("password");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return correctPass;
	}

	
	public static String getAnimaID(String inputName) {

		String animalID = "null";
		try {
			ResultSet result = dbEngine.executeQuery("SELECT animalID FROM animal where name = '" + inputName +"'");

			while (result.next()) {
				animalID = result.getString("animalID");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return animalID;
	}
	
	public static String getAnimalName(String inputName) {

		String name = "null";
		try {
			ResultSet result = dbEngine.executeQuery("SELECT name FROM animal where name = '" + inputName +"'");

			while (result.next()) {
				name = result.getString("name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return name;
	}

	public static String getSpecies(String inputName) {

		String species = "null";
		try {
			ResultSet result = dbEngine.executeQuery("SELECT species FROM animal where name = '" + inputName +"'");

			while (result.next()) {
				species = result.getString("species");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return species;
	}

	public static String getLocation(String inputName) {

		String location = "null";
		try {
			ResultSet result = dbEngine.executeQuery("SELECT location FROM animal where name = '" + inputName +"'");

			while (result.next()) {
				location = result.getString("location");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return location;
	}
	
	public static String getFeedingTime(String inputName) {

		String feedingtime = "null";
		try {
			ResultSet result = dbEngine.executeQuery("SELECT feedingtime FROM animal where name = '" + inputName +"'");

			while (result.next()) {
				feedingtime = result.getString("feedingtime");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return feedingtime;
	}
	
	public static String getCaretaker(String inputName) {

		String caretaker = "null";
		try {
			ResultSet result = dbEngine.executeQuery("SELECT caretaker FROM animal where name = '" + inputName +"'");

			while (result.next()) {
				caretaker = result.getString("caretaker");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return caretaker;
	}
	
	public static String getVetHistory(String inputName) {

		String vetHistory = "null";
		try {
			ResultSet result = dbEngine.executeQuery("SELECT vetHistory FROM animal where name = '" + inputName +"'");

			while (result.next()) {
				vetHistory = result.getString("vetHistory");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return vetHistory;
	}
	
	public static String getSpecialNeeds(String inputName) {

		String specialNeeds = "null";
		try {
			ResultSet result = dbEngine.executeQuery("SELECT specialNeeds FROM animal where name = '" + inputName +"'");

			while (result.next()) {
				specialNeeds = result.getString("specialNeeds");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return specialNeeds;
	}
}
