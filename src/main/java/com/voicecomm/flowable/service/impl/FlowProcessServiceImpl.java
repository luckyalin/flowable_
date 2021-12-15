package com.voicecomm.flowable.service.impl;

import com.voicecomm.flowable.service.FlowProcessService;
import org.flowable.engine.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName FlowProcessServiceImpl
 * @Author yulin.li
 * @Date 2021/12/15 16:56
 * @Description FlowProcessServiceImpl
 */
@Service
public class FlowProcessServiceImpl implements FlowProcessService {
    @Autowired
    private RepositoryService repositoryService;

}
