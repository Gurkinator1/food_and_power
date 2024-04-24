package de.gurkinator.food_and_power;

import de.gurkinator.food_and_power.items.BerryPie;
import de.gurkinator.food_and_power.items.FriedEgg;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public final class FoodAndPower extends JavaPlugin {
    public final NamespacedKey foodLevelKey = new NamespacedKey(this, "food_level");
    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(new NutritionAdjuster(this), this);

        CustomItemRegistry registry = new CustomItemRegistry();
        registry.register(new BerryPie(foodLevelKey, this));
        registry.register(new FriedEgg(foodLevelKey, this));

        registry.registerAllRecipes();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
