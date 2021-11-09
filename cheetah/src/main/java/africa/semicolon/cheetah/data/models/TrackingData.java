package africa.semicolon.cheetah.data.models;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class TrackingData {
    private LocalDateTime dataTimeOfEvent = LocalDateTime.now();
    private String event;
}
