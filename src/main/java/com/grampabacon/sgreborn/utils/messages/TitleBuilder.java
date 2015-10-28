package com.grampabacon.sgreborn.utils.messages;

import net.md_5.bungee.api.ChatColor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by adam on 28/10/2015.
 */
public class TitleBuilder {
    private Class<?> titlePacket;
    private Class<?> actionsPacket;
    private Class<?> chatBaseComponent;
    private Class<?> chatSerializer;

    private String title = "";
    private ChatColor titleColor = ChatColor.WHITE;

    private String subtitle = "";
    private ChatColor subColor = ChatColor.WHITE;

    private int fadeInTicks = -20;
    private int stayTicks = -20;
    private int fadeOutTicks = -20;

    private static final Map<Class<?>, Class<?>> CORRESPONDING_TYPES = new HashMap<>();

    public TitleBuilder(String title) {
        this.title = title;
        loadClasses();
    }

    public TitleBuilder(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;

        loadClasses();
    }

    public TitleBuilder(TitleBuilder title) {
        this.title = title.title;
        this.subtitle = title.subtitle;
        this.titleColor = title.titleColor;
        this.subColor = title.subColor;
        this.fadeInTicks = title.fadeInTicks;
        this.stayTicks = title.stayTicks;
        this.fadeOutTicks = title.fadeOutTicks;

        loadClasses();
    }

    public TitleBuilder(String title, String subtitle, int fadeInTicks, int stayTicks, int fadeOutTicks) {
        this.title = title;
        this.subtitle = subtitle;
        this.fadeInTicks = fadeInTicks;
        this.stayTicks = stayTicks;
        this.fadeOutTicks = fadeOutTicks;

        loadClasses();
    }

    private void loadClasses() {
        titlePacket = getNmsClass("PacketPlayOutTitle");
        actionsPacket = getNmsClass("PacketPlayOutTitle$EnumTitleAction");
        chatBaseComponent = getNmsClass("IChatBaseComponent");
        chatSerializer = getNmsClass("IChatBaseComponent$ChatSerializer");
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }
}
