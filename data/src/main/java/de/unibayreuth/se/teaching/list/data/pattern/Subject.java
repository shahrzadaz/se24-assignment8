package de.unibayreuth.se.teaching.list.data.pattern;

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void updateObservers();
}
