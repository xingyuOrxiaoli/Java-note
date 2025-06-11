# 关于Java中网络编程的使用

## 基础知识
**网络的组成**
- 硬件：计算机、外部设备、通信连路(连接)
- 软件：网络OS、网络管理软件、网络通讯协议(管理协调)

**分类**

- 按照规模
  - 局域网 LAN
  - 城域网 MAN
  - 广域网 WAN
- 传输介质
  - 同轴电缆网络
  - 双绞线
  - 光纤网络
  - 卫星网络
- 拓步结构分类
  - 星形网络
  - 总线网络
  - 环状网络



**基础概念**

- 网络通信协议
- 网络通讯协议的分层
  - 标准：ISO/OSI 
    - 应用层
    - 表示层
    - 会话层
    - 传输层
    - 网络层
    - 数据链路层
    - 物理层
  - 比较流行的：TCP/IP协议栈（Internet协议）
    - 应用层(Telnet、FTP、SMTP、DNS、HTTP以及其它协议)
    - 传输层(TCP/UDP)
    - 网络层(IP、ARP、RARP、ICMP)
    - 物理+数据链路层(各种通信网络接口[以太网等],[物理网络])



- UDP
  - 非面向连接，传输不可靠，可能丢失
  - 发送不管对方是否准备好，接收方收到也不确定
  - 可以广播发送
  - 非常简单的协议，开销小
  - 案例： DNS SNMP
- TCP
  - 面向连接
  - 点到点的通信
  - 可靠性：三次握手
  - 占用资源多，效率低
  - 应用案例：HTTP FTP TELNET SMTP
- IP
  - 192.168.0.0 - 192.168.255.255 私有地址，属于非注册地址，专门为组织机构内部使用
- port 端口
  - 范围： 0 ~ 65535   16位整数
  - 0 - 1023  公认端口 比如80 ：www  21 ：FTP
  - 注册端口 1024 - 49151 分配给用户线程或应用程序
  - 动态/私有端口 49152 - 65535
- IP和端口API
  - InetAddress 封装计算机的ip地址没有端口
  [InetAddress的使用.java](base/InetAddressTest.java)
  - InetSocketAddress 包含端口,用于socket通信
  [InetSocketAddressTest的使用.java](base/InetSocketAddressTest.java)
- URL 统一资源定位符
  - 组成：协议、存放资源的主机域名、端口号、资源文件名
[URLTest的使用.java](base/URLTest.java)

## 网络通信 TCP

[tcp](tcp)

### 登录双向通信

[客户端.java](tcp/login/LoginClient.java)

[服务端.java](tcp/login/LoginServer.java)

### 登录双向通信 引入多线程可以接受多个用户

[登录双向通信多线程类.java](tcp/loginThread/LoginThread.java)

[登录双向通信服务端.java](tcp/loginThread/LoginThreadServer.java)

[登录双向通信客户端.java](tcp/loginThread/LoginThreadClient.java)

### 网络进行文件的上传下载

两次的文件复制

[客户端.java](tcp%2FfileUpload%2FTCPClientTest.java)

[服务端.java](tcp%2FfileUpload%2FTCPServerTest.java)

## 网络通信 UDP

[udp](udp)

### 编程分析
- UDP + Socket
- 不需要利用IO流实现数据的传输
- 每个数据被封装成数据包
- 基础概念
  - DatagramSocket 用于发送或接受数据包
  - DatagramPacket 数据包

### 双向通信

[客户端.java](udp%2FClientTest.java)

[服务端.java](udp%2FServerTest.java)
