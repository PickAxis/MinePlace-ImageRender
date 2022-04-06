package com.pickaxis.place.imagerender;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;

import com.pickaxis.place.imagerender.command.MinePlaceCommand;
import com.pickaxis.place.imagerender.command.RenderCommand;
import com.pickaxis.place.imagerender.command.TpPlaceCommand;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
@Setter( AccessLevel.PRIVATE )
public class MinePlacePlugin extends JavaPlugin
{
    @Getter
    @Setter( AccessLevel.PRIVATE )
    private static MinePlacePlugin instance;
    
    private Properties buildInfo;

    private World world;

    private int blockHeight;

    private int teleportHeight;

    @Setter( AccessLevel.PUBLIC )
    private int fallingBlocksInFlight;
    
    public MinePlacePlugin()
    {
        MinePlacePlugin.setInstance( this );
        this.fallingBlocksInFlight = 0;
    }
    
    @Override
    public void onEnable()
    {
        this.setBuildInfo( new Properties() );
        try
        {
            this.getBuildInfo().load( this.getClass().getClassLoader().getResourceAsStream( "git.properties" ) );
        }
        catch( IOException ex )
        {
            this.getLogger().log( Level.WARNING, "Couldn't load build info.", ex );
        }
        
        this.getCommand( "mineplace" ).setExecutor( new MinePlaceCommand() );
        this.getCommand( "tpplace" ).setExecutor( new TpPlaceCommand() );
        this.getCommand( "render" ).setExecutor( new RenderCommand() );

        this.setWorld( Bukkit.getWorld( MinePlacePlugin.getInstance().getConfig().getString( "world", "mineplace" ) ) );
        this.setBlockHeight( this.getConfig().getInt( "height", 60 ) );
        this.setTeleportHeight( this.getConfig().getInt( "teleport-height", 100 ) );
    }
}
