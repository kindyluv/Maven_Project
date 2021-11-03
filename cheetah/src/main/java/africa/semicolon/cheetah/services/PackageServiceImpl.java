package africa.semicolon.cheetah.services;

import africa.semicolon.cheetah.data.models.Package;
import africa.semicolon.cheetah.data.repositories.PackageRepository;
import africa.semicolon.cheetah.data.repositories.PackageRepositoryImpl;
import africa.semicolon.cheetah.dtos.request.AddPackageRequest;
import africa.semicolon.cheetah.dtos.responses.AddPackageResponse;
import africa.semicolon.cheetah.utils.ModelMapper;

public class PackageServiceImpl implements PackageService {
    private final PackageRepository packageRepository = new PackageRepositoryImpl();

    @Override
    public AddPackageResponse addPackage(AddPackageRequest addPackageRequest) {
        //convert addPackage request to a package
        Package aPackage = ModelMapper.map(addPackageRequest);


        //save package
        Package savePackage = packageRepository.save(aPackage);
        //convert saved package to addPackage response
        AddPackageResponse response = ModelMapper.map(savePackage);

        //return converted response
        return response;
    }
}
