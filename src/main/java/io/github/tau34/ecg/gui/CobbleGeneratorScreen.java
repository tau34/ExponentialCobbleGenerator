package io.github.tau34.ecg.gui;

import io.github.tau34.ecg.ECGMod;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class CobbleGeneratorScreen extends AbstractContainerScreen<CobbleGeneratorMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(ECGMod.MOD_ID, "textures/gui/cobblestone_generator.png");
    private static final ResourceLocation SCROLLBAR_TEXTURE = new ResourceLocation("textures/gui/container/creative_inventory/tabs.png");
    private boolean isScrolling;

    public CobbleGeneratorScreen(CobbleGeneratorMenu p_97741_, Inventory p_97742_, Component p_97743_) {
        super(p_97741_, p_97742_, p_97743_);
        this.imageWidth = 176;
        this.imageHeight = 222;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int i, int i1) {
        guiGraphics.blit(TEXTURE, leftPos, topPos, 0, 0, imageWidth, imageHeight);

        int scrollbarX = leftPos + 157;
        int scrollbarY = topPos + 18 + (int) ((91D * menu.getScrollProgress()));

        guiGraphics.blit(SCROLLBAR_TEXTURE, scrollbarX, scrollbarY, 232, 0, 12, 15);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        guiGraphics.drawString(this.font, this.title, 8, 6, 0x404040, false);
        guiGraphics.drawString(this.font, this.playerInventoryTitle, 8, this.imageHeight - 94, 0x404040, false);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double delta) {
        if (delta > 0) {
            menu.scrollUp();
        } else if (delta < 0) {
            menu.scrollDown();
        }
        return true;
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        int scrollbarX = leftPos + 157;
        int scrollbarYStart = topPos + 18;
        int scrollbarYEnd = scrollbarYStart + 90;

        if (mouseX >= scrollbarX && mouseX <= scrollbarX + 12 && mouseY >= scrollbarYStart && mouseY <= scrollbarYEnd) {
            isScrolling = true;
            updateScroll(mouseY);
            return true;
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        if (isScrolling) {
            updateScroll(mouseY);
            return true;
        }
        return super.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        isScrolling = false;
        return super.mouseReleased(mouseX, mouseY, button);
    }

    private void updateScroll(double mouseY) {
        int scrollbarYStart = topPos + 18;
        int scrollbarYEnd = scrollbarYStart + 90;

        double progress = (mouseY - scrollbarYStart) / (double) (scrollbarYEnd - scrollbarYStart);
        progress = Math.max(0, Math.min(progress, 1)); // 0～1 の範囲に制限

        int newOffset = (int) (progress * 10);
        menu.setScrollOffset(newOffset);
    }
}
