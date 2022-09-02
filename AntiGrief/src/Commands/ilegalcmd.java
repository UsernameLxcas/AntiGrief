package Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import Util.Perms;
import Util.Start;
import net.md_5.bungee.api.ChatColor;

public class ilegalcmd implements CommandExecutor{
	Perms pm = new Perms();
	private Start plugin;
	public ilegalcmd(Start plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("ilegalcmd")) {
			if(!sender.hasPermission(pm.ilegalcmd)) {
				String No_Permissions = "No_Permissions";
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString(No_Permissions)));
			}else {
				if(args.length==0) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&ePlease use:"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e/ilegalcmd info"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e/ilegalcmd reload"));
				}else {
				if(args[0].equalsIgnoreCase("reload") || args[0].equalsIgnoreCase("info")) {
					if (args[0].equalsIgnoreCase("reload")) {
					plugin.reloadConfig();
					String reload_message = "reload_message";
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString(reload_message)));
					}else if (args[0].equalsIgnoreCase("info") ) {
						sender.sendMessage(ChatColor.YELLOW+"Plugin by: Anytown");
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3Spigot:&f https://www.spigotmc.org/members/anytown.1635942/"));
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3Github:&f https://github.com/Anytown"));
					}
				}else {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&ePlease use:"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e/ilegalcmd info"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e/ilegalcmd reload"));
				}
			}
			}
		}
		
		return true;
	}

}
