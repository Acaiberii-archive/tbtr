package me.acaiberii.tbtr.listener;

import me.acaiberii.tbtr.event.events.IncomingChatEvent;
import me.acaiberii.tbtr.event.events.OutgoingChatEvent;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Chat {
    @SubscribeEvent
    public void onInChat(ServerChatEvent event) {
        IncomingChatEvent postEvent = new IncomingChatEvent(event.getMessage(), event);
        MinecraftForge.EVENT_BUS.post(postEvent);
    }

    @SubscribeEvent
    public void onOutChat(ClientChatEvent event) {
        OutgoingChatEvent postEvent = new OutgoingChatEvent(event.getOriginalMessage(), event);
    }
}
