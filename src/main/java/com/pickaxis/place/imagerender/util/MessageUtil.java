package com.pickaxis.place.imagerender.util;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class MessageUtil
{
    public static final String MESSAGE_PREFIX = ChatColor.DARK_AQUA + "[MinePlace] " + ChatColor.AQUA;

    public static void message( CommandSender sender, String message )
    {
        sender.sendMessage( MessageUtil.MESSAGE_PREFIX + message );
    }
}
