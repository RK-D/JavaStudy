# 反编译java
* mac linux 直接 javac 目标文件(.java)---> (.class) 编译
* windows需指定utf8编码(具体代码编码为准) javac  -encoding utf-8 目标文件
* 反汇编 javap -verbose 目标文件
## 本次测试用例反汇编如下
````$xslt
    Classfile /E:/Github/RK-D/JavaStudy/src/synchronizedtest/decompile/DecompileTest.class
      Last modified 2020-7-1; size 502 bytes
      MD5 checksum 23927a27709334dxxxxxxxxxxxxxxxx3
      Compiled from "DecompileTest.java"
    public class synchronizedtest.decompile.DecompileTest
      minor version: 0
      major version: 52
      flags: ACC_PUBLIC, ACC_SUPER
    Constant pool:
       #1 = Methodref          #2.#20         // java/lang/Object."<init>":()V
       #2 = Class              #21            // java/lang/Object
       #3 = Fieldref           #4.#22         // synchronizedtest/decompile/DecompileTest.object:Ljava/la
    ng/Object;
       #4 = Class              #23            // synchronizedtest/decompile/DecompileTest
       #5 = Utf8               object
       #6 = Utf8               Ljava/lang/Object;
       #7 = Utf8               <init>
       #8 = Utf8               ()V
       #9 = Utf8               Code
      #10 = Utf8               LineNumberTable
      #11 = Utf8               method
      #12 = Utf8               (Ljava/lang/Thread;)V
      #13 = Utf8               StackMapTable
      #14 = Class              #23            // synchronizedtest/decompile/DecompileTest
      #15 = Class              #24            // java/lang/Thread
      #16 = Class              #21            // java/lang/Object
      #17 = Class              #25            // java/lang/Throwable
      #18 = Utf8               SourceFile
      #19 = Utf8               DecompileTest.java
      #20 = NameAndType        #7:#8          // "<init>":()V
      #21 = Utf8               java/lang/Object
      #22 = NameAndType        #5:#6          // object:Ljava/lang/Object;
      #23 = Utf8               synchronizedtest/decompile/DecompileTest
      #24 = Utf8               java/lang/Thread
      #25 = Utf8               java/lang/Throwable
    {
      public synchronizedtest.decompile.DecompileTest();
        descriptor: ()V
        flags: ACC_PUBLIC
        Code:
          stack=3, locals=1, args_size=1
             0: aload_0
             1: invokespecial #1                  // Method java/lang/Object."<init>":()V
             4: aload_0
             5: new           #2                  // class java/lang/Object
             8: dup
             9: invokespecial #1                  // Method java/lang/Object."<init>":()V
            12: putfield      #3                  // Field object:Ljava/lang/Object;
            15: return
          LineNumberTable:
            line 8: 0
            line 9: 4
    
      public void method(java.lang.Thread);
        descriptor: (Ljava/lang/Thread;)V
        flags: ACC_PUBLIC
        Code:
          stack=2, locals=4, args_size=2
             0: aload_0
             1: getfield      #3                  // Field object:Ljava/lang/Object;
             4: dup
             5: astore_2
             6: monitorenter       //一个进入 获得monitor锁
             7: aload_2
             8: monitorexit        //多个输出 monitor锁
             9: goto          17
            12: astore_3
            13: aload_2
            14: monitorexit
            15: aload_3
            16: athrow
            17: return
          Exception table:
             from    to  target type
                 7     9    12   any
                12    15    12   any
          LineNumberTable:
            line 13: 0
            line 15: 7
            line 16: 17
          StackMapTable: number_of_entries = 2
            frame_type = 255 /* full_frame */
              offset_delta = 12
              locals = [ class synchronizedtest/decompile/DecompileTest, class java/lang/Thread, class ja
    va/lang/Object ]
              stack = [ class java/lang/Throwable ]
            frame_type = 250 /* chop */
              offset_delta = 4
    }
    SourceFile: "DecompileTest.java"
````