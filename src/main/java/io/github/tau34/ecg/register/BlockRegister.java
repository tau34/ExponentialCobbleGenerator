package io.github.tau34.ecg.register;

import io.github.tau34.ecg.ECGMod;
import io.github.tau34.ecg.item.CpdCobbleItem;
import io.github.tau34.ecg.registry.BlockRegistry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class BlockRegister {
    private final DeferredRegister<Item> ITEM_REGISTER;
    private final DeferredRegister<Block> BLOCK_REGISTER;
    private final BlockBehaviour.Properties DEFAULT_BLOCK = BlockBehaviour.Properties.copy(Blocks.COBBLESTONE);
    private final Item.Properties DEFAULT_ITEM = new Item.Properties();

    public BlockRegister() {
        ITEM_REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, ECGMod.MOD_ID);
        BLOCK_REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, ECGMod.MOD_ID);
    }

    public BlockRegistry createCpdCobble(byte tier) {
        return create("cobblestone_cpd" + String.format("%03d", tier), Block::new, (b, p) -> new CpdCobbleItem(tier, b, p));
    }

    public BlockRegistry create(String name) {
        return create(name, DEFAULT_BLOCK, DEFAULT_ITEM);
    }

    public BlockRegistry create(String name, BlockBehaviour.Properties bp, Item.Properties ip) {
        return create(name, () -> new Block(bp), (block) -> new BlockItem(block, ip));
    }

    public BlockRegistry create(String name, Function<BlockBehaviour.Properties, Block> block, BiFunction<Block, Item.Properties, BlockItem> item) {
        return create(name, () -> block.apply(DEFAULT_BLOCK), (b) -> item.apply(b, DEFAULT_ITEM));
    }

    public BlockRegistry create(String name, Supplier<Block> block, Function<Block, BlockItem> item) {
        RegistryObject<Block> br = BLOCK_REGISTER.register(name, block);
        return new BlockRegistry(br, ITEM_REGISTER.register(name, () -> item.apply(br.get())));
    }

    public void register(IEventBus modEventBus) {
        ITEM_REGISTER.register(modEventBus);
        BLOCK_REGISTER.register(modEventBus);
    }
}
