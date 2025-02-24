package io.github.tau34.ecg.block;

import com.mojang.logging.LogUtils;
import io.github.tau34.ecg.block.entity.CobbleGeneratorBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

public class CobbleGeneratorBlock extends Block implements EntityBlock {
    private static final Logger LOGGER = LogUtils.getLogger();

    public CobbleGeneratorBlock(Properties p_49795_) {
        super(p_49795_);
        LOGGER.info("Registered Cobble Generator");
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new CobbleGeneratorBlockEntity(blockPos, blockState);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_153212_, BlockState p_153213_, BlockEntityType<T> p_153214_) {
        return (BlockEntityTicker<T>) new CobbleGeneratorBlockEntity.CobbleGeneratorTicker();
    }
}
