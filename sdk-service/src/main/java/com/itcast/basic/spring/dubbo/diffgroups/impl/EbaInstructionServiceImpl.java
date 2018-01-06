package com.itcast.basic.spring.dubbo.diffgroups.impl;

import com.itcast.basic.spring.dubbo.diffgroups.service.InstructionService;

/**
 * Created by treey.qian on 2017/11/22.
 */
public class EbaInstructionServiceImpl implements InstructionService {
    @Override
    public void invoke() {
        System.out.println("EbaInstructionServiceImpl invoke");
    }
}
