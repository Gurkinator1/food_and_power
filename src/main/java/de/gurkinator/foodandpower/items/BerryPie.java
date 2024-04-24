package de.gurkinator.foodandpower.items;

import de.gurkinator.foodandpower.FoodItem;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

public class BerryPie extends FoodItem {
    public BerryPie(NamespacedKey foodLevelKey, JavaPlugin plugin) {
        super(foodLevelKey, plugin, "berry_pie");

        base.editMeta(m -> {
            m.setCustomModelData(1);
            m.displayName(Component.translatable("berry_pie", "Berry Pie"));
            m.getPersistentDataContainer().set(foodLevelKey, PersistentDataType.INTEGER, 10);
        });
    }

    @Override
    public Recipe getRecipe() {
        ShapelessRecipe recipe = new ShapelessRecipe(itemKey, base);
        recipe.addIngredient(Material.EGG);
        recipe.addIngredient(Material.SUGAR);
        recipe.addIngredient(Material.SWEET_BERRIES);
        return recipe;
    }
}
