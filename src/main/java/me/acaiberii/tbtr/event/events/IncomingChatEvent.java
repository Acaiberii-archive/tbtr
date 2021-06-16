package me.acaiberii.tbtr.event.events;

import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.common.eventhandler.Event;

public class IncomingChatEvent extends Event {
    private final String message;
    private final ServerChatEvent originalEvent;

    public ServerChatEvent getOriginalEvent() {
        return originalEvent;
    }

    public String getMessage() {
        return message;
    }

    public IncomingChatEvent(String message, ServerChatEvent originalEvent) {
        this.message = message;
        this.originalEvent = originalEvent;
    }
}
