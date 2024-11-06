package practice;

class hIndex {
    public int hIndex(int[] citations) {
        int start=0;
        int end=citations.length;
        int sol=0;
        while (start<=end){
            int i=(start+end)/2;
            int sum=0;
            for(int j=0;j<citations.length;j++){
                if(citations[j]>=i){
                    sum++;
                }
            }
            if (sum>=i){
                start=i+1;
                sol=i;
            }else{
                end=i-1;
            }
        }
        
        return citations.length==1?citations[0]==0?0:1:sol;       
    }
}