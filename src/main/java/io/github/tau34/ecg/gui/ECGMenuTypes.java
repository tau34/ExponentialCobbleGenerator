package io.github.tau34.ecg.gui;

import io.github.tau34.ecg.register.MenuRegister;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

public class ECGMenuTypes {
    private static final MenuRegister REGISTER = new MenuRegister();

    public static final RegistryObject<MenuType<SampleMenu>> SAMPLE_MENU = REGISTER.create("sample_menu", SampleMenu::new);
    public static final RegistryObject<MenuType<CobbleGeneratorMenu>> BASIC_COBBLE_GENERATOR = REGISTER.create("cobble_generator_1", CobbleGeneratorMenu::createContainer);

    public static void register(IEventBus modEventBus) {
        REGISTER.register(modEventBus);
    }
}
