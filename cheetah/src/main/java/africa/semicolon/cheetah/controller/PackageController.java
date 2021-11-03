package africa.semicolon.cheetah.controller;

import africa.semicolon.cheetah.data.repositories.PackageRepository;
import africa.semicolon.cheetah.data.repositories.PackageRepositoryImpl;
import africa.semicolon.cheetah.data.models.Package;
import africa.semicolon.cheetah.dtos.request.AddPackageRequest;
import africa.semicolon.cheetah.dtos.responses.AddPackageResponse;
import africa.semicolon.cheetah.services.PackageService;
import africa.semicolon.cheetah.services.PackageServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
public class PackageController {
    private final PackageService packageService = new PackageServiceImpl();
    private PackageRepository packageRepository = new PackageRepositoryImpl();

    @PostMapping("/api/addpackage")
    public AddPackageResponse addPackage(@RequestBody AddPackageRequest addPackageRequest) {
        return packageService.addPackage(addPackageRequest);
    }

    @GetMapping("/api/package/{id}")
    public Package findPackageId(@PathVariable("id") Integer id){
        return packageService.findPackageWithMy(id);
    }
}
