package com.javarush.task.task39.task3911;

import java.util.*;

public class Software {
    int currentVersion;

    private Map<Integer, String> versionHistoryMap = new LinkedHashMap<>();

    public void addNewVersion(int version, String description) {
        if (version > currentVersion) {
            versionHistoryMap.put(version, description);
            currentVersion = version;
        }
    }

    public int getCurrentVersion() {
        return currentVersion;
    }

    public Map<Integer, String> getVersionHistoryMap() {
        return Collections.unmodifiableMap(versionHistoryMap);
    }

    public boolean rollback(int rollbackVersion) {
        if (versionHistoryMap.containsKey(rollbackVersion)){
            Map<Integer, String> map = new LinkedHashMap<>();
            for (Map.Entry<Integer, String> pair : versionHistoryMap.entrySet()){
                if (pair.getKey() <= rollbackVersion){
                    map.put(pair.getKey(), pair.getValue());
                }
            }
            versionHistoryMap = map;
            currentVersion = rollbackVersion;
            return true;
        }
        return false;
    }
}
