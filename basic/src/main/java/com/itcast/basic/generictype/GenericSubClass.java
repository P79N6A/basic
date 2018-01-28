package com.itcast.basic.generictype;

/**
 * Created by qfl on 16/4/23.
 * 由于泛型擦除当子类继承父类时 子类中会有2个返回值不同(String vs Object)的同名方法(getParameter)
 * 在java中是不允许的(java中不允许存在 仅返回值不同函数签名相同的方法)
 * java会在子类中自动添加一个桥接方法
 * public Object getParameter(){1: invokevirtual #3 // Method getParameter:()Ljava/lang/String;}
 * 调用子类的覆写方法
 */
public class GenericSubClass extends GenericClass<String> {

    public GenericSubClass(String parameter) {
        this.parameter = parameter;
    }

    @Override
    public String getParameter() {
        super.getParameter();
        return "GenericSubClass";
    }

}
/*
 *
 public class com.itcast.basic.generictype.GenericSubClass extends com.itcast.basic.generictype.GenericClass<java.lang.String>
  Signature: #14                          // Lcom/itcast/basic/generictype/GenericClass<Ljava/lang/String;>;
  SourceFile: "GenericSubClass.java"
  minor version: 0
  major version: 51
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #5.#17         //  com/itcast/basic/generictype/GenericClass."<init>":()V
   #2 = String             #18            //  GenericSubClass
   #3 = Methodref          #4.#19         //  com/itcast/basic/generictype/GenericSubClass.getParameter:()Ljava/lang/String;
   #4 = Class              #20            //  com/itcast/basic/generictype/GenericSubClass
   #5 = Class              #21            //  com/itcast/basic/generictype/GenericClass
   #6 = Utf8               <init>
   #7 = Utf8               ()V
   #8 = Utf8               Code
   #9 = Utf8               LineNumberTable
  #10 = Utf8               getParameter
  #11 = Utf8               ()Ljava/lang/String;
  #12 = Utf8               ()Ljava/lang/Object;
  #13 = Utf8               Signature
  #14 = Utf8               Lcom/itcast/basic/generictype/GenericClass<Ljava/lang/String;>;
  #15 = Utf8               SourceFile
  #16 = Utf8               GenericSubClass.java
  #17 = NameAndType        #6:#7          //  "<init>":()V
  #18 = Utf8               GenericSubClass
  #19 = NameAndType        #10:#11        //  getParameter:()Ljava/lang/String;
  #20 = Utf8               com/itcast/basic/generictype/GenericSubClass
  #21 = Utf8               com/itcast/basic/generictype/GenericClass
{
  public com.itcast.basic.generictype.GenericSubClass();
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method com/itcast/basic/generictype/GenericClass."<init>":()V
         4: return
      LineNumberTable:
        line 6: 0

  public java.lang.String getParameter();
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: ldc           #2                  // String GenericSubClass
         2: areturn
      LineNumberTable:
        line 10: 0

  public java.lang.Object getParameter();
    flags: ACC_PUBLIC, ACC_BRIDGE, ACC_SYNTHETIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokevirtual #3                  // Method getParameter:()Ljava/lang/String;
         4: areturn
      LineNumberTable:
        line 6: 0
}

 */