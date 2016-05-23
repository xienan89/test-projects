import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/9/26.
 */
public class ReflectTest1 {

    @Test
    public void printGenericType(){
        Class clazz1 = new ArrayList<Integer>().getClass();
        Class clazz2 = new String[0].getClass();
        Class clazz3 = String.class;
        Class clazz4 = Object.class;
        Class clazz5 = new IntList().getClass();

        System.out.println(clazz1.getGenericSuperclass());
        System.out.println(clazz2.getGenericSuperclass());
        System.out.println(clazz3.getGenericSuperclass());
        System.out.println(clazz4.getGenericSuperclass());
        System.out.println(clazz5.getGenericSuperclass());
    }

    @Test
    public void getGenericType(){
        Class clazz1 = new ArrayList<Integer[]>().getClass();
        Type type = clazz1.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) type;
        System.out.println(parameterizedType);
        System.out.println(parameterizedType.getActualTypeArguments()[0].getClass());

        Class clazz2 = new IntList().getClass();
        Type type2 = clazz2.getGenericSuperclass();
        ParameterizedType parameterizedType2 = (ParameterizedType) type2;
        System.out.println(parameterizedType2);
        System.out.println(parameterizedType2.getActualTypeArguments()[0].getClass());
    }

    @Test
    public void getTypeParameters(){
        Class clazz1 = new ArrayList<Integer>().getClass();
        Class clazz2 = new String[0].getClass();
        Class clazz3 = String.class;
        Class clazz4 = Object.class;

        TypeVariable<Class>[] typeVariables = clazz1.getTypeParameters();
        for (int i = 0; i < typeVariables.length; i++) {
            System.out.println("type" + i + ":" + typeVariables[i].getBounds()[0]);
        }
    }
}
