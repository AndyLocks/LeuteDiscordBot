package org.leuteds.bot.event;

import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.ArrayList;
import java.util.List;

public class SlashCommandUpdater extends ListenerAdapter {
    @Override
    public void onReady(ReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();

        OptionData user = new OptionData(OptionType.USER, "user", "User to search", true);
        OptionData nickname = new OptionData(OptionType.STRING, "nickname", "User to search", true);

        commandData.add(
                Commands.slash(
                        "search",
                        "get user info"
                ).addOptions(user)
        );

        commandData.add(
                Commands.slash(
                        "find_user",
                        "get user info by nickname"
                ).addOptions(nickname)
        );

        commandData.add(
                Commands.context(Command.Type.USER, "find")
        );

        commandData.add(
                Commands.slash(
                        "connect_discord_account",
                        "connect discord account"
                )
        );

        event.getJDA().updateCommands().addCommands(
                commandData
        ).queue();
    }
}
