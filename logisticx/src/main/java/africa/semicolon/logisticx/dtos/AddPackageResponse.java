package africa.semicolon.logisticx.dtos;

import lombok.Data;

@Data
public class AddPackageResponse {
    private String packageName;
    private Integer packageTrackingId;
    private String senderName;
    private String senderPhone;
    private String receiverName;
    private String receiverPhone;
    private String description;
    private double netWeight;
}
