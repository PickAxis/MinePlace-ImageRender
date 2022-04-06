package com.pickaxis.place.imagerender.command;

import java.net.MalformedURLException;

import com.pickaxis.place.imagerender.MinePlacePlugin;
import com.pickaxis.place.imagerender.tasks.DownloadImageTask;
import com.pickaxis.place.imagerender.util.MessageUtil;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class RenderCommand implements CommandExecutor
{
    @Override
    public boolean onCommand( CommandSender sender, Command command, String label, String[] args )
    {
        if( args.length != 1 )
        {
            MessageUtil.message( sender, "Usage: /render <url>" );
            return true;
        }

        try
        {
            new DownloadImageTask( args[0], sender ).runTask( MinePlacePlugin.getInstance() );
        }
        catch( MalformedURLException ex )
        {
            MessageUtil.message( sender, "Error: " + ex.getMessage() );
        }

        return true;
    }
}
