package com.example.workdemo.threadPool.HtYeXiangYangDemo;

import org.springframework.web.bind.annotation.RestController;

/**
 * @author : liyangyang
 * @date 2019-05-13 19:56
 */
@RestController
public class workController {


//    public APIResponse migrate() {
//        //1.初始化线程池
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(78, 78, 0,
//            TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(),
//            new ThreadFactoryBuilder().setNameFormat("migrate-pool-%d").build());
//        List<Future> futureList = new ArrayList<>();
//        EducationStageEnum[] educationStageEnums = EducationStageEnum.values();
//        SubjectEnum[] subjectEnums = SubjectEnum.values();
//        for (int i = 0; i < educationStageEnums.length; i++) {
//            for (int j = 0; j < subjectEnums.length; j++) {
//                EducationStageEnum educationStageEnum = educationStageEnums[i];
//                SubjectEnum subjectEnum = subjectEnums[j];
//                KnowledgeMigrateCallable knowledgeMigrateCallable = new KnowledgeMigrateCallable(
//                    educationStageEnum, subjectEnum, this.knowledgeService, this.mongoTemplate);
//                //2.知识点任务入线程池
//                Future knowledgeFuture = threadPoolExecutor.submit(knowledgeMigrateCallable);
//                futureList.add(knowledgeFuture);
//                //3.题型任务入线程池
//                ExerciseTypeMigrateCallable exerciseTypeMigrateRunnable = new ExerciseTypeMigrateCallable(
//                    educationStageEnum, subjectEnum, this.exerciseTypeService, this.mongoTemplate);
//                Future exerciseTypeFuture = threadPoolExecutor.submit(exerciseTypeMigrateRunnable);
//                futureList.add(exerciseTypeFuture);
//            }
//        }
//        //4.获取结果
//        List<FetureResult> fetureResultList = new ArrayList<>(futureList.size());
//        while (futureList.size() > 0) {
//            Iterator<Future> knowledgeIterator = futureList.iterator();
//            while (knowledgeIterator.hasNext()) {
//                Future future = knowledgeIterator.next();
//                if (future.isDone()) {
//                    try {
//                        FetureResult fetureResult = (FetureResult) future.get();
//                        fetureResultList.add(fetureResult);
//                        knowledgeIterator.remove();
//                    } catch (Exception e) {
//                        log.error("future.get异常:", e);
//                    }
//                }
//            }
//        }
//        //5.关闭线程池
//        threadPoolExecutor.shutdown();
//        return APIResponse.build(APIStatusEnum.SUCCESS).setData(fetureResultList);
//    }
}
