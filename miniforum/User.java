public class User {
    private final String username;
    private final String dispalyname;
    private final int age;

    public User(String username, String dispalyname, int age) {
        this.username = username;
        this.dispalyname = dispalyname;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public String getDispalyname() {
        return dispalyname;
    }

    public int getAge() {
        return age;
    }

    /**
     *  把一个 User 对象转换成一行 CSV 文本，方便保存到文件里。
     *
     *  User user = new User("anna", "Anna Smith", 20);
     *  但是如果你想把它写进 .csv 文件，文件里不能直接保存 Java 对象，通常要保存成一行文字：
     *  anna,Anna Smith,20
     *
     *  为什么要单独写成函数？
     *  因为以后你保存用户时，可以直接写：
     *  String line = user.toCsvLine();
     *
     *  User.java        负责描述一个用户，以及如何把自己变成 CSV
     *  UserDAO.java     负责把用户保存起来 / 读出来
     */

    public String toCsvLine(){
        return username + "," + dispalyname +"," + age;
    }

    /**
     * 把 CSV 文件里的一行文字，重新变回一个 User 对象;
     */
    public static User fromCsvLine(String line){
        String[] parts = line.split(",");

        if(parts.length !=3){//username,displayName,age
            return null;
        }
        String username = parts[0];
        String dispalyname = parts[1];
        int age = Integer.parseInt(parts[2]);

        return new User(username,dispalyname,age);
    }
}
