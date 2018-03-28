package com.itcast.basic.jdk.util.identityhashmap;

/**
 * Created by treey.qian on 2018/3/22.
 */
public class JDKIdentityHashMapMain {
    public static void main(String[] args) {
        try {
            System.out.println("enter into JDKIdentityHashMapMain");
            JDKIdentityHashMap jdkIdentityHashMap = new JDKIdentityHashMap();
            jdkIdentityHashMap.put("name", "admin");
            jdkIdentityHashMap.put("nickName", "root");
            jdkIdentityHashMap.put("age", "25");
            jdkIdentityHashMap.put("school", "beijing");
            jdkIdentityHashMap.put("sex", "man");
            jdkIdentityHashMap.remove("name");
//            JDKHashSet jdkHashSet=new JDKHashSet();
//            for (int i = 0; i < 32; i++) {
//                Integer code=hash(new String("admin"));
//                System.out.println("code=" + code);
//                jdkHashSet.add(code);
//            }
//            System.out.println("jdkHashSet=" + jdkHashSet);
            System.out.println("jdkIdentityHashMap=" + jdkIdentityHashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int hash(Object s) {
        int h = System.identityHashCode(s);
//        System.out.println("hash code is " + s.hashCode() + " h=" + h);
        return ((h << 1) - (h << 8)) & (32 - 1);
    }


}
