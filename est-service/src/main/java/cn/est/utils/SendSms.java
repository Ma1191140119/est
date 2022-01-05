package cn.est.utils;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.stereotype.Component;

/*
pom.xml
<dependency>
  <groupId>com.aliyun</groupId>
  <artifactId>aliyun-java-sdk-core</artifactId>
  <version>4.5.30</version>
</dependency>
*/
@Component
public class SendSms {


    public boolean sendSms(String  phone, String code, boolean isSend){
        if (!isSend) {
            System.out.println(phone+":"+code);
            return true;
        }
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4Fyah32fK7GjPTsnmPEM", "tnrGHKIsVPYnSqoE9gyfL2DJGlIOOB");
        /** use STS Token
         DefaultProfile profile = DefaultProfile.getProfile(
         "<your-region-id>",           // The region ID
         "<your-access-key-id>",       // The AccessKey ID of the RAM account
         "<your-access-key-secret>",   // The AccessKey Secret of the RAM account
         "<your-sts-token>");          // STS Token
         **/
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "小小商城");
        request.putQueryParameter("TemplateCode", "SMS_179390186");
        request.putQueryParameter("TemplateParam", "{'code':'" +code +"'}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            JSONObject result = JSONObject.parseObject(response.getData());
            String staute = result.getString("Code");
            if ( "OK".equals(staute)) {
                return  true;
            }
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return  false;
    }
}
