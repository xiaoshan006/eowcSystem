# 企业官网建设系统后端

##### 技术架构：前后端分离(此处为后端)，前端请见[前端-前台](https://github.com/llanc/eowcSystemFrontEnd-front "前端-前台")、[前端-后台](https://github.com/llanc/eowcSystemFrontEnd-back "前端-后台")
- ##### 开发环境：jdk1.8、maven3.5.2、IDEA2019.1
- ##### 应用技术：SpringBoot、Jersey、MyBatis
- ##### 云服务：腾讯云短信业务、七牛云储

------------

#### 系统功能模块图

![系统功能模块图](http://prn5kvu34.bkt.clouddn.com/%E7%B3%BB%E7%BB%9F%E5%8A%9F%E8%83%BD%E6%A8%A1%E5%9D%97%E5%9B%BE.png "系统功能模块图")


#### 网站有三大角色其用例图如下

- 网站访客

![访客](http://prn5kvu34.bkt.clouddn.com/%E8%AE%BF%E5%AE%A2.png "访客")

- 网站管理员

![管理员](http://prn5kvu34.bkt.clouddn.com/%E7%AE%A1%E7%90%86%E5%91%98.png "管理员")

- 网站操作员

![操作员](http://prn5kvu34.bkt.clouddn.com/%E7%AE%A1%E7%90%86%E5%91%98.png "操作员")

#### 其他
- 系统API均为域名+/api+/具体功能名称/具体操作名称 如：llanc.cn/api/login/verificationCode
- 统一的出入参管理
- 统一的系统状态码管理