import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class UserDAOTest {
//    /添加用户后数量增加
    @Test
    public void addUserIncreaseSize(){
        UserDao dao = new UserDao();
        boolean added = dao.addUser(new User("alice","Alice Zhang",18));

        assertTrue(added);//因为 addUser() 返回的是 boolean
        assertEquals(1,dao.size());
    }
    //可以按 username 找到正确用户
    @Test
    public void findByUsernameReturnsCorrectUser(){
        UserDao dao = new UserDao();
        dao.addUser(new User("alice","alice z",18));

        User result = dao.findByUsername("alice");
        assertEquals("alice",result.getUsername());
        assertEquals("alice z",result.getDispalyname());
        assertEquals(18,result.getAge());
    }
    //找不到时返回 null
    @Test
    public void findByUsernameReturnNullWhenMissing(){
        UserDao dao = new UserDao();

        User result = dao.findByUsername("missing");

        assertNull(result);
    }
    //null user 不应该加入
    @Test
    public void addUserRejectionNullUser(){
        UserDao dao = new UserDao();
        boolean added = dao.addUser(null);
        assertFalse(added);
        assertEquals(0,dao.size());
    }
    //重复 username 不应该加入
    @Test
    public void addUserRejectsDuplicateUsername(){
        UserDao dao = new UserDao();

        boolean first = dao.addUser(new User("alice","alice a",18));
        boolean second = dao.addUser(new User("alice", "Alice Two", 20));

        assertTrue(first);
        assertFalse(second);
        assertEquals(1,dao.size());

        User result = dao.findByUsername("alice");
        assertEquals("alice a",result.getDispalyname());
    }

    //保存后再读取，数据还在
    /**
     *
     * @throws IOException
     */
    @Test
    public void saveAndLoadCsvKeepsUser() throws IOException{
        UserDao dao = new UserDao();
        dao.addUser(new User("alice","alice a",18));
        dao.addUser(new User("bob","bob c",20));

        // 先临时创建一个 users_xxx.csv 文件
        //文件名大概长这样：users123456789.csv
        File file = File.createTempFile("users",".csv");
        //然后把 dao 里的用户保存到这个临时文件里
        //拿到这个临时文件的完整路径。比如可能是：/var/folders/abc123/users98765.csv
        dao.saveToCsv(file.getAbsolutePath());

        //能不能从刚才保存的 CSV 文件里，把用户重新读回来。
        UserDao loadedDao = new UserDao();
        loadedDao.loadFromCsv(file.getAbsolutePath());

        assertEquals(2,loadedDao.size());

        User alice = loadedDao.findByUsername("alice");
        assertNotNull(alice);
        assertEquals("alice a",alice.getDispalyname());
        assertEquals(18,alice.getAge());

        User bob = loadedDao.findByUsername("bob");
        assertNotNull(alice);
        assertEquals("bob c",bob.getDispalyname());
        assertEquals(18,bob.getAge());
    }
    //load 前会清空旧数据
    @Test
    public void loadCsvClearsOldUsersFirst() throws  IOException{
        UserDao dao =new UserDao();
        dao.addUser((new User("old","old o",99)));

        File file = File.createTempFile("users",".csv");

        UserDao writerDao = new UserDao();
        writerDao.addUser(new User("new","new n",18));
        writerDao.saveToCsv(file.getAbsolutePath());

        dao.loadFromCsv(file.getAbsolutePath());//让原来的 dao 读取这个 CSV 文件

        assertEquals(1,dao.size());
        assertNull(dao.findByUsername("old"));
        assertNotNull(dao.findByUsername("new"));

    }


}
