package te4hno.religions.papi;

import org.bukkit.OfflinePlayer;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import plus.Religions_Data;
import plus.Religions_User;

public class Religions_Papi extends PlaceholderExpansion {
	
    @Override
    public boolean canRegister(){
        return true;
    }
	@Override
	public String getAuthor() {
		return "Te4hnoPlus / ReMuru";
	}

	@Override
	public String getIdentifier() {
		return "religions";
	}

	@Override
	public String getVersion() {
		return "1.0.2";
	}
	@Override
    public String onRequest(OfflinePlayer player, String identifier) {
		
		if(!player.getPlayer().isOnline()) {
			return null;
		}

		Religions_User User = Religions_Data.getUser(player.getPlayer());
		
		if(identifier.equals("name")){
			if(User.hasReligion()) {
				return User.getReligion();
			} else {
				return "Нет религии";
				}
        }
		if(identifier.equals("imeg")){
			if(User.hasReligion()) {
				return User.getImeg();
			} else {
				return " ";
			}
        }	
        //switch (identifier) {
        //	case "name":{
        //		return User.getReligion();
        //	}
        //	case "imeg":{
        //		return User.getImeg();
        //	}
        //}
        
		return null;
	}
}
	
