package io.github.tau34.ecg.gui;

import io.github.tau34.ecg.item.CpdCobbleItem;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.Nullable;

public class CobbleGeneratorMenu extends AbstractContainerMenu {
    private final Container container;
    private int scrollOffset = 0;

    protected CobbleGeneratorMenu(@Nullable MenuType<?> type, int id, Inventory inv, Container ctr) {
        super(type, id);

        container = ctr;

        for (int row = 0; row < 6; row ++) {
            for (int col = 0; col < 8; col ++) {
                this.addSlot(new Slot(ctr, col + row * 8, 8 + col * 18, 18 + row * 18));
            }
        }

        for (int row = 0; row < 3; row ++) {
            for (int col = 0; col < 8; col ++) {
                this.addSlot(new Slot(inv, col + row * 8 + 8,8 + col * 18, 139 + row * 18));
            }
        }

        for (int col = 0; col < 8; col ++) {
            this.addSlot(new Slot(inv, col, 8 + col * 18, 197));
        }
    }

    public static CobbleGeneratorMenu createContainer(int id, Inventory inv) {
        return new CobbleGeneratorMenu(ECGMenuTypes.BASIC_COBBLE_GENERATOR.get(), id, inv, new SimpleContainer(128));
    }

    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player player) {
        return container.stillValid(player);
    }

    private boolean isCobblestone(ItemStack stack) {
        if (stack.is(Items.COBBLESTONE)) {
            return true;
        } else return stack.getItem() instanceof CpdCobbleItem;
    }

    public void scrollUp() {
        if (scrollOffset > 0) {
            scrollOffset--;
            updateSlots();
        }
    }

    public void scrollDown() {
        if (scrollOffset < 10) {
            scrollOffset++;
            updateSlots();
        }
    }

    private void updateSlots() {
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 9; col++) {
                int index = col + (row + scrollOffset) * 9;
                getSlot(row * 9 + col).set(container.getItem(index));
            }
        }
    }

    public double getScrollProgress() {
        return (double) scrollOffset / 10D;
    }

    public void setScrollOffset(int offset) {
        this.scrollOffset = Math.max(0, Math.min(offset, 10));
        updateSlots();
    }
}
