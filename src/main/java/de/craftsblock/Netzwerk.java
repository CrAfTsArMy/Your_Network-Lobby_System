package de.craftsblock;

import de.craftsarmy.craftscore.minecraft.Minecraft;
import de.craftsblock.commands.GamemodeCommand;
import de.craftsblock.listeners.ConnectionListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Netzwerk extends JavaPlugin {

    @Override
    public void onEnable() {
        Minecraft.instance().init(this);

        //Bukkit.getOnlinePlayers().forEach(ScoreboardUtils::show);

        register();

        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new ConnectionListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void register() {
        new GamemodeCommand();
    }

}
