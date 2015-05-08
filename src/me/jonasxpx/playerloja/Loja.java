package me.jonasxpx.playerloja;

import me.jonasxpx.playerloja.interfaces.TeleportManager;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public final class Loja implements TeleportManager {

	private final String player;
	private Location loc;
	private PlayerLoja pl;

	public Loja(PlayerLoja pl, String player) {
		this.player = player.toLowerCase();
		this.pl = pl;
	}

	@Override
	public Location getLocation() {
		String[] l = pl.getConfig().getString(player+".Loja").split(",");
		return new Location(Bukkit.getWorld(l[0]), Double.parseDouble(l[1]), Double.parseDouble(l[2]), Double.parseDouble(l[3]), Float.parseFloat(l[5]), Float.parseFloat(l[4]));
	}

	@Override
	public boolean containsSet() {
		return (pl.getConfig().contains(player+".Loja")) ? true : false;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void setNewLocation(Location lastLocation) {
		this.loc = Bukkit.getPlayer(player).getLocation();
		pl.getConfig().set(player+".Loja", loc.getWorld().getName()+","+loc.getX()+","+loc.getY()+","+loc.getZ()+","+loc.getPitch()+","+loc.getYaw());
		pl.saveConfig();
	}

	@Override
	public boolean removeLocation() {
		this.loc = null;
		pl.getConfig().set(player, null);
		pl.saveConfig();
		return true;
	}

}
