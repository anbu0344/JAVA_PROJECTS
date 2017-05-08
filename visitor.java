import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
class Visitor {
	public static void main(String[] args) throws FileNotFoundException,IOException{
		int visitors[][][];
		visitors=new int[12][][];
		int mon[]={31,29,31,30,31,30,31,31,30,31,30,31};
		for (int i=0;i<12 ;i++ ) {
			visitors[i]= new int[mon[i]][24];
			
		}
		boolean loop=true;
		
		

		BufferedReader br=new BufferedReader(new FileReader("Visitor.txt"));
		BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
		for (int i=0;i<visitors.length;i++ ) {
			for (int j=0;j<visitors[i].length;j++ ) {

				for (int k=0;k<visitors[i][j].length;k++ ) {

				
				visitors[i][j][k]=Integer.parseInt(br.readLine());
					}
			
				}
		}

		while(loop)
		{
			System.out.println("\nsum and avg of \n 1:month\n 2:date\n 3:hour\n 4:boundary for month\n 5:boundary for month and day\n 6:boundary given for month,date and hour\n 7:multiple boundaries for month\n 8:multiple boundaries for date\n 9:multiple boundaries for hours\n 10:multiple boundaries for month,date and hours\n 11:exit\n");
			int val=Integer.parseInt(br1.readLine());
				int startMonthBound;
				int endMonthBound;
				int startDateBound;
				int endDateBound;
				int startHourBound;
				int endHourBound;
				int boundCount;
				int startHour;
				int endHour;
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
				int dateArr[]=new int[31];
				int hourArr[]=new int[24];
				int boundCountIterator;
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
     			 startMonthBound=Integer.parseInt(br1.readLine());
      			 System.out.println("ending value of month");
   				 endMonthBound=Integer.parseInt(br1.readLine());
   				 if((startMonthBound>0&&endMonthBound<13)&&(startMonthBound<endMonthBound))
   				 {
   				 for (i=startMonthBound-1;i<endMonthBound-1;i++ ) {
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
     			 startMonthBound=Integer.parseInt(br1.readLine());
      			 System.out.println("ending value of month");
   				 endMonthBound=Integer.parseInt(br1.readLine());
   				 System.out.println("starting value of date");
   				 startDateBound=Integer.parseInt(br1.readLine());
   				 System.out.println("ending value of date");
   				 endDateBound= Integer.parseInt(br1.readLine());
   				  if((startMonthBound>0&&endMonthBound<13)&&(startMonthBound<endMonthBound)&&(startDateBound>0&&endDateBound<32)&&(startDateBound<endDateBound))
   				 {
   					for (i = startMonthBound - 1 ; i < endMonthBound - 1 ; i++ ) {
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
     			 startMonthBound=Integer.parseInt(br1.readLine());
      			 System.out.println("ending value of month");
   				 endMonthBound=Integer.parseInt(br1.readLine());
   				 System.out.println("starting value of date");
   				 startDateBound=Integer.parseInt(br1.readLine());
   				 System.out.println("ending value of date");
   				 endDateBound= Integer.parseInt(br1.readLine());
   				 System.out.println("starting value of hour");
     			 startHourBound=Integer.parseInt(br1.readLine());
      			 System.out.println("ending value of hour");
   				 endHourBound=Integer.parseInt(br1.readLine());
   				 if((startMonthBound>0&&endMonthBound<13)&&(startMonthBound<endMonthBound)&&(startDateBound>0&&endDateBound<32)&&(startDateBound<endDateBound)&&(startHourBound>0&&endHourBound<25)&&(startHourBound<endHourBound))
   				 {
   				 	for (i=startMonthBound-1;i<endMonthBound-1;i++ ) {
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
   				boundCount=Integer.parseInt(br1.readLine());
   				for (boundCountIterator = 0 ; boundCountIterator < boundCount ; boundCountIterator++ ){
   					startMonthBound = 0;
   					endMonthBound = 0;
   					System.out.println("starting value of month");
   					startMonthBound=Integer.parseInt(br1.readLine());
   					System.out.println("ending value of month");
   					endMonthBound=Integer.parseInt(br1.readLine());
   					if((startMonthBound > 0 && endMonthBound < 13) && (startMonthBound < endMonthBound)) {
							for(i = startMonthBound ; i < endMonthBound ; i++) {
								for(j = 0;j < visitors[i - 1].length;j++) {
									for(k = 0;k < visitors[i - 1][j].length;k++) {
										sum += visitors[ i - 1 ][j][k];
										count++;
									}
								}
							}
							avg = sum / count;
							System.out.println("sum:"+sum+"\navg:"+avg); 
						}
						else
							System.out.println("Invalid boundaries");
						}

 				break;
 				case 8:
 						System.out.println("Enter the  month");
						monthVal = Integer.valueOf(br1.readLine());
						monthVal = monthVal - 1;
						if(monthVal >=0 && monthVal <=11) {
							System.out.println("Enter the Hour");
							hourVal = Integer.valueOf(br1.readLine());
							hourVal = hourVal - 1;
							if(hourVal >= 0 && hourVal <=23) {
								System.out.println("Enter the number of boundaries");
								boundCount = Integer.valueOf(br1.readLine());
								for (boundCountIterator = 0 ; boundCountIterator < boundCount ; boundCountIterator++ ){
									System.out.println("Enter the starting date");
									startDateBound = Integer.valueOf(br1.readLine());
									System.out.println("Enter the Ending date");
									endDateBound = Integer.valueOf(br1.readLine());
									startDateBound = startDateBound - 1;
									endDateBound = endDateBound - 1;
									if((visitors[monthVal].length > startDateBound) || (visitors[monthVal].length > endDateBound)) {
										sum = 0 ; 
										avg = 0 ; 
										count = 0;										
										for(j = startDateBound;j < endDateBound;j++) {
											sum = sum + visitors[monthVal][j][hourVal];
											count++;
										}
									avg = sum / count;
									System.out.println("sum:"+sum+"\navg:"+avg);
									}
									else {
										System.out.println("Invalid date Boundaries");
									}
								}
							}
							else {
								System.out.println("Invalid Hour");
							}
						}
						else {
							System.out.println("Invalid month");
						}

 				break;
 				case 9:
 						System.out.println("Enter the  month");
						monthVal = Integer.valueOf(br1.readLine());
						if(monthVal >0 && monthVal <13) {
							monthVal = monthVal - 1;
							System.out.println("Enter the Date");
							dateVal = Integer.valueOf(br1.readLine());
							dateVal = dateVal - 1;
							if(visitors[monthVal].length > dateVal) {
								System.out.println("Enter the number of boundaries for hours");
								boundCount = Integer.valueOf(br1.readLine());
								for (boundCountIterator = 0 ; boundCountIterator < boundCount ; boundCountIterator++ ){
									System.out.println("Enter the starting hour");
									startHour = Integer.valueOf(br1.readLine());
									System.out.println("Enter the Ending hour");
									endHour = Integer.valueOf(br1.readLine());
									startHour = startHour - 1;
									endHour = endHour - 1;
									if((startHour >= 0 && endHour <= 23) && (startHour < endHour )) {
										sum = 0 ; avg = 0 ; count = 0;
										for(i = startHour;i < endHour;i++) {
											sum += visitors[monthVal][dateVal][i];
											count++;
										}
										avg = sum / count;
										System.out.println("sum:"+sum+"\navg:"+avg); 
												
									}
									else {
										System.out.println("Invalid Hour Boundaries");
									}
								}
							}
							else {
								System.out.println("Invalid date for the month");
							}
						}
						else {
							System.out.println("Invalid Month");
						}
 				break;
 				case 10:
 					System.out.println("Enter the Number of Month Boundaries");
						int monthBoundaries = Integer.valueOf(br1.readLine());
						for(int l = 0;l < monthBoundaries;l++) 
						{
							System.out.println("Enter the starting boundary");
							startMonthBound = Integer.valueOf(br1.readLine());
							System.out.println("Enter the Ending boundary");
							endMonthBound = Integer.valueOf(br1.readLine());
							startMonthBound = startMonthBound - 1;
							endMonthBound = endMonthBound - 1;
							System.out.println();
							if((startMonthBound >= 0 && endMonthBound <= 11) && (startMonthBound < endMonthBound)) {
								for(i = startMonthBound;i < endMonthBound;i++) {
									System.out.println("Enter the number of date boundaries");
									int dateBoundaries = Integer.valueOf(br1.readLine());
									while(dateBoundaries > 0) {
										System.out.println("Enter the starting date");
										startDateBound = Integer.valueOf(br1.readLine());
										System.out.println("Enter the Ending date");
										endDateBound = Integer.valueOf(br1.readLine());
										startDateBound = startDateBound - 1;
										endDateBound = endDateBound - 1;
										if((visitors[i].length > startDateBound) || (visitors[i].length > endDateBound)) {										
											for(j = startDateBound;j < endDateBound;j++) {
												System.out.println("Enter the number of hour boundaries");
												int hourBoundaries = Integer.valueOf(br1.readLine());
												while(hourBoundaries > 0) {
													System.out.println("Enter the starting hour");
													startHourBound = Integer.valueOf(br1.readLine());
													System.out.println("Enter the Ending hour");
													endHourBound = Integer.valueOf(br1.readLine());
													startHourBound = startHourBound - 1;
													endHourBound = endHourBound - 1;
													if((startHourBound >= 0 && endHourBound <= 23) && (startHourBound < endHourBound )) {
														sum = 0;
														avg = 0;
														count = 0;
														for(k = startHourBound;k < endHourBound;k++) {
															sum += visitors[i][j][k];
															count++;
														}
														avg = sum / count;
														System.out.println("sum:"+sum+"\navg:"+avg);
													}
													else {
														System.out.println("Invalid Hour boundaries");
													}
													hourBoundaries--;
												}
											}
										}
										else {
											System.out.println("Invalid date boundaries");
										}
										dateBoundaries--;
									}
								}
							}
							else {
								System.out.println("Invalid month boundaries");
							}
						}
						break;
						case 11:
							loop = false;
							break;				
			}





		}


		
	}
	
}
