package com.nckh.nckh2020.events;

import com.nckh.nckh2020.events.engine.FlipDownCardsEvent;
import com.nckh.nckh2020.events.engine.GameWonEvent;
import com.nckh.nckh2020.events.engine.HidePairCardsEvent;
import com.nckh.nckh2020.events.ui.BackGameEvent;
import com.nckh.nckh2020.events.ui.DifficultySelectedEvent;
import com.nckh.nckh2020.events.ui.FlipCardEvent;
import com.nckh.nckh2020.events.ui.NextGameEvent;
import com.nckh.nckh2020.events.ui.ResetBackgroundEvent;
import com.nckh.nckh2020.events.ui.StartEvent;
import com.nckh.nckh2020.events.ui.ThemeSelectedEvent;


public interface EventObserver {

    void onEvent(FlipCardEvent event);

    void onEvent(DifficultySelectedEvent event);

    void onEvent(HidePairCardsEvent event);

    void onEvent(FlipDownCardsEvent event);

    void onEvent(StartEvent event);

    void onEvent(ThemeSelectedEvent event);

    void onEvent(GameWonEvent event);

    void onEvent(BackGameEvent event);

    void onEvent(NextGameEvent event);

    void onEvent(ResetBackgroundEvent event);

}
