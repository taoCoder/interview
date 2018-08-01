package test;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Elem{
    public double res;
    public String info;
    public Elem(double r,String i){
        res = r;
        info = i;
    }
}
public class CalculateAnswer {

    private final int N = 4;
    private final int res = 24;
    private int[] A;
    private Map<Integer, Set<Elem>> map;
    private Set<String> answers;

    public CalculateAnswer(int[] a) {
        A = a;
        map = new HashMap<Integer, Set<Elem>>();
        answers = new HashSet<String>();

    }
    public void run() {
        for(int i=0;i<(1<<N);i++) {
            Set<Elem> set = new HashSet<Elem>();
            map.put(i,set);
        }
        for(int i=0;i<N;i++){
            Elem e = new Elem(A[i], A[i]+"");
            Set<Elem> set = new HashSet<Elem>();
            set.add(e);
            map.put(1<<i, set);
        }
        for (int i = 1; i < (1 << N); i++) {
            fork(i);
        }
        Set<Elem> mSet = map.get((1<<N)-1);
        for(Elem e:mSet){
            if(e.res==res) {
                answers.add(e.info);
            }
        }
        if(answers.size()==0){
            System.out.println("无解");
        }
        else {
            for(String s:answers)
                System.out.println(s);
            System.out.println("共有"+answers.size()+"个解");
        }

    }
    public Set<Elem> fork(int m) {
        Set<Elem> mSet = map.get(m);
        if(mSet.size()>0)
            return mSet;
        else {
            for(int x = 1; x <= m ; x++) {
                if((x&m)==x){
                    Set<Elem> s1 = fork(x);
                    Set<Elem> s2 = fork(m-x);
                    for(Elem e1: s1) {
                        for(Elem e2:s2) {

                            String str = "("+e1.info+"+"+e2.info+")";
                            mSet.add(new Elem(e1.res+e2.res, str));

                            str = "("+ e1.info+"-"+e2.info+")";
                            mSet.add(new Elem(e1.res-e2.res, str));

                            str = "("+ e2.info+"-"+e1.info+")";
                            mSet.add(new Elem(e2.res-e1.res, str));

                            str = "("+ e1.info+"*"+e2.info+")";
                            mSet.add(new Elem(e1.res*e2.res, str));

                            if(e1.res!=0) {
                                str = "("+ e2.info+"/"+e1.info+")";
                                mSet.add(new Elem(e2.res/e1.res, str));
                            }
                            if(e2.res!=0){
                                str = "("+ e1.info+"/"+e2.info+")";
                                mSet.add(new Elem(e1.res/e2.res, str));
                            }
                        }
                    }
                }
            }
            return mSet;
        }

    }
    public static void main(String[] args) {
        int[] a = new int[4];
        Scanner sc = new Scanner(System.in);
        for(int i = 0;i<4;i++) {
            a[i] = sc.nextInt();
        }
        CalculateAnswer cal = new CalculateAnswer(a);
        cal.run();
        sc.close();
    }
}

