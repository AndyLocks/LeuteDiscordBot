package org.leuteds.bot.command;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.leuteds.api.Api;
import org.leuteds.bot.EmbedBuilderCreator;
import org.leuteds.model.Account;
import org.springframework.web.client.ResourceAccessException;

public class FindUserCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if(event.getName().equals("find_user")) {
            OptionMapping userMapping = event.getOption("nickname");
            String nickname = userMapping.getAsString();

            Account account = null;
            try {
                account = Api.getAccount(nickname);;
            }
            catch (ResourceAccessException e) {
                event.reply("The service is not responding.").setEphemeral(true).queue();
                return;
            }

            if (account == null) {
                event.reply("Not found").setEphemeral(true).queue();
                return;
            }

            event.replyEmbeds(EmbedBuilderCreator.embedBuilderFromAccountWithDiscordAccountInformation(account).build()).queue();
        }
    }
}
