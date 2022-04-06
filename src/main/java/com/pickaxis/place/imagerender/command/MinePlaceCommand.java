package com.pickaxis.place.imagerender.command;

import com.pickaxis.place.imagerender.MinePlacePlugin;
import com.pickaxis.place.imagerender.util.MessageUtil;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MinePlaceCommand implements CommandExecutor
{
    @Override
    public boolean onCommand( CommandSender sender, Command command, String label, String[] args )
    {
        MinePlacePlugin mp = MinePlacePlugin.getInstance();
        
        MessageUtil.message( sender, "MinePlace v" + mp.getDescription().getVersion() + " (" +
                                mp.getBuildInfo().getProperty( "git.branch" ) + "/" +
                                mp.getBuildInfo().getProperty( "git.commit.id.describe" ) + ")" );

        String builtBy = "";
        if( sender.hasPermission( "mineplace.cmd.info.extended" ) )
        {
            builtBy = "by " + mp.getBuildInfo().getProperty( "git.build.user.name" );
        }
        MessageUtil.message( sender, "Built " + builtBy + " on " +
                                mp.getBuildInfo().getProperty( "git.build.time" ) );

        if( sender.hasPermission( "mineplace.cmd.info.extended" ) )
        {
            MessageUtil.message( sender, "Full Commit Hash: " + mp.getBuildInfo().getProperty( "git.commit.id" ) );
            MessageUtil.message( sender, "Commit Message: " + mp.getBuildInfo().getProperty( "git.commit.message.short" ) );
            MessageUtil.message( sender, "Committed by " + mp.getBuildInfo().getProperty( "git.commit.user.name" ) + " <" +
                                    mp.getBuildInfo().getProperty( "git.commit.user.email" ) + "> on " +
                                    mp.getBuildInfo().getProperty( "git.commit.time" ) );
        }

        MessageUtil.message( sender, "Scheduler workers: " + mp.getServer().getScheduler().getActiveWorkers().size() );
        MessageUtil.message( sender, "Pending tasks: " + mp.getServer().getScheduler().getPendingTasks().size() );
        
        return true;
    }
}
