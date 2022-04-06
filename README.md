MinePlace-ImageRender
---------------------

Render a PNG of the r/place canvas in Minecraft.  Check it out at `play.pickaxis.com`.

To render an image:
1. Create a server with a void world named `mineplace`.  You can use the  `server.properties` in the root of the repo to achieve this without additional plugins, and to use other recommended settings.  (Setting `settings.allow-end` to `false` in `bukkit.yml` may be desirable as well.)
2. If using Spigot (or a fork), set `settings.timeout-time` higher in `spigot.yml`.  (Note: This plugin will render the entire image in one game tick.  This will generally take enough time such that any online players will get disconnected.  If this is not set high enough, the server will stop before the render completes.  I used 600 in testing. )
3. Run the following command to render the canvas: `/render <url>`.  You should ensure that you're using a 2000x2000 PNG that only contains the colors from r/place.
