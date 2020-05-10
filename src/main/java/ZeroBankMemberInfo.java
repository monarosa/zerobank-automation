

public class ZeroBankMemberInfo {

    private String name;
    private char gender;
    private int age;
    private int last4SSN;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setBirtYear(int age) {
        this.age = age;
    }

    public int getLast4SSN() {
        return last4SSN;
    }

    public void setLast4SSN(int last4SSN) {
        this.last4SSN = last4SSN;
    }

    public ZeroBankMemberInfo(String name, char gender, int age, int last4SSN) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.last4SSN = last4SSN;}

    public boolean isMemberOlder18(int agee){
        if(agee>18) return true;

        return false;
    }

}
