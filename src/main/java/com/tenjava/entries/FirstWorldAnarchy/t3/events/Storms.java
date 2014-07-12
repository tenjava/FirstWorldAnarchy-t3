/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenjava.entries.FirstWorldAnarchy.t3.events;

import com.tenjava.entries.FirstWorldAnarchy.t3.TenJava;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

/**
 *
 * @author family
 */
public enum Storms {

    METEOR_SHOWER("storms.meteor_shower"), ACID_RAIN("storms.acid_rain"), TORNADOS("storms.tornados"), EARTHQUAKES("storms.earthquakes");

    private String alias;

    private static boolean stormInProgress;
    private static Storms currentStorm = null;

    public static boolean isStormInProgress() {
        return stormInProgress;
    }

    public static Storms getCurrentStorm() {
        return currentStorm;
    }

    private static void setCurrentStorm(Storms storm) {
        currentStorm = storm;
    }

    private static void setStormInProgress(boolean stormInProgress) {
        Storms.stormInProgress = stormInProgress;
    }

    private Storms(String alias) {
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }

    public static void startMeteorShower() {
        Bukkit.broadcastMessage(ChatColor.DARK_RED + "A meteor shower has started! Take cover!");
        setStormInProgress(true);
        setCurrentStorm(METEOR_SHOWER);
        Bukkit.getServer().getScheduler().runTaskLater(TenJava.getInstance(), new Runnable() {
            @Override public void run() {
                setStormInProgress(false);
                setCurrentStorm(null);
            }
        }, TenJava.getInstance().getConfig().getInt("storm_duration") * 120);
    }

    public static void startAcidRain() {
        Bukkit.broadcastMessage(ChatColor.BLUE + "It's raining acid! Take cover!");
        setStormInProgress(true);
        setCurrentStorm(ACID_RAIN);
        Bukkit.getServer().getScheduler().runTaskLater(TenJava.getInstance(), new Runnable() {
            @Override public void run() {
                setStormInProgress(false);
                setCurrentStorm(null);
            }
        }, 6000);
    }

    public static void startTornado() {
        Bukkit.broadcastMessage(ChatColor.GRAY + "A tornado has spawned! Take cover!");
        setStormInProgress(true);
        setCurrentStorm(TORNADOS);
        Bukkit.getServer().getScheduler().runTaskLater(TenJava.getInstance(), new Runnable() {
            @Override public void run() {
                setStormInProgress(false);
                setCurrentStorm(null);
            }
        }, 6000);
    }

    public static void startEarthquake() {
        Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "An earthquake has started! Take cover!");
        setStormInProgress(true);
        setCurrentStorm(EARTHQUAKES);Bukkit.getServer().getScheduler().runTaskLater(TenJava.getInstance(), new Runnable() {
            @Override public void run() {
                setStormInProgress(false);
                setCurrentStorm(null);
            }
        }, 6000);
        
    }

    public static void startCorrespondingStorm(String configName) {
        if (configName.equalsIgnoreCase(METEOR_SHOWER.getAlias()) && TenJava.getInstance().getConfig().getBoolean(METEOR_SHOWER.getAlias())) {
            startMeteorShower();
        } else if (configName.equalsIgnoreCase(TORNADOS.getAlias()) && TenJava.getInstance().getConfig().getBoolean(TORNADOS.getAlias())) {
            startTornado();
        } else if (configName.equalsIgnoreCase(ACID_RAIN.getAlias()) && TenJava.getInstance().getConfig().getBoolean(ACID_RAIN.getAlias())) {
            startAcidRain();
        } else if (configName.equalsIgnoreCase(EARTHQUAKES.getAlias()) && TenJava.getInstance().getConfig().getBoolean(EARTHQUAKES.getAlias())) {
            startEarthquake();
        } else {
            startMeteorShower();
        }
    }
}
