package com.gmootrey.Zenith.slashcommands;

import com.gmootrey.Zenith.Bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.IntegrationType;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static net.dv8tion.jda.api.interactions.commands.OptionType.ATTACHMENT;
import static net.dv8tion.jda.api.interactions.commands.OptionType.USER;

public class InsultCommand extends ListenerAdapter {
    private CommandListUpdateAction commands;
    Scanner sc;
    public InsultCommand() {

    }

    public InsultCommand(CommandListUpdateAction commands) {
        this.commands = commands;
    }

    public void setup() {
        commands.addCommands(
                Commands.slash("insult", "insults a specified user.")
                        .addOptions(new OptionData(USER, "user", "The user to insult.")
                        .setRequired(true)) // this is true because our OptionData takes USER as a parameter, and the data must be "set by user" per JavaDoc
                        .setIntegrationTypes(IntegrationType.GUILD_INSTALL) // Only can be run in guilds
        );
    }

    public void run() {
        //TODO: handle run

    }
 }

