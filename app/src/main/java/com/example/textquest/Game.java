package com.example.textquest;

import android.content.Context;

public class Game {
    private Location curLocation;
    private final IRepository repo;

    public Game(Context context) {
//        repo = new Repo(context);
        repo = new VVRepo();
        curLocation = repo.getLocation(0);
    }

    public Location getChoice(int nAct) {
        int newLoc = curLocation.actions[nAct].n;
        curLocation = repo.getLocation(newLoc);
        return curLocation;
    }

    public Location getCurLocation() {
        return curLocation;
    }
}
