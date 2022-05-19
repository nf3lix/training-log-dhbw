package de.dhbw.training_log.adapters.usecase.search_sessions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompositeSearchQuery {

    private final List<SearchQuery> queries = new ArrayList<>();

    public CompositeSearchQuery(final String input) {
        final String[] filterCriteria = input.split(";");
        Arrays.stream(filterCriteria).forEach(query -> queries.add(new SearchQuery(query)));
    }

    public List<SearchQuery> getQueries() {
        return queries;
    }

}
