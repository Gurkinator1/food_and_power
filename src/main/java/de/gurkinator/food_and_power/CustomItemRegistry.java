package de.gurkinator.food_and_power;

import net.kyori.adventure.key.Key;
import org.bukkit.Bukkit;
import java.util.HashMap;

public class CustomItemRegistry {
    private final HashMap<Key, FoodItem> registry = new HashMap<>();
    public CustomItemRegistry() {
    }
    public void register(FoodItem item) {
        registry.put(item.key(), item);
    }

    public void registerAllRecipes() {
        registry.forEach((k, v) -> Bukkit.addRecipe(v.getRecipe()));
    }
}
