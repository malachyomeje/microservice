//package com.malachy.student.util;
//
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//public class ResponseCodeUtil {
//    public <T extends BaseResponse> T updateResponseData(T baseResponse,
//                                                         ResponseCodeEnum responseCodeEnum, Map<String, String> params) {
//        List<ResponseParam> responseParams = params.entrySet().stream().map(map -> new ResponseParam(map.getKey(),
//                map.getValue())).collect(Collectors.toList());
//        String responseCodeDescription = getFormattedResponseCodeDescription(responseCodeEnum, responseParams);
//        return updateResponseData(baseResponse, responseCodeEnum, responseCodeDescription);
//    }
//}
