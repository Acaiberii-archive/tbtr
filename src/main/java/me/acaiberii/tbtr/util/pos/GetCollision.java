package me.acaiberii.tbtr.util.pos;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;

public class GetCollision {
    public static boolean getIsCollidingX(Entity entity) {
        if (entity.posX == Minecraft.getMinecraft().player.posX) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean getIsCollidingY(Entity entity) {
        if (entity.posY == Minecraft.getMinecraft().player.posY) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean getIsCollidingZ(Entity entity) {
        if (entity.posZ == Minecraft.getMinecraft().player.posZ) {
            return true;
        }
        else {
            return false;
        }
    }
}
