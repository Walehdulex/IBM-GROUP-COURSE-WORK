package com.example.group19.service;

import org.springframework.stereotype.Service;

@Service
public class GlobalUserIdService {
    private int currentID = 1;

    public int getCurrentID() {
        return currentID;
    }

    public void setCurrentID(int currentID) {
        this.currentID = currentID;
    }
}
