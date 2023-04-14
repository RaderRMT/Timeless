package fr.rader.timeless;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = "timeless")
public class TimelessConfig implements ConfigData {

    public boolean useOldWorldMenu = true;
    public boolean useOldHitAnimation = true;
}
