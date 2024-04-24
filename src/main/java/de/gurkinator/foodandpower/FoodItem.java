package de.gurkinator.foodandpower;

import org.bukkit.Keyed;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public abstract class FoodItem implements Keyed {
    protected final NamespacedKey foodLevelKey;
    protected final NamespacedKey itemKey;
    protected final ItemStack base = new ItemStack(Material.BREAD);
    public FoodItem(NamespacedKey foodLevelKey, JavaPlugin plugin, String id) {
        this.foodLevelKey = foodLevelKey;
        this.itemKey = new NamespacedKey(plugin, id);
    }

    public abstract Recipe getRecipe();

    @Override
    public @NotNull NamespacedKey getKey() {
        return itemKey;
    }
}
