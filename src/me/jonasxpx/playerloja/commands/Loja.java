package me.jonasxpx.playerloja.commands;

import me.jonasxpx.playerloja.PlayerLoja;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Loja implements CommandExecutor{
	
	private me.jonasxpx.playerloja.Loja loja;
	private PlayerLoja pl;
	
	public Loja(PlayerLoja pl) {
		this.pl = pl;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if(args.length == 0){
			sender.sendMessage("§bUse:§6 /loja <Nick>");
			return true;
		}
		if(args.length >= 1){
			if(sender instanceof Player){
				Player p = (Player)sender;
				loja = new me.jonasxpx.playerloja.Loja(pl, args[0]);
				if(loja.containsSet()){
					p.teleport(new me.jonasxpx.playerloja.Loja(pl, args[0]).getLocation());
					p.sendMessage("§bBem vindo a loja do jogador(a) §6"+args[0].toLowerCase());
				}else{
					p.sendMessage("§bLoja do jogador nao encontrada!.");
				}
			}
		}
		return false;
	}
}
