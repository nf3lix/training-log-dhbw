package de.dhbw.training_log.adapters.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface SessionResourceMapper<T, K> {
    T toResource(final K domainModelObject);
    K toDomainModel(final T resource);

    default List<T> toResourceList(final List<K> list) {
        return list.stream().map(this::toResource).collect(Collectors.toList());
    }

}
