package com.pb.tsvik.hw11;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Consumer;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());

        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());   // не учитывается при выводе время
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());

        mapper.registerModule(module);

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Питер Паркер", LocalDate.of(1997, 12, 30), "0503258574", "Днепр, Шмидта 35", LocalDateTime.of(2021, 7, 2, 17, 8, 1)));
        persons.add(new Person("Питер Педигрю", LocalDate.of(1990, 7, 10), "0503265733, 0679873425", "Днепр, Победа 20", LocalDateTime.of(2021, 9, 1, 7, 52, 27)));
        persons.add(new Person("Дин Винчестер", LocalDate.of(1983, 2, 24), "0503258453", "Днепр, Тополь 1", LocalDateTime.of(2021, 10, 15, 10, 47, 35)));
        persons.add(new Person("Диего Тенорио", LocalDate.of(1988, 6, 17), "0503258574, 0685643728, 0995643262", "Днепр, Парус 10", LocalDateTime.of(2021, 12, 24, 21, 10, 15)));

        System.out.println("------------------------------------");
        System.out.println("ДОБРО ПОЖАЛОВАТЬ В ТЕЛЕФОННУЮ КНИГУ!");
        System.out.println("------------------------------------");


        int exit;
        do {
            System.out.println("Для дальнейшей работы просьба выбрать цифру пункта: " +
                    "\n 1. Добавить новую запись в список." +
                    "\n 2. Удалить существующую запись из списка." +
                    "\n 3. Найти информацию о человеке из списка." +
                    "\n 4. Посмотреть отсортированный список." +
                    "\n 5. Редактирование информации по существующей записи." +
                    "\n 6. Перенос в файл всех текущих записей." +
                    "\n 7. Чтение файла со списком сотрудников." +
                    "\n 8. Выход из программы." +
                    "\n ");
            System.out.print("Сделайте свой выбор: ");

            Scanner scanAnswer = new Scanner(System.in);
            int num = scanAnswer.nextInt();

            switch (num) {
                case 1: {
                    System.out.println("------------------------------------------------");
                    addPerson(persons, mapper);
                }
                break;
                case 2: {
                    System.out.println("--------------------------------------------");
                    deletePerson(persons);
                }
                break;
                case 3: {
                    System.out.println("-------------------------------------------");
                    searchPerson(persons);
                }
                break;
                case 4: {
                    System.out.println("-------------------------------------------------------");
                    sortPerson(persons);
                }
                break;
                case 5: {
                    System.out.println("-------------------------------------------");
                    changePerson(persons);
                }
                break;
                case 6: {
                    System.out.println("---------------------------------------------------");
                    inputFile(persons,mapper);
                }
                break;
                case 7: {
                    System.out.println("---------------------------------------------------");
                    outputPerson(persons, mapper);
                }
                break;
                case 8:
                break;
                default:
                    throw new IllegalStateException("Unexpected value: " + num);
            }
            System.out.println("---------------------------------------------------");

            System.out.println("Если Вы хотите продолжить, введите 1" +
                    "\nЕсли Вы хотите закрыть програму, введите 0");
            Scanner scan = new Scanner(System.in);
            exit = scan.nextInt();

        } while(exit == 1);
    }



    /**
     * Запись в файл всех данных
     * @param persons
     * @param mapper
     * @return
     * @throws Exception
     */
    private static Path inputFile(List<Person> persons, ObjectMapper mapper) throws Exception {

        String personsJson = mapper.writeValueAsString(persons);

        Path path = Paths.get("src\\com\\pb\\tsvik\\hw11\\Phone book.txt");

        try(BufferedWriter writer = Files.newBufferedWriter(path)){

            for (int i = 0; i < personsJson.length(); i++) {
                writer.write(personsJson.charAt(i));
                writer.flush();
            }
        } catch (IOException e) {
            System.out.println("Ошибка в записи файла: " + e);
            e.printStackTrace();
        }
        System.out.println("Запись в файл: " + path.toAbsolutePath() + " успешна!");
     return path;
    }


    /**
     * Добавление элементов
     * @param persons
     * @param mapper
     * @throws Exception
     */
    private static void addPerson(List<Person> persons, ObjectMapper mapper) throws Exception {


        System.out.println("Введите данные о человеке для добавления записи: ");
        System.out.println("------------------------------------------------");
        System.out.print("ФИО:");
        Scanner scanFio = new Scanner(System.in);
        String fio = scanFio.nextLine();
        System.out.print("Год рождения:");
        Scanner scanYear = new Scanner(System.in);
        int year = scanYear.nextInt();
        System.out.print("Месяц рождения (числом):");
        Scanner scanMonth = new Scanner(System.in);
        int month = scanMonth.nextInt();
        System.out.print("День рождения:");
        Scanner scanDay = new Scanner(System.in);
        int day = scanDay.nextInt();
        System.out.print("Номер(а) телефона(ов):");
        Scanner scanPhone = new Scanner(System.in);
        String phone = scanPhone.nextLine();
        System.out.print("Адрес проживания:");
        Scanner scanAddress = new Scanner(System.in);
        String address = scanAddress.nextLine();

        persons.add(new Person(fio, LocalDate.of(year, month, day), phone, address, LocalDateTime.now()));

        System.out.println("В список добавлена новая запись:" +
                "\nPerson{" +
                "fio='" + fio + '\'' +
                ", dateBirth=" + LocalDate.of(year, month, day) +
                ", phone=" + phone +
                ", address='" + address + '\'' +
                ", dateTimeChange=" + LocalDateTime.now() +
                '}');
    }


    /**
     * Удаление элементов из списка
     * @param persons
     */
    private static void deletePerson(List<Person> persons) {
        System.out.println("Для удаления элемента произведите его поиск:");
        System.out.println("--------------------------------------------");
        int index = searchPerson(persons);
        persons.remove(index);
        System.out.println("Удаление прошло успешно!");


//        Scanner scanAnswer = new Scanner(System.in);
//        int num = scanAnswer.nextInt();
//
//        switch (num) {
//            case 1: {
//                System.out.println("Какой элемент из списка удалить(припишите порядковый номер): ");
//                Scanner scanIndex = new Scanner(System.in);
//                int index = scanIndex.nextInt();
//                int in = index - 1;
//                System.out.println("Удаляем запись: " + persons.get(in));
//                persons.remove(in);
//            }
//            break;
//            case 2: {
//                System.out.println("Введите имя и фамилию человека, которого Вы хотите удалить");
//                Scanner scanNameFam = new Scanner(System.in);
//                String nameFam = scanNameFam.nextLine();
//                persons.removeIf(
//                        new Predicate<Person>() {
//                            @Override
//                            public boolean test(Person person) {
//
//                                if (person.getFio().equals(nameFam)) {
//                                    int indexDel = persons.indexOf(person);
//                                    System.out.println("Удаляем запись: " + persons.get(indexDel));
//                                    return true;
//                                } else return false;
//                            }
//                        }
//                );
//            }
//            break;
//            default:
//                throw new IllegalStateException("Unexpected value: " + num);
//        }
//
    }



    static class PersonFioComparator implements Comparator<Person> {

        public int compare(Person a, Person b) {
            return a.getFio().compareTo(b.getFio());
        }
    }

    static class PersonAddressComparator implements Comparator<Person> {

        public int compare(Person a, Person b) {
            return a.getAddress().compareTo(b.getAddress());
        }
    }

    /**
     * Вывод всех записей с сортировкой по указанному полю
     * @param persons
     */
    private static void sortPerson(List<Person> persons) {

        System.out.println("Выберите поля, по которым будет проводиться сортировка: " +
                "\n 1. По ФИО." +
                "\n 2. По адресу." +
                "\n 3. По 2-м полям: ФИО и адресу." +
                "\n ");
        System.out.print("Сделайте свой выбор: ");
        Scanner scanAnswer = new Scanner(System.in);
        int num = scanAnswer.nextInt();

        switch (num) {
            case 1: {
                Comparator<Person> comporator1 = new PersonFioComparator();
                TreeSet<Person> personsComporator1 = new TreeSet<>(comporator1);
                personsComporator1.addAll(persons);
                System.out.println("----------------------");
                System.out.println("Отсортированный список:");
                personsComporator1.forEach(new Consumer<Person>() {
                    @Override
                    public void accept(Person p) {
                        System.out.println(p);
                    }
                });
            }
            break;
            case 2: {
                Comparator<Person> comporator2 = new PersonAddressComparator();
                TreeSet<Person> personsComporator2 = new TreeSet<>(comporator2);
                personsComporator2.addAll(persons);
                System.out.println("----------------------");
                System.out.println("Отсортированный список:");
                personsComporator2.forEach(new Consumer<Person>() {
                    @Override
                    public void accept(Person p) {
                        System.out.println(p);
                    }
                });
            }
            break;
            case 3: {
                Comparator<Person> comporator3 = new PersonFioComparator()
                        .thenComparing(new PersonAddressComparator());
                TreeSet<Person> personsComporator3 = new TreeSet<>(comporator3);
                personsComporator3.addAll(persons);
                System.out.println("----------------------");
                System.out.println("Отсортированный список:");
                personsComporator3.forEach(new Consumer<Person>() {
                    @Override
                    public void accept(Person p) {
                        System.out.println(p);
                    }
                });
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + num);
        }

    }


    /**
     * Поиск элеметнов
     * @param persons
     * @return
     */
    private static int searchPerson(List<Person> persons) {

        System.out.println("По какому параметру Вы хотите найти элемент:" +
                "\n 1. По ФИО." +
                "\n 2. По дате рождения." +
                "\n");

        System.out.print("Сделайте свой выбор: ");

        Scanner scanAnswer = new Scanner(System.in);
        int num = scanAnswer.nextInt();
        int indexDel = -1;

        switch (num) {
            case 1: {
                do {
                System.out.println("--------------------------------------------------------");
                System.out.print("Введите имя и фамилию человека, которого Вы хотите найти: ");
                Scanner scanNameFam = new Scanner(System.in);
                String nameFam = scanNameFam.nextLine();

                    for (Person person : persons) {
                        if (person.getFio().equals(nameFam)) {
                            indexDel = persons.indexOf(person);
                            System.out.println("\nНайдена запись: " + persons.get(indexDel));
                        }
                    }
                    if (indexDel == -1)
                        System.out.println("По указанным параметрам запись не найдена, просьба изменить параметры.");
                } while (indexDel == -1);
            }
            break;
            case 2: {
                do {
                System.out.println("Введите дату рождения человека, которого Вы хотите найти.");
                System.out.print("Введите год рождения: ");
                Scanner scanDateYear = new Scanner(System.in);
                int dateYear = scanDateYear.nextInt();
                System.out.print("Введите месяц рождения: ");
                Scanner scanDateMonth = new Scanner(System.in);
                int dateMonth = scanDateMonth.nextInt();
                System.out.print("Введите день рождения: ");
                Scanner scanDateDay = new Scanner(System.in);
                int dateDay = scanDateDay.nextInt();
                LocalDate nameDate = LocalDate.of(dateYear, dateMonth, dateDay);

                    for (Person person : persons) {
                        if (person.getDateBirth().equals(nameDate)) {
                            indexDel = persons.indexOf(person);
                            System.out.println("\nНайдена запись: " + persons.get(indexDel));
                        }
                    }
                    if (indexDel == -1)
                        System.out.println("По указанным параметрам запись не найдена, просьба изменить параметры.");
                } while (indexDel == -1);
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + num);
        }
        return indexDel;
    }


    /**
     * Редактирование элемента
     * @param persons
     */
    private static void changePerson(List<Person> persons) {
        System.out.println("Для изменения элемента произведите его поиск:");
        int index = searchPerson(persons);
        System.out.println("\nВыберите, что вы хотите изменить:" +
                "\n 1. ФИО." +
                "\n 2. День рождения." +
                "\n 3. Телефон." +
                "\n 4. Адрес." +
                "\n");

        System.out.print("Сделайте свой выбор: ");

        Scanner scanAnswer = new Scanner(System.in);
        int num = scanAnswer.nextInt();

        for (Person person : persons) {
            if (persons.indexOf(person) == index) {
                switch (num) {
                    case 1: {
                        System.out.println("Текущее ФИО: " + person.getFio());
                        System.out.print("Введите новые имя и фамилию: ");
                        Scanner scanNameFam = new Scanner(System.in);
                        String nameFam = scanNameFam.nextLine();
                        person.setFio(nameFam);
                        person.setDateTimeChange(LocalDateTime.now());
                    }
                    break;
                    case 2: {
                        System.out.println("Текущий день рождения: " + person.getDateBirth());
                        System.out.print("Введите новый год рождения: ");
                        Scanner scanDateBirthYear = new Scanner(System.in);
                        int dateBirthYear = scanDateBirthYear.nextInt();
                        System.out.print("Введите новый месяц рождения: ");
                        Scanner scanDateBirthMonth = new Scanner(System.in);
                        int dateBirthMonth = scanDateBirthMonth.nextInt();
                        System.out.print("Введите новый день рождения: ");
                        Scanner scanDateBirthDay = new Scanner(System.in);
                        int dateBirthDay = scanDateBirthDay.nextInt();
                        LocalDate DateBirth = LocalDate.of(dateBirthYear, dateBirthMonth, dateBirthDay);
                        person.setDateBirth(DateBirth);
                        person.setDateTimeChange(LocalDateTime.now());
                    }
                    break;
                    case 3: {
                        System.out.println("Текущий телефон: " + person.getPhone());
                        System.out.print("Введите новый телефон(ы): ");
                        Scanner scanPhone = new Scanner(System.in);
                        String phone = scanPhone.nextLine();
                        person.setPhone(phone);
                        person.setDateTimeChange(LocalDateTime.now());
                    }
                    break;
                    case 4: {
                        System.out.println("Текущий адрес: " + person.getAddress());
                        System.out.print("Введите новый адрес: ");
                        Scanner scanAddress = new Scanner(System.in);
                        String address = scanAddress.nextLine();
                        person.setAddress(address);
                        person.setDateTimeChange(LocalDateTime.now());
                    }
                    break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + num);
                }
                System.out.println("\nЗапись успешно изменена!" +
                        "\n" +
                        "\nТекущая информация: " + persons.get(index));
            }
        }
    }


    /**
     * Загрузка из файла всех данных
     * @param persons
     * @param mapper
     * @throws Exception
     */
    private static void outputPerson(List<Person> persons, ObjectMapper mapper) throws Exception {

        Path path =  inputFile(persons,mapper);
        System.out.println("---------------------------------------------------");
        System.out.println("Информация из файла:");
        try (BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(path)))){
            String line;
            while((line =  reader.readLine()) != null) {
              System.out.println(line);
            }
        } catch(Exception e) {
            System.out.println("Ошибка в перезаписи файла: " + e);
            e.printStackTrace();
        }
    }
}