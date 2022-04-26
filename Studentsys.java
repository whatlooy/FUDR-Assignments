import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Studentsys {
    static List<Studentsys> slist=new ArrayList<>();
         Integer rank,age;
         String rollNumber;
         String name;
         Branch branch;
        Studentsys(int rank,int age,String rollNumber,String name,Branch branch){
            this.rank=rank;
            this.age=age;
            this.rollNumber=rollNumber;
            this.name=name;
            this.branch=branch;}
        static Comparator<Studentsys> compareByRank=new Comparator<Studentsys>() {
            @Override
            public int compare(Studentsys s1,Studentsys s2){
                return s1.getRank() - s2.getRank();
            }
        };
        static Comparator<Studentsys> compareByName=new Comparator<Studentsys>() {
            @Override
            public int compare(Studentsys s1,Studentsys s2){
                return s1.getName().compareTo(s2.getName());
            }
        };
        static Comparator<Studentsys> compareByAge=new Comparator<Studentsys>() {
            @Override
            public int compare(Studentsys s1,Studentsys s2){
                return s1.getAge() - s2.getAge();
            }
        };
        static Comparator<Studentsys> compareByBranch=new Comparator<Studentsys>() {
            @Override
            public int compare(Studentsys s1,Studentsys s2){
                return s1.getBranch().compareTo(s2.getBranch());
            }
        };
            public Studentsys() {
        }

            public Studentsys(int i, int j, String string, String string2) {
                this.rank=i;
                this.age=j;
                this.rollNumber=string;
                this.name=string2;
            }

            public int getRank(){
                return rank;
            }
            public void setRank(int rank){
                this.rank=rank;
            }
            public int getAge(){
                return age;
            }
            public void setAge(int age){
                this.age=age;
            }
            public String getRollNumber(){
                return rollNumber;
            }
            public void setRollNumbe(String rollNumber){
                this.rollNumber=rollNumber;
            }
            public String getName(){
                return name;
            }
            public void setName(String name){
                this.name=name;
            }
            public Branch getBranch(){
                return branch;
            }
            public void setBranch(Branch branch){
                this.branch=branch;
            }
            static Studentsys addStudent(Studentsys studentsys) throws Exception{
                if(studentsys.rollNumber==null||studentsys.name==null||studentsys.rank==0){
                    throw new Exception("the feild of the student is null");
                }
                return studentsys;
            }
            static List<Studentsys> getBranchStudent(Branch branch) throws Exception{
                List<Studentsys> ls=new ArrayList<>();
                for(Studentsys s:slist){
                    if(s.branch==branch){
                        ls.add(s);
                    }
                }
                if(ls.isEmpty()){
                    throw new Exception("No branch found");
                }
                return ls;
            }
            static void updatelist(String rollNumber,int rank){
                for(Studentsys s1:slist){
                    if(s1.rollNumber==rollNumber){
                        s1.rank=rank;
                        
                    }
                    else{
                        continue;
                    }
                }
            }
            Studentsys foundByRollNum(String rollNumber) throws Exception{
                Studentsys s=new Studentsys();
                for(Studentsys s1:slist){
                    if(s1.rollNumber==rollNumber){
                        s=s1;
                        break;
                    }
                    else{
                        continue;
                    }
                }
                if(s.rollNumber== null){
                    throw new Exception("No roll number found");
                }
                return s;
            }
            static Studentsys removeByRollNum(String rollNumber){
                Studentsys s=new Studentsys();
                for(Studentsys s1:slist){
                    if(s1.rollNumber==rollNumber){
                        slist.remove(s1);
                        break;
                    }
                    else{
                        continue;
                    }
                }
                return s;
            }
            static int countnum(){
                int count=0;
                for(Studentsys s:slist){
                    count++;
                }
                return count;
                

            }

            static List<Studentsys> sortStudent(String sortfeild,String order){
                if(sortfeild=="name"&&order=="A"){
                    slist.sort(compareByName);
                }
                else if(sortfeild=="name" && order=="D"){
                    slist.sort(compareByName);
                    Collections.reverse(slist);
                }
                if(sortfeild=="branch"&&order=="A"){
                    slist.sort(compareByBranch);
                }
                else if(sortfeild=="branch" && order=="D"){
                    slist.sort(compareByBranch);
                    Collections.reverse(slist);
                }
                if(sortfeild=="rank"&&order=="A"){
                    slist.sort(compareByRank);
                }
                else if(sortfeild=="rank" && order=="D"){
                    slist.sort(compareByRank);
                    Collections.reverse(slist);
                }
                if(sortfeild=="age"&&order=="A"){
                    slist.sort(compareByAge);
                }
                else if(sortfeild=="age" && order=="D"){
                    slist.sort(compareByAge);
                    Collections.reverse(slist);
                }
                return slist;
            }
        public static void main(String[] args) throws Exception{
            
            Studentsys st=new Studentsys(1, 20, "A", "Puneet",Branch.ECE);
            Studentsys st1=new Studentsys(2, 20, "B", "Bhanu", Branch.ECE);
            Studentsys st2=new Studentsys(3,21,"C","Rajat",Branch.CIVIL);

            slist.add(Studentsys.addStudent(st));
            slist.add(Studentsys.addStudent(st1));
            slist.add(Studentsys.addStudent(st2));
            for(Studentsys s:slist){
                System.out.println(s.getAge()+" "+s.getName()+" "+ s.getRank()+" "+s.getRollNumber()+" "+s.branch);
            }
            System.out.println("******************************");
            List<Studentsys> ls=new ArrayList<>();
            ls=Studentsys.getBranchStudent(Branch.ECE);
                for(Studentsys s:ls){
                    System.out.println(s.getAge()+" "+s.getName()+" "+ s.getRank()+" "+s.getRollNumber()+" "+s.branch);
                }
                
                System.out.println("******************************");
            Studentsys st3=new Studentsys().foundByRollNum("C");
            System.out.println(st3.getAge()+" "+st3.getName()+" "+st3.getRank()+" "+st3.getRollNumber()+" "+st3.getBranch());
            System.out.println("The number of student in list"+"\n"+countnum());
            Studentsys.updatelist("C",4);
            System.out.println(st3.getAge()+" "+st3.getName()+" "+st3.getRank()+" "+st3.getRollNumber()+" "+st3.getBranch());
            slist.remove(Studentsys.removeByRollNum("C"));
            
            List<Studentsys> ls1=new ArrayList<>();
                ls1=Studentsys.sortStudent("rank","A");
                for(Studentsys s:ls1){
                    System.out.println(s.getAge()+" "+s.getName()+" "+ s.getRank()+" "+s.getRollNumber()+" "+s.branch);
                }
        }   
    }

