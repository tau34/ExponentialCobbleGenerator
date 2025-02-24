package io.github.tau34.ecg.datagen;

import io.github.tau34.ecg.ECGMod;
import io.github.tau34.ecg.block.ECGBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ECGBlockStateProvider extends BlockStateProvider {
    public ECGBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ECGMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for (int i = 0; i < 127; i++) {
            simpleBlock(ECGBlocks.CPD_COBBLE[i].getBlock(), cubeAll(Blocks.COBBLESTONE));
        }
    }
}
