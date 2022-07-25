package hra.teleporteri.listenery;

import hra.teleporteri.Teleporteri;
import hra.teleporteri.*;
import hra.teleporteri.commands.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;


public class NesmrtelnostTeleporteru implements Listener {

    @EventHandler
    public void nesmrtelnostTeleporteru(EntityDeathEvent event) {

        String jmeno = event.getEntity().getCustomName();
        if (jmeno == null) return;
        var entity = event.getEntity();
        try {
            var teleporter = Teleporteri.valueOf(jmeno.toUpperCase());
            switch (teleporter) {
                case DUCH:
                    new Duch().vytvorDucha(entity.getWorld(), entity.getLocation());
                    break;
                case GOLEM:
                    new Golem().vytvorGolema(entity.getWorld(), entity.getLocation());
                    break;
                case LUCISTNIK:
                    new Lucistnik().vytvorLucistnika(entity.getWorld(), entity.getLocation());
                    break;
                case OHNIVAK:
                    new Ohnivak().vytvorOhnivaka(entity.getWorld(), entity.getLocation());
                    break;
                case VIDLAK:
                    new Vidlak().vytvorVidlaka(entity.getWorld(), entity.getLocation());
                    break;
            }
        } catch (IllegalArgumentException e) {
            return;
        }

    }
}