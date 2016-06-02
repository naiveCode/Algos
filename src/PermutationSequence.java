/**
 * Created by naiveCode on 17/1/16.
 */
public class PermutationSequence {
    public static void main(String[] args) {
        PermutationSequence p = new PermutationSequence();
        System.out.println(p.getPermutation(3,2));
    }

    public String getPermutation(int n, int k) {
        int factorial =1;
        int i=1;
        while (i!=n){
            factorial *= i;
            i++;
        }
        i--;

        int[]num = {1,2,3,4,5,6,7,8,9};

        StringBuilder b = new StringBuilder();
        int index=0;
        while (i>0&&factorial>0){
            System.out.println("factorial is " + factorial);
            if(k/factorial == 0){
                while (num[index]==-1){
                    index = (index+1)%n;
                }
                b.append(num[index]);
                num[index] = -1;
            }else {
                int t = (k+1)/factorial;
                while (num[t]==-1){
                    t = (t+1)%n;
                }
                b.append(num[t]);
                num[t] = -1;
            }
            index=0;
            k=k%factorial;
            factorial=factorial/(i);
            i--;

        }
        for (int j=0;j<9;j++){
            if(num[j]!=-1){
                b.append(num[j]);
                break;
            }
        }
//        System.out.println("factorial is " + factorial);
    return b.toString();
    }
}
