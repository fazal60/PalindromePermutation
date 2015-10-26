import java.util.Scanner;


public class SpermMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str;
		boolean result=false;
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the String:");
		str=scan.nextLine();
		SpermMain obj=new SpermMain();
		
		
		if(str.length()==0)
			System.out.println("Invalid input");
		else
		{
			result=obj.permute(str.toCharArray(), 0, str.length());
		}
		System.out.println(result);
		scan.close();
	}
	
	public boolean isPalindrome(char[] str)
	{
		int i,j;
		String newStr="";
		i=0;
		
		j=str.length-1;
		if(str.length%2==0)
		{
			while(j>i)
			{
				if(str[i]==' ' || str[i]=='\0')
				{
					i++;
					continue;
				}
				if(str[j]==' ' || str[j]=='\0')
				{
					j--;
					continue;
				}
				else if(str[i]!=str[j])
					return false;
				i++;
				j--;
			}
		}
		else if(str.length%2==1)
		{
			while(i!=j)
			{
				if(str[i]==' ' || str[i]=='\0')
				{
					i++;
					continue;
				}
				if(str[j]==' ' || str[j]=='\0')
				{
					j--;
					continue;
				}
				else if(str[i]!=str[j])
					return false;
				i++;
				j--;
			}
		}
		return true;
	}
	
	public boolean permute(char[] str,int index,int lev)
	{
		if(index==lev)
		{
			if(str[0]=='#' || str[str.length-1]=='#')
				;
			else
			{
				if(isPalindrome(str))
				{
					return true;
				}
		}
		}
		else
		{
			for(int i=index;i<str.length;i++)
			{
				char t=str[i];
				str[i]=str[index];
				str[index]=t;
				if(permute(str, index+1, lev))
					return true;
				t=str[i];
				str[i]=str[index];
				str[index]=t;
			}
		}
		
		return false;
	}

}
