package me.acaiberii.tbtr.utility;

import net.minecraft.client.Minecraft;

public class FontUtil {
    public static void drawStringWithShadow(String text, float x, float y, int color) {
        Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(text, x, y, color);
    }
}
