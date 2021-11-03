package africa.semicolon.cheetah.data.repositories;

import africa.semicolon.cheetah.data.models.Package;

import java.util.*;


public class PackageRepositoryImpl implements PackageRepository {
    private final Map<Integer, Package> database = new HashMap<>();

    @Override
    public Package save(Package aPackage) {
        Integer trackingNumber = null;
        if(aPackage.getId() == null){
            trackingNumber = database.size()+1;
            aPackage.setId(trackingNumber);
        }
        trackingNumber = aPackage.getId();
        database.put(trackingNumber, aPackage);
        return database.get(trackingNumber);
    }

    @Override
    public List<Package> findAll() {

        List<Package> all = new ArrayList<Package>();
        Set<Integer> keys = database.keySet();
        for(Integer key : keys){
            all.add(database.get(key));
        }
//        keys.forEach(key -> all.add(database.get(key)));
        return all;
    }

    @Override
    public void delete(Package aPackage) {
        database.remove(aPackage.getId());

    }

    @Override
    public void delete(Integer trackingNumber) {
        database.remove(trackingNumber);
    }

    @Override
    public Package findPackageTrackingNumbered(Integer trackingNumber) {
        return database.get(trackingNumber);
    }
}
