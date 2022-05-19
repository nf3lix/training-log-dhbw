package de.dhbw.training_log.adapters.resource.filter_criteria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterQueryResource {

    private final List<QueryResource> queries = new ArrayList<>();

    public FilterQueryResource(final String input) {
        final String[] filterCriteria = input.split(";");
        Arrays.stream(filterCriteria).forEach(query -> queries.add(new QueryResource(query)));
    }

    public List<QueryResource> getQueries() {
        return queries;
    }

}
