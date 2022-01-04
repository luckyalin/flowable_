package com.voicecomm.flowable.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.voicecomm.flowable.entity.FlowEntry;
import com.voicecomm.flowable.exception.BadRequestException;
import com.voicecomm.flowable.mapper.FlowEntryMapper;
import com.voicecomm.flowable.service.FlowEntryService;
import lombok.Cleanup;
import org.apache.commons.lang3.StringUtils;
import org.flowable.bpmn.converter.BpmnXMLConverter;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.Deployment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Service
public class FlowEntryServiceImpl extends ServiceImpl<FlowEntryMapper, FlowEntry> implements FlowEntryService {
    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private FlowEntryService flowEntryService;


    /**
     * 发布流程
     * @param xml 流程暂存表id
     */
    @Override
    public void publish(String xml) {
//        FlowEntry flowEntry = flowEntryService.getById(entryId);
//        if(flowEntry == null) {
//            throw new BadRequestException("流程不存在");
//        }else if(StringUtils.isBlank(flowEntry.getBpmnXml())) {
//            throw new BadRequestException("该流程没有流程图，请添加流程图");
//        }
//        String bpmnXml = flowEntry.getBpmnXml();
        BpmnModel bpmnModel = null;
        try {
            bpmnModel = convertToBpmnModel(xml);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        Deployment deploy = repositoryService.createDeployment()
                .addBpmnModel("123.bpmn", bpmnModel)
                .name("流程1")
                .key("123")
                .deploy();
    }

    private BpmnModel convertToBpmnModel(String bpmnXml) throws XMLStreamException {
        BpmnXMLConverter converter = new BpmnXMLConverter();
        InputStream in = new ByteArrayInputStream(bpmnXml.getBytes(StandardCharsets.UTF_8));
        @Cleanup XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(in);
        return converter.convertToBpmnModel(reader);
    }
}
