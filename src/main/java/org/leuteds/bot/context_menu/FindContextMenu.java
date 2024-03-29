package org.leuteds.bot.context_menu;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.leuteds.api.Api;
import org.leuteds.bot.EmbedBuilderCreator;
import org.leuteds.model.Account;
import org.springframework.web.client.ResourceAccessException;

public class FindContextMenu extends ListenerAdapter {
    @Override
    public void onUserContextInteraction(UserContextInteractionEvent event) {
        if(event.getName().equals("find")) {
            Member member = event.getTargetMember();

            Account account = null;
            try {
                account = Api.getAccountById(member.getId());
            }
            catch (ResourceAccessException e) {
                event.reply("The service is not responding.").setEphemeral(true).queue();
                return;
            }

            if (account == null) {
                event.reply("Not found").setEphemeral(true).queue();
                return;
            }

            event.replyEmbeds(EmbedBuilderCreator.embedBuilderFromAccount(account).build()).setEphemeral(true).queue();
        }
    }
}
