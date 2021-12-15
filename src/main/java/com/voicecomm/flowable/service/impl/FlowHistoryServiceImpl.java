package com.voicecomm.flowable.service.impl;

import com.voicecomm.flowable.service.FlowHistoryService;
import org.flowable.engine.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName FlowHistoryServiceImpl
 * @Author yulin.li
 * @Date 2021/12/15 16:53
 * @Description 流程操作历史service
 */
@Service
public class FlowHistoryServiceImpl implements FlowHistoryService {
    @Autowired
    private HistoryService historyService;

}
