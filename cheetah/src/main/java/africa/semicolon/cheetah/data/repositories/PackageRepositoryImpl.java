package africa.semicolon.cheetah.data.repositories;

import africa.semicolon.cheetah.data.models.Package;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PackageRepositoryImpl implements PackageRepository {
    private final Map<Integer, Package> database = new HashMap<>();

    @Override
    public Package save(Package aPackage) {
        Integer trackingNumber = database.size()+1;
        aPackage.setTrackingNumber(trackingNumber);
        database.put(trackingNumber, aPackage);
        return database.get(trackingNumber);
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
