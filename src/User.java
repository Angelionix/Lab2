
public class User
{
    public int id;
    public String firstName;
    public String lastName;
    public int age;
    public String country;

    User(int id, String firstName, String lastName, int age, String country)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.age = age;
        this.country = country;
    }

    public int getAge()
    {
        return age;
    }

    public String getLastName()
    {
        return lastName;
    }
}