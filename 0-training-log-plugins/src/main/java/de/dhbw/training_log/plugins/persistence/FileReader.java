package de.dhbw.training_log.plugins.persistence;

import de.dhbw.training_log.adapters.mapper.SessionEntityMapper;
import de.dhbw.training_log.adapters.resource.DistanceResource;
import de.dhbw.training_log.adapters.resource.SessionDateResource;
import de.dhbw.training_log.adapters.resource.SessionResource;
import de.dhbw.training_log.adapters.resource.SessionTimeResource;
import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.training_session_type.SessionType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

public class FileReader {

    static final ArrayList<Session> DEFAULT_SESSION_LIST = new ArrayList<>(Arrays.asList(
        fromString("569e2f72-f0f6-4a88-b701-af38e948742b;01.01.2022;10000.0 METERS;39:20;DESCRIPTION;LONG_RUN"),
        fromString("d069e2cf-d02b-4d51-ac50-2946ae88c540;04.01.2022;12.0 KILOMETERS;46:30;DESCRIPTION;LONG_RUN"),
        fromString("eaa5773c-67f3-4b33-81b7-ebed40ea926e;06.01.2022;5000 METERS;16:12;DESCRIPTION;SPEED_RUN"),
        fromString("faa6361b-2587-4e24-a870-64b6e9c26a37;09.01.2022;7 KILOMETERS;31:30;DESCRIPTION;RECOVERY_RUN"),
        fromString("93ea1a5c-97af-4439-b1b9-65f48793b4e3;13.01.2022;6 KILOMETERS;18:00;DESCRIPTION;INTERVALS"),
        fromString("3e35d8b7-2ddf-4a75-9e8c-b45555188109;17.01.2022;12 KILOMETERS;46:30;DESCRIPTION;PROGRESSION_RUN"),
        fromString("f9b04681-965f-4be9-a184-4e627fc14208;20.01.2022;8 KILOMETERS;28:19;DESCRIPTION;OTHER"),
        fromString("957676d8-46de-4cc1-bf4a-29368aa81911;25.01.2022;12 KILOMETERS;46:12;DESCRIPTION;LONG_RUN"),
        fromString("f758cb0b-1122-4e19-8761-c3aaf44c557c;01.02.2022;10 KILOMETERS;32:40;DESCRIPTION;SPEED_RUN")
    ));

    private static Session fromString(final String input) {
        final String[] line = input.split(";");
        final SessionResource resource = new SessionResource(
                UUID.fromString(line[0]),
                new SessionDateResource(line[1]),
                new DistanceResource(line[2]),
                new SessionTimeResource(line[3]),
                line[4],
                SessionType.valueOf(SessionType.class, line[5])
        );
        return new SessionEntityMapper().toDomainModel(resource);
    }


}
