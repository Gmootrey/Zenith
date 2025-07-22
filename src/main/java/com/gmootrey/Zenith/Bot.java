package com.gmootrey.Zenith;

import com.gmootrey.Zenith.slashcommands.InsultCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;

import java.io.*;

import java.util.*;

public class Bot {
    
    private static String getToken() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/main/java/com/gmootrey/Zenith/token.txt"));
        String token = sc.useDelimiter("\\A").next();
        sc.close();
        return token;
    }

    public static void main(String[] args) throws FileNotFoundException {
        JDA api = JDABuilder.createDefault(getToken()).build();

        // Instantiate all command objects to eventually call their run method. TODO: a better way of doing this?
        InsultCommand insultRunner = new InsultCommand(api);
        // TODO: call command run methods via slash commands
    }
}
