package de.unibayreuth.se.teaching.list.data.impl;

import de.unibayreuth.se.teaching.list.data.persistence.DoublyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ListDataServiceDoublyLinkedImplTest {
    private static final int MAX_LENGTH = 10;

    @Mock
    DoublyLinkedList mockedList;

    private ListDataServiceDoublyLinkedImpl sut;

    @BeforeEach
    void setUp() {
        sut = new ListDataServiceDoublyLinkedImpl(mockedList, MAX_LENGTH);
    }

    @Test
    void testGet() {
        when(mockedList.asArray()).thenReturn(new double[]{});
        sut.get();
        verify(mockedList).asArray();
    }

    @Test
    void testAppend() {
        double value = 0.2;
        sut.append(value);
        verify(mockedList).append(value);
    }

    @Test
    void testAppendWithMaxLength() {
        // given: a list with max length
        when(mockedList.getLength()).thenReturn(MAX_LENGTH);
        // when: appending another element
        // then: an exception is thrown
        assertThrows(IllegalStateException.class, () -> sut.append(0.0));
    }
}
