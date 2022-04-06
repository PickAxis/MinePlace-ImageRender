package com.pickaxis.place.imagerender.tasks;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;

import com.pickaxis.place.imagerender.MinePlacePlugin;
import com.pickaxis.place.imagerender.util.MessageUtil;

import lombok.Getter;

import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitRunnable;

@Getter
public class DownloadImageTask extends BukkitRunnable
{
    private final URL pngUrl;

    private final CommandSender sender;

    public DownloadImageTask( String pngUrl, CommandSender sender ) throws MalformedURLException
    {
        this.pngUrl = new URL( pngUrl );
        this.sender = sender;
    }

    @Override
    public void run()
    {
        BufferedImage image;
        try
        {
            image = ImageIO.read( pngUrl );
        }
        catch( IOException ex )
        {
            MessageUtil.message( sender, "Failed to download image: " + ex.getMessage() );
            return;
        }

        if( image instanceof BufferedImage )
        {
            new FramePaintTask( image ).runTask( MinePlacePlugin.getInstance() );
        }
    }
}
