package fr.rader.timeless.gui;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import fr.rader.timeless.TimelessConfig;
import me.shedaniel.autoconfig.AutoConfig;

public class ConfigScreen implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> AutoConfig.getConfigScreen(TimelessConfig.class, parent).get();
    }
}
