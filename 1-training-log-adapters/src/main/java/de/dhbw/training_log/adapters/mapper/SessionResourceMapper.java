package de.dhbw.training_log.adapters.mapper;

public interface SessionResourceMapper<T, K> {
    T toResource(final K domainModelObject);
    K toDomainModel(final T resource);
}
