package com.voicecomm.flowable.entity.dto;

import lombok.Data;

import java.util.List;

/**
 * @ClassName TaskElementsDTO
 * @Author yulin.li
 * @Date 2021/12/17 9:42
 * @Description TaskElementsDTO
 */
@Data
public class TaskElementsDTO {
    private List<String> type;
    private List<String> value;
    private List<String> condition;
    private List<String> operationType;
    private List<String> sort;

}
