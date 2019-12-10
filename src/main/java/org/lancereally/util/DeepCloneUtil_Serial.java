package org.lancereally.util;

import java.io.*;

public class DeepCloneUtil_Serial {
//工具方法
    public static Object cloneObject(Object object) throws IOException, ClassNotFoundException {
//将对象序列化
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(object);

//将字节反序列化
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Object obj = objectInputStream.readObject();

        return obj;
    }

}
