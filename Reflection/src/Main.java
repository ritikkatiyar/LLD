import java.lang.reflect.Field;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
//    public static void main(String[] args) throws Exception {
//
//        // 1. Get Class object in three ways
//        Class<?> cls1 = Person.class;                      // via .class
//        Class<?> cls2 = new Person().getClass();           // via object
//        Class<?> cls3 = Class.forName("Person");           // via fully qualified name
//
//        System.out.println("Class Name: " + cls1.getName());
//        System.out.println("Simple Name: " + cls1.getSimpleName());
//        System.out.println("Is Interface: " + cls1.isInterface());
//        System.out.println("Superclass: " + cls1.getSuperclass().getName());
//    }



    public static void main(String[] args) throws Exception {
        Person person = new Person("Ritik", 25);
        Class<?> cls = person.getClass();

        System.out.println("Declared Fields:");
        Field[] fields = cls.getDeclaredFields();
        for (Field f : fields) {
            System.out.println("Field: " + f.getName() + " | Type: " + f.getType());
        }

        // Access private field
        Field nameField = cls.getDeclaredField("name");
        nameField.setAccessible(true); // bypass private access
        nameField.set(person, "Ritik Katiyar");

        System.out.println("\nAfter modifying private field:");
        person.displayInfo();
    }
}