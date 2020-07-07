package com.nckh.nckh2020.events;

import com.nckh.nckh2020.events.engine.FlipDownCardsEvent;
import com.nckh.nckh2020.events.engine.GameWonEvent;
import com.nckh.nckh2020.events.engine.HidePairCardsEvent;
import com.nckh.nckh2020.events.ui.BackGameEvent;
import com.nckh.nckh2020.events.ui.FlipCardEvent;
import com.nckh.nckh2020.events.ui.NextGameEvent;
import com.nckh.nckh2020.events.ui.ResetBackgroundEvent;
import com.nckh.nckh2020.events.ui.ThemeSelectedEvent;
import com.nckh.nckh2020.events.ui.DifficultySelectedEvent;
import com.nckh.nckh2020.events.ui.StartEvent;


public class EventObserverAdapter implements EventObserver {

    public void onEvent(FlipCardEvent event) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void onEvent(DifficultySelectedEvent event) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void onEvent(HidePairCardsEvent event) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void onEvent(FlipDownCardsEvent event) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void onEvent(StartEvent event) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void onEvent(ThemeSelectedEvent event) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void onEvent(GameWonEvent event) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void onEvent(BackGameEvent event) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void onEvent(NextGameEvent event) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void onEvent(ResetBackgroundEvent event) {
        throw new UnsupportedOperationException();
    }

}
