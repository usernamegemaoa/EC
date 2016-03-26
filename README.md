# EC
Electronic Commerce

## 如何开始工作
1. 安装[Mars Eclipse for J2EE](http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/mars1)
2. 从`dev开发分支`新建自己的分支
3. 在数据库中新建数据库及表

        CREATE DATABASE `productsdb`;
        USE productsdb;
    
        CREATE TABLE `product` (
            `product_id` int(11) NOT NULL AUTO_INCREMENT,
            `name` varchar(128) NOT NULL,
            `description` varchar(512) NOT NULL,
            `price` float NOT NULL,
            PRIMARY KEY (`product_id`)
        );

4. 添加新的数据库用户

        CREATE USER ec IDENTIFIED BY 'ec';
        GRANT ALL PRIVILEGES ON productsdb.* TO 'ec'@'localhost' IDENTIFIED BY 'ec';

5. 打开Eclipse，`Servers`>>`Add new Servers`， 添加`Tomcat`
6. `File`>>`Import`>>`Git`>>`Projects from Git`>>`Existing local resposity`>>`Add`>>选择你github文件夹>>`Search`>>`EC.git`>>`Import as general project`+`ec文件夹`>>`Finish`
7. `Window`>>`Preferences`>>`JAVA`>>`Installed JREs`>>`Edit`>>修改*jre*目录为*jdk*目录
8. 右键项目>>`Configure`>>`Conver to Maven Project`
9. 右键项目>>`Preferences` *以下操作均在Preferences中进行*
10. `Project Facets`>>`Runtimes`>>`Apache Tomcat`>>`Dynamic Web Module`>>`Java`>>`JavaScript`>>`Further configuartion available`>>`Content directory`=`/src/main/wabapp`>>`Generate web.xml`打勾>>`Apply`
11. `Java Build Path`>>`JRE`>>`Edit`>>1.7+>>`Apply`
12. `OK`关闭
13. 右键项目>>`Preferences`
14. `Deployment assembly`>>`Add`>>`Java Path`>>`Maven`>>`Apply`
15. 右键项目>>`Run as`>>`Maven build`>>`Goals = clean install`>>`run`>>Console显示BUILD SUCCESS
16. 右键项目>>`Run as`>>`Run on server`>>`Finish`>>Console显示`Hibernate: select * from product` 浏览器显示`Hello world EC`