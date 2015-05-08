package me.jonasxpx.playerloja.interfece;

import org.bukkit.Location;

public interface TeleportManager {

	public Location getLocation();
	public boolean containsSet();
	public void setNewLocation(Location lastLocation);
	public boolean removeLocation();
	
}
