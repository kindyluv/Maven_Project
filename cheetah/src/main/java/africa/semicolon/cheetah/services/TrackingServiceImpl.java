package africa.semicolon.cheetah.services;

import africa.semicolon.cheetah.data.models.TrackingData;
import africa.semicolon.cheetah.data.models.TrackingInformation;
import africa.semicolon.cheetah.data.repositories.TrackingInformationRepository;
import africa.semicolon.cheetah.data.repositories.TrackingInformationRepositoryImpl;
import africa.semicolon.cheetah.dtos.responses.AddTrackingInfoResponse;
import africa.semicolon.cheetah.dtos.request.AddTrackingInfoRequest;
import africa.semicolon.cheetah.exceptions.InvalidPackageIdException;
import africa.semicolon.cheetah.utils.ModelMapper;

import java.util.Optional;

public class TrackingServiceImpl implements TrackingService {
    private PackageService packageService = new PackageServiceImpl();
    private TrackingInformationRepository trackingRepo = new TrackingInformationRepositoryImpl();

    @Override
    public AddTrackingInfoResponse updateTrackingInfo(AddTrackingInfoRequest addTrackingInfoRequest) {
        //verify package id is correct
        var aPackage = packageService.findPackageWithMy(addTrackingInfoRequest.getPackageId());
        if(aPackage == null) throw new InvalidPackageIdException("Package id is invalid");

        TrackingData trackingData = new TrackingData(addTrackingInfoRequest.getEvent());
        //find previous tracking info
        Optional<TrackingInformation> optionalInfo = trackingRepo.findByPackageId(addTrackingInfoRequest.getPackageId());

        if(optionalInfo.isPresent()) {
            optionalInfo.get().getTrackingData().add(trackingData);
            trackingRepo.save(optionalInfo.get());
        }else{
            TrackingInformation trackingInformation = new TrackingInformation();
            trackingInformation.setPackageId(addTrackingInfoRequest.getPackageId());
            trackingInformation.getTrackingData().add(trackingData);
            trackingRepo.save(trackingInformation);
        }
        //if exist add new event and save
        //else create new tracking info, add new event and save
        //convert saved tracking info to response dto
        //return response dto
        return ModelMapper.map(trackingData, addTrackingInfoRequest);
    }

    @Override
    public TrackingInformation trackingPackage(Integer packageId) {
        return trackingRepo.findByPackageId(packageId).get();
    }
}
