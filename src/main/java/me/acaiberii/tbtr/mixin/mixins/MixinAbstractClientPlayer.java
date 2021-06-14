package me.acaiberii.tbtr.mixin.mixins;

import me.acaiberii.tbtr.utility.CapeUtil;
import me.acaiberii.tbtr.wrapper.Wrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;
import java.util.Objects;

@Mixin(AbstractClientPlayer.class)
public abstract class MixinAbstractClientPlayer {

    @Shadow
    @Nullable
    protected abstract NetworkPlayerInfo getPlayerInfo();

    @Inject(method = "getLocationCape", at = @At("HEAD"), cancellable = true)
    private void getCapeHook(CallbackInfoReturnable<ResourceLocation> cir) {
        if (me.acaiberii.tbtr.util.init.init.capeUtil.hasRegCape(Objects.requireNonNull(getPlayerInfo()).getGameProfile().getId())) {
            cir.setReturnValue(new ResourceLocation("tbtr:regcape.png"));
        }
        else if (me.acaiberii.tbtr.util.init.init.capeUtil.hasInkCape(Objects.requireNonNull(getPlayerInfo()).getGameProfile().getId())) {
            cir.setReturnValue(new ResourceLocation("tbtr:inkcape.png"));
        }
    }
}
