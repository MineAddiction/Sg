package com.grampabacon.sgreborn.utils.commands;

import com.grampabacon.sgreborn.utils.MessageBuilder;
import net.md_5.bungee.api.ChatColor;

/**
 * Created by Adam on 05/09/2015.
 */
public enum Messages {
    NOT_ENOUGH_ARGUMENTS(new MessageBuilder("Not enough arguments.").colour(ChatColor.RED).create().toString()),
    TOO_MANY_ARGUMENTS(new MessageBuilder("Too many arguments.").colour(ChatColor.RED).create().toString()),
    COMMAND_NOT_FOUND(new MessageBuilder("Command not found.").colour(ChatColor.RED).create().toString());

    private String message;
    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
