# 如何使用git

[git文档](https://git-scm.com/book/en/v2)

# 如何使用github进行团队协作

1. 打开项目目录，打开`Settings`页面
2. 选择`Collaborators`标签，添加合作伙伴
3. 在`GitHub Desktop`中打开本项目
4. 点击左上角`Create new branch`
5. 分支名称为本次修改的主要目的，`From branch`一般为主分支`master`
6. 开始增删改代码
7. 完成后commit，`Summary`必须填写，`Description`为补充。当发现本次commit的Summary无法在一行内结束，说明本次commit做了过多的事情，需要分成几个小部分来提交。
8. 任务完成后，再次进入`GitHub Desktop`中，点击`Update from master`，如有冲突发生，则开始解决冲突。
9. 点击`Publish`，提交到github官网上。
10. 进入团队评审阶段，所有人使用`GitHub Desktop`切换到当前分支，进行评审修改
11. 评审通过后，点击`Pull request`
12. 到官网上查看Pull request，适当讨论后，合并分支到master
13. 删除本次任务分支

**FINISH**
