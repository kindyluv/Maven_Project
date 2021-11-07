package africa.semicolon.logisticx.data.models;

import lombok.Data;

@Data
public class Package {
    private String packageName;
    private Integer packageId;
    private String senderName;
    private String senderPhone;
    private String receiverName;
    private String receiverPhone;
    private double netWeight;
    private String description;
}
