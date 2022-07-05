package de.craftsblock.uitls;

import de.craftsarmy.craftscore.buildin.animate.Animator;
import de.craftsarmy.craftscore.minecraft.scoreboard.Score;
import de.craftsarmy.craftscore.minecraft.scoreboard.Scoreboard;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ScoreboardUtils {

    public static void show(Player player) {
        Scoreboard scoreboard = new Scoreboard();
        String[] username = player.getName().split("");
        List<String> items = new ArrayList<>();
        StringBuilder temp = new StringBuilder("§c");
        for (String s : username) {
            items.add(temp.toString());
            temp.append(s);
        }
        for (int i = 0; i < 10; i++)
            items.add(temp.toString());
        Animator<String> animator = new Animator<>(items);
        scoreboard.setScore(0, new Score(animator));
        scoreboard.setScore(1, new Score("§6§lDein Name:"));
        scoreboard.setInterval(10);
        scoreboard.build("Willkommen");
        scoreboard.showTo(player);
    }

}
