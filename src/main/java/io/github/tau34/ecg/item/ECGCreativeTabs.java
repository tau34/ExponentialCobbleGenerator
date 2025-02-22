package io.github.tau34.ecg.item;

import io.github.tau34.ecg.ECGMod;
import io.github.tau34.ecg.block.ECGBlocks;
import io.github.tau34.ecg.registry.BlockRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ECGCreativeTabs {
    private static final DeferredRegister<CreativeModeTab> REGISTER = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ECGMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB = REGISTER.register("example_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ECGBlocks.CPD_COBBLE[0].getItem().getDefaultInstance())
            .displayItems((parameters, output) -> {
                for (BlockRegistry block : ECGBlocks.CPD_COBBLE) {
                    output.accept(block.getItem());
                }
            }).build());

    public static void register(IEventBus modEventBus) {
        REGISTER.register(modEventBus);
    }
}
