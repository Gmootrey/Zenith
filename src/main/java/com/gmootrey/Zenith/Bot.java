package com.gmootrey.Zenith;

import com.gmootrey.Zenith.slashcommands.HelpCommand;
import com.gmootrey.Zenith.slashcommands.InsultCommand;
import com.gmootrey.Zenith.slashcommands.AddInsultCommand;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;


public class Bot extends ListenerAdapter {

    // TODO: should these be instance variables?
    JDA api;
    CommandListUpdateAction commands;

    InsultCommand insultRunner;
    HelpCommand helpRunner;
    AddInsultCommand addInsultRunner;

    private String getToken() {
        try {
            Scanner sc = new Scanner(new File("src/main/java/com/gmootrey/Zenith/token.txt"));
            return sc.useDelimiter("\\A").next();
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void initCMDS() {
        api = JDABuilder.createDefault(getToken())
                .addEventListeners(new Bot())
                .build();

        commands = api.updateCommands();
        // Update all runner objects to eventually call their class setup method, then "run" in the listener.
        // TODO: iterate through these?
        insultRunner = new InsultCommand(commands);
        helpRunner = new HelpCommand(commands);
        addInsultRunner = new AddInsultCommand(commands);

        //TODO integrate setup() into constructor
        insultRunner.setup();
        helpRunner.setup();
        addInsultRunner.setup();


        commands.queue();
    }

    public static void main(String[] args) {
        Bot setupCMD = new Bot();
        setupCMD.initCMDS();
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        //TODO: setup where commands are accepted (guilds)
        switch (event.getName()) {
            // TODO: avoid updating instance variables for each case... or check if they're making more objects per case
            case "help":
                helpRunner = new HelpCommand(commands);
                helpRunner.run(event);
                break;

            case "insult":
                insultRunner.run();

                break;

        }
    }
}
