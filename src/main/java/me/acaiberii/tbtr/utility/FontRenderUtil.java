package me.acaiberii.tbtr.utility;

import net.minecraft.client.Minecraft;

import static me.acaiberii.tbtr.utility.ColorUtil.getRGBWave;

public class FontRenderUtil {
    public static void drawStringWithShadow(String text, float x, float y, int color) {
        Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(text, x, y, color);
    }

    public static void drawString(String text, int x, int y, int color) {
        Minecraft.getMinecraft().fontRenderer.drawString(text, x, y, color);
    }

    public static void drawRainbowStringWithShadow(String text, int x, int y, double offset, float time, float sat) {
        double xOffset = 0;
        char[] charArray = text.toCharArray();
        for (char c : charArray) {
            FontRenderUtil.drawStringWithShadow(String.valueOf(c), (float)(x + xOffset), y, getRGBWave(time, 1, sat, 35L * (long) xOffset));
            xOffset += Minecraft.getMinecraft().fontRenderer.getStringWidth(String.valueOf(c)) + offset;
        }
    }

    public static void drawRainbowString(String text, int x, int y, double offset, float time, float sat) {
        double xOffset = 0;
        char[] charArray = text.toCharArray();
        for (char c : charArray) {
            FontRenderUtil.drawString(String.valueOf(c), (int)(x + xOffset), y, getRGBWave(time, 1, sat, 35L * (long) xOffset));
            xOffset += Minecraft.getMinecraft().fontRenderer.getStringWidth(String.valueOf(c)) + offset;
        }
    }

    public static int getFontHeight() {
        return Minecraft.getMinecraft().fontRenderer.FONT_HEIGHT;
    }

    public static int getStringWidth(String str) {
        return Minecraft.getMinecraft().fontRenderer.getStringWidth(str);
    }
}
