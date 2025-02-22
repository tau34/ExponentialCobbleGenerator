package io.github.tau34.ecg.item;

import io.github.tau34.ecg.register.ItemRegister;
import net.minecraftforge.eventbus.api.IEventBus;

public class ECGItems {
    private static final ItemRegister REGISTER = new ItemRegister();

    public static void register(IEventBus modEventBus) {
        REGISTER.register(modEventBus);
    }
}
