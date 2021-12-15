package com.voicecomm.flowable.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.BeanCopier;
import com.voicecomm.flowable.entity.FlowEntry;
import com.voicecomm.flowable.entity.dto.FlowEntryDTO;
import com.voicecomm.flowable.service.FlowEntryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName FlowEntryController
 * @Author yulin.li
 * @Date 2021/12/15 15:55
 * @Description 流程操作controller 自定义流程信息表
 */
@RestController("/flowEntry")
@Api("流程操作controller")
public class FlowEntryController {
    @Autowired
    private FlowEntryService flowEntryService;

    @PostMapping
    @ApiOperation(("添加流程"))
    public ResponseEntity<Object> post(@RequestBody FlowEntryDTO flowEntry) {
        FlowEntry saveFlowEntry = BeanUtil.copyProperties(flowEntry, FlowEntry.class);
        return ResponseEntity.ok(flowEntryService.save(saveFlowEntry));
    }
}
