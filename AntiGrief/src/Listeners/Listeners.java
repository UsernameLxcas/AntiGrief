package Listeners;

import java.net.InetSocketAddress;
import java.util.List;

import org.bukkit.BanList.Type;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import Util.Start;
import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.ChatColor;

public class Listeners implements Listener{
	private Start plugin;
	public Listeners(Start plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onCommandExecute(PlayerCommandPreprocessEvent event) {
		String command = event.getMessage();
		List<String> block = plugin.getConfig().getStringList("ilegal_commands");
		for(int i=0;i<block.size();i++) {
		String text = block.get(i);
		if(command.equalsIgnoreCase(text) || command.startsWith(text)) {
			event.setCancelled(true);
			Player player = event.getPlayer();
			String kick= "kick_when_execute";
			Boolean shit = plugin.getConfig().getBoolean(kick);
			if(shit) {
				String kickMessage = "kick_message";
				player.kickPlayer(ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(player, plugin.getConfig().getString(kickMessage))));
				}
			}
		
		}
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		if (player.hasPermission("*") || player.isOp() || player.hasPermission("any.imgay")) {
		List<String> block = plugin.getConfig().getStringList("allowed_with_op");
		if (!block.contains(player.getName())) {
			String add = player.getAddress().getHostString();
			Bukkit.banIP(add);
			Bukkit.getBannedPlayers().add(player);
			String banmsg = "ban_staff_recive";
			String alert = "alert_console_msg";
			String user_ban = "user_ban";
			Bukkit.getBanList(Type.NAME).addBan(player.getName(), ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString(user_ban)), null, null);			
			Bukkit.broadcast(ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(player, plugin.getConfig().getString(banmsg))), "Antigrief.recive");
			Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(player, plugin.getConfig().getString(alert))));
			player.kickPlayer(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString(user_ban)));
		}else if (block.contains(player.getName())){
			
		}
		
		}
		
	}

}