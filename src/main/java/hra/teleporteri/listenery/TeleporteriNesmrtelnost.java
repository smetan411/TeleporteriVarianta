package hra.teleporteri.listenery;

import hra.teleporteri.Teleporteri;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import static hra.vybava.MecNaTeleportery.MEC_NA_TELEPORTERY;

public class TeleporteriNesmrtelnost {
    @EventHandler
    public void nastavNesmrtelnost(EntityDamageByEntityEvent udalost) {

       var utocnik = (Player) udalost.getDamager();

        if ((Teleporteri.DUCH.getJmeno().equals(udalost.getEntity().getCustomName())) &&
                (!(MEC_NA_TELEPORTERY.equals(utocnik.getInventory().getItemInMainHand().getItemMeta().getDisplayName())))) {
            udalost.setCancelled(true);
        }
        else if ((Teleporteri.GOLEM.getJmeno().equals(udalost.getEntity().getCustomName())) &&
                (!(MEC_NA_TELEPORTERY.equals(utocnik.getInventory().getItemInMainHand().getItemMeta().getDisplayName())))) {
            udalost.setCancelled(true);
        }
        else if ((Teleporteri.LUCISTNIK.getJmeno().equals(udalost.getEntity().getCustomName())) &&
                (!(MEC_NA_TELEPORTERY.equals(utocnik.getInventory().getItemInMainHand().getItemMeta().getDisplayName())))) {
            udalost.setCancelled(true);
        }
        else if ((Teleporteri.OHNIVAK.getJmeno().equals(udalost.getEntity().getCustomName())) &&
                (!(MEC_NA_TELEPORTERY.equals(utocnik.getInventory().getItemInMainHand().getItemMeta().getDisplayName())))) {
            udalost.setCancelled(true);
        }
        else if ((Teleporteri.VIDLAK.getJmeno().equals(udalost.getEntity().getCustomName())) &&
                (!(MEC_NA_TELEPORTERY.equals(utocnik.getInventory().getItemInMainHand().getItemMeta().getDisplayName())))) {
            udalost.setCancelled(true);
        }


    }
}