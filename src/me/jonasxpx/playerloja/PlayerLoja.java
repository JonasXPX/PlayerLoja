package me.jonasxpx.playerloja;

import me.jonasxpx.playerloja.commands.DelLoja;
import me.jonasxpx.playerloja.commands.SetLoja;

import org.bukkit.plugin.java.JavaPlugin;
/**
 * 
 * @author JonasXPX
 * @since 30/3/2015
 * Este codigo nao deve ser modificado,
 * assim respeitando o direito do autor.
 *
 */
public class PlayerLoja extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getCommand("delloja").setExecutor(new DelLoja(this));
		getCommand("setloja").setExecutor(new SetLoja(this));
		getCommand("loja").setExecutor(new me.jonasxpx.playerloja.commands.Loja(this));
	}

	public final static PlayerLoja getThisPlugin(){
		return new PlayerLoja();
	}
}
