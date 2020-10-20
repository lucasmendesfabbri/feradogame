package br.com.hype_mc.pvp.rank.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.hype_mc.pvp.Hype;
import br.com.hype_mc.pvp.rank.Rank;

public class RankCommand implements CommandExecutor {

	private Hype instance;

	public RankCommand(Hype instance, String command) {
		this.instance=instance;
		this.instance.getCommand("rank").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if(sender instanceof Player) {
			if(command.getName().equalsIgnoreCase("rank")) {
				Player playerBy = (Player) sender;
				Rank playerByRank = this.instance.getRankManager().playerRank(playerBy.getUniqueId());

				if(args.length == 0) {
					
					if(playerByRank.playerRank().getRankId() >= 4) {
						playerBy.sendMessage("§cSem permissão.");
						return true;
					}
					
					playerBy.sendMessage("§cUsage /rank <username> <rank> <timer>");
					return true;
				}
			    if(args[0].equalsIgnoreCase(args[0])) {
			    	
					if(this.instance.getRankManager().playerRank(Bukkit.getPlayer(args[0]).getUniqueId()).playerUniqueId() == null || this.instance.getRankManager().playerRank(Bukkit.getOfflinePlayer(args[0]).getUniqueId())==null) {
	                    playerBy.sendMessage("§cNenhum jogador foi registrado com esse username.");
						return true;
					}
					
					
					
			    	
			    }
			    return true;
			}
		}

		return true;
	}



}
