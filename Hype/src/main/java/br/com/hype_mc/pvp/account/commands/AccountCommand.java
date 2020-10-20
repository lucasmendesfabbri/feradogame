package br.com.hype_mc.pvp.account.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.hype_mc.pvp.Hype;
import br.com.hype_mc.pvp.rank.Rank;

public class AccountCommand implements CommandExecutor {

	private Hype instance;

	public AccountCommand(Hype instance, String command) {
		this.instance=instance;
		this.instance.getCommand("acc").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if(sender instanceof Player) {
			if(command.getName().equalsIgnoreCase("acc")) {
				Player playerBy = (Player) sender;
				Rank playerByRank = this.instance.getRankManager().playerRank(playerBy.getUniqueId());

				if(args.length == 0) {

					if(playerByRank.playerRank().getRankId() >= 4) {
						playerBy.sendMessage("");
						playerBy.sendMessage("§fUsuário: §a"+playerBy.getName());
						playerBy.sendMessage("§fXP: §6" + this.instance.getLeagueManager().playerLeague(playerBy.getUniqueId()).playerXP());
						playerBy.sendMessage("§fRanking: §a" + this.instance.getLeagueManager().playerLeague(playerBy.getUniqueId()).playerLeague().getName());
						playerBy.sendMessage("§fPrimeiro login: §7" + this.instance.getLeagueManager().formatDate(this.instance.getLeagueManager().playerLeague(playerBy.getUniqueId())));					
						playerBy.sendMessage("§fÚltimo login: §7-");
						playerBy.sendMessage("");
						playerBy.sendMessage("§fRank: " + this.instance.getRankManager().playerRank(playerBy.getUniqueId()).playerRank().getRankName() + "§f - §7" + this.instance.getRankManager().formatDateExpire(this.instance.getRankManager().playerRank(playerBy.getUniqueId())));
						playerBy.sendMessage("");
						return true;
					}

					playerBy.sendMessage("");
					playerBy.sendMessage("§fUsuário: §a"+playerBy.getName());
					playerBy.sendMessage("§fXP: §6" + this.instance.getLeagueManager().playerLeague(playerBy.getUniqueId()).playerXP());
					playerBy.sendMessage("§fRanking: §a" + this.instance.getLeagueManager().playerLeague(playerBy.getUniqueId()).playerLeague().getName());
					playerBy.sendMessage("§fPrimeiro login: §7" + this.instance.getLeagueManager().formatDate(this.instance.getLeagueManager().playerLeague(playerBy.getUniqueId())));					
					playerBy.sendMessage("§fÚltimo login: §7-");
					playerBy.sendMessage("");
					playerBy.sendMessage("§fRank: " + this.instance.getRankManager().playerRank(playerBy.getUniqueId()).playerRank().getRankName() + "§f - §7" + this.instance.getRankManager().formatDateExpire(this.instance.getRankManager().playerRank(playerBy.getUniqueId())));
					playerBy.sendMessage("");
					playerBy.sendMessage("§cUsage: /acc <nick>");
					playerBy.sendMessage("");
					return true;
				}
				if(args.length >=1) {

					if(playerByRank.playerRank().getRankId() >= 4) {
						playerBy.sendMessage("§cSem permissão.");
						return true;
					}
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
