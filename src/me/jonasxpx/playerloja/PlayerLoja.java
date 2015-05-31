package me.jonasxpx.playerloja;

import java.io.IOException;
import java.util.logging.Level;

import me.jonasxpx.playerloja.commands.DelLoja;
import me.jonasxpx.playerloja.commands.SetLoja;
import me.mcstats.Metrics;

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
		try{
			Metrics metrics = new Metrics(this);
			metrics.start();
		}catch(IOException ex){
			getLogger().log(Level.WARNING, "Não foi possivel conectar a Metrics");
		}
	}

	public final static PlayerLoja getThisPlugin(){
		return new PlayerLoja();
	}
}
