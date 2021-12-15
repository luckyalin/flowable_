package com.voicecomm.flowable.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.voicecomm.flowable.entity.FlowEntry;
import com.voicecomm.flowable.mapper.FlowEntryMapper;
import com.voicecomm.flowable.service.FlowEntryService;
import org.springframework.stereotype.Service;

@Service
public class FlowEntryServiceImpl extends ServiceImpl<FlowEntryMapper, FlowEntry> implements FlowEntryService {

}
