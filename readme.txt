基于开源版简表修改

整合正式为了展示报表和打印,编辑的话还是使用原来的jor.bin即可.

开发环境使用Java1.8,加入Maven,Velocity模板引擎,并按Spring boot规范做了代码目录调整.
对于公共类放到pom.xml里面了,一些早期的lib还是保留了下来,使用addjars-maven-plugin统一打包到jar里面了.
具体使用参考jor-sample.
