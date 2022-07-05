package de.craftsblock.listeners;

import de.craftsblock.uitls.ScoreboardUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectionListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (event.getPlayer().hasPermission("player.mvp"))
            event.setJoinMessage("§7[§a+§7] " + event.getPlayer().getName());
        else
            event.setJoinMessage(null);
        //ScoreboardUtils.show(event.getPlayer());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        if (event.getPlayer().hasPermission("player.mvp"))
            event.setQuitMessage("§7[§c-§7] " + event.getPlayer().getName());
        else
            event.setQuitMessage(null);
    }

}
