# 结构型设计模式
## 适配器模式
  * 特点:将一个接口转化成客户端希望的另一个接口
  * 关系：适配接口和被适配接口没有层次关系
  * 举例：Java AWT、Java I/O、Spring Web MVC
## 装饰器模式
  * 特点：动态添加或覆盖被包装者的接口行为
  * 关系：装饰者和被装饰者接口有层次关系
  * 举例：JAVA I/O、Spring Core、Spring Web MVC
## 享元模式
  * 特点：共享对象状态，减少重复创建
  * 关系：享元对象缓存共享实体
  * 举例：Integer缓存、String intern()方法，ThreadLocal

## 组合模式

* 特点：执行组合对象时如同执行其元素对象
* 关系：组合对象和被组合对象是相同类型
* 举例：EL、Spring Cache、Spring Web MVC

## 门面模式

* 特点：简化接口，聚合子系统实现
* 关系：门面接口和子系统接口自动组合实现
* 举例：Tomcat、DispatcherServlet