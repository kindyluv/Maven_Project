package africa.semicolon.logisticx.service;

import africa.semicolon.logisticx.data.models.Package;
import africa.semicolon.logisticx.data.repositories.PackageRepositoryImpl;
import africa.semicolon.logisticx.dtos.AddPackageResponse;
import africa.semicolon.logisticx.dtos.AddPackageRequest;
import africa.semicolon.logisticx.utils.ModelMapper;

public class PackageServiceImpl implements PackageService{
    private static final PackageRepositoryImpl savedData = new PackageRepositoryImpl();
    @Override
    public AddPackageResponse addNewPackage(AddPackageRequest _request) {
        Package _pack = ModelMapper.map(_request);


        Package data = savedData.save(_pack);

        AddPackageResponse response = ModelMapper.map(data);


        return response;
    }

    @Override
    public Package findPackageByCustomersId(Integer trackingId) {
        return savedData.findByTrackingNumber(trackingId);
    }
}
