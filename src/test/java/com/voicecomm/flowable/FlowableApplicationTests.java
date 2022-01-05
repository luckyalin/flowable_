package com.voicecomm.flowable;

import org.flowable.engine.*;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.DeploymentBuilder;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.flowable.task.api.history.HistoricTaskInstance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class FlowableApplicationTests {
    /**
     * 流程定义管理业务类
     */
    @Autowired
    private RepositoryService repositoryService;

    /**
     * 任务管理业务类
     */
    @Autowired
    private TaskService taskService;

    /**
     * 流程实例运行业务类 包括启动、推进、删除流程实例操作
     */
    @Autowired
    private RuntimeService runtimeService;

    /**
     * 历史数据业务类
     */
    @Autowired
    private HistoryService historyService;

    /**
     * 组织机构管理业务类
     */
    @Autowired
    private IdentityService identityService;

    /**
     * 流程表单管理业务类
     */
    @Autowired
    private FormService formService;

    /**
     * 动态修改Bpmn流程定义以及部署库等操作
     */
    @Autowired
    private DynamicBpmnService dynamicBpmnService;

    @Test
    void test() {
        String taskId = queryMyTask("b");
//        complete(taskId);
    }

    /**
     * 部署流程文档
     */
    @Test
    void deploy() {
        //方式1 classPathResource
        Deployment deploy = this.repositoryService
                .createDeployment()
                //流程图xml
                .addClasspathResource("qingjia.bpmn20.xml")
                .category("分类1")
                .name("请假流程")
                .deploy();

        //方式2
        System.out.println("流程部署id:" + deploy.getId());
    }

    /**
     * 启动流程实例
     */
    @Test
    String start(String proDefKey) {
        //方式1
        ProcessInstance processInstance = this.runtimeService.startProcessInstanceByKey(proDefKey);
        System.out.println("流程实例id:" + processInstance.getProcessInstanceId());
        return processInstance.getProcessInstanceId();
    }

    /**
     * 查询当前待办任务
     */
    @Test
    String queryMyTask(String assignee) {
        //获取当前用户所有待办任务 对应act_ru_task表
        Task task = this.taskService.createTaskQuery().taskAssignee(assignee).singleResult();
        return task.getId();
    }

    /**
     * 处理任务（审批）
     */
    @Test
    void complete(String taskId) {
        this.taskService.complete(taskId);
    }

    /**
     * 查询已办任务
     */
    @Test
    void history() {
        List<HistoricTaskInstance> tasks = this.historyService
                .createHistoricTaskInstanceQuery()
                .finished()
                .taskAssignee("a").list();
        tasks.forEach(t -> {
            System.out.println("任务id:" + t.getId() + "    任务名称:" + t.getName());
        });
    }
}
