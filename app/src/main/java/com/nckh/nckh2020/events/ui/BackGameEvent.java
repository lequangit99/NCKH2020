package com.nckh.nckh2020.events.ui;

import com.nckh.nckh2020.events.AbstractEvent;
import com.nckh.nckh2020.events.EventObserver;

/**
 * When the 'back to menu' was pressed.
 */
public class BackGameEvent extends AbstractEvent {

    public static final String TYPE = BackGameEvent.class.getName();

    @Override
    protected void fire(EventObserver eventObserver) {
        eventObserver.onEvent(this);
    }

    @Override
    public String getType() {
        return TYPE;
    }

}
