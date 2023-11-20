# 一. 用户分析
对电脑有购置需求的群体
从年龄上来看：用户多集中在25-35岁的年龄区间 ，25岁以下的年轻用户和45岁以上的中老年用户比较少。
从品类上区分：高端轻薄笔记本以高学历白领为主，游戏本品类以青年男性为主，多为学生群体。
因此本项目着重面向年轻群体，在ui设计方向应该偏好于轻量、新潮。
后端交互服务可以。。。。。。。
# 二. 系统目标
建成平台运营整体框架结构以及完成交易流程为重点，旨在以品质、专业、服务为核心推广筑巢电商品牌形象，最终以渠道下放、丰富品类而达到从流量到订单的转化，形成交易的闭环。常规网站运营的目的主要是保证网站正常运转，网上商城除了对网站内容的运维和人气的聚敛外，还要考虑网站的整体市场营销推广。即结合平台内容和市场推广与一体的方法来充实网站，吸引、固化更大的客户群体。
# 三. 功能模块概述
商城共分两个部分，一部分是面向用户的部分，包括：顾客在线注册、购物、提交订单、付款等操作；另外一部分是商城管理部分，这部分的内容包括：产品的添加、删除、查询、订单的管理、操作员的管理、注册用户的管理等。
# 四. 功能需求详细规格说明
## 4.1 后台模块和信息维护
### 4.1.1 管理员登录
前端文件名称：
功能描述：普通登录页，输入管理员账号后跳入管理员界面  
账号识别为管理员后直接跳转到管理员管理页面
### 4.1.2 商品类别添加
功能描述：添加商品类别
后台管理界面应包含“商品类别管理页面”  
通过功能选项“添加”进入商品类别添加。  
添加方式为选择类别，输入商品名称后保存  
商品名称要求：（1）类别名称长度3-15。（2）各类别名称之间不能重复    
### 4.1.3 商品类别删除
功能描述:删除指定的商品  
删去前需弹出窗口询问是否确定删除  

### 4.1.4 商品添加
功能描述: 添加商品  
后台管理界面应包含“商品管理”  
通过功能选项“添加”进行管理  
商品添加：  
1. 输入商品名称，选择商品类别
2. 输入价格，描述，存货量
3. 可添加图片
4. 成功后弹出添加成功界面  

添加限制：  
1)	商品名称3-15字符。
2)	价格最多包含2位小数。
3)	图片检查后缀，后缀允许：jpg, gif, png, bmp。.

### 4.1.5 用户添加
功能描述：在后台直接添加用户  
用户名需保证唯一性  
### 4.1.6 用户删除
功能描述：在后台直接删除用户  
### 4.1.7 用户信息修改
功能描述：在后台直接更改用户信息
### 4.1.8 订单查询
1.	在后台管理页点击“订单”进入订单查询页。
2.	在订单查询页，可输入用户名、下单日期区间、商品名称来查询订单。  

说明：  
1.	所有的订单都可单击“修改订单”修改订单
2.	单击“查看详细”来查看订单的详细信息。
3.	分页显示订单，格式参照后台商品查询。

### 4.1.9 订单查看  
在订单列表中，单击“订单详情”进入。  
说明：包含订单的详细信息和订单的所有商品  

## 4.2 商城界面模块与功能
### 4.2.1 功能流程图

### 4.2.2 首页
包含内容：  
1.	用户通过输入首页网址进入首页。
2.	显示登录状态、登录，购物车         
3.	轮播图
4.	推荐商品列表                      
5.	搜索框     
### 4.2.3 商品搜索功能
1.	用户可根据关键字(即商品名称) 查询商品。关键字模糊匹配商品名称，如果没有商品则显示 “未找到商品”。
2.	查得商品分页显示。每一项商品下面都有详细信息和购买两个功能按钮(或链接)。  
### 4.2.4 商品详情页
应包含商品名、价格、分类、库存、详细介绍等信息  
### 4.2.5 购买商品
1.	未注册用户点击购买，应跳转到登录页
2.	在商品列表或者商品详细信息页上点击“购买”进行购买，（如果缺货不能购买，总购买数量不能大于该商品的库存）。
3.	点击“添加到购物车” 添加到购物车
4.	支持修改购买数量

### 4.2.6 用户注册
1.	在首页点击“注册”进入用户注册页。
2.	在用户注册页面输入用户名、密码、确认密码、电子邮箱、等信息后,点 提交按钮，进行客户端验证，验证通过后进行注册，如注册失败提示失败原因及重新提交；
3.	注册成功后自动登陆进入首页。

### 4.2.7 用户登录
用户通过用户名及密码登录
用户登入数据规范：用户名必填，只能为数字与字母，长度3-15。密码必填，可包含数字、字母和特殊符号，且至少包含上述的两种，长度6-30
额外要求（待定）：加入登录时的验证码功能
### 4.2.8 用户退出
退出登录，返回用户登录界面
### 4.2.9 购物车
在首页点击“购物车”进入购物车页面。
### 4.2.10 购物车管理
1.	在购物车管理页中, 以友好方式显示购物车的商品信息和汇总信息； 如购物车中无商品，则提示；如未登录则进入登录页，用户登录成功后直接进入结算确认页。
商品信息包括: 商品名称，商品缩略图，商品单价，商品数量，商品小计；
汇总信息包括: 商品总价，商品总个数，商品种类数；
2. 可以修改购物车中某种商品的数量，用户输入的新商品数量需是大于0的数字,并且不能大于商品库存数。
3. 可以删除购物车中某种商品。
4. 单击“结算”去结算下订单。

### 4.2.11 订单确认
1.	在购物车管理页中点击“结算”；进入结算确认页选择付款方式、收货方式后, 用户可点击“确认结算”进入下单页,也可点击“返回购物车”回到购物车管理页；
注: 付款方式、收货方式必选
2.	如点击“确认结算”进入下单页, 下单页收货人信息默认来自登录用户的信息但可进行修改；在下单页中点提交订单，进行下订单； 
    1. 订单页信息包括：  
    所购商品种类数；所购商品总件数；价格总计；付款方式；收货方式；   
    及收货人相关信息(收货人姓名、收货人地址、收货人电话、收货人邮编)；  
    2. 	跟商品有关的信息不可修改，收货人信息可修改。 
    3. 收货人信息验证要求：默认为登录人信息，可修改
        1. 收货人姓名：必填；中文，2-10个字符；
        2. 收货人地址：必填；3-100个字符；
        3. 收货人电话：必填；
        4. 收货人邮编：必填, 且格式要正确；
3.	如下单失败则提示失败原因；下订成功提示成功信息（信息中包括订单编号，下订单日期）可进入会员中心我的订单页；

### 4.2.12 用户中心
1.	在首页点击“用户中心”进入用户中心的基本资料页。
2.	如果用户未登录，则转到登录页面，登录成功后自动到首页。
### 4.2.13 基本资料查看
显示登录用户自己的资料
### 4.2.14 基本资料修改
修改登录用户自己的资料
# 五. 技术架构
## 5.1 前端
html+css+js+Vue+Element-uiVue
## 5.2 后端
springboot 
## 5.3 数据库
mysql
## 5.4 前端ui设计
figma
## 
# 六. 特色功能
。。。。。。。
# 七. UI设计草图
。。。。。。。