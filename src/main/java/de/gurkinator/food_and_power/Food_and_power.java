package de.gurkinator.food_and_power;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

public final class Food_and_power extends JavaPlugin {
    public final NamespacedKey food_level_key = new NamespacedKey(this, "food_level");
    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(new NutritionAdjuster(this), this);

        //Berry pie
        {
            //create item
            ItemStack item = new ItemStack(Material.BREAD);

            item.editMeta(m -> {
                m.setCustomModelData(1);
                m.displayName(Component.text("berry pie"));
                m.getPersistentDataContainer().set(food_level_key, PersistentDataType.INTEGER, 1);
            });

            //create recipe
            NamespacedKey key = new NamespacedKey(this, "berry_pie");
            ShapelessRecipe recipe = new ShapelessRecipe(key, item);
            recipe.addIngredient(Material.EGG);
            recipe.addIngredient(Material.SUGAR);
            recipe.addIngredient(Material.SWEET_BERRIES);

            Bukkit.addRecipe(recipe);

        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
