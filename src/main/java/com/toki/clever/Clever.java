package com.toki.clever;

import com.toki.clever.DirectMessaging.DailyDM.DailyDM;
import com.toki.clever.DirectMessaging.Game.GameDM;
import com.toki.clever.DirectMessaging.HelpDM;
import com.toki.clever.DirectMessaging.DailyDM.Modules.DailyWorkout;
import com.toki.clever.TheCafeServer.cafeMemberJoined;
import com.toki.clever.TheCafeServer.roleCreator.roleChannel;
import com.toki.clever.commands.CommandManager;
import com.toki.clever.events.MessageEventListener;
import com.toki.clever.events.ReadyEventListener;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

public class Clever {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        String token = dotenv.get("TOKEN");
        JDABuilder builder = JDABuilder.createDefault(token);


        builder.setStatus(OnlineStatus.DO_NOT_DISTURB);
        builder.setActivity(Activity.watching("Cat Videos"));
        JDA jda = builder
                .setMemberCachePolicy(MemberCachePolicy.ALL)
                .enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MEMBERS)
                .addEventListeners(new ReadyEventListener(), new CommandManager(), new MessageEventListener(),
                        new DailyDM(), new HelpDM(), new DailyWorkout(), new GameDM(), new roleChannel(), new cafeMemberJoined())
                .build();

    }
}
