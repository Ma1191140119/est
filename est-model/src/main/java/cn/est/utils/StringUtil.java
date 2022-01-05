package cn.est.utils;
import cn.est.constants.Constants;
import org.apache.commons.lang3.StringUtils;
import java.util.*;

/**
 * @Description 关于集合处理的一些工具类
 * @Date 2019-08-16 16:42
 * @Author est team
 * Version 1.0
 **/
public class StringUtil {
    /**
     * 根据传入的字符串和切割方式返回一个Long的集合
     * @param s
     * @param cut
     * @return
     */
    public static Set<Long> string2LongSet(String s, String cut) {
        if(StringUtil.isBlank(s) ){
            return null;
        }
        if(StringUtil.isBlank(cut)){
            cut = Constants.Connnector.COMMA_;
        }
        String s_temp = s.trim();
        String[] arr = s_temp.split(cut);
        Set<Long> list = new HashSet<Long>();
        if(arr==null || arr.length<=0){
            return null;
        }
        for(String l : arr){
            if(!StringUtil.isBlank(l)){
                try {
                    list.add(Long.parseLong(l));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    continue;
                }
            }
        }
        return list;
    }
    /**
     * 根据传入的字符串和切割方式返回一个object的集合
     * @param s
     * @param cut
     * @return
     * @author: liujx
     * @date: 2016年5月10日 下午3:36:30
     */
    public static List<String> string2StringList(String s,String cut) {
        if(StringUtil.isBlank(s)){
            return null;
        }
        if(StringUtil.isBlank(cut)){
            cut = Constants.Connnector.COMMA_;
        }
        String s_temp = s.trim();
        String[] arr = s_temp.split(cut);
        List<String> list = new ArrayList<String>();
        if(arr==null || arr.length<=0){
            return null;
        }
        for(String l : arr){
            if(!StringUtil.isBlank(l)){
                list.add(l);
            }
        }
        return list;
    }
    /**
     * 根据出入的参数创建一个key
     * @return 如果参数为空，那么返回null
     */
    public static String formatKeys(String ... args){
        if (args != null && args.length > 0){
            StringBuilder key = new StringBuilder();
            for (String s: args){
                key.append(s).append(Constants.Connnector.UNDERLINE);
            }
            return key.toString();
        }
        return null;
    }

    /**
     * 根据出入的参数创建一个Redis key，自动拼接前缀
     * @return 如果参数为空，那么返回null
     */
    public static String formatKeyWithPrefix(String ... args){
        if (args != null && args.length > 0){
            StringBuffer key=new StringBuffer("");
            for (String s: args){
                key.append(s).append(Constants.Connnector.COLON);
            }
            return key.toString();
        }
        return null;
    }

    /**
     * Description: 创建一个简单的map对象
     * @param key
     * @param value
     * @return
     * @Author est team
     * @since 2017年5月24日 下午1:18:09
     */
    public static Map<String,Object> createSimpleMap(String key, Object value){
        Map<String,Object> conditions = null;
        if(key !=null && !key.equals("")){
            conditions = new HashMap<String,Object>();
            conditions.put(key, value);
        }
        return conditions;
    }
    /***
     * 判断字符串是否为空
     * @param temp
     * @return
     */
    public static boolean isBlank(String temp){
        return StringUtils.isBlank(temp);
    }

    /**
     * 返回一个没有中划线的32位字符串
     * @return
     */
    public static String createToken(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
