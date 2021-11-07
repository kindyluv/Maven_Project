package africa.semicolon.logisticx.data.repositories;

import africa.semicolon.logisticx.data.models.Package;

import java.util.List;

public interface PackageRepository {

    Package save(Package _package);
    List<Package> findAll();
    void remove(Package _package);
    void delete(Integer tracking);
    Package update(Package _package);
    Package findByTrackingNumber(Integer trackingNumber);
}
