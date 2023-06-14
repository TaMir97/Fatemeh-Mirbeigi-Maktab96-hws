package org.example.repository;

public interface Repository {
    public boolean isUnique(int newID);
    
    public int recordCounter();
    
    public int idGenerator();

    public int[] loadAllIDs();
}
