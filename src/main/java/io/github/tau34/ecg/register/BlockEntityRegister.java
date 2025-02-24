package io.github.tau34.ecg.register;

import io.github.tau34.ecg.ECGMod;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityRegister {
    private final DeferredRegister<BlockEntityType<?>> BE_REGISTER;

    public BlockEntityRegister() {
        BE_REGISTER = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ECGMod.MOD_ID);
    }

    public <T extends BlockEntity> RegistryObject<BlockEntityType<T>> create(String name, BlockEntityType.BlockEntitySupplier<T> be, Block... blocks) {
        return BE_REGISTER.register(name, () -> BlockEntityType.Builder.of(be, blocks).build(null));
    }

    public void register(IEventBus modEventBus) {
        BE_REGISTER.register(modEventBus);
    }
}
