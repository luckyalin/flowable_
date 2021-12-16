package com.voicecomm.flowable.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.voicecomm.flowable.entity.FlowEntry;

public interface FlowEntryService extends IService<FlowEntry> {
    void publish(String entryId);
}
