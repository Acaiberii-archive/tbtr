package me.acaiberii.tbtr.mixin.mixins;

import me.acaiberii.tbtr.wrapper.Wrapper;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.Display;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@Mixin(Minecraft.class)
public class MixinMinecraft {
    @Redirect(method = "createDisplay", at = @At(value = "INVOKE", target = "Lorg/lwjgl/opengl/Display;setTitle(Ljava/lang/String;)V"))
    private void overrideCreateDisplay(String newTitle) {
        Display.setTitle("Minecraft " + Minecraft.getMinecraft().getVersion() + "*");
    }
}
