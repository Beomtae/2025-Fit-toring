package fittoring.aspect.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public record ErrorLog(
        String event,
        String method,
        String uri,
        Long durationMs,
        String errorType,
        String message,
        String stack,
        String normalizedUri,
        Integer statusCode,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
        LocalDateTime timestamp,
        String traceId
) {
}
