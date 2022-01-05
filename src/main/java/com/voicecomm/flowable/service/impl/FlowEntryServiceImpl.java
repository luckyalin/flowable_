package com.voicecomm.flowable.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.voicecomm.flowable.entity.FlowEntry;
import com.voicecomm.flowable.mapper.FlowEntryMapper;
import com.voicecomm.flowable.service.FlowEntryService;
import lombok.AllArgsConstructor;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.flowable.bpmn.converter.BpmnXMLConverter;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.engine.RepositoryService;
import org.springframework.stereotype.Service;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author yulin.li
 */
@Service
@AllArgsConstructor
@Slf4j
public class FlowEntryServiceImpl extends ServiceImpl<FlowEntryMapper, FlowEntry> implements FlowEntryService {
    private final RepositoryService repositoryService;

    /**
     * 发布流程
     * @param entryId 流程暂存表id
     */
    @Override
    public void publish(String entryId) {
        log.info("开始发布流程,流程id:" + entryId);
        try {
            FlowEntry flowEntry = this.getById(entryId);
            verifyFlowEntry(flowEntry);
            //将xml转为BpmnModel对象
            BpmnModel bpmnModel = convertToBpmnModel(flowEntry.getBpmnXml());

        } catch (XMLStreamException e) {
            log.error("流程发布发生异常：" + e);
            e.printStackTrace();
        }
    }

    /**
     * 校验流程是否符合要求
     * @param flowEntry  TODO
     * @throws XMLStreamException
     */
    public void verifyFlowEntry(FlowEntry flowEntry) throws XMLStreamException {

    }

    /**
     * 根据流程xml 转换为 BpmnModel对象
     * @param bpmnXml
     * @return
     * @throws XMLStreamException
     */
    private BpmnModel convertToBpmnModel(String bpmnXml) throws XMLStreamException {
        BpmnXMLConverter converter = new BpmnXMLConverter();
        InputStream in = new ByteArrayInputStream(bpmnXml.getBytes(StandardCharsets.UTF_8));
        @Cleanup XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(in);
        return converter.convertToBpmnModel(reader);
    }

}

