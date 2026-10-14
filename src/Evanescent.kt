
fun main(){


    val t= readln().trim().toInt()

    repeat(t) {
        val n = readln().trim().toInt()
        val a = readln().trim().split("").filter { it.isNotBlank() }

        var deletedIndex = -2

        for(i in 1..<a.lastIndex){
            if(a[i-1] ==a[i+1] && a[i-1] != a[i]) {

                deletedIndex = i
                break
            }
        }

        if(deletedIndex ==-2){
         for (i in 1..< a.lastIndex){
             if(a[i]!=a[i-1] && a[i]!=a[i+1])
                 deletedIndex =i
         }
        }

        if(deletedIndex==-2)
            deletedIndex = 1

       val s  = a.filterIndexed { index, value ->

           when (index) {
               0 -> true
               deletedIndex -> false
               else -> {

                 //  println("$value is ${a[deletedIndex-1]}  ${index == deletedIndex+1}")
                   if(index == deletedIndex+1)
                       value != a[deletedIndex-1]
                   else
                       value != a[index-1]
               }
           }
       }
//        println(a)
//        println(deletedIndex)
//        println(s)
        println( s.size)




    }
}

/*

#include<bits/stdc++.h>
using namespace std;
string s;
int main(){
	ios::sync_with_stdio(false),cin.tie(0);
	int T,n,i,c,x;
	for(cin>>T;T>0;T--)
	{
		cin>>n>>s;
		c=1;
		for(i=1;i<n;i++)
		{
			if(s[i]!=s[i-1])c++;
		}
		x=0;
		for(i=1;i<n-1;i++)
		{
			if(s[i]==s[i-1]||s[i]==s[i+1])continue;
			if(s[i-1]==s[i+1])x=max(x,2);
			else x=max(x,1);
		}
		cout<<c-x<<'\n';
	}
	return 0;
}
 */
