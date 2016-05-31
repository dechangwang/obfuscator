#### obfuscate笔记

+ 在Main中调用comp.Compole() 在JavaCompiler.java文件中的923line中的方法
+ readSource() line 656 打开文件读取 在该方法被调用后 在一个content （其实从debug 右端的窗口中可以看出这是HeapCharBufffer类型） 中可以看到.java文件中的所有内容
+ in parse() at line 692,在这一行执行后tree将得到.java中的内容，此时得到的内容中不包含注释掉的内容（该方法是在parse方法中 line 737调用）
+ parseFiles() 该方法中在for loop 获取要编译的所有.java文件中的内容，将.java中的内容保存在trees中（该方法是在compile() at line 946 call
+ 在desugar（）中添加obfuscate code时，该方法其实是在 line 949 中的delegateCompiler.compile2()中调用到的
	+ ##### 大致调用步骤是
	+ 进入compile2()
	+ at line 989 in compile2() call desugar(para) this function at line 1449
	+ then in desugar(envs) calls desugar in a for loop (now will reach to where add obfuscate coding)

##### after obfuscating code 
+ at line 1569```JCTree untranslated = env.tree``` 查看untranslated中的值，此时的sym为ClassSymbol进一步展开sym 有members_field参数，会发现class中所有的属性以及方法均在这里（也就是说 class中对于属性和方法都当作成员处理

*在执行完自定义的混淆代码语句后 从逐步执行的结果来看 desugar方法是编译时期最后执行的（只针对单个class）*