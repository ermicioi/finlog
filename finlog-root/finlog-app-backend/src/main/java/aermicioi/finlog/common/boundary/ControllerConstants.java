package aermicioi.finlog.common.boundary;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
abstract public class ControllerConstants {

    public static final String JSON_TYPE = "application/json";
    public static final String JSON_FINLOG_TYPE = "application/vnd.finlog+json";
    public static final String JSON_FINLOG_V1_TYPE = "application/vnd.finlog+json;v=1";

}
