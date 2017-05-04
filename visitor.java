import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.NumberFormatException;
import java.util.IllegalFormatConversionException;
class Visitor {
	public static void main(String[] args) throws FileNotFoundException,IOException,NumberFormatException,IllegalFormatConversionException{
		int visitors[][][];
		visitors=new int[12][][];
		int mon[]={31,29,31,30,31,30,31,31,30,31,30,31};
		for (int i=0;i<12 ;i++ ) {
			visitors[i]= new int[mon[i]][24];
			
		}
		
		

		BufferedReader br=new BufferedReader(new FileReader("Visitor.txt"));
		BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
		for (int i=0;i<visitors.length;i++ ) {
			for (int j=0;j<visitors[i].length;j++ ) {

				for (int k=0;k<visitors[i][j].length;k++ ) {

				
				visitors[i][j][k]=Integer.parseInt(br.readLine());
				//System.out.print(visitors[i][j][k]+" ");
					}
			//System.out.println();
			
				}
			//System.out.println();
		}

		while(true)
		{
			System.out.println("\nsum and avg of \n 1:month\n 2:date\n 3:hour\n 4:boundary for month\n 5:boundary for month and day\n 6:boundary given for month,date and hour\n");
			int val=Integer.parseInt(br1.readLine());
				int start_mon_bound;
				int end_mon_bound;
				int startDateBound;
				int endDateBound;
				int startHourBound;
				int endHourBound;
				double sum=0;
				double avg=0;
				double avg1=0;
				int count=0;
				int count1=0;
				int i,j,k;
				int m;
				double ind_sum;
			switch(val)
			{
				case 1:
				int month_val;
				System.out.println("enter the month");
				 month_val=Integer.parseInt(br1.readLine());
				 if(month_val>0&&month_val<13)
				 {
					for (j=0;j<visitors[month_val-1].length;j++ ) {
						for (k=0;k<visitors[month_val-1][j].length;k++ ) {

							sum +=visitors[month_val-1][j][k];
							count++;

						}
					}
					avg=Double.valueOf(sum/count);
					System.out.println("sum:"+sum);
					System.out.printf("avg:%.3f",avg);
				}
				else
				{
					System.out.println("invalid month");
				}

				break;
				case 2:
				int date_val;
				System.out.println("enter the date");
				date_val=Integer.parseInt(br1.readLine());
				if(date_val>0&&date_val<30)
				{
				for (i=0;i<visitors.length;i++ ) {
					ind_sum=0;
					avg=0;
					count=0;
						for (k=0;k<visitors[i][date_val-1].length;k++ ) {

							sum +=visitors[i][date_val-1][k];
							ind_sum+=visitors[i][date_val-1][k];
							count++;

						}
						avg=Double.valueOf(ind_sum/count);
						m=i+1;
						System.out.println("data for month="+m+"sum:"+ind_sum);
						System.out.printf("avg:%.3f",avg);
						count1++;
					}
					avg1=Double.valueOf(sum/count1);
					System.out.println("total data of date "+date_val+"\nsum:"+sum);
					System.out.printf("avg:%.3f",avg1);
				}
				else if( date_val==30 )
				{
					for (i=0;i<visitors.length;i++ ) {
						ind_sum=0;
						avg=0;
						count=0;
						
						if(visitors[i].length>29&&visitors[i].length<32)
						{
						for (k=0;k<visitors[i][date_val-1].length;k++ ) {

							sum +=visitors[i][date_val-1][k];
							ind_sum+=visitors[i][date_val-1][k];
							count++;

						}
						

						}
						avg=Double.valueOf(ind_sum/count);
						m=i+1;
						System.out.println("data for month="+m+"sum:"+ind_sum);
						System.out.printf("avg:%.3f",avg);
						count1++;
					}
						avg1=Double.valueOf(sum/count1);
						System.out.println("total data of date "+date_val+"\nsum:"+sum);
						System.out.printf("avg:%.3f",avg1);
				}
				else if (date_val==31) {
					for (i=0;i<visitors.length;i++ ) {
						ind_sum=0;
						avg=0;
						count=0;

						if(visitors[i].length>30&&visitors[i].length<32)
						{
						for (k=0;k<visitors[i][date_val-1].length;k++ ) {

							sum +=visitors[i][date_val-1][k];
							ind_sum+=visitors[i][date_val-1][k];
							count++;

						}
						
						}
						avg=Double.valueOf(ind_sum/count);
						m=i+1;
						System.out.println("data for month="+m+"sum:"+ind_sum);
						System.out.printf("avg:%.3f",avg);
						count1++;

					}
						avg1=Double.valueOf(sum/count1);
						System.out.println("total data of date "+date_val+"\nsum:"+sum);
						System.out.printf("avg:%.3f",avg1);
					
				}
				else
				{
					System.out.println("invalid date");
				}
				break;
				case 3:
				System.out.println("enter the hour");
				int hour_val=Integer.parseInt(br1.readLine());
				if(hour_val>0&&hour_val<25)
				{
				for (i=0;i<visitors.length;i++ ) {
						for (j=0;j<visitors[i].length;j++ ) {
							//System.out.println(visitors[i][j][k]);

							sum +=visitors[i][j][hour_val-1];
							count++;

						}
					}
					avg=Double.valueOf(sum/count);
					System.out.println("hour data of "+hour_val+"\nsum:"+sum);
					System.out.printf("avg:%.3f",avg);
					System.out.println();
				}
				else
				{
					System.out.println("invalid hour");
				}
				break;
				case 4:

				 System.out.println("starting value of month");
     			 start_mon_bound=Integer.parseInt(br1.readLine());
      			 System.out.println("ending value of month");
   				 end_mon_bound=Integer.parseInt(br1.readLine());
   				 if((start_mon_bound>0&&end_mon_bound<13)&&(start_mon_bound<end_mon_bound))
   				 {
   				 for (i=start_mon_bound-1;i<end_mon_bound ;i++ ) {
   				 	for (j=0;j<visitors[i].length;j++ ) {
   				 		for (k=0; k<visitors[i][j].length;k++ ) {
   				 			sum += visitors[i][j][k];
   				 			count++;
   				 			
   				 		}
   				 		
   				 	}
   				 	
   				 }
   				 avg=Double.valueOf(sum/count);
				 System.out.println("sum:"+sum);
				 System.out.printf("avg:%.3f",avg);
				}
				else
				{
					System.out.println("invalid boundary");
				}
				 break;
				 case 5:
				 System.out.println("starting value of month");
     			 start_mon_bound=Integer.parseInt(br1.readLine());
      			 System.out.println("ending value of month");
   				 end_mon_bound=Integer.parseInt(br1.readLine());
   				 System.out.println("starting value of date");
   				 startDateBound=Integer.parseInt(br1.readLine());
   				 System.out.println("ending value of date");
   				 endDateBound= Integer.parseInt(br1.readLine());
   				  if((start_mon_bound>0&&end_mon_bound<13)&&(start_mon_bound<end_mon_bound))
   				 {
   				 	if((startDateBound>0&&endDateBound<32)&&(startDateBound<endDateBound))
   				 	{
   				  for (i=start_mon_bound;i<end_mon_bound ;i++ ) {
   				 	for (j=startDateBound;j<endDateBound;j++ ) {
   				 		for (k=0; k<visitors[i][j].length;k++ ) {
   				 			sum += visitors[i][j][k];
   				 			count++;
   				 			
   				 		}
   				 		
   				 	}
   				 	
   				 }
   				 	avg=Double.valueOf(sum/count);
				 	System.out.println("sum:"+sum+"\navg:"+avg);
					}
					else
					{
						System.out.println("invalid date");
					}
				}
				else
				{
					System.out.println("invalid month");
				}


				 break;
				 case 6:
				 System.out.println("starting value of month");
     			 start_mon_bound=Integer.parseInt(br1.readLine());
      			 System.out.println("ending value of month");
   				 end_mon_bound=Integer.parseInt(br1.readLine());
   				 System.out.println("starting value of date");
   				 startDateBound=Integer.parseInt(br1.readLine());
   				 System.out.println("ending value of date");
   				 endDateBound= Integer.parseInt(br1.readLine());
   				 System.out.println("starting value of hour");
     			 startHourBound=Integer.parseInt(br1.readLine());
      			 System.out.println("ending value of hour");
   				 endHourBound=Integer.parseInt(br1.readLine());
   				 if((start_mon_bound>0&&end_mon_bound<13)&&(start_mon_bound<end_mon_bound))
   				 {
   				 	if((startDateBound>0&&endDateBound<32)&&(startDateBound<endDateBound))
   				 	{
   				 		if ((startHourBound>0&&endHourBound<25)&&(startHourBound<endHourBound)) 
   				 		{
   				 			
   				 		
   				  for (i=start_mon_bound;i<end_mon_bound ;i++ ) {
   				 	for (j=startDateBound;j<endDateBound;j++ ) {
   				 		for (k=0; k<visitors[i][j].length;k++ ) {
   				 			sum += visitors[i][j][k];
   				 			count++;
   				 			
   				 					}
   				 		
   				 				}
   				 	
   							 }
   				 	avg=Double.valueOf(sum/count);
				 	System.out.println("sum:"+sum+"\navg:"+avg);
						}
						else
						{
							System.out.println("invalid hour");
						}
					}
					else
					{
						System.out.println("invalid date");
					}
				}
				else
				{
					System.out.println("invalid month");
				}
   				break;
   				case 7:
   				
  
				 	
				 

			}





		}


		
	}
	
}
