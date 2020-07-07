package com.nckh.nckh2020.events.engine;

import com.nckh.nckh2020.events.AbstractEvent;
import com.nckh.nckh2020.events.EventObserver;
import com.nckh.nckh2020.model.GameState;

/**
 * When the 'back to menu' was pressed.
 */
public class GameWonEvent extends AbstractEvent {

    public static final String TYPE = GameWonEvent.class.getName();

    public GameState gameState;


    public GameWonEvent(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    protected void fire(EventObserver eventObserver) {
        eventObserver.onEvent(this);
    }

    @Override
    public String getType() {
        return TYPE;
    }

}
