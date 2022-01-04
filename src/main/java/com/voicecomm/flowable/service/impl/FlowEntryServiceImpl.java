package com.voicecomm.flowable.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.voicecomm.flowable.entity.FlowEntry;
import com.voicecomm.flowable.mapper.FlowEntryMapper;
import com.voicecomm.flowable.service.FlowEntryService;
import org.flowable.engine.RepositoryService;
import org.springframework.stereotype.Service;

/**
 * @author yulinli
 */
@Service
public class FlowEntryServiceImpl extends ServiceImpl<FlowEntryMapper, FlowEntry> implements FlowEntryService {
    private final RepositoryService repositoryService;


    public FlowEntryServiceImpl(RepositoryService repositoryService, FlowEntryService flowEntryService) {
        this.repositoryService = repositoryService;
    }


    /**
     * 发布流程
     * @param xml 流程暂存表id
     */
    @Override
    public void publish(String xml) {

    }

}
