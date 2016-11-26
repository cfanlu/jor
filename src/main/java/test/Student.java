package test;

import java.util.ArrayList;
import java.util.List;



/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision: 1.1 $
  */
public class Student {
    private String name;
    private int age;
    private String sex;
    private int mark;

    /**
     * Creates a new Student object.
     *
     * @param name DOCUMENT ME!
     * @param age DOCUMENT ME!
     * @param sex DOCUMENT ME!
     * @param mark DOCUMENT ME!
     */
    public Student(String name, int age, String sex, int mark) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.mark = mark;
    }

    /**
    * Creates a new Student object.
    *
    * @param name DOCUMENT ME!
    * @param age DOCUMENT ME!
    * @param mark DOCUMENT ME!
    */
    public Student(String name, int age, int mark) {
        this.name = name;
        this.age = age;
        this.mark = mark;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public List getMembers() {
    	
        List result = new ArrayList();
        result.add(new Person("父亲", "崔爸", 40, "男"));
        result.add(new Person("母亲", "崔妈", 38, "女"));

        return result;
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
    public int getMark() {
        return mark;
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
}
