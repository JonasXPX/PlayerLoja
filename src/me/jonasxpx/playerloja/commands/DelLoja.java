package me.jonasxpx.playerloja.commands;

import me.jonasxpx.playerloja.Loja;
import me.jonasxpx.playerloja.PlayerLoja;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DelLoja implements CommandExecutor{
	
	private Loja loja;
	private PlayerLoja pl;
	
	public DelLoja(PlayerLoja pl) {
		this.pl = pl;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if(args.length >= 0){
			if(sender instanceof Player){
				loja = new Loja(pl, sender.getName());
				if(loja.containsSet()){
					if(loja.removeLocation()){
						sender.sendMessage("§bSua loja foi deletada!.");
					}
				}else{
					sender.sendMessage("§bVocê nao contem uma loja");
					return true;
				}
			}
		}
		return false;
	}
	
}
