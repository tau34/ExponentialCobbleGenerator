package io.github.tau34.ecg.datagen;

import io.github.tau34.ecg.ECGMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ECGMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ECGDataGen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper helper = event.getExistingFileHelper();

        generator.addProvider(event.includeServer(), new ECGItemModelProvider(output, helper));
        generator.addProvider(event.includeServer(), new ECGBlockStateProvider(output, helper));
    }
}
