package com.nckh.nckh2020.events;

public abstract class AbstractEvent implements Event {

    protected abstract void fire(EventObserver eventObserver);

}
