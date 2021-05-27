package plus;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.entity.EntityDamageByEntityEvent;

import org.bukkit.event.entity.PlayerDeathEvent;

public class Religions_Combat implements Listener {
	@EventHandler
	public void opPlayerCombat(EntityDamageByEntityEvent e){

			
		if(e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			
			Player player = (Player) e.getEntity();
			Player damager = (Player) e.getDamager();
			
			Religions_User user = Religions_Data.getUser(player);
			Religions_User damg = Religions_Data.getUser(damager);
			
			String param = Religions_Core.getPlConfig().getString(user.getReligion()+".damag."+damg.getReligion());
			
			if(param != null) {
				Religions_Core.runEffect((Player) e.getDamager(), param);
			}
				
		}
	}
	
	public void opPlayerKill(PlayerDeathEvent e)
		
		if(e.getEntity().getKiller() == null) {
			return;
		}
		if(!(e.getEntity().getKiller() instanceof Player)) {
			return;
		}
		
		Religions_User user = Religions_Data.getUser(e.getEntity());
		Religions_User damg = Religions_Data.getUser(e.getEntity().getKiller());
		
		String param = Religions_Core.getPlConfig().getString(user.getReligion()+".death."+damg.getReligion());
		
		if(param != null) {
			Religions_Core.runEffect(e.getEntity().getKiller(), param);
		}	
	}
}
