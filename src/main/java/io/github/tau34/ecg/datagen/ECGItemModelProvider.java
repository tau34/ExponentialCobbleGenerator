package io.github.tau34.ecg.datagen;

import io.github.tau34.ecg.ECGMod;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ECGItemModelProvider extends ItemModelProvider {
    public ECGItemModelProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, ECGMod.MOD_ID, helper);
    }

    @Override
    protected void registerModels() {
        for (int i = 1; i <= 127; i++) {
            withExistingParent("cobblestone_cpd" + String.format("%03d", i), mcLoc("block/cobblestone"));
        }
    }
}