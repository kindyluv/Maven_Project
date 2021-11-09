package africa.semicolon.cheetah.data.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class TrackingInformation {
    private final List<TrackingData> trackingData = new ArrayList<TrackingData>();
    private Integer packageId;

}
