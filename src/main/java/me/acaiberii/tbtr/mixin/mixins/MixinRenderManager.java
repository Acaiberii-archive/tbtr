package me.acaiberii.tbtr.mixin.mixins;

import me.acaiberii.tbtr.Main;
import me.acaiberii.tbtr.event.events.RenderEntityEvent;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RenderManager.class)
public class MixinRenderManager {
    @Inject(method = "shouldRender", at = @At("HEAD"), cancellable = true)
    public void onRender(Entity entityIn, ICamera camera, double camX, double camY, double camZ, final CallbackInfoReturnable<Boolean> callback)
    {
        RenderEntityEvent event = new RenderEntityEvent(entityIn, camera, camX, camY, camZ);
        Main.EVENT_BUS.post(event);

        if (event.isCancelled())
            callback.setReturnValue(false);
    }
}
