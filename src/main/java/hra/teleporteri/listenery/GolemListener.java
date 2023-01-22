package hra.teleporteri.listenery;


import hra.mista.MistoAreny;
import hra.teleporteri.Teleporteri;
import hra.vybava.VybavaGolem;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static hra.vybava.MecNaTeleportery.MEC_NA_TELEPORTERY;

public class GolemListener implements Listener {

    @EventHandler
    public void uderDoTeleportera(EntityDamageByEntityEvent event) {

        if (!(event.getDamager() instanceof Player)) return;
        var hrac = (Player) event.getDamager();
        var mistoAreny = new MistoAreny(hrac.getWorld());
        var vesnican = event.getEntity();
        var jmenoVesnicana = vesnican.getCustomName();

        if (Teleporteri.GOLEM.getJmeno().equals(jmenoVesnicana)) {
            if ((Teleporteri.GOLEM.getJmeno().equals(event.getEntity().getCustomName())) &&
                    ((MEC_NA_TELEPORTERY.equals(hrac.getInventory().getItemInMainHand().getItemMeta().getDisplayName())))) {
                event.getEntity().remove();
                //            event.setCancelled(true);
            } else {
                var vybavaGolem = new VybavaGolem();
                hrac.teleport(mistoAreny.get());
                hrac.sendMessage("Byl jsi úspěšně připojen do hry.");
                hrac.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999999, 5, true, false, false));
                hrac.getInventory().clear();
                hrac.getInventory().setBoots(vybavaGolem.vyrobGolemBoty());
                hrac.getInventory().setHelmet(vybavaGolem.vyrobGolemDyne());
                hrac.getInventory().setLeggings(vybavaGolem.vyrobGolemKalhoty());
                hrac.getInventory().setChestplate(vybavaGolem.vyrobGolemBrneni());
                hrac.getInventory().addItem(vybavaGolem.vyrobGolemMec());
                hrac.getInventory().addItem(vybavaGolem.vyrobEnderPerlu());
                hrac.getInventory().addItem(vybavaGolem.vyrobJabka());
                hrac.getInventory().addItem(vybavaGolem.vyrobSekeru());
                hrac.getInventory().setItemInOffHand(vybavaGolem.vyrobGolemStit());
                if (vesnican instanceof LivingEntity) {
                    LivingEntity zijiciVesnican = (LivingEntity) vesnican;
                    zijiciVesnican.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 10, 5));
                }
            }
        }
    }
}
