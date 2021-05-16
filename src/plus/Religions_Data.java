package plus;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class Religions_Data {
	private static HashMap<Player, Religions_User> data = new HashMap<>();
	
	public static void addUser(Player player) {
		
		if(data.containsKey(player)) {
			return;
		}
		
		//System.out.println("Добавлен юзер");//
		
		Religions_User user = new Religions_User(player);
		
		data.put(player, user);
		
		//System.out.println(data.get(player));//
		
	}
	
	public static Religions_User getUser(Player player) {
		return data.get(player);
	}
	
}
