package com.qbwl.bkglpt02.commonenum;


public enum E_EXCEPTION {

    /**
     * 旧密码错误
     */
    OLD_PW_ERROR("旧密码错误",1),
    /**
     * 访问路径不存在
     */
    PATH_ERROR("访问路径不存在",9),
    /**
     * access_token验证失败
     */
    TOKEN_LOSE("access_token验证失败",10),
    /**
     * 已存在有效的accsdd_token
     */
    TOKEN_EXIT("已存在有效的accsdd_token",11),
    /**
     * 请求刷新access_token时验证失败
     */
    TOKEN_OUTMODED("请求刷新access_token时验证失败",12),

    /**
     * 参数格式异常
     */
    PARAM_FORMAT("参数格式异常",28),
    /**
     * 缺少参数
     */
    NO_PARAM("缺少参数",13),
    /**
     * 请求类型错误
     */
    TYPE_ERROR("请求类型错误",14),
    /**
     * 您没有权限执行此操作
     */
    NO_RANK("您没有权限执行此操作",15),
    /**
     * 保存数据失败
     */
    INSERT_FAIL("保存数据失败",16),
    /**
     * 更新数据失败
     */
    UPDATE_FAILE("更新数据失败",17),
    /**
     * 删除数据失败
     */
    DELET_FAIL("删除数据失败",18),
    /**
     * 未查询到有效的数据
     */
    NO_RESULT("未查询到有效的数据",19),
    /**
     * 事务处理中
     */
    PROJECT_TRANSACTION_PROCESSING("事务处理中",20),
    /**
     * 字典数据不存在
     */
    PROJECT_DICTIONARY_DATA_DOES_NOT_EXIST("字典数据不存在",21),
    /**
     * 字典项数据不存在
     */
    PROJECT_DICTIONARY_ENTRY_DATA_DOES_NOT_EXIST("字典项数据不存在",22),
    /**
     * 无效的字典编号
     */
    PROJECT_INVALID_DICTIONARY_NUMBER("无效的字典编号",23),
    /**
     * 查询数据错误
     */
    QUERY_DATA_ERROR("查询数据错误",24),
    /**
     * 上传文件不存在
     */
    NO_FILE("上传文件不存在",25),
    /**
     * 添加数据已经存在
     */
    DATA_EXIT("添加数据已经存在",26),
    /**
     * 管理员用户不能删除
     */
    PROJECT_THE_ADMINISTRATOR_USER_CANNOT_DELETE("管理员用户不能删除",27),
    /**
     * 不是有效的IP
     */
    PROJECT_NOT_VALID_IP("不是有效的IP",50),
    /**
     * 用户已存在(已注册)
     */
    USER_CONFIG("用户已存在(已注册)",201),
    /**
     * 用户密码不匹配
     */
    PW_NOMATCH("用户密码不匹配",202),
    /**
     * 用户状态异常(关闭)
     */
    STATUS_ERR("用户状态异常(关闭)",203),
    /**
     * 用户不存在
     */
    USER_NOT_FOUND("用户不存在",204),
    /**
     * 短信验证码错误
     */
    SMS_VERIFICATION_CODE_ERROR("短信验证码错误",205),
    /**
     * 短信验证码失效
     */
    SMS_VERIFICATION_CODE_INVALID("短信验证码失效",206),
    /**
     * 注册失败(数据库错误)
     */
    REGISTRATION_FAILED_DATABASE_ERROR("注册失败(数据库错误)",207),
    /**
     * 更新信息失败,登陆失败
     */
    UPDATE_FAILED_LOGIN_FAILED("更新信息失败,登陆失败",208),
    /**
     * 公司不存在或者状态异常
     */
    PROJECT_COMPANY_DOESNOT_EXIST("公司不存在或者状态异常",209),
    /**
     * 公司状态异常不允许修改信息
     */
    PROJECT_COMPANY_STATUS_EXCEPTION_DOESNOT_ALLOW_MODIFICATION("公司状态异常不允许修改信息",210),
    /**
     * 已经通过实名认证
     */
    PROJECT_VERIFIED_BY_REAL_NAME("已经通过实名认证",211),
    /**
     * 实名认证正在审核中
     */
    PROJECT_REALNAME_AUTHENTICATION("实名认证正在审核中",212),
    /**
     * 管理者旗下已经有公司
     */
    PROJECT_MANAGERS_HAVE_COMPANY("管理者旗下已经有公司",213),
    /**
     * 类型错误
     */
    PROJECT_TYPE_ERROR("类型错误",214),
    /**
     * 申请表不存在
     */
    PROJECT_APPLICATION_DOESNOT_EXIST("申请表不存在",215),
    /**
     * 认证状态异常
     */
    PROJECT_ABNORMAL_AUTHENTICATION_STATUS("认证状态异常",216),
    /**
     * 无数据
     */
    PROJECT_NO_DATA("无数据",217),
    /**
     * ID不存在
     */
    PROJECT_ID_NOT_EXIST("ID不存在",218),
    /**
     * 验证码错误
     */
    PROJECT_VCODE_ERROR("验证码错误",219),
    /**
     * 传来的数据有错误
     */
    RPOJECT_ERROR_INCOMING_DATA("传来的数据有错误",220),
    /**
     * 旧密码输入有错误
     */
    RPOJECT_OLD_PASSWORD_ENTERED_INCORRECTLY("旧密码输入有错误",221),
    /**
     * 暂无企业
     */
    PROJECT_NO_ENTERPRISE("暂无企业",222),
    /**
     * 生成编码失败
     */
    PROJECT_GENERATION_CODE_FAILED("生成编码失败",223),
    /**
     * 审核已通过
     */
    RROJECT_APPROVED_AUDIT("审核已通过",224),
    PROJECT_ADD_BASIC_INFOMATION_OPERATION("请添加基本信息后操作",225),
    /**
     * 用户名和手机号不匹配
     */
    PROJECT_USERNAME_DOESNOT_MATCH_THE_PHONE_NUMBER("用户名和手机号不匹配",226),
    /**
     * 正在审核
     */
    PROJECT_IN_VERFICATION("正在审核",227),
    /**
     * 信息重复提交
     */
    PROJECT_REPEATED_SUBMISSION_INFORMATION("信息重复提交",228),
    /**
     * 门店只有状态在未审核状态才能删除
     */
    PROJECT_UNAUDITED_STATUS_CAN_ONLY_DELETED("门店只有状态在未审核状态才能删除",229),
    /**
     * 手机号已注册
     */
    PROJECT_PHONE_NUMBER_REGISTERED("手机号已注册",230),
    /**
     * 添加失败(数据库错误)
     */
    PROJECT_ADD_FAILED_DATABASE_ERROR("添加失败(数据库错误)",231),
    /**
     * 修改失败(数据库错误)
     */
    PROJECT_MODIFICATION_FAILED_DATABASE_ERROR("修改失败(数据库错误)",232),
    /**
     * 删除失败(数据库错误)
     */
    PROJECT_DELETED_FAILED_DATABASE_ERROR("删除失败(数据库错误)",233),
    /**
     * 禁止重复添加门店
     */
    PROJECT_DONOT_ADD_STORES_REPEATEDLT("禁止重复添加门店",234),
    /**
     * 请先添加门店
     */
    PROJECT_ADD_STORE_FIRST("请先添加门店",235),
    /**
     * 门店已注销
     */
    PROJECT_STORE_CANCELLED("门店已注销",236),
    PROJECT_DONOT_MATCH_TWICE("两次密码不一致",237),
    PROJECT_OBLIGATION("待付款",300),
    PROJECT_PAYMENT_FAILURE("支付失败",301),
    /**
     * 状态有误,无法修改
     */
    PROJECT_STATUS_INCORRECT_CANNOT_MODIFIED("状态有误,无法修改",302),
    /**
     * 手机号不存在
     */
    PHONE_NO_EXIT("手机号不存在",304),
    /**
     * 无效的管辖机构代码
     */
    AGENCY_INVALID("无效的管辖机构代码",305),
    PROJECT_USERNAME_PASSWORD_CANNOT_INCLUDE_CHINESE("用户名或密码不能包括中文",306),
    /**
     * 企业名称已存在
     */
    PROJECT_BUSINESSNAME_EXISTS("企业名称已存在",307),
    PROJECT_MUCH_DATA_FILTER_QUERY("数据量过大,请过滤查询",308);




    ;





    private String message;
    private int code;


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    E_EXCEPTION(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public static String getErrorMsg(int code) {
        for (E_EXCEPTION e : E_EXCEPTION.values()) {
            if (e.getCode() == code) {
                return e.message;
            }
        }
        return null;
    }
}
