package org.leuteds.bot;


import net.dv8tion.jda.api.EmbedBuilder;
import org.leuteds.model.Account;

import java.awt.*;

public class EmbedBuilderCreator {
    private static Color standardColor = Color.getColor("2c2f33");
    public static EmbedBuilder embedBuilderFromAccount(Account account) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setDescription("# " + account.getNickname() + "\n\n" + account.getDescription())
                .setColor(standardColor);

        return embedBuilder;
    }

    public static EmbedBuilder embedBuilderFromAccountWithDiscordAccountInformation(Account account) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setDescription("# " + account.getNickname() + "\n\n" + account.getDescription())
                .setFooter(account.getDiscordNickname(), account.getImageUrl())
                .setColor(standardColor);

        return embedBuilder;
    }
}
