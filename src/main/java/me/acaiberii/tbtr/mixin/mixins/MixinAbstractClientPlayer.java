package me.acaiberii.tbtr.mixin.mixins;

import me.acaiberii.tbtr.storage.Resources;
import me.acaiberii.tbtr.utility.act.Actions;
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
import static me.acaiberii.tbtr.tbtr.capeUtil;
import static me.acaiberii.tbtr.tbtr.logger;

@Mixin(AbstractClientPlayer.class)
public abstract class MixinAbstractClientPlayer {

    @Shadow
    @Nullable
    protected abstract NetworkPlayerInfo getPlayerInfo();

    @Inject(method = "getLocationCape", at = @At("HEAD"), cancellable = true)
    private void getCapeHook(CallbackInfoReturnable<ResourceLocation> cir) {
        try {
            if (capeUtil.hasRegCape(Objects.requireNonNull(getPlayerInfo()).getGameProfile().getId())) {
                cir.setReturnValue(Resources.regCape);
            } else if (capeUtil.hasBrokCape(Objects.requireNonNull(getPlayerInfo()).getGameProfile().getId())) {
                cir.setReturnValue(Resources.brokCape);
            } else if (capeUtil.hasStellaCape(Objects.requireNonNull(getPlayerInfo()).getGameProfile().getId())) {
                cir.setReturnValue(Resources.stellaCape);
            } else if (capeUtil.hasAcaiCape(Objects.requireNonNull(getPlayerInfo()).getGameProfile().getId())) {
                cir.setReturnValue(Resources.acaiCape);
            } else if (capeUtil.hasYTCape(Objects.requireNonNull(getPlayerInfo()).getGameProfile().getId())) {
                cir.setReturnValue(Resources.ytCape);
            } else if (capeUtil.hasPMCCape(Objects.requireNonNull(getPlayerInfo()).getGameProfile().getId())) {
                cir.setReturnValue(Resources.pmcCape);
            } else if (capeUtil.hasTwitchCape(Objects.requireNonNull(getPlayerInfo().getGameProfile().getId()))) {
                cir.setReturnValue(Resources.twitchCape);
            }
        }
        catch (Exception e) {
            logger.error(Actions.formatError("rendering capes"));
            e.printStackTrace();
        }
    }
}
