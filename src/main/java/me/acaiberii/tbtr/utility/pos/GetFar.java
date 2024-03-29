package me.acaiberii.tbtr.utility.pos;

import net.minecraft.entity.Entity;

import static me.acaiberii.tbtr.utility.player.GetPos.*;

public class GetFar {
    public static boolean isFarX(Entity entity, double pos) {
        if (Math.rint(entity.posX - getPosX()) > pos) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean isFarY(Entity entity, double pos) {
        if (Math.rint(entity.posY - getPosY()) > pos) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean isFarZ(Entity entity, double pos) {
        if (Math.rint(entity.posX - getPosZ()) > pos) {
            return true;
        }
        else {
            return false;
        }
    }
}
