package hra.vybava;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class MecNaTeleportery implements CommandExecutor {

    public static final String MEC_NA_TELEPORTERY = "MEC NA TELEPORTERY";

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) return false;
        var player = (Player) commandSender;

        var mecNaTeleportery = new ItemStack(Material.GOLDEN_SWORD);
        var itemMeta = mecNaTeleportery.getItemMeta();
        itemMeta.setDisplayName(MEC_NA_TELEPORTERY);
        itemMeta.setUnbreakable(true);
        AttributeModifier attributeModifier = new AttributeModifier("Damage", 5, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, attributeModifier);
        mecNaTeleportery.setItemMeta(itemMeta);
        player.getInventory().addItem(mecNaTeleportery);
        return true;
    }
}
