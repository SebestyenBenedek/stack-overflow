package com.codecool.stackoverflowtw.logger;

import org.springframework.stereotype.Service;

@Service
public interface Logger {
    void logError(String message);
    void logInfo(String message);
}
