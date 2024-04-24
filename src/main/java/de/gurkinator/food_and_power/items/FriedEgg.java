package de.gurkinator.food_and_power.items;

import de.gurkinator.food_and_power.FoodItem;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.Recipe;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

public class FriedEgg extends FoodItem {
    public FriedEgg(NamespacedKey foodLevelKey, JavaPlugin plugin) {
        super(foodLevelKey, plugin, "fried_egg");

        base.editMeta(m -> {
            m.setCustomModelData(2);
            m.displayName(Component.translatable("fried_egg", "Fried Egg"));
            m.getPersistentDataContainer().set(foodLevelKey, PersistentDataType.INTEGER, 5);
        });
    }

    @Override
    public Recipe getRecipe() {
        return new FurnaceRecipe(
                itemKey,
                base,
                Material.EGG,
                0f,
                100
        );
    }
}
