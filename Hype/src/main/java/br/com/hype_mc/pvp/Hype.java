package br.com.hype_mc.pvp;

import org.bukkit.plugin.java.JavaPlugin;

import br.com.hype_mc.pvp.account.AccountManager;
import br.com.hype_mc.pvp.account.commands.AccountCommand;
import br.com.hype_mc.pvp.account.listeners.PlayerJoinAccount;
import br.com.hype_mc.pvp.account.listeners.PlayerQuitAccount;
import br.com.hype_mc.pvp.database.Database;
import br.com.hype_mc.pvp.league.League;
import br.com.hype_mc.pvp.league.LeagueManager;
import br.com.hype_mc.pvp.rank.RankManager;
import br.com.hype_mc.pvp.rank.commands.RankCommand;
import br.com.hype_mc.pvp.rank.listeners.PlayerJoinRank;
import br.com.hype_mc.pvp.rank.listeners.PlayerQuitRank;

public class Hype extends JavaPlugin{

	public Database databaseSQL;
	public RankManager rankManager;
	public AccountManager accountManager;
	public LeagueManager leagueManager;


	public void onEnable() {

		databaseSQL = new Database();

		this.rankManager = new RankManager(this);
		this.accountManager = new AccountManager(this);
		this.leagueManager = new LeagueManager(this);
		
		new RankCommand(this, "rank");
		new AccountCommand(this, "acc");
		
		
		new PlayerJoinRank(this);new PlayerQuitRank(this);
		new PlayerJoinAccount(this);new PlayerQuitAccount(this);
		
	}
	
	public void onDisable() {

		databaseSQL.closeConnection();
		rankManager.ranks.clear(); rankManager = null;
		accountManager.accounts.clear(); accountManager = null;
		leagueManager.leagues.clear(); leagueManager = null;

	}

	public RankManager getRankManager() {
		return rankManager;
	}
	
	public AccountManager getAccountManager() {
		return accountManager;
	}
	public LeagueManager getLeagueManager() {
		return leagueManager;
	}

	public Database getDatabaseSQL() {
		return databaseSQL;
	}

}
