package hra.listenery;

import hra.mista.MistoLobby;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class RespawnHrace implements Listener {
    @EventHandler
    public void respawn(PlayerRespawnEvent respawnEvent) {
        Player player = respawnEvent.getPlayer();
        var mistoLoby = new MistoLobby(player.getWorld());
        player.getInventory().clear();
        player.teleport(mistoLoby.get());
    }
}
