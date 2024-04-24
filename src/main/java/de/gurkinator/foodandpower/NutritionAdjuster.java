package de.gurkinator.foodandpower;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class NutritionAdjuster implements Listener {
    FoodAndPower plugin;
    public NutritionAdjuster(FoodAndPower plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    @SuppressWarnings({"DataFlowIssue"})
    public void onEatEvent(PlayerItemConsumeEvent event) {
        PersistentDataContainer pdc = event.getItem().getItemMeta().getPersistentDataContainer();
        if (pdc.has(plugin.foodLevelKey)) {
            event.setCancelled(true);
            int level = pdc.get(plugin.foodLevelKey, PersistentDataType.INTEGER);
            Player p = event.getPlayer();

            //only decrement item if player is in survival/adventure
            GameMode gm = p.getGameMode();
            if (gm == GameMode.SURVIVAL || gm == GameMode.ADVENTURE) {
                ItemStack mainHand = p.getInventory().getItemInMainHand();
                mainHand.setAmount(mainHand.getAmount()-1);
            }

            //add levels
            p.setFoodLevel(Math.min(p.getFoodLevel() + level, 20));
            p.setSaturation(Math.min(p.getSaturation() + level, 20));
        }
    }
}
