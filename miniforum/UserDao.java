import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 这里 DAO 做这些事：
 * addUser
 * findByUsername
 * getAllUsers
 * saveToCsv
 * loadFromCsv
 */
public class UserDao {
    private final ArrayList<User> users;//它负责保存所有用户的列表。
    private final HashMap<String,User> usersByUsername;//它负责通过 username 快速找到某个用户。

    public UserDao(ArrayList<User> users, HashMap<String, User> usersByUsername) {
        this.users = users;
        this.usersByUsername = usersByUsername;
    }
    public UserDao() {
        this.users = new ArrayList<>();
        this.usersByUsername = new HashMap<>();
    }

    /**
     *这个 User 能不能被安全地放进 DAO 里，并且以后能不能用 username 找到它。
     * “唯一身份”的字段是：username
     *
     * @param user
     * @return
     */
    public boolean addUser(User user){
        //如果传进来的用户根本不存在，就不能添加。
        if(user == null){
            return false;
        }
        //用户名不存在 or   用户名是空字符串 ""
        if(user.getUsername() == null || user.getUsername().isEmpty()){
            return false;
        }
        if(usersByUsername.containsKey(user.getUsername())){
            return false;
        }
        users.add(user);
        usersByUsername.put(user.getUsername(),user);
        return true;
    }
    public User findByUsername(String username){
        if(username == null){
            return null;
        }
        return usersByUsername.get(username);
    }

    /**
     * new - 是为了保护 UserDAO 里面真正的 users 列表，不让外部直接改坏它。
     * @return
     */
    public ArrayList<User> getAllUsers(){
        return  new ArrayList<>(users);
    }
    public int size(){
        return users.size();
    }
    public void clear(){
        users.clear();
        usersByUsername.clear();
    }

    /**
     * 这个函数的作用是：把 UserDAO 里保存的所有用户，写入一个 CSV 文件。
     *
     * @param filePath
     * @throws IOException
     */
    public void saveToCsv(String filePath) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter((filePath)));
        for(User user : users){
            writer.write(user.toCsvLine());
            writer.newLine();
        }
        writer.close();
    }
    /**
     *  从 CSV 文件里读取用户数据，然后重新放回 UserDAO 里。
     *  从 filePath 指定的文件里读取用户数据
     * 这个方法不返回值
     * 如果读文件出错，就抛出 IOException
     *
     */
    public void loadFromCsv(String filepath) throws IOException{
        clear();//用文件里的数据重新加载 DAO -> public void clear()
        BufferedReader reader = new BufferedReader(new FileReader(filepath));

        String line;//这个变量用来暂时保存 CSV 文件中的每一行。

        while (((line = reader.readLine())) != null){
            if(line.trim().isEmpty()){//会去掉前后空格。
                continue;
            }

            User user = User.fromCsvLine(line);

            if(user != null){
                addUser(user);
            }
        }
        reader.close();
    }

}
