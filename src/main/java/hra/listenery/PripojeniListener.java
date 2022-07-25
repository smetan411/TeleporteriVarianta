package hra.listenery;

import hra.mista.MistoLobby;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PripojeniListener implements Listener {

    public void pripojeni(PlayerJoinEvent event) {
        var mistoLoby = new MistoLobby(event.getPlayer().getWorld());
        event.getPlayer().teleport(mistoLoby.get());
    }
}
