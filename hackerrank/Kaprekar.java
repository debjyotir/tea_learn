class Kaprekar {
    private static String[] splitAt(String str, int idx){
        String[] ans = new String[2];
        ans[0] = str.substring(0, idx-1);
        if(ans[0].equals("")) ans[0] = "0"; //parsing "" throws an exception
        ans[1] = str.substring(idx);
        return ans;
    }
 
    public static void main(String[] args) throws java.lang.Exception{
        java.io.BufferedReader b = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        Long p = Long.parseLong(b.readLine());
        Long q = Long.parseLong(b.readLine());
        int count=0;
        for(long i = p; i <= q; i++){
            String sqrStr = Long.toString(i * i, 10);
            int j = sqrStr.length() / 2 ;
            String[] parts = splitAt(sqrStr, j);
            long firstNum = Long.parseLong(parts[0], 10);
            long secNum = Long.parseLong(parts[1], 10);
            //if the right part is all zeroes, then it will be forever, so break
            if(secNum == 0) break;
            if(firstNum + secNum == i){
                System.out.print(Long.toString(i, 10)+" ");
                count++;
            }
        }
        if(count==0){
            System.out.println("INVALID RANGE");
        }
    }
}