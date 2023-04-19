import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();

        m.runit();
    }

    public void runit() {

        System.out.println("Streams Examples");

        String[] names = {"Tom", "Bob", "Fed", "Joe", "Bob", "Sam", "Joe"};

        List<String> namesList = Arrays.asList(names);

        System.out.println("array size=" + names.length);
        System.out.println("namesList size=" + namesList.size());

        namesList.stream().forEach(System.out::println);

        long size = namesList.stream().filter(name -> !name.equals("Tom")).count();

        List<String> filteredNames = namesList.stream().filter(name -> !name.equals("Tom")).collect(Collectors.toList());

        System.out.println("-------");
        filteredNames.stream().forEach(System.out::println);

        List<String> uniqueNames = namesList.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println("-------");
        uniqueNames.stream().forEach(System.out::println);

        long uniqueNameCount = namesList.stream().distinct().count();
        System.out.println("-------");
        System.out.println("uniqueNameCount=" + uniqueNameCount);

        System.out.println("Raw namesList-------");
        namesList.stream().forEach(System.out::println);

        List<User> userList = Arrays.asList(new User("123", "Fred"), new User("222", "Tom"));

        List<User> filteredUsers = userList.stream().filter(user -> user.getName().equals("Tom")).collect(Collectors.toList());

        System.out.println("filteredUsers-------");
        filteredUsers.stream().forEach(user -> System.out.println(user.getName()));

        List<UserDTO> userDTOList = userList.stream().map(user -> {
            UserDTO userDTO = new UserDTO(user.getName());
            return userDTO;
        }).collect(Collectors.toList());

        System.out.println("userDTOList-------");
        userDTOList.stream().forEach(user -> System.out.println(user.getName()));

        List<Integer> intList = Arrays.asList(1, 10, 20, 100, 20, 5);

        Set<Integer> sortedIntList= intList.stream().collect(Collectors.toSet());

        System.out.println("sortedIntList-------");
        sortedIntList.stream().forEach(i -> System.out.println(i));

        long sum = sortedIntList.stream().filter(i -> i < 25).mapToLong(i -> i).sum();

        System.out.println("sum-------");
        System.out.println("sum=" + sum);

    }

    class User {
        private String id;
        private String name;

        public User(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    class UserDTO {
        private String name;

        public UserDTO(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}