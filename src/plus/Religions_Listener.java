package plus;
//import java.sql.SQLException;
//import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

//import org.bukkit.plugin.Plugin;

public class Religions_Listener implements Listener {

	//private Plugin plugin = Bukkit.getPluginManager().getPlugin("Te4hno_Religions");
	@EventHandler
	public void onConnect(PlayerJoinEvent ev) {
		Player Joiner = ev.getPlayer();
		
		try {
			Religions_Data.addUser(Joiner);
			//String newreligion = Religions_Sqlite.getData(Joiner.getName());
			//Religions_User User = Religions_Data.getUser(Joiner);
			
			//User.setReligion(newreligion);
			
			
			//Religions_Core.getPlConfig().getString(newreligion+".imeg");

			//User.setImeg(Religions_Core.getPlConfig().getString(newreligion+".imeg"));
			
		} catch (Exception error) {

		}
	}
	
}
