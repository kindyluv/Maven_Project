package africa.semicolon.cheetah.utils;

import africa.semicolon.cheetah.data.models.Package;
import africa.semicolon.cheetah.dtos.request.AddPackageRequest;
import africa.semicolon.cheetah.dtos.responses.AddPackageResponse;

public class ModelMapper {

    public static Package map(AddPackageRequest addPackageRequest){
        Package aPackage = new Package();
        aPackage.setName(addPackageRequest.getPackageDescription());
        aPackage.setDeliveryAddress(addPackageRequest.getDeliveryAddress());
        aPackage.setSenderName(addPackageRequest.getSendersPhone());
        aPackage.setSenderPhone(addPackageRequest.getSendersPhone());
        aPackage.setReceiverPhone(addPackageRequest.getReceiverPhone());
        aPackage.setReceiverName(addPackageRequest.getReceiversName());
        aPackage.setNetWeight(addPackageRequest.getWeight());

        return aPackage;
    }

    public static AddPackageResponse map(Package savePackage){

        AddPackageResponse response = new AddPackageResponse();
        response.setPackageName(savePackage.getName());
        response.setPackageWeight(savePackage.getNetWeight());
        response.setReceiverName(savePackage.getReceiverName());
        response.setReceiverPhone(savePackage.getReceiverPhone());
        response.setTrackingNumber(savePackage.getId());

        return response;
    }
}
