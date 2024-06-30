package de.unibayreuth.se.teaching.list.data.impl;

import de.unibayreuth.se.teaching.list.business.ports.ListDataService;
import de.unibayreuth.se.teaching.list.data.persistence.DoublyLinkedList;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Doubly-linked-list-based implementation of the data service that the business layer provides as a port.
 */
@Service
@RequiredArgsConstructor
@Qualifier("doublyLinkedListDataService")
@Primary
class ListDataServiceDoublyLinkedImpl implements ListDataService {
    private final DoublyLinkedList list;

    @Value("${seubt.list.maxLength}")
    private final Integer maxLength;

    @Override
    public List<Double> get() {
        return Arrays.stream(list.asArray()).boxed().toList();
    }

    @Override
    public int getMaxLength() {
        return maxLength;
    }

    @Override
    public void append(Double value) {
        Objects.requireNonNull(maxLength);
        if (list.getLength() >= maxLength) {
            throw new IllegalStateException(
                    "List already contains %d elements (max length: %d).".formatted(list.getLength(), maxLength)
            );
        }
        list.append(value);
    }
}
