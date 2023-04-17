import java.util.ArrayList;

public class User
{
    private int id;
    private String name;
    private String lastName;
    /**
     * Constructor for objects of class Usuario
     */
    public User()
    {
        this.name = "";
        this.lastName = "";
        this.id = -1;
    }
    public User(int id, String name, String lastName){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }
    public User(String name, String lastName)
    {
        this(-1, name, lastName);
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    @Override
    public String toString(){
        return "ID: " + id + " Name: " + name + " Lastname: " + lastName;
    }

}