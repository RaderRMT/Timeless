package fr.rader.timeless;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "timeless")
public class TimelessConfig implements ConfigData {

    public boolean useOldWorldMenu = true;
    public boolean disableHitDirection = true;

    @ConfigEntry.Gui.RequiresRestart()
    public boolean useOldIcons = true;

    public boolean doPistonClunk = true;
}
