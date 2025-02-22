package io.github.tau34.ecg.block;

import io.github.tau34.ecg.register.BlockRegister;
import io.github.tau34.ecg.registry.BlockRegistry;
import net.minecraftforge.eventbus.api.IEventBus;

public class ECGBlocks {
    private static final BlockRegister REGISTER = new BlockRegister();

    public static BlockRegistry[] CPD_COBBLE = new BlockRegistry[127];

    static {
        for (byte b = 0; b < 127; b ++) {
            CPD_COBBLE[b] = REGISTER.createCpdCobble((byte) (b + 1));
        }
    }

    public static void register(IEventBus modEventBus) {
        REGISTER.register(modEventBus);
    }
}
