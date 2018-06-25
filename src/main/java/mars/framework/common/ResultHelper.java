package mars.framework.common;

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
