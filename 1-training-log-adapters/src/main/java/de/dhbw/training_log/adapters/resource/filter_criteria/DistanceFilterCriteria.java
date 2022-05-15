package de.dhbw.training_log.adapters.resource.filter_criteria;

import de.dhbw.training_log.adapters.resource.DistanceResource;

public class DistanceFilterCriteria extends FilterCriteriaResource<DistanceResource> {

    public DistanceFilterCriteria(String input) {
        super(input);
    }

    @Override
    DistanceResource readComparedObject(String input) {
        return new DistanceResource(input);
    }

}
