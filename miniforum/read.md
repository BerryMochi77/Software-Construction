MiniForum User Storage Practice
用户注册后，系统要把用户存在内存里，
也可以保存到 CSV 文件，再从 CSV 文件重新加载回来，
并且你要写测试验证功能正确。

| Hackathon Task           | 对应练习内容                 |
| ------------------------ | ---------------------- |
| Task 3 Persistent Data   | CSV save / load        |
| Task 4 Design Patterns   | DAO 结构                 |
| Task 5 Software Testing  | JUnit 测试               |
| Task 1/2 Data Structures | ArrayList / HashMap 基础 |

第 1 步：创建 User.java
第 2 步：创建 UserDAO.java，只实现 add / find
第 3 步：写基础测试
第 4 步：加 saveToCsv
第 5 步：加 loadFromCsv
第 6 步：补边界测试
第 7 步：Git commit + push




DAO = Data Access Object - 专门负责和数据打交道
功能1 ：业务逻辑
        用户点击注册按钮
        检查邮箱是否重复
        创建新用户

功能2:数据操作
       把用户存到 ArrayList
       把用户写进 CSV 文件
       把用户存进数据库
       从文件里读取用户
常见方法：
add()
get()
getAll()
update()
delete()