import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.NumberFormatException;
import java.util.IllegalFormatConversionException;
import java.util.Arrays;
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
				int startMonthBoundary;
				int endMonthBoundary;
				int startDateBound;
				int endDateBound;
				int startHourBound;
				int endHourBound;
				int monthBoundCount;
				double sum=0;
				double avg=0;
				double avg1=0;
				int count=0;
				int count1=0;
				int i,j,k;
				int mnth;
				int itr=0;
				int arrayCount=12;
				double indSum;
				int monthArr[]=new int[12];
				int dateArr[]=new int[12];
				int hourArr[]=new int[12];
				int monthBoundCountIterator;
			switch(val)
			{
				case 1:
				int monthVal;
				System.out.println("enter the month");
				 monthVal=Integer.parseInt(br1.readLine());
				 if(monthVal>0&&monthVal<13){
					for (j=0;j<visitors[monthVal-1].length;j++ ) {
						for (k=0;k<visitors[monthVal-1][j].length;k++ ) {

							sum +=visitors[monthVal-1][j][k];
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
				int dateVal;
				System.out.println("enter the date");
				dateVal=Integer.parseInt(br1.readLine());
				if(dateVal>0&&dateVal<30)
				{
				for (i=0;i<visitors.length;i++ ) {
					indSum=0;
					avg=0;
					count=0;
						for (k=0;k<visitors[i][dateVal-1].length;k++ ) {

							sum +=visitors[i][dateVal-1][k];
							indSum+=visitors[i][dateVal-1][k];
							count++;

						}
						avg=Double.valueOf(indSum/count);
						mnth=i+1;
						System.out.println("data for month="+mnth+"sum:"+indSum);
						System.out.printf("avg:%.3f",avg);
						count1++;
					}
					avg1=Double.valueOf(sum/count1);
					System.out.println("total data of date "+dateVal+"\nsum:"+sum);
					System.out.printf("avg:%.3f",avg1);
				}
				else if( dateVal==30 )
				{
					for (i=0;i<visitors.length;i++ ) {
						indSum=0;
						avg=0;
						count=0;
						
						if(visitors[i].length>29&&visitors[i].length<32)
						{
						for (k=0;k<visitors[i][dateVal-1].length;k++ ) {

							sum +=visitors[i][dateVal-1][k];
							indSum+=visitors[i][dateVal-1][k];
							count++;

						}
						

						}
						avg=Double.valueOf(indSum/count);
						mnth=i+1;
						System.out.println("data for month="+mnth+"sum:"+indSum);
						System.out.printf("avg:%.3f",avg);
						count1++;
					}
						avg1=Double.valueOf(sum/count1);
						System.out.println("total data of date "+dateVal+"\nsum:"+sum);
						System.out.printf("avg:%.3f",avg1);
				}
				else if (dateVal==31) {
					for (i=0;i<visitors.length;i++ ) {
						indSum=0;
						avg=0;
						count=0;

						if(visitors[i].length>30&&visitors[i].length<32)
						{
						for (k=0;k<visitors[i][dateVal-1].length;k++ ) {

							sum +=visitors[i][dateVal-1][k];
							indSum+=visitors[i][dateVal-1][k];
							count++;

						}
						
						}
						avg=Double.valueOf(indSum/count);
						mnth=i+1;
						System.out.println("data for month="+mnth+"sum:"+indSum);
						System.out.printf("avg:%.3f",avg);
						count1++;

					}
						avg1=Double.valueOf(sum/count1);
						System.out.println("total data of date "+dateVal+"\nsum:"+sum);
						System.out.printf("avg:%.3f",avg1);
					
				}
				else
				{
					System.out.println("invalid date");
				}
				break;
				case 3:
				System.out.println("enter the hour");
				int hourVal=Integer.parseInt(br1.readLine());
				if(hourVal>0&&hourVal<25)
				{
				for (i=0;i<visitors.length;i++ ) {
						for (j=0;j<visitors[i].length;j++ ) {
							//System.out.println(visitors[i][j][k]);

							sum +=visitors[i][j][hourVal-1];
							count++;

						}
					}
					avg=Double.valueOf(sum/count);
					System.out.println("hour data of "+hourVal+"\nsum:"+sum);
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
     			 startMonthBoundary=Integer.parseInt(br1.readLine());
      			 System.out.println("ending value of month");
   				 endMonthBoundary=Integer.parseInt(br1.readLine());
   				 if((startMonthBoundary>0&&endMonthBoundary<13)&&(startMonthBoundary<endMonthBoundary))
   				 {
   				 for (i=startMonthBoundary-1;i<endMonthBoundary-1;i++ ) {
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
					System.out.println("invalid boundaries");
				}
				 break;
				 case 5:
				 System.out.println("starting value of month");
     			 startMonthBoundary=Integer.parseInt(br1.readLine());
      			 System.out.println("ending value of month");
   				 endMonthBoundary=Integer.parseInt(br1.readLine());
   				 System.out.println("starting value of date");
   				 startDateBound=Integer.parseInt(br1.readLine());
   				 System.out.println("ending value of date");
   				 endDateBound= Integer.parseInt(br1.readLine());
   				  if((startMonthBoundary>0&&endMonthBoundary<13)&&(startMonthBoundary<endMonthBoundary)&&(startDateBound>0&&endDateBound<32)&&(startDateBound<endDateBound))
   				 {
   					for (i = startMonthBoundary - 1 ; i < endMonthBoundary - 1 ; i++ ) {
   				 		for (j = startDateBound - 1 ; j < endDateBound - 1 ; j++ ) {
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
						System.out.println("invalid boundaries");
					}


				 break;
				 case 6:
				 System.out.println("starting value of month");
     			 startMonthBoundary=Integer.parseInt(br1.readLine());
      			 System.out.println("ending value of month");
   				 endMonthBoundary=Integer.parseInt(br1.readLine());
   				 System.out.println("starting value of date");
   				 startDateBound=Integer.parseInt(br1.readLine());
   				 System.out.println("ending value of date");
   				 endDateBound= Integer.parseInt(br1.readLine());
   				 System.out.println("starting value of hour");
     			 startHourBound=Integer.parseInt(br1.readLine());
      			 System.out.println("ending value of hour");
   				 endHourBound=Integer.parseInt(br1.readLine());
   				 if((startMonthBoundary>0&&endMonthBoundary<13)&&(startMonthBoundary<endMonthBoundary)&&(startDateBound>0&&endDateBound<32)&&(startDateBound<endDateBound)&&(startHourBound>0&&endHourBound<25)&&(startHourBound<endHourBound))
   				 {
   				 	for (i=startMonthBoundary-1;i<endMonthBoundary-1;i++ ) {
   				 		if((visitors[i].length <= startDateBound-1) || (visitors[i].length <= endDateBound-1)) 
								continue;
   				 				for (j=startDateBound-1;j<endDateBound-1;j++ ) {
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
					System.out.println("invalid boundaries");
				}
   				break;
   				case 7:
   				int arrayCnt=0;
   				System.out.println("enter the no of boundaries for month");
   				monthBoundCount=Integer.parseInt(br1.readLine());
   				for (monthBoundCountIterator = 0 ; monthBoundCountIterator < monthBoundCount ; monthBoundCountIterator++ ){
   					System.out.println("starting value of month");
   					startMonthBoundary=Integer.parseInt(br1.readLine());
   					System.out.println("ending value of month");
   					endMonthBoundary=Integer.parseInt(br1.readLine());
   					for ( i = startMonthBoundary ; i < endMonthBoundary ; i++ ) {
						for (j = 0; j < arrayCount ; j++) {
						   	if(monthArr[j] != i){
						   		monthArr[arrayCnt] = i;
						   		arrayCnt++;
						   		break;
						   	}						
						}   	

   					}
   				}
   				int end=12;
   				for (i = 0; i < end; i++) {
        			for (j = i + 1; j < end; j++) {
            			if (monthArr[i] == monthArr[j]) {                  
                			int shiftLeft = j;
                				for (k = j+1; k < end; k++, shiftLeft++) {
                   					 monthArr[shiftLeft] = monthArr[k];
                				}
                				end--;
                				j--;
           				 }
        			}
    			}

   				for ( i = 0 ; i < arrayCount ; i++ ) {
   						System.out.println(monthArr[i]);
   					}
   					for (i = monthArr[itr] - 1 ; monthArr[itr] != 0 ; itr++ ) {
   				 				for (j = 0 ; j < visitors[i].length ; j++ ) {
   				 					for (k=0; k<visitors[i][j].length;k++ ) {
   				 						sum += visitors[i][j][k];
   				 						count++;
   				 			
   				 					}
   				 		
   				 				}
   				 	
   					}
   					 	avg=Double.valueOf(sum/count);
				 		System.out.println("sum:"+sum+"\navg:"+avg);
				
	



   				break;
   				
  
				 	
				 

			}





		}


		
	}
	
}
