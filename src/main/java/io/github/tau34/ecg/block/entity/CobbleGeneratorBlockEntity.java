package io.github.tau34.ecg.block.entity;

import io.github.tau34.ecg.util.LargeInteger;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.math.BigInteger;

public class CobbleGeneratorBlockEntity extends RandomizableContainerBlockEntity {
    private LargeInteger items;
    private int count;

    public CobbleGeneratorBlockEntity(BlockEntityType<?> p_155228_, BlockPos p_155229_, BlockState p_155230_) {
        super(p_155228_, p_155229_, p_155230_);
        items = LargeInteger.MIN_VALUE;
        count = 20;
    }

    public CobbleGeneratorBlockEntity(BlockPos p_155229_, BlockState p_155230_) {
        this(ECGBlockEntities.COBBLE_GENERATOR.get(), p_155229_, p_155230_);
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return items.toStackList();
    }

    @Override
    protected void setItems(NonNullList<ItemStack> nonNullList) {
        items = LargeInteger.fromStackList(nonNullList);
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.ecg.cobble_generator");
    }

    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory inventory) {
        return null;
    }

    @Override
    public int getContainerSize() {
        return 128;
    }

    public void generateCobblestone() {
        if (level == null || level.isClientSide) return;
        addToInventory(new LargeInteger(BigInteger.ONE));
    }

    private void addToInventory(LargeInteger li) {
        items.add(li);
    }

    @Override
    public void load(CompoundTag p_155245_) {
        super.load(p_155245_);
        this.items = LargeInteger.MIN_VALUE;

        if (!this.tryLoadLootTable(p_155245_)) {
            NonNullList<ItemStack> isl = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
            ContainerHelper.loadAllItems(p_155245_, isl);
            this.items = LargeInteger.fromStackList(isl);
        }
    }

    @Override
    protected void saveAdditional(CompoundTag p_187461_) {
        super.saveAdditional(p_187461_);

        if (!this.trySaveLootTable(p_187461_)) {
            ContainerHelper.saveAllItems(p_187461_, this.items.toStackList());
        }
    }

    public static class CobbleGeneratorTicker implements BlockEntityTicker<CobbleGeneratorBlockEntity> {
        @Override
        public void tick(Level level, BlockPos pos, BlockState state, CobbleGeneratorBlockEntity blockEntity) {
            if (--blockEntity.count <= 0) {
                blockEntity.count += 20;
                blockEntity.generateCobblestone();
            }
        }
    }
}
