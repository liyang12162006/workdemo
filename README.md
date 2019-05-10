# Exercise Bank `题库`

## 开发约定
- 版本号
  >定义：x.x.x.x 第四位为bug修复使用，第三位为已有功能升级或小迭代，第一、二为为大版本升级使用；如遇bug修复与开发并行，则在线上版本上修改版本，
  如线上版本1.0.10.0，正在开发版本1.0.11.0，则此时bug修复版本为1.0.10.1(第四位根据已修复bug数量递增)  
  >升级：本项目采用常规maven多模块方式，所有子模块都继承自同一父模块，所以升级版本号需要父子模块保持同步(意味着所有pom都需要升级)，为方便
  升级版本maven提供versions插件方便升级，使用方法：项目根目录下执行命令  
  $mvn versions:set -DnewVersion=1.0.1.0-SNAPSHOT   
  $mvn versions:commit  
- SQL：在项目代码目录/doc下.sql文件中根据队形增加每个版本对应的SQL
- 版本升级日志：每个版本需要记录对应的功能改动及具体功能实现改动点日志在项目代码目录/Changelog.md
- exercisebank/exercisebank-web/src/main/resources下各个环境使用的profile中配置项跟运维发布脚本共同配合发布应用，所以请勿随意修改
  (test prep prodnew)，dev profile目前未使用可以作为本地调试修改使用  
- Mapper XML文件：项目采用maven插件mybatis-generator来反向生成Mapper XML文件和model，每次自动生成会覆盖原来文件；由于自动生成会覆盖
  原文件，所以如果需要手动增加SQL需要在resource/mybatis/manual下增加单独的XML文件，在com.huitongjy.answersheet.dao.manual.mapping下
  增加对应xml的mapper接口
- 线程池：建议使用MDCThreadPoolExecutor，使用此类创建的线程池中线程执行任务时使用的MDC与提交异步任务请求的MDC一致，目前体现为打印日志中
  traceId会保持原请求中的traceId，解决了异步线程日志traceId与原请求不一致的问题
- 事物管理：目前系统为多数据源，所以每个数据源对应有各自的事物管理器，系统默认根据process下包名称来做切面配置对应的事务管理器所以在process包下使用
@Transactional注解配置事物时无需指定此方法具体使用哪个事物管理器，如果在切面不能切到的地方使用@Transactional需要显示指定使用的事务管理器，具体事务管理器的bean名称见spring-mybatis.xml
- 其他相关约定和指引见：[会通教育－技术部 / 系统设计 / 新题库设计](http://172.16.10.43:8090/pages/viewpage.action?pageId=9441418)

## 系统功能设计
- 告警推送：系统发生异常时会推送告警邮件  
    定义：最小告警时间间隔为m,最小重复次数n；在时间m内只会推送一次告警且需要告警重复次数达到n次（包含）
    推送策略配置：支持json格式的策略配置（alert-policy.json文件），示例：
          {
            "module": "CMI",                错误码所属模块
            "errorCode": "CMI0055",         错误码
            "minIntervalTime": "300000",    最小告警时间间隔（单位毫秒）
            "minRepeatNum": "50"            最小重复次数
          }
    策略加载/更新：目前只是在应用重启时加载一次  
    默认策略：如果未配置策略则使用默认策略(m, 1)，即在默认最小告警时间间隔(5分钟)内只推送第一次告警  
    告警开关：每次应用重启都会加载配置文件中推送开关配置(alert.push)并缓存，如果缓存中已经存在配置则以缓存中配置为准不会被覆盖  
    推送人员：追加 alert.mail.to，示例alert.mail.to[1]=xxx@huitongjy.com


- 系统异常记录：目前系统发生的异常都会记录进数据库system_error_log中，方便查看系统异常情况  
- 日志记录
>com.huitongjy.exercisebank.annotation.LogAnnotation 注解作用于方法上，用来控制方法的参数和返回值的日志记录，具体见注释  
>com.huitongjy.common.annotation.LogFieldConfig 注解作用于字段上，用来控制该字段在日志记录时的日志级别，具体见注释

系统会对注解了LogAnnotation的方法请求参数和响应参数做日志记录，具体的日志记录配置根据LogAnnotation配置来决定，其中各个对象会使用json序列化为json字符串记录进日志；对于题目内容，切题内容等大文本字段需要使用LogFieldConfig配置日志级别用于控制在正常日志记录中不予记录这些大文本字段，从而减少无用的日志内容

- Tcc  
TryMethodAop会对@Compensable注解的方法做切面，切面中对方法第一个参数为Table类型的对table的每一行会进行加锁(data_input_type)  
ConfirmMethodAop会对@ConfirmMethod注解的方法做切面，切面中对方法第一个参数为Table类型的对table的每一行会进行解锁(data_input_type)  
CancelMethodAop会对@CancelMethod注解的方法做切面，切面中对方法第一个参数为Table类型的对table的每一行会进行解锁(data_input_type)  
所以，当tcc方法第一个参数为Table类型则必须有对应的confirm和cancel方法且方法上必须注解@ConfirmMethod或@CancelMethod，否则会导致加锁后
数据未解锁；如果tcc方法无需锁数据则可选择省略confirm和cancel方法
## 接口功能设计

## 系统存在问题