package hra.listenery;

import hra.mista.MistoAreny;
import hra.vybava.VybavaOhnivak;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static hra.vybava.MecNaTeleportery.MEC_NA_TELEPORTERY;

public class OhnivakListener implements Listener {

    @EventHandler
    public void uderDoTeleportera(EntityDamageByEntityEvent event) {

        if (!(event.getDamager() instanceof Player)) return;
        var hrac = (Player) event.getDamager();
        var mistoAreny = new MistoAreny(hrac.getWorld());
        var vesnican = event.getEntity();
        var jmenoVesnicana = vesnican.getCustomName();

        if (Teleporteri.OHNIVAK.getJmeno().equals(jmenoVesnicana)) {
            if ((Teleporteri.OHNIVAK.getJmeno().equals(event.getEntity().getCustomName())) &&
                    ((MEC_NA_TELEPORTERY.equals(hrac.getInventory().getItemInMainHand().getItemMeta().getDisplayName())))) {
                event.getEntity().remove();
             } else {
                var vybavaOhnivak = new VybavaOhnivak();
                hrac.teleport(mistoAreny.get());
                hrac.sendMessage("Byl jsi úspěšně připojen do hry.");
                hrac.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999999, 5, true, false, false));
                hrac.getInventory().clear();
                hrac.getInventory().setBoots(vybavaOhnivak.vyrobOhnivakBoty());
                hrac.getInventory().setHelmet(vybavaOhnivak.vyrobOhnivakHelma());
                hrac.getInventory().setChestplate(vybavaOhnivak.vyrobOhnivakBrneni());
                hrac.getInventory().setLeggings(vybavaOhnivak.vyrobOhnivakKalhoty());
                hrac.getInventory().addItem(vybavaOhnivak.vyrobOhnivakMec());
                hrac.getInventory().addItem(vybavaOhnivak.vyrobSekeru());
                hrac.getInventory().addItem(vybavaOhnivak.vyrobLuk());
                hrac.getInventory().addItem(vybavaOhnivak.vyrobSip());
                hrac.getInventory().addItem(vybavaOhnivak.vyrobEnderPerlu());
                hrac.getInventory().addItem(vybavaOhnivak.vyrobJabka());
                hrac.getInventory().setItemInOffHand(vybavaOhnivak.vyrobOhnivakStit());
                if (vesnican instanceof LivingEntity) {
                    LivingEntity zijiciVesnican = (LivingEntity) vesnican;
                    zijiciVesnican.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 10, 5));
                }
            }
        }
    }
}
