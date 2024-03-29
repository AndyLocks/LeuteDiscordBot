package org.leuteds.bot.command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import net.dv8tion.jda.api.interactions.modals.Modal;
import org.leuteds.api.Api;
import org.leuteds.model.DiscordAccountPost;
import org.springframework.web.client.HttpClientErrorException;

import java.awt.*;
import java.util.regex.Pattern;

public class AddDiscordAccount extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("connect_discord_account")) {
            Button firstButton = Button.secondary("login_button", "Login");

            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setTitle("Login")
                    .setDescription("Вы точно хотите подключить дискорд аккаунт?")
                    .setFooter("Внимание!!!\nНе вводите свои данные от аккаунта discord!")
                    .setColor(Color.getColor("2c2f33"));

            event.replyEmbeds(embedBuilder.build()).addActionRow(firstButton).setEphemeral(true).queue();
        }
    }

    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        if (event.getComponentId().equals("login_button")) {
            TextInput email = TextInput.create("email", "Email", TextInputStyle.SHORT)
                    .setPlaceholder("Email")
                    .setRequired(true)
                    .build();

            TextInput password = TextInput.create("password", "Password", TextInputStyle.SHORT)
                    .setPlaceholder("Password")
                    .setRequired(true)
                    .build();

            Modal modal = Modal.create("login_modmail", "Login")
                    .addComponents(ActionRow.of(email), ActionRow.of(password))
                    .build();

            event.replyModal(modal).queue();
        }
    }

    @Override
    public void onModalInteraction(ModalInteractionEvent event) {
        if (event.getModalId().equals("login_modmail")) {
            String email = event.getValue("email").getAsString();
            String password = event.getValue("password").getAsString();

            if (!Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$").matcher(email).matches()) {
                event.reply("Email is not correct.").setEphemeral(true).queue();
                return;
            }

            if (!Api.checkLogin(email, password)) {
                event.reply("Password is not correct.").setEphemeral(true).queue();
                return;
            }

            DiscordAccountPost discordAccountPost = new DiscordAccountPost(
                    event.getMember().getUser().getName(),
                    event.getMember().getUser().getEffectiveName(),
                    "",
                    event.getMember().getUser().getId(),
                    event.getMember().getUser().getAvatarUrl()
            );

            try {
                Api.addDiscordAccount(
                        discordAccountPost,
                        email,
                        password
                );
            }
            catch (HttpClientErrorException e) {
                if (e.getStatusCode().value() == 409) {
                    event.reply("Discord account is already added").setEphemeral(true).queue();
                } else if (e.getStatusCode().value() == 400) {
                    event.reply(e.getMessage()).setEphemeral(true).queue();
                }
                return;
            }

            event.reply(":white_check_mark:").setEphemeral(true).queue();
        }
    }
}
