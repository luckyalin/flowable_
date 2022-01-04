package com.voicecomm.flowable.service;

/**
 * @ClassName RuntimeService
 * @Author yulin.li
 * @Date 2021/12/16 11:21
 * @Description RuntimeService
 */
public interface FlowRuntimeService {
    /**
     * 发起一个流程
     * @param processDefinitionKey
     */
    void startProcess(String processDefinitionKey);
}
