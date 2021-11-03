package africa.semicolon.cheetah.dtos.request;

import lombok.Data;

@Data
public class AddPackageRequest {
    private String sendersName;
    private String sendersPhone;
    private String receiversName;
    private String deliveryAddress;
    private double weight;
    private String packageDescription;
    private String receiverPhone;


}
