package africa.semicolon.logisticx.utils;

import africa.semicolon.logisticx.data.models.Package;
import africa.semicolon.logisticx.dtos.AddPackageRequest;
import africa.semicolon.logisticx.dtos.AddPackageResponse;

public class ModelMapper {

    public static Package map(AddPackageRequest _request){
        Package _pack = new Package();

        _pack.setPackageName(_request.getPackageName());
        _pack.setPackageId(_request.getPackageTrackingId());
        _pack.setSenderName(_request.getSenderName());
        _pack.setSenderPhone(_request.getSenderPhone());
        _pack.setReceiverName(_request.getReceiverName());
        _pack.setReceiverPhone(_request.getReceiverPhone());
        _pack.setDescription(_request.getDescription());
        _pack.setNetWeight(_request.getNetWeight());

        return _pack;
    }

    public static AddPackageResponse map(Package data){
        AddPackageResponse response = new AddPackageResponse();

        response.setPackageName(data.getPackageName());
        response.setPackageTrackingId(data.getPackageId());
        response.setSenderName(data.getSenderName());
        response.setSenderPhone(data.getSenderPhone());
        response.setReceiverName(data.getReceiverName());
        response.setReceiverPhone(data.getReceiverPhone());
        response.setDescription(data.getDescription());
        response.setNetWeight(data.getNetWeight());

        return response;
    }

}
