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
    private static final String[] EXP_LIST = {"1", "9", "81", "729", "6561", "59049", "5.3144e5", "4.7830e6", 
            "4.3047e7", "3.8742e8", "3.4868e9", "3.1381e10", "2.8243e11", "2.5419e12", "2.2877e13", "2.0589e14",
            "1.8530e15", "1.6677e16", "1.5009e17", "1.3509e18", "1.2158e19", "1.0942e20", "9.8477e20", 
            "8.8629e21", "7.9766e22", "7.1790e23", "6.4611e24", "5.8150e25", "5.2335e26", "4.7101e27", 
            "4.2391e28", "3.8152e29", "3.4337e30", "3.0903e31", "2.7813e32", "2.5032e33", "2.2528e34", 
            "2.0276e35", "1.8248e36", "1.6423e37", "1.4781e38", "1.3303e39", "1.1973e40", "1.0775e41", 
            "9.6977e41", "8.7280e42", "7.8552e43", "7.0697e44", "6.3627e45", "5.7264e46", "5.1538e47", 
            "4.6384e48", "4.1746e49", "3.7571e50", "3.3814e51", "3.0433e52", "2.7389e53", "2.4650e54", 
            "2.2185e55", "1.9967e56", "1.7970e57", "1.6173e58", "1.4556e59", "1.3100e60", "1.1790e61", 
            "1.0611e62", "9.5500e62", "8.5950e63", "7.7355e64", "6.9620e65", "6.2658e66", "5.6392e67", 
            "5.0753e68", "4.5678e69", "4.1110e70", "3.6999e71", "3.3299e72", "2.9969e73", "2.6972e74", 
            "2.4275e75", "2.1847e76", "1.9663e77", "1.7696e78", "1.5927e79", "1.4334e80", "1.2901e81", 
            "1.1611e82", "1.0450e83", "9.4046e83", "8.4641e84", "7.6177e85", "6.8560e86", "6.1704e87", 
            "5.5533e88", "4.9980e89", "4.4982e90", "4.0484e91", "3.6435e92", "3.2792e93", "2.9513e94", 
            "2.6561e95", "2.3905e96", "2.1515e97", "1.9363e98", "1.7427e99", "1.5684e100", "1.4116e101", 
            "1.2704e102", "1.1434e103", "1.0290e104", "9.2614e104", "8.3352e105", "7.5017e106", "6.7516e107", 
            "6.0764e108", "5.4688e109", "4.9219e110", "4.4297e111", "3.9867e112", "3.5881e113", "3.2292e114", 
            "2.9063e115", "2.6157e116", "2.3541e117", "2.1187e118", "1.9068e119", "1.7162e120", "1.5445e121"};
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
        list.add(Component.translatable("tooltip.cpd", tier, EXP_LIST[b]));
    }
}
