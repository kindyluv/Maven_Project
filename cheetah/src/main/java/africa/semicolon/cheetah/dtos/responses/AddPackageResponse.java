package africa.semicolon.cheetah.dtos.responses;

import lombok.Data;

@Data
public class AddPackageResponse {
    private Integer trackingNumber;
    private String PackageName;
    private String receiverName;
    private String receiverPhone;
    private double packageWeight;
}
