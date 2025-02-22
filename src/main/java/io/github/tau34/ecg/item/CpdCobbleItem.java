package io.github.tau34.ecg.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CpdCobbleItem extends BlockItem {
    private static final String[] SUP_NUM_LIST = {"⁰", "¹", "²", "³", "⁴", "⁵", "⁶", "⁷", "⁸", "⁹"};
    private final String tier;
    private final byte b;

    public CpdCobbleItem(byte t, Block p_40565_, Properties p_40566_) {
        super(p_40565_, p_40566_);
        StringBuilder builder = new StringBuilder();
        b = t;
        for (char c: String.valueOf(t).toCharArray()) {
            builder.append(SUP_NUM_LIST[Integer.parseInt(String.valueOf(c))]);
        }
        tier = builder.toString();
    }

    @Override
    public Component getName(ItemStack p_41458_) {
        return Component.translatable("item.cpd_cobble", b);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(stack, level, list, flag);
        list.add(Component.translatable("tooltip.cpd", tier));
    }
}
