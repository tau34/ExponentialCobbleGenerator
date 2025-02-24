package io.github.tau34.ecg.block;

import io.github.tau34.ecg.register.BlockRegister;
import io.github.tau34.ecg.registry.BlockRegistry;
import net.minecraft.world.item.BlockItem;
import net.minecraftforge.eventbus.api.IEventBus;

public class ECGBlocks {
    private static final BlockRegister REGISTER = new BlockRegister();

    public static final BlockRegistry[] CPD_COBBLE = new BlockRegistry[127];
    public static final BlockRegistry SAMPLE_BLOCK = REGISTER.create("sample_block", SampleBlock::new, BlockItem::new);
    public static final BlockRegistry BASIC_COBBLE_GENERATOR;

    static {
        for (byte b = 0; b < 127; b ++) {
            CPD_COBBLE[b] = REGISTER.createCpdCobble((byte) (b + 1));
        }
        BASIC_COBBLE_GENERATOR = REGISTER.create("basic_cobble_generator", CobbleGeneratorBlock::new, BlockItem::new);
    }

    public static void register(IEventBus modEventBus) {
        REGISTER.register(modEventBus);
    }
}
