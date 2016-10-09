# crm  #
-------------

## 这是一个学习阶段用SSH框架编写的一个客户管理平台 ##
## 一、Struts2的运行环境的测试 ##
	
		1.导入struts的jar包
		2.导入配置文件,和日志配置文件
		3.编写测试的TestAction
		4.配置struts.xml，配置TestAction
		5.编写测试的jsp
		6.启动项目，测试struts2运行环境
## 二、测试Srping的运行环境 ##
	
	1.导入Spring的jar包
	2.导入applicationContext.xml配置文件
	3.创建TestServiceImpl和TestDaoImpl类及其接口，并编写一个测试类TestDemo
	4.测试Spring的IOC功能
	5.编写一个Aop类，测试Spring的AOP功能
## 三、Spring整合Struts2框架 ##
	
		1.将Action对象交给Spring框架创建
			注意：1.Action在Spring的配置文件配置时，一定要配置成多例
				2.在Struts2的配置文件中，Action的配置的class改为在applicationContext中的id值
				3.在使用Spring的IOC的注解方式时，一定要在applicationContext中开启注解扫描<context:component-scan base-package="com.itcast.test" />
		2.在web.xml文件中加入Spring的一个监听器，监听ServletContext的创建，这样在项目启动时，Spring会创建
		一个xmlWebApplicationContext类作为IOC容器来读取我们配置的applicationContext.xml文件并将IOC
		容器放到ServletContext中
## 四.Hibernate框架环境测试 ##
	
		1.导入heibernate的jar包
		2.导入hibernate的核心配置文件
		3.编写一个持久类（javaBean+映射文件）
		4.在TestDemo中编写一个测试hibernate的测试方法，创建一个user对象，调用service的方法保存对象
## 五、Spring整合hibernate框架 ##
	
		1.将sessionFactory交给Spring框架创建
			1.将hibernate文件中的c3p0连接池交给Spring框架创建
			2.创建LocalSessionFactoryBean来创建sessiongFactory这个对象
		2.将事务交给Spring管理
			1.创建事务管理器
			2.开启事务注解扫描，在service层添加事务注解
		3.注意事项：
			1.在dao层要利用HibernateTemplate来和数据库交互，所以要获取到HibernateTemplate
			我们为了操作方便，需要dao层继承HibernateDaoSupport，这样我们在创建dao对象时，直接向它
			注入sessionFactory即可
## 六、注意： ##
	
		1.导入UI界面后会报错，是因为缺少jstl标签的jar包
			1.导入jstl标签的jar包
		2.做一个添加客户界面跳转的测试
		3.做添加一个客户的测试
		4.关于懒加载问题的解决
			1.no session问题出现的原因
				我们的session是在service层创建的，并且事务提交实在service层提交的，当事务调教后，session就已经
				关闭，如果我们使用的是懒加载，那么我们在web层获取对象的其他属性时，才会去数据库查询，这时session已经
				关闭了，不能查询了。
			2.解决思路：
				将session的创建和事务提交提前到web层，这样在web层使用懒加载的时候，session就可以获取到。
			3.步骤：在web.xml文件中配置一个过滤器就可以了，注意
				过滤器一定要配置在Struts2的核心过滤器之前
				<filter>
					<filter-name>OpenSessionInViewFilter</filter-name>
					<filter-class>org.springframework.orm.hibernate5.support.OpenSessionInViewFilter</filter-class>
				</filter>
				<filter-mapping>
					<filter-name>OpenSessionInViewFilter</filter-name>
					<url-pattern>/*</url-pattern>
				</filter-mapping>
	
