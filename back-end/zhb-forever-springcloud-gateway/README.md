
router:路由，是网关的基础模块，由一个ID,一个目标uri，以及一组断言和过滤器定义。

predicates：断言，对HTTP请求的任何内容进行匹配。

filters：过滤器，用它来修改请求和响应。

例如：

spring： 
  cloud: 
    gateway: 
      routes:
        - id: e-frame-upm
          uri: e-frame-upm #lb表示从注册中心获取服务http://localhost:8080
	  predicates:
	    - Path=/upm/**
	  filters:
	    - StripPrefix=1  #去除原请求地址中的upm

如果前端请求路径为：localhost:8080/upm/user/auther
则，匹配到这个路由了，过滤后路径为：localhost:8080/user/auther
StripPrefix过滤器是去掉一个路径。