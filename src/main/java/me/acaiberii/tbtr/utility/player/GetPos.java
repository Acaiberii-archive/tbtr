package me.acaiberii.tbtr.utility.player;

import me.acaiberii.tbtr.wrapper.Wrapper;

public class GetPos {
    public static double getPosX() {
        return Wrapper.getPlayer().posX;
    }

    public static double getPosY() {
        return Wrapper.getPlayer().posY;
    }

    public static double getPosZ() {
        return Wrapper.getPlayer().posZ;
    }
}
