package africa.semicolon.cheetah.services;

import africa.semicolon.cheetah.data.models.TrackingInformation;
import africa.semicolon.cheetah.dtos.responses.AddTrackingInfoResponse;
import africa.semicolon.cheetah.dtos.request.AddTrackingInfoRequest;

public interface TrackingService {

    AddTrackingInfoResponse updateTrackingInfo(AddTrackingInfoRequest AddTrackingInfoRequest);
    TrackingInformation trackingPackage(Integer packageId);
}
