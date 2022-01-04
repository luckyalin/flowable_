package com.voicecomm.flowable.service.impl;

import com.voicecomm.flowable.service.FlowRuntimeService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName RuntimeServiceImpl
 * @Author yulin.li
 * @Date 2021/12/16 11:21
 * @Description RuntimeServiceImpl
 */
@Service
public class FlowRuntimeServiceImpl implements FlowRuntimeService {
    @Autowired
    private RuntimeService runtimeService;
    @Override
    public void startProcess(String processDefinitionKey) {
        ProcessInstance processInstance = runtimeService.startProcessInstanceById(processDefinitionKey, null, null);
        String processInstanceId = processInstance.getProcessInstanceId();
    }
}
