/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenjava.entries.FirstWorldAnarchy.t3.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 *
 * @author family
 */
public class RandomEvent extends Event {

    private static HandlerList handlers = new HandlerList();
    
    @Override public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
