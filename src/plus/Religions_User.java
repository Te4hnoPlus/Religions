package plus;

import java.sql.SQLException;

import org.bukkit.entity.Player;

public class Religions_User {
	
	private Player user;
	private String religion;
	private String imeg;
	
	public Religions_User(Player player) {
		user = player;
		try {
			religion = Religions_Sqlite.getData(player.getName());
			String newimeg = Religions_Core.getPlConfig().getString(religion+".imeg");
			if(newimeg != null) {
				imeg = newimeg;
			} else {
				imeg =  " ";
			}
			
		} catch (SQLException e) {
			religion = "none";
		}
	}
	
	public String getReligion() {
		return religion;
	}
	
	public void setReligion(String newreligion) {
		setImeg(Religions_Core.getPlConfig().getString(newreligion+".imeg"));
		religion = newreligion;
		String newimeg = Religions_Core.getPlConfig().getString(religion+".imeg");
		if(newimeg != null) {
			imeg = newimeg;
		} else {
			imeg =  " ";
		}
	}
	public Player toPlayer() {
		return user;
	}
	
	public String getImeg() {
		return imeg;
	}
	public void setImeg(String newimeg) {
		imeg = newimeg;
	}
	public boolean hasReligion() {
		if(religion.equals("none")) {
			return false;
		}
		return true;
	}
}
