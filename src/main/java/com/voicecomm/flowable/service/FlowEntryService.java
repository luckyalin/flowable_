package com.voicecomm.flowable.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.voicecomm.flowable.entity.FlowEntry;

/**
 * @author yulin.li
 */
public interface FlowEntryService extends IService<FlowEntry> {

    /**
     * 流程发布
     * @param entryId
     */
    void publish(String entryId);
}
