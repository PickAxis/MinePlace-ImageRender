package com.pickaxis.place.imagerender;

import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;
import java.awt.Color;

import org.bukkit.Material;

@Getter
public enum PlaceColor
{
    BURGUNDY( Color.decode( "#6D001A" ), Material.RED_NETHER_BRICKS ),
    DARK_RED( Color.decode( "#BE0039" ), Material.RED_CONCRETE ),
    ORANGE_RED( Color.decode( "#FF4500" ), Material.RED_WOOL ),
    ORANGE_YELLOW( Color.decode( "#FFA800" ), Material.YELLOW_TERRACOTTA ),
    CANARY_YELLOW( Color.decode( "#FFD635" ), Material.YELLOW_WOOL ),
    STICKYNOTE_YELLOW( Color.decode( "#FFF8B8" ), Material.SMOOTH_SANDSTONE ),
    GREEN( Color.decode( "#00A368" ), Material.GREEN_CONCRETE ),
    MINT_GREEN( Color.decode( "#00CC78"), Material.GREEN_WOOL ),
    LIME( Color.decode( "#7EED56" ), Material.LIME_WOOL ),
    DEEP_TEAL( Color.decode( "#00756F" ), Material.WARPED_WART_BLOCK ),
    CYAN_TEAL( Color.decode( "#009EAA" ), Material.CYAN_WOOL ),
    LIGHT_TEAL( Color.decode( "#00CCC0" ), Material.STRIPPED_WARPED_HYPHAE ),
    DARK_BLUE( Color.decode( "#2450A4" ), Material.LAPIS_BLOCK ),
    BLUE( Color.decode( "#3690EA" ), Material.CYAN_WOOL ),
    CYAN( Color.decode( "#51E9F4" ), Material.LIGHT_BLUE_WOOL ),
    BLURPLE( Color.decode( "#493AC1" ), Material.BLUE_TERRACOTTA ),
    LIGHT_BLURPLE( Color.decode( "#6A5CFF" ), Material.AMETHYST_BLOCK ),
    SKY_BLUE( Color.decode( "#94B3FF" ), Material.PACKED_ICE ),
    PURPLE( Color.decode( "#811E9F" ), Material.PURPLE_WOOL ),
    LIGHT_PURPLE( Color.decode( "#B44AC0" ), Material.AMETHYST_BLOCK ),
    LIGHTER_PURPLE( Color.decode( "#E4ABFF" ), Material.PURPUR_BLOCK ),
    DEEP_PINK( Color.decode( "#DE107F" ), Material.STRIPPED_CRIMSON_HYPHAE ),
    HOT_PINK( Color.decode( "#FF3881" ), Material.MAGENTA_WOOL ),
    LIGHT_PINK( Color.decode( "#FF99AA" ), Material.PINK_WOOL ),
    DARK_BROWN( Color.decode( "#6D482F" ), Material.BROWN_TERRACOTTA ),
    BROWN( Color.decode( "#9C6926" ), Material.BROWN_WOOL ),
    BEIGE( Color.decode( "#FFB470" ), Material.STRIPPED_OAK_WOOD ),
    BLACK( Color.decode( "#000000" ), Material.COAL_BLOCK ),
    DARK_GRAY( Color.decode( "#515252" ), Material.GRAY_WOOL ),
    GRAY( Color.decode( "#898D90" ), Material.STONE ),
    LIGHT_GRAY( Color.decode( "#D4D7D9" ), Material.LIGHT_GRAY_WOOL ),
    WHITE( Color.decode( "#FFFFFF" ), Material.WHITE_WOOL );
    
    Material material;

    Color color;

    int rgb;
    
    PlaceColor( Color color, Material material )
    {
        this.color = color;
        this.material = material;
        this.rgb = color.getRGB();
    }
    
    public static PlaceColor getColorById( int id )
    {
        return PlaceColor.values()[ id ];
    }

    public static Optional<PlaceColor> getColorByRGB( int rgb )
    {
        return Arrays.stream( PlaceColor.values() ).filter( pc -> pc.getRgb() == rgb ).findAny();
    }
    
    public static boolean isWool( Material material )
    {
        return Arrays.stream( PlaceColor.values() ).anyMatch( pc -> pc.material == material );
    }
}
