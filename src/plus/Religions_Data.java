package plus;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class Religions_Data {
	
	private static HashMap<Player, Religions_User> data = new HashMap<>();
	
	public static void addUser(Player player) {
		
		if(data.containsKey(player)) {
			return;
		}
		
		data.put(player, new Religions_User(player));
			
	}
	
	public static Religions_User getUser(Player player) {
		
		return data.get(player);
	}
	
}
