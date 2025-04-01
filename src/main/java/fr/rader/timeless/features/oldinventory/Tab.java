package fr.rader.timeless.features.oldinventory;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;

import java.util.Optional;
import java.util.function.Supplier;

public abstract class Tab {

    //#if MC>=12000
    private final RegistryKey<ItemGroup> group;
    //#else
    //$$ private final ItemGroup group;
    //#endif
    private final ItemGroup.Row location;
    private final int column;
    private final Text title;
    private final Supplier<ItemStack> icon;

    //#if MC>=12000
    private Registry<ItemGroup> registry;
    //#else
    //$$ private ItemGroup registry;
    //#endif

    //#if MC>=12000
    protected Tab(RegistryKey<ItemGroup> group, ItemGroup.Row location, int column, Text title, ItemStack icon) {
    //#else
    //$$ protected Tab(ItemGroup group, ItemGroup.Row location, int column, Text title, ItemStack icon) {
    //#endif
        this(group, location, column, title, () -> icon);
    }

    //#if MC>=12000
    protected Tab(RegistryKey<ItemGroup> group, ItemGroup.Row location, int column, Text title, Supplier<ItemStack> icon) {
    //#else
    //$$ protected Tab(ItemGroup group, ItemGroup.Row location, int column, Text title, Supplier<ItemStack> icon) {
    //#endif
        this.group = group;
        this.location = location;
        this.column = column;
        this.title = title;
        this.icon = icon;
    }

    protected void populateTab(ItemGroup.DisplayContext displayContext, ItemGroup.Entries entries) {
    }

    protected void createItemGroup(ItemGroup.Builder builder) {
        builder.entries(this::populateTab);
    }

    //#if MC>=12000
    protected Registry<ItemGroup> getRegistry() {
        return this.registry;
    }
    //#else
    //$$ protected ItemGroup getRegistry() {
    //$$     return this.registry;
    //$$ }
    //#endif

    protected <T> Optional<? extends RegistryWrapper.Impl<T>> getOptional(ItemGroup.DisplayContext displayContext, RegistryKey<? extends Registry<? extends T>> registryRef) {
        //#if MC>=12102
        return displayContext.lookup().getOptional(registryRef);
        //#else
        //$$ return displayContext.lookup().getOptionalWrapper(registryRef);
        //#endif
    }

    //#if MC>=12000
    public final void register(Registry<ItemGroup> registry) {
    //#else
    //$$ public final void register(ItemGroup registry) {
    //#endif
        this.registry = registry;

        ItemGroup.Builder builder = ItemGroup.create(this.location, this.column)
                .displayName(this.title)
                .icon(this.icon);

        createItemGroup(builder);

        Registry.register(
                registry,
                this.group,
                builder.build()
        );
    }
}
