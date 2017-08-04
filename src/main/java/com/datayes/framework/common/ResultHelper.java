/*
 * *
 *  * 通联数据机密
 *  * --------------------------------------------------------------------
 *  * 通联数据股份公司版权所有 © 2013-1016
 *  *
 *  * 注意：本文所载所有信息均属于通联数据股份公司资产。本文所包含的知识和技术概念均属于
 *  * 通联数据产权，并可能由中国、美国和其他国家专利或申请中的专利所覆盖，并受商业秘密或
 *  * 版权法保护。
 *  * 除非事先获得通联数据股份公司书面许可，严禁传播文中信息或复制本材料。
 *  *
 *  * DataYes CONFIDENTIAL
 *  * --------------------------------------------------------------------
 *  * Copyright © 2013-2016 DataYes, All Rights Reserved.
 *  *
 *  * NOTICE:  All information contained herein is the property of DataYes
 *  * Incorporated. The intellectual and technical concepts contained herein are
 *  * proprietary to DataYes Incorporated, and may be covered by China, U.S. and
 *  * Other Countries Patents, patents in process, and are protected by trade
 *  * secret or copyright law.
 *  * Dissemination of this information or reproduction of this material is
 *  * strictly forbidden unless prior written permission is obtained from DataYes.
 *
 *
 * * Copyright © 2013-2016 DataYes, All Rights Reserved.
 *
 *
 */

package com.datayes.framework.common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Random;

public class ResultHelper {


    public static Result dataToResult(Object data) {
        if (data == null) {
            return new Result(ResultCode.NO_DATA_ERROR.getCode(),
                ResultCode.NO_DATA_ERROR.getMessage());
        } else if (data instanceof Collection) {
            @SuppressWarnings("rawtypes") Collection col = (Collection) data;
            if (col.size() == 0) {
                return new Result(ResultCode.NO_DATA_ERROR.getCode(),
                    ResultCode.NO_DATA_ERROR.getMessage());
            }
        }

//        processData(data);
        Result result = new Result();
        result.setData(data);
        return result;
    }

    private static void processData(Object data) {
        if(data instanceof Collection) {
            Collection col = (Collection) data;
            for(Object obj : col)
                processData(obj);
        }
        for (Field f : data.getClass().getDeclaredFields()) {   //遍历通过反射获取object的类中的属性名
            String fieldName = f.getName();
            Class tCls = data.getClass();
            String getMethodName =
                "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            try {
                Method getMethod = tCls.getMethod(getMethodName);
                Object value = getMethod.invoke(data);
                if(value instanceof Double) {
                    Double randomVal = new Random(122).nextDouble();
                    String setMethodName =
                        "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    Method setMethod = tCls.getMethod(setMethodName, randomVal.getClass());
                    setMethod.invoke(data, randomVal);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }



        }

    }

}
