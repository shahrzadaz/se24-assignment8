package de.unibayreuth.se.teaching.list.data.impl;

import de.unibayreuth.se.teaching.list.business.ports.ListDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Qualifier("arrayListDataService")
public class ListDataServiceArrayListImpl implements ListDataService {
    private final ArrayList<Double> list = new ArrayList<>();
    private final ApplicationContext applicationContext;

    @Override
    public List<Double> get() {
        return list;
    }

    @Override
    public int getMaxLength() {
        Integer maxLength = applicationContext.getEnvironment().getProperty("seubt.list.maxLength", Integer.class);
        Objects.requireNonNull(maxLength);
        return maxLength;
    }

    @Override
    public void append(Double value) {
        list.add(value);
    }
}
