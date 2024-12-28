import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        int userCount = 50;
        Random rand = new Random();
        User[]  users = new User[userCount];
        initUsers(rand, users, userCount);

        // Выведем всех сгенерированных ползователей
        System.out.println("Список юзверей базовый");
        printUsers(users);
        System.out.println("Проверяем есть ли у нас в списке кто-то младше 7 лет");
        checkMinAge(users);
        System.out.println("Вычисляем средний возраст");
        printAveragAge(users);
        System.out.println("Считаем кол-во уникальных стран");
        printUniqCountiesCount(users);
        System.out.println("Сортируем по возрасту");
        printUsersSortByAge(users);
        System.out.println("Сортируем по Фамилии");
        printUsersSortBylastName(users);



    }
    public static void initUsers(Random rand, User[] users, int usersCount)
    {
        int id =0;
        String[] names ={"Александр", "Анна", "Борис", "Вера", "Григорий", "Дарья", "Евгений", "Екатерина", "Иван",
                "Ирина", "Кирилл", "Ксения", "Леонид", "Мария", "Михаил", "Наталья", "Николай", "Ольга", "Павел",
                "Светлана", "Роман", "Татьяна", "Сергей", "Юлия", "Дмитрий", "Елена", "Андрей", "Анастасия",
                "Артем", "Виктория"};
        String[] lastNames ={"Иванов", "Петров", "Сидоров", "Смирнов", "Кузнецов",
                "Попов", "Васильев", "Соколов", "Михайлов", "Новиков", "Федоров",
                "Морозов", "Волков", "Алексеев", "Лебедев", "Семенов", "Егоров",
                "Павлов", "Козлов", "Степанов", "Николаев", "Орлов", "Андреев",
                "Макаров", "Зайцев", "Соловьев", "Богданов", "Белов", "Герасимов", "Воробьев"};
        String[] countryList ={"Россия", "США", "Китай", "Япония", "Германия", "Франция", "Великобритания",
                "Индия", "Бразилия", "Канада", "Австралия", "Италия", "Испания", "Мексика", "Южная Корея",
                "Индонезия", "Турция", "Саудовская Аравия", "Нигерия", "Аргентина", "Польша",
                "Бельгия", "Швейцария", "Швеция", "Нидерланды", "Австрия", "Норвегия", "Ирландия",
                "Дания", "Финляндия"};
        for (int i = 0; i < usersCount; i++)
        {
            User user = new User(id, names[rand.nextInt(0, names.length)],
                    lastNames[rand.nextInt(lastNames.length)],
                    rand.nextInt(5,99),
                    countryList[rand.nextInt(countryList.length)]);
            users[i] = user;
            id++;
        }
    }
    public static void printUsers(User[] users)
    {
        for (int i=0; i < users.length; i++)
        {
            System.out.println("ID:"+users[i].id + " Name:"+users[i].firstName + " LastName:" + users[i].lastName +
                    " Age:"+users[i].age +" Country:"+ users[i].country);
        }
    }
    public static void printUsersSortBylastName(User[] users)
    {
        Arrays.sort(users, Comparator.comparing(User::getLastName));
        printUsers(users);
    }
    public static void printUsersSortByAge(User[] users)
    {
        Arrays.sort(users, Comparator.comparingInt(User::getAge));
        printUsers(users);
    }
    public static void printAveragAge(User[] users)
    {
        int summ =0;
        for (int i=0; i < users.length; i++)
        {
            summ += users[i].age;
        }
        System.out.println("Average Age:"+summ/users.length);
    }
    public static void printUniqCountiesCount(User[] users)
    {
        HashSet<String> uniqCountries = new HashSet<>();
        for (int i=0; i < users.length; i++)
        {
            uniqCountries.add(users[i].country);
        }
        System.out.println("Uniq Counties Count:"+ uniqCountries.size());
    }
    public static void checkMinAge(User[] users)
    {
        boolean pass = true;
        for (int i=0; i < users.length; i++)
        {
            if (users[i].age < 7) {
                pass = false;
                break;
            }
        }
        System.out.println("Not all users are older then 6");
    }
}