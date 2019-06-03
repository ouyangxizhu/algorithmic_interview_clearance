package _43_51_dynamic_programming;

/**
 * https://leetcode-cn.com/problems/edit-distance/
 */
public class _51_SevenTwo {
    public int minDistance(String word1, String word2) {
        //dp[i][j]表示第一个单词前i个字符变化成第二个单词的前j个字符所需要的最小编辑次数
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        char [] ch1 = word1.toCharArray();
        char [] ch2 = word2.toCharArray();

        dp[0][0]=0;
        for(int i=0;i<=word1.length();i++){
            for(int j=0;j<=word2.length();j++){
                if(i==0){
                    dp[i][j]=j;   //如果 i=0 则需要插入j个字符
                }else if(j==0){
                    dp[i][j]=i;    //如果j=0则需要删除i个字符
                }else if(ch1[i-1]==ch2[j-1]){   //如果字符相同则不做变换，等于这个字符之前的步数
                    dp[i][j]=dp[i-1][j-1];
                }else{                          //否则 就从插入，删除，修改中选择最小的 加 1
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }
            }
        }

        return dp[word1.length()][word2.length()];

    }
}
