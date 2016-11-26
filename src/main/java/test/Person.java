package test;



/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision: 1.1 $
  */
public class Person {
    private String relations;
    private String name;
    private int age;
    private String sex;

    
    /**
     * Creates a new Student object.
     *
     * @param name DOCUMENT ME!
     * @param age DOCUMENT ME!
     * @param sex DOCUMENT ME!
     * @param mark DOCUMENT ME!
     */
    public Person(String relations, String name, int age, String sex) {
        this.relations = relations;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public int getAge() {
        return age;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public String getName() {
        return name;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public String getSex() {
        return sex;
    }

    /**
     * DOCUMENT ME!
     *
     * @param sex DOCUMENT ME!
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public String getRelations() {
        return relations;
    }

    /**
     * DOCUMENT ME!
     *
     * @param relations DOCUMENT ME!
     */
    public void setRelations(String relations) {
        this.relations = relations;
    }
}
