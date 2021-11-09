package africa.semicolon.cheetah.controller;

import africa.semicolon.cheetah.data.models.TrackingInformation;
import africa.semicolon.cheetah.dtos.request.AddTrackingInfoRequest;
import africa.semicolon.cheetah.dtos.responses.AddTrackingInfoResponse;
import africa.semicolon.cheetah.services.TrackingService;
import africa.semicolon.cheetah.services.TrackingServiceImpl;
import org.springframework.web.bind.annotation.*;

public class PackageTrackingController {
    private final TrackingService trackingService = new TrackingServiceImpl();

    @PatchMapping("/v1/api/trackingInfo")
    public AddTrackingInfoResponse addTrackingInfo(@RequestBody AddTrackingInfoRequest addTrackingInfoRequest){
        return trackingService.updateTrackingInfo(addTrackingInfoRequest);
    }

    @GetMapping("/api/trackingnfo/{id}")
    public TrackingInformation getTrackingInfo(@PathVariable("id") Integer trackingId){
        return trackingService.trackingPackage(trackingId);
    }
}
