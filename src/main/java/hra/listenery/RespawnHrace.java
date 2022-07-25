package hra.listenery;

import hra.mista.MistoLobby;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerRespawnEvent;

public class RespawnHrace {
    public void respawn(PlayerRespawnEvent respawnEvent) {
        Player player = respawnEvent.getPlayer();
        var mistoLoby = new MistoLobby(player.getWorld());
        player.getInventory().clear();
        player.teleport(mistoLoby.get());
    }
}
