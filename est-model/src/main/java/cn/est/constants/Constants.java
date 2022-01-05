package cn.est.constants;

import java.math.BigDecimal;

/***
 * 系统中保存的一些常量
 */
public class Constants {
    //通用常量
    public static class Common{
        //否
        public final static Integer NOT = 0;
        //是
        public final static Integer YES = 1;
        //女
        public final static Integer SEX_WOMEN = 0;
        //男
        public final static Integer SEX_MAN = 1;
        //数据精度
        public final static Integer DECIMAL_DIGITS = 2;
    }
    //访问来源
    public static class SourceType{
        //访问来源-APP
        public final static Integer APP = 0;
        //访问来源-PC
        public final static Integer PC = 1;
    }
    //首页展示商品数量
    public static class Home{
        public final  static Integer MODEL_SIZE = 5;
    }
    //短信相关常量
    public static class Sms{
        public static class SmsType{
            //注册或登录类型验证码
            public final static Integer REGIST_OR_LOGIN = 0;
            //修改密码类型验证码
            public final static Integer UP_PASS = 1;
            //通知类型验证码
            public final static Integer NOTICE = 2;
            //短信下单类型验证码
            public final static Integer SUBMIT_CHECK = 3;
        }
        //短信模板
        public static class SmsTemplateCode{
            //注册或登录类型验证码
            public final static String REGIST_OR_LOGIN = "SMS_197895260";
            //修改密码类型验证码
            public final static String UP_PASS = "SMS_197895260";
            //通知类型验证码
            public final static String NOTICE = "SMS_197895260";
            //短信下单类型验证码
            public final static String SUBMIT_CHECK = "SMS_197895260";
        }
        //状态（1:成功2:失败）
        public static class SmsStatus{
            //成功
            public final static Integer SUCCESS = 1;
            //失败
            public final static Integer FAILURE = 2;
        }
    }
    //Redis key的常量
    public static class RedisKey{
        //公共前缀
        public final static String PREFIX = "est";
        //短信前缀
        public final static String PREFIX_SMS = PREFIX+Connnector.COLON+"sms";
        //Token前缀
        public final static String PREFIX_TOKEN = PREFIX+Connnector.COLON+"token";
        //首页缓存前缀
        public final static String KEY_HOME_TREE = PREFIX +Connnector.COLON+"homeClassifyTree";
    }
    //连接符
    public static class Connnector{
        //逗号
        public final static String COMMA_ = ",";
        //下划线
        public final static String UNDERLINE = "_";
        //冒号
        public final static String COLON=":";
    }
    //时长
    public static class Duration{
        //一秒
        public final static Integer SECOND_INT = 1;
        //一分钟
        public final static Integer MINUTE_INT = SECOND_INT * 60;
        //半小时
        public final static Integer HALF_HOUR_INT = MINUTE_INT * 30;
    }
    //商品型号
    public static class ModelStatus{
        //上架
        public final static Integer SALE = 1;
        //下架
        public final static Integer SOLD_OUT = 2;
    }
    //维修类型
    public static class ProcessType{
        //维修
        public final static Integer MAINTAIN = 1;
        //更换零件
        public final static Integer REPLACEMENT_PART = 2;
    }
    //订单相关常量
    public static class Order{
        //预约相关状态
        public static class AppointStatus {
            //已预约
            public final static Integer APPOINT = 1;
            //已完成
            public final static Integer FINISH = 2;
        }
        //预约时间段
        public static class TemporalInterval {
            //上午
            public final static Integer AM = 1;
            //中午
            public final static Integer NOON = 2;
            //下午
            public final static Integer PM = 3;
            //晚上
            public final static Integer NIGHT = 4;
        }
        //支付渠道
        public static class Channel {
            //现金
            public final static Integer CASH = 1;
            //刷卡
            public final static Integer CARD = 2;
            //支付宝
            public final static Integer ALIPAY = 3;
            //微信
            public final static Integer WECHAT = 4;
        }

        //定金常量
        public static class Subscription {
            //最低支付金额
            public final static Double MINIMUM_DECIMAL = new Double(30);
            //支付比例
            public final static Double RATIO = 0.1D;
        }
        //订单状态
        public static class MaintainStatus {
            //已预约下单
            public final static Integer APPOINT = 1;
            //已支付定金
            public final static Integer PAY_DEPOSIT = 2;
            //用户已取消
            public final static Integer CANCLE = 3;
            //订单已完成
            public final static Integer FINISH = 4;
        }

        //支付状态
        public static class PayStaus {
            //未支付
            public final static Integer UN_PAY = 1;
            //支付成功
            public final static Integer SUCCESS = 2;
            //支付失败
            public final static Integer FAIL = 3;
        }
    }

    //正则的一些常量
    public static class RegConstant{
        //手机号正则
        public static String PHONE_REGSTR = "^[1][0-9]{10}$";
        //密码正则
        public static String PASSWORD_REGSTR = "^([A-Z]|[a-z]|[0-9]|[_]){6,10}$";
    }

    //Oss目录
    public static class OssDir{
        //商品目录
        public static String MODEL_DIR="model/";
        //用户目录
        public static String USER_DIR="user/";
    }
}
