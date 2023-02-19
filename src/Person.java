public class Person {
    private String name;
    private String family;
    private Integer age;
    private Main.Sex sex;
    private Main.Education education;

    public Person(String name, String family, int age, Main.Sex sex, Main.Education education) {
        this.name = name;
        this.family = family;
        this.age = age;
        this.sex = sex;
        this.education = education;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public Integer getAge() {
        return age;
    }

    public Main.Sex getSex() {
        return sex;
    }

    public Main.Education getEducation() {
        return education;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", education=" + education +
                '}';
    }


}

