package io.github.tau34.ecg.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class BlockRegistry {
    private final RegistryObject<Block> blockObj;
    private final RegistryObject<BlockItem> itemObj;

    public BlockRegistry(RegistryObject<Block> block, RegistryObject<BlockItem> item) {
        blockObj = block;
        itemObj = item;
    }

    public Block getBlock() {
        return blockObj.get();
    }

    public BlockItem getItem() {
        return itemObj.get();
    }
}
