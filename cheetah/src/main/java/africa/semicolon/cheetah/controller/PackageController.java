package africa.semicolon.cheetah.controller;

import africa.semicolon.cheetah.data.repositories.PackageRepository;
import africa.semicolon.cheetah.data.repositories.PackageRepositoryImpl;
import africa.semicolon.cheetah.dtos.request.AddPackageRequest;
import africa.semicolon.cheetah.dtos.responses.AddPackageResponse;
import africa.semicolon.cheetah.services.PackageService;
import africa.semicolon.cheetah.services.PackageServiceImpl;

public class PackageController {
    private final PackageService packageService = new PackageServiceImpl();
    private PackageRepository packageRepository = new PackageRepositoryImpl();

    public AddPackageResponse addPackage(AddPackageRequest addPackageRequest) {
        return packageService.addPackage(addPackageRequest);
    }
}
