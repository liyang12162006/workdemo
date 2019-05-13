package com.example.workdemo.threadPool.HtYeXiangYangDemo;

import java.io.Serializable;
import lombok.Data;

/**
 * 数据迁移多线程处理返回结果类
 *
 * @author yexiangyang
 * @since 2019-02-28
 */
@Data
public class FetureResult implements Serializable {

    private static final long serialVersionUID = -244501207504315128L;
    /**
     * 教育阶段
     */
    private EducationStageEnum educationStageEnum;
    /**
     * 学科
     */
    private SubjectEnum subjectEnum;
    /**
     * 类型:1:知识点;2:题型
     */
    private Integer type;
    /**
     * 是否成功
     */
    private Boolean isSuccess;
    /**
     * 失败原因
     */
    private String msg;
}
