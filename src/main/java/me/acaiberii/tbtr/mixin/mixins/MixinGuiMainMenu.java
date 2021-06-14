package me.acaiberii.tbtr.mixin.mixins;

import me.acaiberii.tbtr.utility.FontUtil;
import me.acaiberii.tbtr.wrapper.Wrapper;
import net.minecraft.client.gui.GuiMainMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.awt.*;

@Mixin(GuiMainMenu.class)
public class MixinGuiMainMenu extends Wrapper {
    @Inject(method = "drawScreen", at = @At("TAIL"))
    private void drawScreenHook(int mouseX, int mouseY, float partialTicks, CallbackInfo ci) {
        FontUtil.drawStringWithShadow("tbtr", 2, 2, 0xff0000);
    }
}
