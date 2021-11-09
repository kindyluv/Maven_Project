package africa.semicolon.cheetah.dtos.responses;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class AddTrackingInfoResponse {
    private Integer packageId;
    private LocalDateTime dateTime;
    private String event;

}
