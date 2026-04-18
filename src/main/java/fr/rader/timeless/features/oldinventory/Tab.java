package fr.rader.timeless.features.oldinventory;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.Optional;
import java.util.function.Supplier;

public abstract class Tab {

    private final ResourceKey<CreativeModeTab> group;
    private final CreativeModeTab.Row location;
    private final int column;
    private final Component title;
    private final Supplier<ItemStack> icon;

    private Registry<CreativeModeTab> registry;

    protected Tab(ResourceKey<CreativeModeTab> group, CreativeModeTab.Row location, int column, Component title, Supplier<ItemStack> icon) {
        this.group = group;
        this.location = location;
        this.column = column;
        this.title = title;
        this.icon = icon;
    }

    protected void populateTab(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output entries) {
    }

    protected void createItemGroup(CreativeModeTab.Builder builder) {
        builder.displayItems(this::populateTab);
    }

    protected Registry<CreativeModeTab> getRegistry() {
        return this.registry;
    }

    protected <T> Optional<? extends HolderLookup.RegistryLookup<T>> getOptional(CreativeModeTab.ItemDisplayParameters parameters, ResourceKey<? extends Registry<? extends T>> registryRef) {
        return parameters.holders().lookup(registryRef);
    }

    public final void register(Registry<CreativeModeTab> registry) {
        this.registry = registry;

        CreativeModeTab.Builder builder = CreativeModeTab.builder(this.location, this.column)
                .title(this.title)
                .icon(this.icon);

        createItemGroup(builder);

        Registry.register(
                registry,
                this.group,
                builder.build()
        );
    }
}
