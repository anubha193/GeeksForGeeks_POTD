package potd;

public class AlternateVowelAndConsonants {
	public static String rearrange(String S, int N){
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        
        int vowels =0;
        int consnt = 0;
        
        for(int i=0; i<N; i++){
            char c = S.charAt(i);
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){ arr1[c-'a']++; vowels++; }
            else{ arr2[c-'a']++; consnt++; }
        }
        
        if(Math.abs(vowels-consnt)>1){ return "-1"; }
        
        boolean bool = true;
        
        if(vowels<consnt){ bool=false; }
        
        StringBuilder str = new StringBuilder();
        
        int i=0; int j=0;
        
        while(i<26 && j<26){
            if(bool){
                while(i<26 && arr1[i]==0){ i++; }
                if(i<26){ str.append((char)(i+'a')); arr1[i]--; }
                
                while(j<26 && arr2[j]==0){ j++; }
                if(j<26){ str.append((char)(j+'a')); arr2[j]--; }
            }
            else{
                while(j<26 && arr2[j]==0){ j++; }
                if(j<26){ str.append((char)(j+'a')); arr2[j]--; }
            
                while(i<26 && arr1[i]==0){ i++; }
                if(i<26){ str.append((char)(i+'a')); arr1[i]--; }
            }
        }
        
        return str.toString();
    
}
	public static void main(String[] args)
	{
		String s="dacxeohino";
		System.out.println(rearrange(s,s.length()));
	}

}
