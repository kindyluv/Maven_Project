package africa.semicolon.cheetah.data.repositories;

import africa.semicolon.cheetah.data.models.Package;

import java.util.List;
import java.util.Optional;

public class PackageRepositoryImpl implements PackageRepository {
    @Override
    public Package save(Package aPackage) {
        return null;
    }

    @Override
    public List<Package> findAll() {
        return null;
    }

    @Override
    public void delete(Package aPackage) {

    }

    @Override
    public void deleteByTrackingNumber(Integer trackingNumber) {

    }

    @Override
    public Optional<Package> findPackageTrackingNumbered(Integer trackingNumber) {
        return Optional.empty();
    }
}
