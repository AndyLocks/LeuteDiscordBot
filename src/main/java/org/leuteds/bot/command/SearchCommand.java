package org.leuteds.bot.command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.leuteds.api.Api;
import org.leuteds.bot.EmbedBuilderCreator;
import org.leuteds.model.Account;
import org.springframework.web.client.ResourceAccessException;

import java.awt.*;

public class SearchCommand extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if(event.getName().equals("search")) {
            OptionMapping userMapping = event.getOption("user");
            User user = userMapping.getAsUser();

            Account account = null;
            try {
                account = Api.getAccountById(user.getId());
            }
            catch (ResourceAccessException e) {
                event.reply("The service is not responding.").setEphemeral(true).queue();
                return;
            }

            if (account == null) {
                event.reply("Not found").setEphemeral(true).queue();
                return;
            }

            event.replyEmbeds(EmbedBuilderCreator.embedBuilderFromAccount(account).build()).queue();
        }
    }
}
