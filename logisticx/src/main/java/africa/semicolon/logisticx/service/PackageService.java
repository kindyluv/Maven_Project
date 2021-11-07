package africa.semicolon.logisticx.service;

import africa.semicolon.logisticx.data.models.Package;
import africa.semicolon.logisticx.dtos.AddPackageResponse;
import africa.semicolon.logisticx.dtos.AddPackageRequest;

public interface PackageService {

    AddPackageResponse addNewPackage(AddPackageRequest request);
    Package findPackageByCustomersId(Integer trackingId);
}
