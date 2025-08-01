package com.gmootrey.Zenith;

import com.gmootrey.Zenith.slashcommands.HelpCommand;
import com.gmootrey.Zenith.slashcommands.InsultCommand;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;

import java.io.*;

import java.util.*;

public class Bot extends ListenerAdapter {

    // TODO: should these be instance variables?
    JDA api;
    CommandListUpdateAction commands;
    InsultCommand insultRunner;
    HelpCommand helpRunner;

    private String getToken() {
        try {
            Scanner sc = new Scanner(new File("src/main/java/com/gmootrey/Zenith/token.txt"));
            return sc.useDelimiter("\\A").next();
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void setup() {
        this.api = JDABuilder.createDefault(getToken())
                .addEventListeners(new Bot())
                .build();

        this.commands = api.updateCommands();
        // Update all runner objects to eventually call their class setup method, then "run" in the listener.
        this.insultRunner = new InsultCommand(commands);
        this.helpRunner = new HelpCommand(commands);

        // TODO: not sure if setup and queue should be called every time. Refer to docs and implement better solution.
        insultRunner.setup();
        helpRunner.setup();

        commands.queue();
    }

    public static void main(String[] args) {
        Bot setupCMD = new Bot();
        setupCMD.setup();
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        //TODO: setup where commands are accepted (guilds)
        switch (event.getName()) {
            // TODO: avoid updating instance variables for each case
            case "help":
                this.helpRunner = new HelpCommand(commands);
                helpRunner.run(event);
                break;

            case "insult":
                insultRunner.run();

                break;

        }
    }
}
