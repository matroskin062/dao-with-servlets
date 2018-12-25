import dao.Dao;
import dao.UserMySql;
import entities.User;

public class using {
    public static void main(String[] args){
        Dao dao = new UserMySql();
//        dao.truncate();
        System.out.println(dao.getAll());
    }
}
