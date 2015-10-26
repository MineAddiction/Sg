package com.grampabacon.sgreborn.utils.commands;

import org.bukkit.command.CommandSender;

/**
 * Created by Adam on 31/07/2015.
 */
public abstract class AbstractCommand {
    public abstract void onCommand(CommandSender sender, String[] args);

    public abstract String name();

    public abstract String info();

    public abstract String usage();
}
