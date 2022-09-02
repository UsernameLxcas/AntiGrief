package Util;
import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import Commands.ilegalcmd;
import Listeners.Listeners;


public class Start extends JavaPlugin{
	String carpeta;
	@Override
	public void onEnable()  {
		Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&aAntiGrief has been activated"));
		Configuracion();
		Comando();
        getServer().getPluginManager().registerEvents(new Listeners(this), this);

	}
	
	@Override
	public void onDisable() {
		
	}
	public void Comando() {
		this.getCommand("ilegalcmd").setExecutor(new ilegalcmd(this));
	}
	
	public void Configuracion() {
		File config = new File(this.getDataFolder(),"config.yml");
		carpeta = config.getPath();
		if(!config.exists()){
    	this.getConfig().options().copyDefaults(true);
    	saveDefaultConfig();
		}
    }

}
