package africa.semicolon.cheetah.data.models;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TrackingData {
    private LocalDateTime dataTimeOfEvent = LocalDateTime.now();
    @NonNull
    private String event;
}
