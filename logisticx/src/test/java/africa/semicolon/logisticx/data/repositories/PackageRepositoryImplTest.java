package africa.semicolon.logisticx.data.repositories;

import africa.semicolon.logisticx.data.models.Package;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PackageRepositoryImplTest {
    PackageRepository pack;

    @BeforeEach
    void setUp() {
        pack = new PackageRepositoryImpl();
    }

    @Test
    void save() {
        Package _package = new Package();

        _package.setPackageName("Lenovo Yoga");
//        _package.setPackageId(1);
        _package.setSenderName("Toye");
        _package.setSenderPhone("08997890");
        _package.setSenderName("Lois");
        _package.setReceiverPhone("08877060");
        _package.setNetWeight(67.0);

        Package _pack = pack.save(_package);
        assertEquals(1, _pack.getPackageId());
    }

    @Test
    void findAll() {
        Package _package = new Package();

        _package.setPackageName("Lenovo Yoga");
//        _package.setPackageId(1);
        _package.setSenderName("Toye");
        _package.setSenderPhone("08997890");
        _package.setSenderName("Lois");
        _package.setReceiverPhone("08877060");
        _package.setNetWeight(67.0);

        Package _pack = pack.save(_package);

        assertEquals(1, pack.findAll().size());
    }

    @Test
    void remove() {
        Package _package = new Package();

        _package.setPackageName("Lenovo Yoga");
//        _package.setPackageId(1);
        _package.setSenderName("Toye");
        _package.setSenderPhone("08997890");
        _package.setSenderName("Lois");
        _package.setReceiverPhone("08877060");
        _package.setNetWeight(67.0);

        Package _pack = pack.save(_package);

        pack.remove(_pack);
        assertEquals(0, pack.findAll().size());
    }

    @Test
    void delete() {
        Package _package = new Package();

        _package.setPackageName("Lenovo Yoga");
//        _package.setPackageId(1);
        _package.setSenderName("Toye");
        _package.setSenderPhone("08997890");
        _package.setSenderName("Lois");
        _package.setReceiverPhone("08877060");
        _package.setNetWeight(67.0);

        Package _pack = pack.save(_package);

        pack.delete(1);
        assertEquals(0, pack.findAll().size());
    }

    @Test
    void findByTrackingNumber() {
        Package _package = new Package();

        _package.setPackageName("Lenovo Yoga");
//        _package.setPackageId(1);
        _package.setSenderName("Toye");
        _package.setSenderPhone("08997890");
        _package.setSenderName("Lois");
        _package.setReceiverPhone("08877060");
        _package.setNetWeight(67.0);

        Package _pack = pack.save(_package);
        assertEquals(_pack, pack.findByTrackingNumber(1));
    }

    @Test
    void updateDatabase(){
        Package _package = new Package();

        _package.setPackageName("Lenovo Yoga");
//        _package.setPackageId(1);
        _package.setSenderName("Toye");
        _package.setSenderPhone("08997890");
        _package.setSenderName("Lois");
        _package.setReceiverPhone("08877060");
        _package.setNetWeight(67.0);

        Package _pack = pack.save(_package);
        _pack.setSenderName("jumia");
        Package _pack1 = pack.save(pack.update(_pack));
        assertEquals(1, _pack1.getPackageId());
    }
}