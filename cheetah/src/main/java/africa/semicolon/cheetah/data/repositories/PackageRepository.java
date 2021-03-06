package africa.semicolon.cheetah.data.repositories;
import africa.semicolon.cheetah.data.models.Package;
import africa.semicolon.cheetah.data.models.Sender;
import africa.semicolon.cheetah.exceptions.SenderNotFoundException;

import java.util.List;

public interface PackageRepository {
    Package save(Package aPackage);
    List<Package> findAll();
    void delete(Package aPackage);
    void delete(Integer trackingNumber);
    Package findPackageTrackingNumbered(Integer trackingNumber);
    Package findPackageBySenderEmail(String email) throws SenderNotFoundException;
}
