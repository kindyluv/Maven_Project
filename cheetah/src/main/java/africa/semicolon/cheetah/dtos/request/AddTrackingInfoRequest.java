package africa.semicolon.cheetah.dtos.request;

import lombok.Data;

@Data
public class AddTrackingInfoRequest {
    private Integer packageId;
    private String event;
}
