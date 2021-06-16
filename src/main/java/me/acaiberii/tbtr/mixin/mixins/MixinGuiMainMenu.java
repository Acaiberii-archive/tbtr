package me.acaiberii.tbtr.mixin.mixins;

import me.acaiberii.tbtr.storage.Info;
import me.acaiberii.tbtr.storage.Versions;
import me.acaiberii.tbtr.utility.ColorUtil;
import me.acaiberii.tbtr.utility.FontRenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.awt.*;

@Mixin(GuiMainMenu.class)
public class MixinGuiMainMenu {
    @Inject(method = "drawScreen", at = @At("TAIL"))
    private void drawScreenHook(int mouseX, int mouseY, float partialTicks, CallbackInfo ci) {
        FontRenderUtil.drawRainbowStringWithShadow("tbtr", 2, 2, 0.3, 10, 1f);
        if (Info.isOutdated) {
            FontRenderUtil.drawStringWithShadow("Latest version: " + Versions.latestVersion, 2, FontRenderUtil.getFontHeight() + 2, ColorUtil.getInteger(155, 0, 0));
        } else if (!Info.isOutdated) {
            FontRenderUtil.drawStringWithShadow("Latest version: " + Versions.latestVersion, 2, FontRenderUtil.getFontHeight() + 2, ColorUtil.getInteger(0, 155, 0));
        }
    }
}
