package plus;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.economy.Economy;

public class Religions_Core extends JavaPlugin {
	
	private File configfile = new File(getDataFolder()+ File.separator+"config.yml");
	private static FileConfiguration config;
	private static Economy econ = null;
	List<String> allowedreligions;
	
	@Override
	public void onEnable() {
		if(!configfile.exists()){
			getConfig().options().copyDefaults(true);
			saveDefaultConfig();
		}
		config = getConfig();

		try {
			Religions_Sqlite.Conn();
			Religions_Sqlite.CreateDB();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		Bukkit.getPluginManager().registerEvents(new Religions_Listener(), this);
		Bukkit.getPluginManager().registerEvents(new Religion_Eat(), this);
		Bukkit.getPluginManager().registerEvents(new Religions_Combat(), this);
		
		getCommand("religion").setExecutor(this);
		
		config = getConfig();
		setupEconomy();
		
		allowedreligions = config.getStringList("Religions_List");
		System.out.println(String.valueOf(allowedreligions.size())+" Ðåëèãèé çàãðóæåíî.");
			
	}
	
	private void setupEconomy() {
		
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
        	System.out.println("Vault íå îáíàðóæåí");
            return;
        } else {
        	System.out.println("Vault îáíàðóæåí");
        }
		
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		
        if (rsp == null) {
        	System.out.println("Ïðîâîäíèê ýêîíîìèêè íå îáíàðóæåí");
            return;
        } else {
        	System.out.println("Ïðîâîäíèê ýêîíîìèêè îáíàðóæåí");
        }
        econ = rsp.getProvider();
        return;
    	}
	
	public int balset = getConfig().getInt("NeedMoney_ReSet");
	public int balreset = getConfig().getInt("NeedMoney_Set");
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		Player player = (Player) sender;
		
		if(args.length == 0 || args.length>2) {
			player.sendMessage(getConfig().getString("Message_False"));
			return true;
		}
		
		if(args[0].equals("help")) {
			player.sendMessage(getConfig().getString("Message_Help"));
			return true;
		}
		
		Religions_User user = Religions_Data.getUser(player);
		
		if(args[0].equals("set")) {
			if(args.length == 1) {
				player.sendMessage(getConfig().getString("Message_Wrong"));
				return true;
			}
			
			double playermoney = econ.getBalance(player.getName());
	
			int newbalminus;
			
			if(user.hasReligion()) {

				if(playermoney<balreset) {
					player.sendMessage(getConfig().getString("Message_NoMoney"));
					return true;
				} else {
					newbalminus = balreset;
				}
			} else {

				if(playermoney<balset) {
					player.sendMessage(getConfig().getString("Message_NoMoney"));
					return true;
				} else {
					newbalminus = balset;
				}
			}

			if(allowedreligions.contains(args[1])) {
			
				user.setReligion(args[1]);
				
				econ.withdrawPlayer(player, newbalminus);
				
				try {

					Religions_Sqlite.saveData(player.getName(), args[1]);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				player.sendMessage(getConfig().getString("Message_Success"));
				return true;
			} else {
				player.sendMessage(getConfig().getString("Message_Wrong"));
				return true;
			}
			
		}
		
		if(args[0].equals("get")) {

			player.sendMessage(user.getReligion());
			return true;
		}
		
		return true;
	}
	
	public static FileConfiguration getPlConfig() {
		return config;
	}
	
	public static void runEffect(Player player, String params) {
		Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "effect give "+player.getName()+params);
	}
	
	public static Economy getEcon() {
		return econ;
	}	
}
