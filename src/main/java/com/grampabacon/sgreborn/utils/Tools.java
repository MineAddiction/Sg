package com.grampabacon.sgreborn.utils;

import com.grampabacon.sgreborn.utils.commands.AbstractCommand;
import com.grampabacon.sgreborn.utils.commands.Messages;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 21/07/2015.
 */
public class Tools {

    private Tools() {

    }

    public static List<String> stringToList(String s, String sep) {
        List<String> l = new ArrayList<>();
        String ls = "";

        for (int i = 0; i < s.length() - sep.length() + 1; i++) {
            if (s.substring(i, i + sep.length()).equalsIgnoreCase(sep)) {
                l.add(ls);
                ls = "";
                i = i + sep.length() - 1;
            } else {
                ls = ls + s.substring(i, i + 1);
            }
        }
        if (ls.length() > 0) {
            l.add(ls);
        }
        return l;
    }

    public static String listToString(List<Object> list, String sep, String wrapper) {
        String sb = "";
        StringBuilder builder;

        for (Object s : list) {
            builder = new StringBuilder(wrapper);
            builder.append(s);
            builder.append(wrapper);
            s = builder.toString();

            sb += s + sep;
        }

        sb = sb.substring(0, sb.length() - sep.length());
        return sb;
    }

    public static String toLowerCase(String s) {
        return s == null ? null : s.toLowerCase();
    }

    public static boolean argsTest(CommandSender sender, String[] args, AbstractCommand command, int num) {
        if (args.length > num) {
            sender.sendMessage(Messages.TOO_MANY_ARGUMENTS.getMessage());
            sender.sendMessage(ChatColor.RED + command.usage());
            return false;
        }
        if (args.length < num) {
            sender.sendMessage(Messages.NOT_ENOUGH_ARGUMENTS.getMessage());
            sender.sendMessage(ChatColor.RED + command.usage());
            return false;
        }
        return true;
    }

    public static String getTitle(){
        String prefix = "[Permissions]";
        String spacer = "=";

        int titleLength = prefix.length() + 2;
        int chatLength = 53;
        String string = ChatColor.GREEN + "";

        int titlePosition = (int) Math.floor((chatLength - titleLength) / 2);

        for(int i = 0; i < 53; i++){
            if (i == titlePosition) {
                string += " " + prefix + ChatColor.GREEN + " ";
                i += prefix.length() - 2;
            } else {
                string += spacer;
            }
        }

        return string;
    }
}
