package br.com.hype_mc.pvp.rank;

import java.util.UUID;

public class Rank {

	private UUID id;
	private Ranks rank;
	private int rankId;
	private long rankExpire, rankTimer;
	
	public Rank(UUID id, Ranks rank, int rankId, long rankExpire, long rankTimer) {
		this.id=id;this.rank=rank;this.rankId=rankId;this.rankExpire=rankExpire;this.rankTimer=rankTimer;
	}
	
	public UUID playerUniqueId() {
		return id;
	}
	public Ranks playerRank() {
		return rank;
	}
	public long playerRankExpire() {
		return rankExpire;
	}
	public int playerRankId() {
		return rankId;
	}
	public long playerRankTimer() {
		return rankTimer;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	public void setRank(Ranks rank) {
		this.rank = rank;
	}
	public void setRankExpire(long rankExpire) {
		this.rankExpire = rankExpire;
	}
	public void setRankId(int rankId) {
		this.rankId = rankId;
	}
	public void setRankTimer(long rankTimer) {
		this.rankTimer = rankTimer;
	}
	
}
