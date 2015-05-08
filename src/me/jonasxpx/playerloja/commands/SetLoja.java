package me.jonasxpx.playerloja.commands;

import me.jonasxpx.playerloja.Loja;
import me.jonasxpx.playerloja.PlayerLoja;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetLoja implements CommandExecutor{

	private PlayerLoja pl;
	public SetLoja(PlayerLoja pl) {
		this.pl = pl;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if(args.length >= 0){
			if(sender instanceof Player){
				if(!sender.hasPermission("PlayerLoja.setLoja")){
					sender.sendMessage("§cVocê nao pode marcar uma Loja");
					return true;
				}
				new Loja(pl, sender.getName()).setNewLocation(((Player)sender).getLocation());
				sender.sendMessage("§bLoja marcada!. §6Digite /loja "+sender.getName() + " Para testar.");
				return true;
			}
		}
		return false;
	}

	
	
}
