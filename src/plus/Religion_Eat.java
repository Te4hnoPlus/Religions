package plus;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class Religion_Eat implements Listener{
	@EventHandler
	public void opPlayerZgretFood(PlayerItemConsumeEvent e){
		
		Religions_User user = Religions_Data.getUser(e.getPlayer());

		String param = Religions_Core.getPlConfig().getString(user.getReligion()+".food."+e.getItem().getType().name());
		
		if(param != null) {
			Religions_Core.runEffect(e.getPlayer(), param);
		}
	}
	
}
