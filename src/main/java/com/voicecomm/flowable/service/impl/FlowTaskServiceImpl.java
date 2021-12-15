package com.voicecomm.flowable.service.impl;

import com.voicecomm.flowable.service.FlowTaskService;
import org.flowable.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName ActTaskServiceImpl
 * @Author yulin.li
 * @Date 2021/12/15 16:50
 * @Description 任务操作service
 */
@Service
public class FlowTaskServiceImpl implements FlowTaskService {
    @Autowired
    private TaskService taskService;
}
