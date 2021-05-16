package plus;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
//import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Religions_Combat implements Listener {
	@EventHandler
	public void opPlayerCombat(EntityDamageByEntityEvent e){
		//if(e.getEntity() instanseof Player) 
			
		if(e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			Player player = (Player) e.getEntity();
			
			Religions_User user = Religions_Data.getUser(player);
			
			String param = Religions_Core.getPlConfig().getString(user.getReligion()+".resist");
			
			if(param != null) {
				Religions_Core.runEffect((Player) e.getDamager(), param);
			}
				
		}
	}

}
