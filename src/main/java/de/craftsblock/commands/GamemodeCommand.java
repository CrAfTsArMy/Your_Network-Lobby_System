package de.craftsblock.commands;

import de.craftsarmy.craftscore.minecraft.commands.AbstractCommand;
import de.craftsblock.Messages;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;

public class GamemodeCommand extends AbstractCommand implements Messages {

    public GamemodeCommand() {
        super("gamemode", "Ändere deinen Spielmodus", "§cUsage: /gamemode <0/1/2/3>", Collections.singletonList("gm"));
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(NO_PLAYER);
            return true;
        }
        if (!sender.hasPermission("command.gamemode")) {
            sender.sendMessage(NO_PERM);
            return true;
        }
        if (args.length != 1) return false;
        switch (args[0].trim().toLowerCase()) {
            case "0", "s", "survival" -> {
                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage(PREFIX + "§7Dein Spielmodus wurde zu §bÜberleben§7 geändert.");
            }
            case "1", "c", "creative" -> {
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage(PREFIX + "§7Dein Spielmodus wurde zu §bKreativ§7 geändert.");
            }
            case "2", "a", "adventure" -> {
                player.setGameMode(GameMode.ADVENTURE);
                player.sendMessage(PREFIX + "§7Dein Spielmodus wurde zu §bAbenteuer§7 geändert.");
            }
            case "3", "sp", "spectator" -> {
                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage(PREFIX + "§7Dein Spielmodus wurde zu §bZuschauer§7 geändert.");
            }
        }
        return true;
    }

}
