package com.grampabacon.sgreborn.utils;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 08/09/2015.
 */
public class MessageBuilder {
    private ComponentBuilder builder;
    private BaseComponent[] cache;
    private List<String> list;
    private String current;

    public MessageBuilder(String message) {
        if (isChatApiPresent()) {
            builder = new ComponentBuilder(message);
        }
        list = new ArrayList<>();
        current = message;
    }

    public MessageBuilder append(String message) {
        if (isChatApiPresent()) {
            cache = null;
            builder = builder.append(message);
        }
        list.add(current);
        current = message;
        return this;
    }

    public MessageBuilder colour(ChatColor colour) {
        if (isChatApiPresent()) {
            cache = null;
            builder = builder.color(ChatColor.valueOf(colour.name()));
        }
        current = colour + current;
        return this;
    }

    public MessageBuilder bold(boolean bold) {
        if (isChatApiPresent()) {
            cache = null;
            builder = builder.bold(bold);
        } else {
            if (bold) {
                colour(ChatColor.BOLD);
            }
            current = current.replaceAll("" + ChatColor.BOLD, "");
        }
        return this;
    }

    public MessageBuilder italic(boolean italic) {
        if (isChatApiPresent()) {
            cache = null;
            builder = builder.italic(italic);
        } else {
            if (italic) {
                colour(ChatColor.ITALIC);
            }
            current = current.replaceAll("" + ChatColor.ITALIC, "");
        }
        return this;
    }

    public MessageBuilder underlined(boolean underlined) {
        if (isChatApiPresent()) {
            cache = null;
            builder = builder.underlined(underlined);
        } else {
            if (underlined) {
                colour(ChatColor.UNDERLINE);
            }
            current = current.replaceAll("" + ChatColor.UNDERLINE, "");
        }
        return this;
    }

    public MessageBuilder strikethrough(boolean strikethrough) {
        if (isChatApiPresent()) {
            cache = null;
            builder = builder.strikethrough(strikethrough);
        } else {
            if (strikethrough) {
                colour(ChatColor.STRIKETHROUGH);
            }
            current = current.replaceAll("" + ChatColor.STRIKETHROUGH, "");
        }
        return this;
    }

    public MessageBuilder obfuscated(boolean obfuscated) {
        if (isChatApiPresent()) {
            cache = null;
            builder = builder.obfuscated(obfuscated);
        } else {
            if (obfuscated) {
                colour(ChatColor.MAGIC);
            }
            current = current.replaceAll("" + ChatColor.MAGIC, "");
        }
        return this;
    }

    public MessageBuilder event(ClickEvent event) {
        if (isChatApiPresent()) {
            if (event == null) {
                builder = builder.event((ClickEvent) null);
            } else {
                cache = null;
                ClickEvent.Action action = ClickEvent.Action.valueOf(event.getAction().name());
                builder = builder.event(new ClickEvent(action, event.getValue()));
            }
        }
        return this;
    }

    public MessageBuilder event(HoverEvent event) {
        if (isChatApiPresent()) {
            if (event == null) {
                builder = builder.event((HoverEvent) null);
            } else {
                cache = null;
                HoverEvent.Action action = HoverEvent.Action.valueOf(event.getAction().name());
                builder = builder.event(new HoverEvent(action, event.getValue()));
            }
        }
        return this;
    }

    public BaseComponent[] create() {
        if (cache == null) {
            cache = builder.create();
        }
        return cache;
    }

    public String toString() {
        String ret = "";
        for (String s : list) {
            ret = ret + s;
        }
        ret = ret + current;
        return ret;
    }

    public boolean isChatApiPresent() {
        try {
            Class.forName("net.md_5.bungee.api.chat.BaseComponent");
            return true;
        } catch (Throwable t) {

        }
        return false;
    }
}
