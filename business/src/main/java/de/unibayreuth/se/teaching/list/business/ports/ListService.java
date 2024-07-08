package de.unibayreuth.se.teaching.list.business.ports;

import java.util.List;

/**
 * Interface for the implementation of the list service that the business layer provides as a port.
 */
public interface ListService {
    List<Value> get();
    int getMaxLength();
    void append(List<Value> valuesToAppend);
}
