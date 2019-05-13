package com.example.workdemo.threadPool.HtYeXiangYangDemo;

import java.util.concurrent.Callable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 知识点数据迁移多线程处理类
 *
 * @author yexiangyang
 * @since 2019-03-11
 */
@Slf4j
@Data
@AllArgsConstructor
public class KnowledgeMigrateCallable implements Callable<FetureResult> {

    /**
     * 教育阶段
     */
    private EducationStageEnum educationStageEnum;
    /**
     * 学科
     */
    private SubjectEnum subjectEnum;

    @Override
    public FetureResult call() throws Exception {
        return null;
    }

//    @Override
//    public FetureResult call() throws Exception {
//        String tip = educationStageEnum.getTitle() + "-" + subjectEnum.getTitle() + "-" + Thread
//            .currentThread().getName();
//        log.info("KnowledgeMigrateCallable----------" + tip + "----------start");
//        FetureResult fetureResult = new FetureResult();
//        fetureResult.setEducationStageEnum(this.educationStageEnum);
//        fetureResult.setSubjectEnum(this.subjectEnum);
//        fetureResult.setType(1);
//        fetureResult.setIsSuccess(false);
//        try {
//            MigrateKnowledgeDataRequest migrateKnowledgeDataRequest = new MigrateKnowledgeDataRequest();
//            migrateKnowledgeDataRequest.setEducationStage(this.educationStageEnum);
//            migrateKnowledgeDataRequest.setSubject(this.subjectEnum);
//            SystemResponse<List<MigrateKnowledgeDataResponse>> response = this.knowledgeService
//                .migrateKnowledgeDataFromMysqlToMongoDB(migrateKnowledgeDataRequest);
//            if (response == null) {
//                fetureResult.setMsg("knowledgeService.migrateKnowledgeDataFromMysqlToMongoDB返回空");
//            } else if (!response.isSuccessful()) {
//                fetureResult
//                    .setMsg(response.getResponseCode() + "-" + response.getResponseMessage());
//            } else {
//                List<MigrateKnowledgeDataResponse> responseData = response.getResponseData();
//                List<KnowledgeInfo> knowledgeInfoList = this
//                    .buildKnowledgeInfoList(responseData, null);
//                if (knowledgeInfoList != null && knowledgeInfoList.size() > 0) {
//                    this.mongoTemplate.insert(knowledgeInfoList, KnowledgeInfo.class);
//                }
//                fetureResult.setIsSuccess(true);
//            }
//        } catch (Exception e) {
//            log.error("KnowledgeMigrateCallable----------" + tip + "----------error:", e);
//            fetureResult.setMsg(e.getMessage());
//        }
//        log.info("KnowledgeMigrateCallable----------" + tip + "----------end");
//        return fetureResult;
//   }

    /**
     * 组装数据
     *
     * @param migrateKnowledgeDataResponseList 源数据
     * @param ids ids
     * @return 目标数据
     */
//    private List<KnowledgeInfo> buildKnowledgeInfoList(
//        List<MigrateKnowledgeDataResponse> migrateKnowledgeDataResponseList, List<Long> ids) {
//        List<KnowledgeInfo> knowledgeInfoList = null;
//        if (migrateKnowledgeDataResponseList != null
//            && migrateKnowledgeDataResponseList.size() > 0) {
//            knowledgeInfoList = new ArrayList<>(migrateKnowledgeDataResponseList.size());
//            for (MigrateKnowledgeDataResponse migrateKnowledgeDataResponse : migrateKnowledgeDataResponseList) {
//                Long id = Long.valueOf(migrateKnowledgeDataResponse.getId());
//                if (ids == null) {
//                    ids = new ArrayList<>();
//                }
//                ids.add(id);
//                KnowledgeInfo knowledgeInfo = new KnowledgeInfo();
//                knowledgeInfo
//                    .setEducateStage(migrateKnowledgeDataResponse.getEducationStage());
//                knowledgeInfo.setSubject(migrateKnowledgeDataResponse.getSubjectCode());
//                knowledgeInfo.setKnowledgeId(id);
//                knowledgeInfo.setOriginalId(id);
//                knowledgeInfo.setOrderIndex(migrateKnowledgeDataResponse.getOrderIndex());
//                knowledgeInfo.setName(migrateKnowledgeDataResponse.getKnowledgeName());
//                knowledgeInfo.setDepth(migrateKnowledgeDataResponse.getDepth().getValue());
//                knowledgeInfo.setLearnOrder(migrateKnowledgeDataResponse.getLearnOrder());
//                knowledgeInfo.setLearnType(KnowledgeLearnTypeEnum.create(migrateKnowledgeDataResponse.getLearnType().getValue()));
//                knowledgeInfo.setStatus(UseStatusEnum.create(migrateKnowledgeDataResponse.getStatus().getValue()));
//                knowledgeInfo.setIsLeaf(migrateKnowledgeDataResponse.getIsLeaf().isYes());
//                knowledgeInfo.setCreateDate(migrateKnowledgeDataResponse.getCreateDate());
//                knowledgeInfo.setModifyDate(migrateKnowledgeDataResponse.getModifyDate());
//                knowledgeInfo.setOperatorId(migrateKnowledgeDataResponse.getOperatorId());
//                knowledgeInfo.setDeleted(migrateKnowledgeDataResponse.getIsDeleted().isYes());
//                //非叶子节点继续查询
//                if (!migrateKnowledgeDataResponse.getIsLeaf().isYes()) {
//                    List<KnowledgeInfo> children = this
//                        .buildKnowledgeInfoList(migrateKnowledgeDataResponse.getChildren(), ids);
//                    knowledgeInfo.setChildren(children);
//                }
//                //第一层设置ids字段,其他层不需要设置
//                if (KnowledgeDepthEnum.ONE.equals(migrateKnowledgeDataResponse.getDepth())) {
//                    Long[] idsArray = new Long[ids.size()];
//                    knowledgeInfo.setIds(ids.toArray(idsArray));
//                    //第一层重置ids,再次循环ids不重复;其他层直接使用第一层ids
//                    ids = null;
//                }
//                knowledgeInfoList.add(knowledgeInfo);
//            }
//        }
//        return knowledgeInfoList;
//    }
}
