# **JavaWeb**

Java学习过程中的例子

学习完成后准备做一下案例：账本Web，每个用户有1个免费账本可以记录平时花销，如果想要再次创建新账本则需要花费金钱。每次可以记录消费或者收入。

1. 数据库表的构建

   <img src="assImg/屏幕截图 2023-04-25 142438.png" alt="屏幕截图 2023-04-25 142438" style="zoom:80%;" />



<img src="assImg/屏幕截图 2023-04-25 142728.png" alt="屏幕截图 2023-04-25 142728" style="zoom:80%;" />

暂时有三个表账本表、用户表、收支表

账本表与用户表是多对一，收支表与账户表是多对一，因为其中只有一个免费账本，所以每个账户都有一个免费账户ID，用来控制账本数量。

