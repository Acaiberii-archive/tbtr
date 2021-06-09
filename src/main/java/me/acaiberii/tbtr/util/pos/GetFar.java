package me.acaiberii.tbtr.util.pos;

import me.acaiberii.tbtr.wrapper.Wrapper;
import net.minecraft.entity.Entity;

import static me.acaiberii.tbtr.util.player.GetPos.*;

public class GetFar {
    public static boolean isFarX(Entity entity) {
        if (Math.rint(entity.posX - getPosX()) > 100) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean isFarY(Entity entity) {
        if (Math.rint(entity.posY - getPosY()) > 100) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean isFarZ(Entity entity) {
        if (Math.rint(entity.posX - getPosZ()) > 100) {
            return true;
        }
        else {
            return false;
        }
    }
}
