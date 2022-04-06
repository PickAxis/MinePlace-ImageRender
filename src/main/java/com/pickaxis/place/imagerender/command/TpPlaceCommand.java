package com.pickaxis.place.imagerender.command;

import com.pickaxis.place.imagerender.MinePlacePlugin;
import com.pickaxis.place.imagerender.util.MessageUtil;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;

public class TpPlaceCommand implements CommandExecutor
{
    @Override
    public boolean onCommand( CommandSender sender, Command command, String label, String[] args )
    {
        if( args.length == 0 || args.length > 2 )
        {
            MessageUtil.message( sender, "Usage: /tpplace <x> <y>" );
            return true;
        }

        try
        {
            if( args[0].contains( "," ) && args.length == 1 )
            {
                args = args[0].split( "," );
            }

            int x = Integer.parseInt( args[1] );
            int y = Integer.parseInt( args[0] );

            MinePlacePlugin mp = MinePlacePlugin.getInstance();

            Player p = (Player) sender;
            Location dest =  new Location( mp.getWorld(), x, mp.getTeleportHeight(), y, 90, 90 );
            p.teleport( dest, TeleportCause.COMMAND );
        }
        catch( Exception ex )
        {
            MessageUtil.message( sender, "Failed to teleport.  Usage: /tpplace <x> <y>");
        }
        
        return true;
    }
}
