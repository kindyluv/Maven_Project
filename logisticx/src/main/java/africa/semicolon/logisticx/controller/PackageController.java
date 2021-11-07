package africa.semicolon.logisticx.controller;

import africa.semicolon.logisticx.data.models.Package;
import africa.semicolon.logisticx.dtos.AddPackageRequest;
import africa.semicolon.logisticx.dtos.AddPackageResponse;
import africa.semicolon.logisticx.service.PackageService;
import africa.semicolon.logisticx.service.PackageServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PackageController {
    private PackageService service = new PackageServiceImpl();

    @PostMapping("api/addPackage")
    public AddPackageResponse addPackage(AddPackageRequest request){
        return service.addNewPackage(request);
    }

    @GetMapping("api/findPackageById")
    public Package findPackageBy(@PathVariable("id")Integer id){
        return service.findPackageByCustomersId(id);
    }

}
