package com.gmootrey.Zenith.slashcommands;

import net.dv8tion.jda.api.interactions.InteractionContextType;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HelpCommand {
    private CommandListUpdateAction commands;

    public HelpCommand() {

    }

    public HelpCommand(CommandListUpdateAction commands) {
        this.commands = commands;
    }

    public void setup() {
        commands.addCommands(
                Commands.slash("help", "shows the help context menu.")
                        .setContexts(InteractionContextType.ALL)
        );
    }

    public void run(SlashCommandInteraction event) {
        try {
            Scanner sc = new Scanner(new File("src/main/java/com/gmootrey/Zenith/slashcommands/HelpCMDInput.txt"));
            event.reply(sc.useDelimiter("\\A").next()).queue();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
