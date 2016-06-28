import java.util.List;

class FindMedianTwoSortedArrays {

    double fms(List<Integer> A, int m, List<Integer> B, int n, int k){

        if (m>n) {return fms(B,n,A,m,k);}

        if (m==0) { return B.get(k-1);}
        if (k==1) { return Math.min(A.get(0),B.get(0));}
        int pa = Math.min(k/2,m);
        int pb = k-pa;
        if (A.get(pa-1)<=B.get(pb-1)) {return fms(A.subList(pa,A.size()),m-pa,B,n,k-pa);}
        return fms(A,m,B.subList(pb,B.size()),n-pb,k-pb);
    }

    public double findMedianSortedArrays(final List<Integer> A, final List<Integer> B) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int m= A.size(),n=B.size();
        int total = m + n;
        if(total%2==1){
            return fms(A,m,B,n,total/2+1);
        }else{
            return (fms(A,m,B,n,total/2)+fms(A,m,B,n,total/2+1))/2;
        }

    }
};