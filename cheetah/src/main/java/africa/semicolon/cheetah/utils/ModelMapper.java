package africa.semicolon.cheetah.utils;

import africa.semicolon.cheetah.data.models.Package;
import africa.semicolon.cheetah.data.models.Sender;
import africa.semicolon.cheetah.data.models.TrackingData;
import africa.semicolon.cheetah.dtos.responses.AddTrackingInfoResponse;
import africa.semicolon.cheetah.dtos.request.AddTrackingInfoRequest;
import africa.semicolon.cheetah.dtos.request.RegisterSenderRequest;
import africa.semicolon.cheetah.dtos.responses.RegisterSenderResponse;
import africa.semicolon.cheetah.dtos.request.AddPackageRequest;
import africa.semicolon.cheetah.dtos.responses.AddPackageResponse;

public class ModelMapper {

    public static Package map(AddPackageRequest addPackageRequest){
        Package aPackage = new Package();

        aPackage.setName(addPackageRequest.getPackageDescription());
        aPackage.setDeliveryAddress(addPackageRequest.getDeliveryAddress());
        aPackage.setSenderEmail(addPackageRequest.getSenderEmail());
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

    public static Sender map(RegisterSenderRequest request){
        Sender sender = new Sender();
        sender.setSenderName(request.getSenderName());
        sender.setPhoneNumber(request.getPhoneNumber());
        sender.setEmailAddress(request.getSenderEmail());
        return sender;
    }

    public static RegisterSenderResponse map(Sender sender){
        RegisterSenderResponse response = new RegisterSenderResponse();
        response.setSenderEmail(sender.getEmailAddress());
        return response;
    }

    public static AddTrackingInfoResponse map(TrackingData trackingData, AddTrackingInfoRequest addTrackingInfo) {
        AddTrackingInfoResponse addTrackingInfoResponse = new AddTrackingInfoResponse();
        addTrackingInfoResponse.setDateTime(trackingData.getDataTimeOfEvent());
        addTrackingInfoResponse.setEvent(trackingData.getEvent());
        addTrackingInfoResponse.setPackageId(addTrackingInfo.getPackageId());
        return addTrackingInfoResponse;
    }
}
