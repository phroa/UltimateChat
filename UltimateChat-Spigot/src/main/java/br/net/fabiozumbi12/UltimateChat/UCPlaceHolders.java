package br.net.fabiozumbi12.UltimateChat;

import me.clip.placeholderapi.external.EZPlaceholderHook;

import org.bukkit.entity.Player;

public class UCPlaceHolders extends EZPlaceholderHook {

	public UCPlaceHolders(UChat plugin) {
		super(plugin, "uchat");
	}

	@Override
	public String onPlaceholderRequest(Player p, String arg) {
		String text = "--";
		if (arg.equals("player_channel_name")){
			text = UChat.config.getChannel(UChat.pChannels.get(p.getName())).getName();
		}
		if (arg.equals("player_channel_alias")){
			text = UChat.config.getChannel(UChat.pChannels.get(p.getName())).getAlias();
		}
		if (arg.equals("player_channel_color")){
			text = UChat.config.getChannel(UChat.pChannels.get(p.getName())).getColor();
		}
		if (arg.equals("player_tell_with") && UChat.tellPlayers.containsKey(p.getName())){
			text = UChat.tellPlayers.get(p.getName());
		}
		if (arg.equals("player_ignoring") && UChat.ignoringPlayer.containsKey(p.getName())){
			text = UChat.ignoringPlayer.get(p.getName()).toArray().toString();
		}
		if (arg.equals("default_channel")){
			text = UChat.config.getDefChannel().getName();
		}		
		return text;
	}
}
