package africa.semicolon.cheetah.data.repositories;

import africa.semicolon.cheetah.data.models.Package;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PackageRepositoryImplTest {
    PackageRepository  packageRepository;

    @BeforeEach
    void setUp() {
        packageRepository= new PackageRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        Package aPackage = new Package();
        aPackage.setName("Sleeping Mat");
        aPackage.setSenderName("Jerry");
        aPackage.setReceiverName("Dami");
        aPackage.setReceiverPhone("111112222");
        aPackage.setDeliveryAddress("312, ");
//        aPackage.setId(1234);
        aPackage.setNetWeight(32.4);
        aPackage.setSenderPhone(aPackage.getReceiverPhone());

        Package savedPackage = packageRepository.save(aPackage);
        assertEquals(1, savedPackage.getId());
    }

    @Test
    void updatePackageTest() {
        Package aPackage = new Package();
        aPackage.setName("Sleeping Mat");
        aPackage.setSenderName("Jerry");
        aPackage.setReceiverName("Dami");
        aPackage.setReceiverPhone("111112222");
        aPackage.setDeliveryAddress("312, ");
        aPackage.setNetWeight(32.4);
        aPackage.setSenderPhone(aPackage.getReceiverPhone());

        Package savedPackage = packageRepository.save(aPackage);
        savedPackage.setName("Sniper");
        Package updatedPackage = packageRepository.save(savedPackage);
        assertEquals(1, updatedPackage.getId());
    }

//    @Test
//    void findAll() {
//        Package aPackage = new Package();
//        aPackage.setName("Sleeping Mat");
//        aPackage.setSenderName("Jerry");
//        aPackage.setReceiverName("Dami");
//        aPackage.setReceiverPhone("111112222");
//        aPackage.setDeliveryAddress("312, ");
//        aPackage.setId(1234);
//        aPackage.setNetWeight(32.4);
//        aPackage.setSenderPhone(aPackage.getReceiverPhone());
//
//        Package savedPackage = packageRepository.save(aPackage);
//        assertEquals(1, packageRepository.findAll().size());
//    }

//    @Test
//    void delete() {
//        Package aPackage = new Package();
//        aPackage.setName("Sleeping Mat");
//        aPackage.setSenderName("Jerry");
//        aPackage.setReceiverName("Dami");
//        aPackage.setReceiverPhone("111112222");
//        aPackage.setDeliveryAddress("312, ");
//        aPackage.setId(1234);
//        aPackage.setNetWeight(32.4);
//        aPackage.setSenderPhone(aPackage.getReceiverPhone());
//
//        Package savedPackage = packageRepository.save(aPackage);
//        assertEquals(1, packageRepository.findAll().size());
//
//        packageRepository.delete(savedPackage);
//        assertEquals(0, packageRepository.findAll().size());
//    }

//    @Test
//    void deleteByTrackingNumber() {
//        Package aPackage = new Package();
//        aPackage.setName("Sleeping Mat");
//        aPackage.setSenderName("Jerry");
//        aPackage.setReceiverName("Dami");
//        aPackage.setReceiverPhone("111112222");
//        aPackage.setDeliveryAddress("312, ");
////        aPackage.setId(1234);
//        aPackage.setNetWeight(32.4);
//        aPackage.setSenderPhone(aPackage.getReceiverPhone());
//
//        Package savedPackage = packageRepository.save(aPackage);
//        assertEquals(1, packageRepository.findAll().size());
//
//        packageRepository.delete(1);
//        assertEquals(0, packageRepository.findAll().size());
//    }

//    @Test
//    void findPackageTrackingNumbered() {
//        Package aPackage = new Package();
//        aPackage.setName("Sleeping Mat");
//        aPackage.setSenderName("Jerry");
//        aPackage.setReceiverName("Dami");
//        aPackage.setReceiverPhone("111112222");
//        aPackage.setDeliveryAddress("312, ");
////        aPackage.setId(1234);
//        aPackage.setNetWeight(32.4);
//        aPackage.setSenderPhone(aPackage.getReceiverPhone());
//
//        Package savedPackage = packageRepository.save(aPackage);
//        assertEquals(savedPackage, packageRepository.findPackageTrackingNumbered(1));
//    }
}