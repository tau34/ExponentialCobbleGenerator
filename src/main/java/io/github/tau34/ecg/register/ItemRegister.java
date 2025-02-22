package io.github.tau34.ecg.register;

import io.github.tau34.ecg.ECGMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;
import java.util.function.Supplier;

public class ItemRegister {
    private final DeferredRegister<Item> ITEM_REGISTER;

    public ItemRegister() {
        ITEM_REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, ECGMod.MOD_ID);
    }

    public RegistryObject<Item> create(String name) {
        return create(name, new Item.Properties());
    }

    public RegistryObject<Item> create(String name, Item.Properties properties) {
        return create(name, () -> new Item(properties));
    }

    public RegistryObject<Item> create(String name, Function<Item.Properties, Item> item) {
        return create(name, () -> item.apply(new Item.Properties()));
    }

    public RegistryObject<Item> create(String name, Supplier<Item> item) {
        return ITEM_REGISTER.register(name, item);
    }

    public void register(IEventBus modEventBus) {
        ITEM_REGISTER.register(modEventBus);
    }
}
