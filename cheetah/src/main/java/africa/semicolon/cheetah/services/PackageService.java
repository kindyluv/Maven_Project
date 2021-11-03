package africa.semicolon.cheetah.services;

import africa.semicolon.cheetah.dtos.request.AddPackageRequest;
import africa.semicolon.cheetah.dtos.responses.AddPackageResponse;

public interface PackageService {

    AddPackageResponse addPackage(AddPackageRequest addPackageRequest);
}
