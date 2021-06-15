package me.acaiberii.tbtr.utility;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;

public class ChatUtil {
    public static void printInfo(String msg) {
        Minecraft.getMinecraft().player.sendMessage(new TextComponentString(ChatFormatting.BLACK + "[" + ChatFormatting.BLUE + "TBTR" + ChatFormatting.BLACK + "]" + ChatFormatting.RESET + " " + msg));
    }

    public static void printWarn(String msg) {
        Minecraft.getMinecraft().player.sendMessage(new TextComponentString(ChatFormatting.BLACK + "[" + ChatFormatting.YELLOW + "TBTR" + ChatFormatting.BLACK + "]" + ChatFormatting.RESET + " " + msg));
    }

    public static void printErr(String msg) {
        Minecraft.getMinecraft().player.sendMessage(new TextComponentString(ChatFormatting.BLACK + "[" + ChatFormatting.RED + "TBTR" + ChatFormatting.BLACK + "]" + ChatFormatting.RESET + " " + msg));
    }
}
