package io.github.tau34.ecg.register;

import io.github.tau34.ecg.ECGMod;
import io.github.tau34.ecg.gui.SampleMenu;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MenuRegister {
    private final DeferredRegister<MenuType<?>> MENU_REGISTER;

    public MenuRegister() {
        MENU_REGISTER = DeferredRegister.create(ForgeRegistries.MENU_TYPES, ECGMod.MOD_ID);
    }

    public <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> create(String name, MenuType.MenuSupplier<T> menu) {
        return MENU_REGISTER.register(name, () -> new MenuType<>(menu, FeatureFlags.DEFAULT_FLAGS));
    }

    public void register(IEventBus modEventBus) {
        MENU_REGISTER.register(modEventBus);
    }
}
