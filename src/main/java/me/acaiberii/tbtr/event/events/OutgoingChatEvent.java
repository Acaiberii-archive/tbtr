package me.acaiberii.tbtr.event.events;

import ca.weblite.objc.Client;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.Event;

public class OutgoingChatEvent extends Event {
    private final String message;
    private final ClientChatEvent originalEvent;

    public String getMessage() {
        return message;
    }

    public ClientChatEvent getOriginalEvent() {
        return originalEvent;
    }

    public OutgoingChatEvent(String message, ClientChatEvent originalEvent) {
        this.message = message;
        this.originalEvent = originalEvent;
    }
}
