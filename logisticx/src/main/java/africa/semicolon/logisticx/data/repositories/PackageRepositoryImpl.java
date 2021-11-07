package africa.semicolon.logisticx.data.repositories;

import africa.semicolon.logisticx.data.models.Package;

import java.util.*;

public class PackageRepositoryImpl implements PackageRepository{
    private final Map<Integer, Package> dataBase = new HashMap<Integer, Package>();
    @Override
    public Package save(Package _package_) {
        Package  pack;
        Integer trackingNumber = null;
        if (_package_.getPackageId() == null){
            trackingNumber = dataBase.size()+1;
            _package_.setPackageId(trackingNumber);
        }
        trackingNumber = _package_.getPackageId();
        pack = dataBase.put(trackingNumber, _package_);
        return dataBase.get(trackingNumber);
    }

    @Override
    public List<Package> findAll() {
        List<Package> pack = new ArrayList<Package>();
        Set<Integer> keys = dataBase.keySet();
        for (Integer key: keys) {
            pack.add(dataBase.get(key));
        }
        return pack;
    }

    @Override
    public void remove(Package _package) {
        dataBase.remove(_package.getPackageId());
    }

    @Override
    public void delete(Integer tracking) {
        dataBase.remove(tracking);
    }

    @Override
    public Package update(Package _package) {
        return save(_package);
    }

    @Override
    public Package findByTrackingNumber(Integer trackingNumber) {
        return dataBase.get(trackingNumber);
    }
}
