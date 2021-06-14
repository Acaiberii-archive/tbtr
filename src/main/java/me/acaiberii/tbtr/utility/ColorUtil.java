package me.acaiberii.tbtr.utility;

import net.minecraft.client.Minecraft;

import java.awt.*;

public class ColorUtil {
    public static int getRGBWave(float seconds, float brightness, float saturation, long index) {
        float hue = ((System.currentTimeMillis() + index) % (int) (seconds * 1000)) / (seconds * 1000);
        return Color.HSBtoRGB(hue, saturation, brightness);
    }

    public static int getRGB(float seconds, float brightness, float saturation) {
        float hue = (System.currentTimeMillis() % (int) (seconds * 1000)) / (seconds * 1000);
        return Color.HSBtoRGB(hue, saturation, brightness);
    }
}
