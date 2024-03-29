package org.leuteds;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.leuteds.bot.command.FindUserCommand;
import org.leuteds.bot.command.AddDiscordAccount;
import org.leuteds.bot.command.SearchCommand;
import org.leuteds.bot.context_menu.FindContextMenu;
import org.leuteds.bot.event.SlashCommandUpdater;

import java.io.IOException;

public class Main {
    private static ShardManager shard;

    public static void main(String[] args) throws IOException {
        Dotenv config = Dotenv.configure().load();
        String token = config.get("DISCORD_TOKEN");

        DefaultShardManagerBuilder bot = DefaultShardManagerBuilder.create(
                token,
                GatewayIntent.GUILD_MESSAGES,
                GatewayIntent.AUTO_MODERATION_CONFIGURATION,
                GatewayIntent.AUTO_MODERATION_EXECUTION,
                GatewayIntent.DIRECT_MESSAGE_REACTIONS,
                GatewayIntent.DIRECT_MESSAGE_TYPING,
                GatewayIntent.DIRECT_MESSAGES,
                GatewayIntent.GUILD_EMOJIS_AND_STICKERS,
                GatewayIntent.GUILD_INVITES,
                GatewayIntent.GUILD_MEMBERS,
                GatewayIntent.GUILD_MESSAGE_REACTIONS,
                GatewayIntent.GUILD_MESSAGE_TYPING,
                GatewayIntent.GUILD_MODERATION,
                GatewayIntent.GUILD_PRESENCES,
                GatewayIntent.GUILD_VOICE_STATES,
                GatewayIntent.MESSAGE_CONTENT,
                GatewayIntent.SCHEDULED_EVENTS
        );


        bot.setMemberCachePolicy(MemberCachePolicy.ALL);
        bot.setChunkingFilter(ChunkingFilter.ALL);
        bot.enableCache(CacheFlag.ONLINE_STATUS);

        bot.addEventListeners(new SlashCommandUpdater());

        bot.addEventListeners(
                new SearchCommand(),
                new FindUserCommand(),
                new FindContextMenu(),
                new AddDiscordAccount()
        );

        shard = bot.build();
    }

    public static ShardManager getShard() {
        return shard;
    }

}