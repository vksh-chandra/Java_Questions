import java.util.*;

public class demoString{
    
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);

        System.out.println("Enter String: ");
        //String s = src.nextLine();


    // 1. COUNT VOWEL & CONSONANT

    //     int vol = 0, con = 0;
    //     for(int i=0; i<s.length();i++)
    //     {
    //         if(s.charAt(i)=='a' || s.charAt(i) =='e'|| s.charAt(i) =='i' || s.charAt(i) =='o'|| s.charAt(i) =='u')
    //             vol++;
    //         else
    //             con++;
    //     }
    //     System.out.println("Vol= "+vol);
    //     System.out.println("Const= "+con);
    // }



    // 2. DIVIDE STRING IN EQUAL INTERVALS

        // int len = s.length();
        // System.out.println("Enter no. of parts you want to divide: ");
        // int n = src.nextInt();
        // int chars = len/n;
        // String[] newStr = new String[n];
        // int temp =0;
        // if(len%n !=0 || n==0)
        // {
        //     System.out.println("String cannot be divide");
        // }
        // else
        // {
        //     for(int i=0; i<len; i= i+chars)
        //     {
        //         String part = s.substring(i, i+chars);
        //         newStr[temp] = part;
        //         temp++;
        //     }
        // }
        // System.out.println(n+ " equal division of string is: ");
        // // for(int i=0; i<newStr.length; i++)
        // // {
        // //     System.out.println(newStr[i]);
        // // }
        // System.out.println(Arrays.toString(newStr));
        // src.close();

        // 3. STRING SUBSETS
        
        // String subStr[] = new String[(len*(len+1))/2];
        // int temp=0;

        // for(int i=0; i<len;i++)
        // {
        //     for(int j=i; j<len; j++)
        //     {
        //         subStr[temp] = s.substring(i, j+1);
        //         temp++;
        //     }
        // }

        // System.out.println("Subset of string is: ");
        // System.out.println(Arrays.toString(subStr));

        // 3. REMOVE WHITE SPACE

        // s = s.replaceAll("\\s+", "");
        // System.out.println(s);



        //4. REPLACE SPACE WITH SPECIFIC CHARACTER

        // char ch = '-';
        // s = s.replace(' ',ch);
        // System.out.println(s);

        //5. COUNT CHARACTER IN STRING
        // int count=0;
        // for(int i=0; i<len-1; i++)
        // {
        //     if(s.charAt(i) == ' ' && Character.isLetter(s.charAt(i+1)) && (i > 0))
        //         count++;
        // }
        // count++;
        // System.out.println(count);



        //6. PALLINDROME

        // s = s.toLowerCase();
        // int flag =0;
        // for(int i=0; i<len/2;i++){
        //     if(s.charAt(i)!=s.charAt(len-i-1))
        //         {
        //             flag =0;
        //             break;
        //         }
        //         else
        //             flag = 1;
        //     }

        // if(flag ==0)
        //     System.out.println("Not Pallindrome");
        // else
        //     System.out.println("Pallindrome");



        //7. CHECK ROTATION OR NOT

        // System.out.println("Enter second string");
        // String s2 = src.nextLine();

        // if(s.length()!=s2.length())
        //     System.out.println("Not a rotation of each other");
        // else{
        //     s = s.concat(s);

        //     if(s.indexOf(s2)!=-1)
        //         System.out.println("String is rotation of each other");
        //     else
        //         System.out.println("Not a rotation of each other.");
        // }


        
        //8. REVERSE A STRING

        // String rev = "";

        // for(int i= len-1; i>=0; i--)
        // {
        //     rev = rev + s.charAt(i);
        // }
        // System.out.println(rev);
        


        // 9. DUPLICATE CHARACTER IN STRING

        // char[] ch = s.toCharArray();
        // int count;

        // System.out.println("Duplicates are: ");
        // for(int i=0; i<len; i++)
        // {
        //     count = 1;
        //     for(int j= i+1; j<len; j++)
        //     {
        //         if(ch[i]== ch[j] && ch[i] != ' ')
        //         {
        //             count++;
        //             ch[j] = '0';
        //         }
        //     }
        //     if(count>1 && ch[i] !='0')
        //         System.out.println(ch[i]);
        // }



        // 10. DUPLICATE WORD IN JAVA

        // s = s.toLowerCase();
        // String sp[] = s.split(" ");

        // int count;
        // System.out.println("Duplicate word is: ");
        // for(int i=0; i< sp.length; i++)
        // {
        //     count =1;
        //     for(int j=i+1; j<sp.length; j++){
        //         if(sp[i].equals(sp[j]))
        //         {
        //             count++;
        //             sp[j] = "0";
        //         }
        //     }
        //     if(count>1 && sp[i]!="0")
        //         System.out.println(sp[i]);
        // }



        //11. LARGEST AND SMALLEST STIRNG IN STRING

        // s = s.toLowerCase();
        // String sp[] = s.split(" ");
        // int[] freq = new int[sp.length];

        // for(int i =0; i<sp.length; i++)
        // {
        //     freq[i] = sp[i].length();
        // }

        // int min = freq[0];
        // int max = freq[0];
        // int j = 0, k=0;
        // for(int i=1; i<freq.length; i++)
        // {
        //     if(max < freq[i])
        //     {
        //         max = freq[i];
        //         j =i;
        //     }

        //     if(min > freq[i])
        //     {
        //         min = freq[i];
        //         k =i;
        //     }
        // }
        // System.err.println("Largets is: "+sp[j]+ "\nSmallest is " +sp[k]);

        
        
        //12. SUBSTRING COMPARISION

        // System.out.println("Enter number to divide string: ");
        // int k = src.nextInt();
        // int n = len-k+1;
        // String[] string = new String[n];
        // for(int i=0; i<n; i++)
        // {
        //     string[i] = s.substring(i, i+k);
        // }
        // Arrays.sort(string);
        // String smallest = string[0];
        // String largest = string[n-1];

        // System.out.println(Arrays.toString(string));
        // System.out.println("Smalest = "+smallest+ " \nLargets = "+largets);

        //or 

        // String smallest = s.substring(0,k);
        //String largest = "";
        // for(int i=0; i<n; i++){
        //     if(s.substring(i, i+k).compareTo(smallest)<0)
        //         smallest = s.substring(i, i+k);
        //     if(s.substring(i, i+k).compareTo(largest)>0)
        //         largest = s.substring(i, i+k);
        // }
        src.close();


    }

}