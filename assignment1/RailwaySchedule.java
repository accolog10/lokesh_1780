import java.util.Scanner;

public class RailwaySchedule {
	static stats[] platForm=new stats[4];
	static void heapify(stats []platForm,int i){
		int root=i;
		int left=(i<<1)+1;
		int right=left+1;
		if(left<platForm.length && isMin(platForm[left],platForm[root]))
			root=left;
		if(right<platForm.length && isMin(platForm[right],platForm[root]))
			root=right;
		if(root!=i){
			stats temp=platForm[root];
			platForm[root]=platForm[i];
			platForm[i]=temp;
			heapify(platForm,root);
		}		
	}
	private static boolean isMin(stats a, stats b) {
		if(a.departureTimeH < b.departureTimeH)
			return true;
		if(a.departureTimeH == b.departureTimeH && a.departureTimeM < b.departureTimeM)
			return true;
		return false;
	}
	public static void main(String args[]){
		for(int i=0;i<4;i++)
			platForm[i]=new stats(i,-1,-1);
		Scanner in = new Scanner(System.in);
		int noTrains=in.nextInt();
		int sameTime=-1;
		int sameTimeCount=0;
		for(int i=0;i<noTrains;i++){
			int trainNo=in.nextInt();
			int startTimeH=in.nextInt();
			int startTimeM=in.nextInt();
			int timeInt=startTimeH*100+startTimeM;
			if(sameTime==-1){
				sameTime=timeInt;
				sameTimeCount=1;
			}
			else if(sameTime==timeInt)
				sameTimeCount++;
			else{
				sameTime=timeInt;
				sameTimeCount=1;
			}
			if(sameTimeCount>=4){
				System.out.println("No");
				continue;
			}
			stats route1=new stats(-1,startTimeH+1,startTimeM);
			stats route2=new stats(-1,startTimeH+1,startTimeM+15);
			route2.checkMin();
			stats route3=new stats(-1,startTimeH+1,startTimeM+45);
			route3.checkMin();
			//R1
			if(sameTimeCount<=1&&!isMin(route1, platForm[0])){
				int platform=getPlatform(route1,platForm);
				platForm[platform].departureTimeH=route1.departureTimeH;
				platForm[platform].departureTimeM=route1.departureTimeM+15;
				platForm[platform].checkMin();
				System.out.println(trainNo+"\tR1\t"+route1.departureTimeH+":"+route1.departureTimeM+"\t"+platForm[platform].departureTimeH+":"+platForm[platform].departureTimeM+"\t"+platForm[platform].platForm);
				heapify(platForm,platform);
			}
			//R2
			else if(sameTimeCount<=2&&!isMin(route2, platForm[0])){
				int platform=getPlatform(route2,platForm);
				platForm[platform].departureTimeH=route2.departureTimeH;
				platForm[platform].departureTimeM=route2.departureTimeM+15;
				platForm[platform].checkMin();
				System.out.println(trainNo+"\tR2\t"+route2.departureTimeH+":"+route2.departureTimeM+"\t"+platForm[platform].departureTimeH+":"+platForm[platform].departureTimeM+"\t"+platForm[platform].platForm);
				heapify(platForm,platform);
			}
			//R3
			else if(sameTimeCount<=3&&!isMin(route3, platForm[0])){
				int platform=getPlatform(route3,platForm);
				platForm[platform].departureTimeH=route3.departureTimeH;
				platForm[platform].departureTimeM=route3.departureTimeM+15;
				platForm[platform].checkMin();
				System.out.println(trainNo+"\tR3\t"+route3.departureTimeH+":"+route3.departureTimeM+"\t"+platForm[platform].departureTimeH+":"+platForm[platform].departureTimeM+"\t"+platForm[platform].platForm);
				heapify(platForm,platform);
			}
			//not possible
			else System.out.println("No");
		}
	}
	private static int getPlatform(stats route, stats[] platForm) {
		int minMax=platForm[0].departureTimeH*100+platForm[0].departureTimeM;
		int minMaxPlatform=0;
		int routeTime=route.departureTimeH*100+route.departureTimeM;
		for(int i=1;i<platForm.length;i++){
			int temp=platForm[i].departureTimeH*100+platForm[i].departureTimeM;
			if(routeTime>temp)
				if(temp>minMax){
					minMax=temp;
					minMaxPlatform=i;
				}
		}
		return minMaxPlatform;
	}
}
class stats{
	public int platForm;
	public int departureTimeH;
	public int departureTimeM;
	stats(int platForm,int departureTimeH,int departureTimeM){
		this.platForm=platForm;
		this.departureTimeH=departureTimeH;
		this.departureTimeM=departureTimeM;
	}
	public void checkMin(){
		departureTimeH+=departureTimeM/60;
		departureTimeM=departureTimeM%60;
	}
}