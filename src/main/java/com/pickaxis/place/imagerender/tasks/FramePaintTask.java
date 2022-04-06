package com.pickaxis.place.imagerender.tasks;

import java.awt.image.BufferedImage;
import java.util.Optional;
import java.util.logging.Level;

import com.pickaxis.place.imagerender.MinePlacePlugin;
import com.pickaxis.place.imagerender.PlaceColor;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.scheduler.BukkitRunnable;

public class FramePaintTask extends BukkitRunnable
{
    private final BufferedImage image;

    FramePaintTask( BufferedImage image )
    {
        this.image = image;
    }

    @Override
    public void run()
    {
        MinePlacePlugin mp = MinePlacePlugin.getInstance();

        int[] pixels = image.getRGB( 0, 0, image.getWidth(), image.getHeight(), null, 0, image.getWidth() );

        for( int x = 0; x < image.getHeight(); x++ )
        {
            if( x % 50 == 0 )
            {
                MinePlacePlugin.getInstance().getLogger().log( Level.INFO, "Rendering x={0}", x );
            }

            for( int z = 0; z < image.getWidth(); z++ )
            {
                int pixel = z * image.getWidth() + x;
                int argb = pixels[ pixel ];
                int alpha = ( argb >> 24 ) & 0xFF;

                if( alpha != 0 )
                {
                    Optional<PlaceColor> color = PlaceColor.getColorByRGB( argb );
                    if( !color.isPresent() )
                    {
                        MinePlacePlugin.getInstance().getLogger().log( Level.WARNING, "Missing color {0} at {1}, {2}", new Object[]{ argb, x, z } );
                        continue;
                    }
                    Material material = color.get().getMaterial();

                    Block block = mp.getWorld().getBlockAt( x, mp.getBlockHeight(), z );
                    if( block.getType() != material )
                    {
                        block.setType( material );
                    }
                }
            }
        }
    }
}
