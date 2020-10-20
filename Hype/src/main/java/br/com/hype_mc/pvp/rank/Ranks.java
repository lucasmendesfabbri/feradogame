package br.com.hype_mc.pvp.rank;

public enum Ranks {

	DONO("§4Dono", "§4§lDONO", 1),
	DIRETOR("§4Diretor", "§4§lDIRETOR", 2),
	ADMIN("§cAdmin", "§c§lADMIN", 3),
	MODERADOR("§5Moderador", "§5§lMOD", 4),
	TRIAL("§dTrial", "§5§lTRIAL", 5),
	YOUTUBERPLUS("§3Youtuber+", "§3§lYT+", 5),
	YOUTUBER("§bYoutuber", "§b§lYT", 10),
	BETA("§1Beta", "§1§lBETA", 11),
	MEMBER("§7Membro", "§7", 30);
	
	private String name, prefix;
	private int id;
	
	private Ranks(String name,String prefix, int id) {
		this.name=name;this.prefix=prefix;this.id=id;
	}
	
	public int getRankId() {
		return id;
	}
	public String getRankName() {
		return name;
	}
	public String getRankPrefix() {
		return prefix;
	}
	
}
