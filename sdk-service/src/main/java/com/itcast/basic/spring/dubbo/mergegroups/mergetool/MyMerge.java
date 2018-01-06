package com.itcast.basic.spring.dubbo.mergegroups.mergetool;

import com.alibaba.dubbo.rpc.cluster.Merger;
import com.itcast.basic.spring.dubbo.mergegroups.dto.ResponseDto;

/**
 * Created by treey.qian on 2017/11/22.
 */
public class MyMerge implements Merger<ResponseDto> {

    @Override
    public ResponseDto merge(ResponseDto... responseDtos) {
        ResponseDto returnRes=null;
        for (ResponseDto responseDto : responseDtos) {
            if ("success".equals(responseDto.getMessage())) {
                returnRes=responseDto;
                break;
            }
        }
        return returnRes;
    }
}
