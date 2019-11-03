
springboot

@SpringBootApplication  --启动类


@RestController(value="hello")
    --控制器，作用于controller类上
    --包含@Controller + @ResponseBody
    spring4之后新加入的注解，

@Controller(value="hello")
    --控制器，作用于controller类上
    --用来响应页面，必须配合模板来使用，常用的有：FreeMarker、Thymeleaf（官网推荐）、Velocity、Groovy、Jsp

@ResponseBody
    --作用于控制器的方法上
    --将方法的返回值以json的格式写入到response的body中

@RequestMapping(value="world",method= RequestMethod.GET)
    --配置url映射
    可作用于控制器类 和 方法上

@PostMapping(value="world")
    --配置url映射
@GetMapping(value="world")
    --配置url映射



@PathVaribale
    --获取url中的数据，这些数据不是参数，是url的一部分
    在方法参数列表里，@PathVariable("id") Integer id
        例如：访问url为：localhost:8888/user/fpc/blog/1
        @RequestMapping("/user/{username:[a-zA-Z0-9_]+}/blog/{blogId}")
        则username为：fpc，blogId为：1

@RequestParam
    --获取请求参数的值，？号后面参数的值
    在方法参数列表里，@RequestParam("id") Integer id
