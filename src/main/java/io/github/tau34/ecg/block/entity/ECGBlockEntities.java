package io.github.tau34.ecg.block.entity;

import io.github.tau34.ecg.block.ECGBlocks;
import io.github.tau34.ecg.register.BlockEntityRegister;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

public class ECGBlockEntities {
    private static final BlockEntityRegister REGISTER = new BlockEntityRegister();

    public static final RegistryObject<BlockEntityType<CobbleGeneratorBlockEntity>> COBBLE_GENERATOR = REGISTER.create("cobble_generator_1", CobbleGeneratorBlockEntity::new, ECGBlocks.BASIC_COBBLE_GENERATOR.getBlock());

    public static void register(IEventBus modEventBus) {
        REGISTER.register(modEventBus);
    }
}
