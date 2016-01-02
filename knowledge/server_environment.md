# 购买服务器
服务器为阿里云服务器，配置如下：
- CPU 1核
- 内存 1024 MB
- 操作系统 Ubuntu 14.04 64位
- 带宽 1Mbps
- 硬盘 20G

**FINISH**

# 更新系统

    apt-get update
    apt-get upgrade

**FINISH**

# 安装java

    apt-get install default-jdk

**FINISH**

# 安装mysql

    apt-get install mysql-server

**FINISH**

# 安装tomcat

    apt-get install tomcat7

修改java虚拟机配置

    vim /etc/default/tomcat7
    
修改和添加`JAVA_OPTS`中的配置

    JAVA_OPTS="-Xmx512m -XX:MaxPermSize=512m"
    
安装tomcat管理员界面

    apt-get install tomcat7-docs tomcat7-admin tomcat7-examples
    
添加管理员账号

    vim /etc/tomcat7/tomcat-users.xml
    
    <tomcat-users>
        <user username="admin" password="password" roles="manager-gui,admin-gui"/>
    </tomcat-users>

修改tomcat端口从`8080`到`80`

    vim /etc/tomcat7/server.xml

将下句中的`8080`修改为`80`    
    
    <Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" ...
    
打开另一个配置文件,设置`AUTHBIND=yes`

    vim /etc/default/tomcat7

重启tomcat

    service tomcat7 restart
    
在浏览器中打开`http://server_IP_address`

**FINISH**

# 安装hudson

1. 在[hudson官网](http://www.eclipse.org/hudson/download.php)下载最新版hudson3.3.2
2. 打开`http://server_IP_address/manager`
3. 上传`hudson.war`

修改配置文件

    vim /etc/default/tomcat7
    
添加`JAVA_OPTS`中的配置

    JAVA_OPTS="-DHUDSON_HOME=/home/hudson/"

新建hudson文件夹

    mkdir /home/hudson
    
修改文件的所属用户和用户组

    chown tomcat7:tomcat7 hudson/
    
在浏览器中打开`http://server_IP_address/hudson-3.3.2/`

**FINISH**

# 安装git

    apt-get install git

**FINISH**
    
# 安装maven

    apt-get install maven

**FINISH**
    
# 安装ftp

    apt-get install vsftpd

修改配置文件

    vim /etc/vsftpd.conf
    
    write_enable=YES
    local_umask=022
    chroot_local_user=YES
    allow_writeable_chroot=YES
    pasv_enable=Yes
    pasv_min_port=40000
    pasv_max_port=40100
    
添加ftp用户

    useradd -m ftpuser -s /usr/sbin/nologin
    passwd ftpuser
    
添加nologin shell

    vim /etc/shells
    
    /usr/sbin/nologin
    
重启ftp service

    service vsftpd restart

**FINISH**
    
# 开启iptables防火墙

显示iptables

    iptables -L -v
    
允许已建立的连接接收数据

    iptables -A INPUT -m state --state ESTABLISHED,RELATED -j ACCEPT
    
查看服务器外网网卡

    ifconfig
    
共有三块网卡**'eth0'** **'eth1'** **'lo'**,阿里云中**eth1**为外网网卡
    
开放ssh端口**22**

    iptables -A INPUT -p tcp -i eth1 --dport 22 -j ACCEPT
    
开放tomcat端口**80**

    iptables -A INPUT -p tcp -i eth1 --dport 80 -j ACCEPT
    
开放ftp端口**20&21**

    iptables -A INPUT -p tcp -i eth0 --dport 20 -j ACCEPT
    iptables -A INPUT -p tcp -i eth0 --dport 21 -j ACCEPT

允许内网网卡**eth0**和环回端口**lo**的所有报文

    iptables -A INPUT -i eth0 -j ACCEPT
    iptables -A INPUT -i lo -j ACCEPT
    
丢弃不在表中的所有报文

    iptables -A INPUT -j DROP

保存当前的规则

    iptables-save > /etc/iptables.up.rules
    
添加开机自动加载规则

    vim /etc/network/interfaces
    
在最后一行加入

    pre-up iptables-restore < /etc/iptables.up.rules

**FINISH**
