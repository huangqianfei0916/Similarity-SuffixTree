# Similarity-SuffixTree

* 这不是一个可执行程序，这个仅仅提供对两个字符串相似度的计算，得到的是一个相似度数值。

我们的jar利用后缀树计算两个字符串的相似度矩阵。先计算字符串string1和string2的相似度，然后,

计算string1和string2的逆反序列的相似度，取两者的最大值为相似度。在使用jar之前请确保已经安装

jvm. 

逆反序列：将dna字符串先取反，再按A-T,G-C进行替换得到逆反矩阵。

如：string：ATGC的反序列为CGTA，它的逆反序列为GCAT 

### 使用方法

* 类名：HQFSuffixTree 


* 方法：public static double CalculateSimilarity_matrix(String s1, String s2) 


* 使用：HQFSuffixTree.CalculateSimilarity_matrix(string1,string2); 


* 返回值为double型的相似度。 
