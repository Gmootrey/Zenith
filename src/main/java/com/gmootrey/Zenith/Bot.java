package com.gmootrey.Zenith;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.io.*;

import java.util.*;

public class Bot {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scnr = new Scanner(new File("src/main/java/com/gmootrey/Zenith/token.txt"));
        String token = scnr.useDelimiter("\\A").next();
        scnr.close();
        JDA api = JDABuilder.createDefault((token),
                GatewayIntent.GUILD_MESSAGES,
                GatewayIntent.MESSAGE_CONTENT
                ).build();
        System.out.println(new File(".").getAbsoluteFile());

        api.addEventListener(new MyListener());

    }
}
