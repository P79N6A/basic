package com.itcast.basic.spring.dubbo.context.impl;

import com.alibaba.dubbo.rpc.RpcContext;
import com.itcast.basic.spring.dubbo.context.service.DownloadService;

/**
 * Created by treey.qian on 2017/11/23.
 */
public class DownloadServiceImpl implements DownloadService {

    @Override
    public boolean download() {
        boolean isSuccess = false;
        try {
            StringBuilder dubboInfo = new StringBuilder();
            dubboInfo.append("isProviderSide is ")
                    .append(RpcContext.getContext().isProviderSide())
                    .append(" remote host is ")
                    .append(RpcContext.getContext().getRemoteHost())
                    .append(" application is ")
                    .append(RpcContext.getContext().getUrl().getParameter("application"));
            System.out.println("dubbo info is " + dubboInfo.toString());
            Object downloadIndex = RpcContext.getContext().get("downloadIndex");
            System.out.println("download from " + downloadIndex + ", current is " + System.currentTimeMillis());
            Thread.sleep(500);
            isSuccess = true;
        } catch (Exception e) {
            System.out.println("DownloadServiceImpl error message is" + e);
        }
        return isSuccess;
    }
}
