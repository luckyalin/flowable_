package com.voicecomm.flowable.entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName FlowEntryDTO
 * @Author yulin.li
 * @Date 2021/12/15 16:34
 * @Description FlowEntryDTO
 */
@Data
@ApiModel("流程信息传输对象")
public class FlowEntryDTO {
    /**
     * 流程名称。
     */
    @TableField(value = "process_definition_name")
    @ApiModelProperty(value = "流程名称")
    private String processDefinitionName;

    /**
     * 流程标识Key。
     */
    @TableField(value = "process_definition_key")
    @ApiModelProperty("流程标识Key")
    private String processDefinitionKey;

    /**
     * 流程分类。
     */
    @TableField(value = "category_id")
    @ApiModelProperty("流程分类")
    private Long categoryId;

    /**
     * 主版本流程Id。
     */
    @TableField(value = "main_version_id")
    @ApiModelProperty("主版本流程id")
    private Long mainVersionId;

    /**
     * 最新发布时间。
     */
    @TableField(value = "lastest_publish_time")
    @ApiModelProperty("最新发布时间")
    private Date lastPublishTime;

    /**
     * 流程状态。
     */
    @TableField(value = "status")
    @ApiModelProperty("流程状态")
    private Integer status;

    /**
     * 流程定义的xml。
     */
    @TableField(value = "bpmn_xml")
    @ApiModelProperty("流程定义的xml")
    private String bpmnXml;

    /**
     * 绑定表单类型。
     */
    @TableField(value = "form_type")
    @ApiModelProperty("绑定表单类型")
    private String formType;

    /**
     * 表单Id。
     */
    @TableField(value = "form_id")
    @ApiModelProperty("表单Id")
    private String formId;

}
