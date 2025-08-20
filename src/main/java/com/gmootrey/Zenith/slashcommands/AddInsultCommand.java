package com.gmootrey.Zenith.slashcommands;

import net.dv8tion.jda.api.interactions.InteractionContextType;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;

public class AddInsultCommand {
    private CommandListUpdateAction commands;

    public AddInsultCommand(CommandListUpdateAction commands) {
        this.commands = commands;

    }

    // TODO: complete this class
    public void setup() {
        commands.addCommands(
                Commands.slash("addinsult", "Adds an insult to the insult list.")
                        .setContexts(InteractionContextType.BOT_DM)
                        .addOption(OptionType.STRING, "Placeholder", "The point to mention the user when calling the insult.", true)
        );
    }
    public void run() {

    }


}
